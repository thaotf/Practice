package mcv;
/**
 * Class: ICS 372-01
 * @author Ian, Kyle, Chelsea, Kevin, 
 * based upon code by Brahma Dathan and Sarnath Ramnath
 * Last modified: 11/27/2015
 * Project Name: Project #3
 * Class Name: NewSwingUI
 * Description: Represents an Oval
 */
import java.awt.*;

public class Oval extends Item {
    private Point point1;
    private Point point2;
    private int width;
    private int height;
    private int xCoord;
    private int yCoord;

    /**
     * Creates an Oval with the given endpoints
     * 
     * @param point1
     *            one endpoint
     * @param point2
     *            another endpoint
     */
    public Oval(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
        width = (int) (point2.getX() - point1.getX());
        height = (int) (point2.getY() - point1.getY());
        xCoord = (int) point1.getX();
        yCoord = (int) point1.getY();
    }

    /**
     * Creates an Oval with no specific endpoints
     */
    public Oval() {
    }

    /**
     * Checks whether the given point falls within the oval's bounding box 
     *      * 
     * @return true iff the given point is close to bounding box
     */
    public boolean includes(Point point) {
    
        boolean xCheck = ( point.getX() < (point1.getX() + width + 10) ) && 
                ( point.getX() > ( point1.getX() - 10) );
        boolean yCheck = ( point.getY() < (point1.getY() + height + 10) ) &&
                ( point.getY() > ( point1.getY() - 10));
        return (xCheck && yCheck);
    }

    /**
     * Displays the Oval
     */
    public void render() {
        uiContext.draw(this);
    }

    /**
     * Sets one of the endpoints
     * 
     * @param point
     *            an endpoint
     */
    public void setPoint1(Point point) {
        point1 = point;
        xCoord = (int) point1.getX();
        yCoord = (int) point1.getY();
    }

    /**
     * Sets one of the endpoints
     * 
     * @param point
     *            an endpoint
     */
    public void setPoint2(Point point) {
        point2 = point;
        width = (int) (point2.getX() - point1.getX());
        height = (int) (point2.getY() - point1.getY());
    }

    /**
     * Returns one of the endpoints
     * 
     * @return an endpoint
     */
    public Point getPoint1() {
        return point1;
    }

    /**
     * Returns one of the endpoints
     * 
     * @return an endpoint
     */
    public Point getPoint2() {
        return point2;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getXCoord(){
        return xCoord;
    }
    
    public int getYCoord(){
        return yCoord;
    }
    
    /**
     * Returns a string representation of the Oval
     * 
     * @return a string representation
     */
    public String toString() {
        return "Oval with center at " + (int) (point1.getX() + width / 2)
                + ", width of " + width + ", and height of " + height + ".";
    }
}