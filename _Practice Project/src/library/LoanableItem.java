package library;
/**
 * 
 * @author Brahma Dathan and Sarnath Ramnath
 * @Copyright (c) 2010
 
 * Redistribution and use with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - the use is for academic purpose only
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *   - Neither the name of Brahma Dathan or Sarnath Ramnath
 *     may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * The authors do not make any claims regarding the correctness of the code in this module
 * and are not responsible for any loss or damage resulting from its use.  
 */
import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * This class is the super class for all items that can be loaned out by the
 * library. It implements some of the functionality needed to issue, return,
 * remove, and renew a single item.
 * 
 * @author Brahma Dathan
 *
 */
public abstract class LoanableItem implements Matchable<String>, Serializable {
	private static final long serialVersionUID = 1L;
	private String title;
	private String id;
	protected Member borrowedBy;
	protected Calendar dueDate;
	private List<Hold> holds = new LinkedList<Hold>();

	/**
	 * Takes in the title and id stores them.
	 * 
	 * @param title
	 *            the title of the item
	 * @param id
	 *            the id of the item
	 */
	public LoanableItem(String title, String id) {
		this.id = id;
		this.title = title;
	}

	/**
	 * Issues the item to the member
	 * 
	 * @param member
	 *            The member to whom the item should be issued
	 * @return true iff the operations is syuccessful
	 */
	public boolean issue(Member member) {
		if (borrowedBy != null) {
			return false;
		}
		dueDate = new GregorianCalendar();
		borrowedBy = member;
		return true;
	}

	/**
	 * Returns the title of the item
	 * 
	 * @return the title of the item
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Returns the id of the item
	 * 
	 * @return the id of the item
	 */
	public String getId() {
		return id;
	}

	/**
	 * Returns the borrower of the item
	 * 
	 * @return the borrower of the item
	 */
	public Member getBorrower() {
		return borrowedBy;
	}

	/**
	 * Returns the due date of the item
	 * 
	 * @return the due date of the item
	 */
	public Calendar getDueDate() {
		return dueDate;
	}

	/**
	 * Returns true if and only if the supplied id is the same as the id of the
	 * item.
	 */
	@Override
	public boolean matches(String id) {
		return (this.id.equals(id));
	}

	/**
	 * Adds one more hold to the item
	 * 
	 * @param hold
	 *            the new hold on the item
	 */
	public void placeHold(Hold hold) {
		holds.add(hold);
	}

	/**
	 * Removes hold for a specific member
	 * 
	 * @param memberId
	 *            whose hold has to be removed
	 * @return true iff the hold could be removed
	 */
	public boolean removeHold(String memberId) {
		for (ListIterator<Hold> iterator = holds.listIterator(); iterator
				.hasNext();) {
			Hold hold = iterator.next();
			String id = hold.getMember().getId();
			if (id.equals(memberId)) {
				iterator.remove();
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns a valid hold
	 * 
	 * @return the next valid hold
	 */
	public Hold getNextHold() {
		for (ListIterator<Hold> iterator = holds.listIterator(); iterator
				.hasNext();) {
			Hold hold = iterator.next();
			iterator.remove();
			if (hold.isValid()) {
				return hold;
			}
		}
		return null;
	}

	/**
	 * Checks whether there is a hold on this item
	 * 
	 * @return true iff there is a hold
	 */
	public boolean hasHold() {
		ListIterator<Hold> iterator = holds.listIterator();
		return (iterator.hasNext());
	}

	/**
	 * Returns an iterator for the holds
	 * 
	 * @return iterator for the holds on the book
	 */
	public Iterator<Hold> getHolds() {
		return holds.iterator();
	}

	/**
	 * Renews the item
	 * 
	 * @param member
	 *            who wants to renew the item
	 * @return true iff the item could be renewed
	 */
	public boolean renew(Member member) {
		if (hasHold()) {
			return false;
		}
		if ((member.getId()).equals(borrowedBy.getId())) {
			return (issue(member));
		}
		return false;
	}

	/**
	 * Marks the item as returned
	 * 
	 * @return the member who had borrowed the item
	 */
	public Member returnItem() {
		if (borrowedBy == null) {
			return null;
		} else {
			Member borrower = borrowedBy;
			borrowedBy = null;
			return borrower;
		}
	}

	@Override
	public String toString() {
		return "LoanableItem [title=" + title + ", id=" + id + ", borrowedBy="
				+ borrowedBy + ", dueDate=" + dueDate + "]";
	}

	/**
	 * Implements the accept method of the Visitor pattern.
	 * 
	 * @param visitor
	 *            the Visitor that will process the LoanableItem object
	 */
	public void accept(LoanableItemVisitor visitor) {
		visitor.visit(this);
	}
}
