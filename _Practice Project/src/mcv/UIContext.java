package mcv;
/**
 * /**
 * Class: ICS 372-01
 * @author Ian, Kyle, Chelsea, Kevin, 
 * based upon code by Brahma Dathan and Sarnath Ramnath
 * Last modified: 11/27/2015
 * Project Name: Project #3
 * Class Name: UIContext
 * Description: A given technology can implement this to draw the items in 
 * its own way.
 *
 */
public interface UIContext {
	//  public abstract void drawCircle(Circle circle);
	/**
	 * Draw the line
	 * @param line the line
	 */
	public abstract void draw(Line line);
	
	/**
     * Draw the oval
     * @param oval the oval
     */
	
	public abstract void draw(Oval oval); //oval
	
	/**
	 * Draw the label
	 * @param label the label
	 */
	public abstract void draw(Label label);
	/**
	 * Draws unspecified items
	 * @param item the item
	 */
	public abstract void draw(Item item);
}
