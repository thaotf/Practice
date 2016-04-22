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
import java.io.IOException;

/**
 * The collection class for all LoanableItem objects
 * 
 * @author Brahma Dathan and Sarnath Ramnath
 *
 */
public class Catalog extends ItemList<LoanableItem, String> {
	private static Catalog catalog;

	/*
	 * Private constructor for singleton pattern
	 */
	private Catalog() {
	}

	/**
	 * Supports the singleton pattern
	 * 
	 * @return the singleton object
	 */
	public static Catalog instance() {
		if (catalog == null) {
			return (catalog = new Catalog());
		} else {
			return catalog;
		}
	}

	/**
	 * Removes a book from the catalog
	 * 
	 * @param loanableItemId
	 *            book id
	 * @return true iff book could be removed
	 */
	public boolean removeLoanableItem(String loanableItemId) {
		LoanableItem loanableItem = search(loanableItemId);
		if (loanableItem == null) {
			return false;
		} else {
			return super.remove(loanableItem);
		}
	}

	/**
	 * Inserts a book into the collection
	 * 
	 * @param book
	 *            the book to be inserted
	 * @return true iff the book could be inserted. Currently always true
	 */
	public boolean insertLoanableItem(LoanableItem loanableItem) {
		return super.add(loanableItem);
	}

	/*
	 * Supports serialization
	 * 
	 * @param output the stream to be written to
	 */
	private void writeObject(java.io.ObjectOutputStream output)
			throws IOException {
		output.defaultWriteObject();
		output.writeObject(catalog);
	}

	/*
	 * Supports deserialization
	 * 
	 * @param input the stream to be read from
	 */
	private void readObject(java.io.ObjectInputStream input)
			throws IOException, ClassNotFoundException {
		input.defaultReadObject();
		if (catalog == null) {
			catalog = (Catalog) input.readObject();
		} else {
			input.readObject();
		}
	}
}
