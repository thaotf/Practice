package mcv;
/**
 * Class: ICS 372-01
 * @author Ian, Kyle, Chelsea, Kevin, 
 * based upon code by Brahma Dathan and Sarnath Ramnath
 * Last modified: 11/27/2015
 * Project Name: Project #3
 * Class Name: NewSwingUI
 * Description: a UI that uses the swing package
 */

import java.awt.Graphics;

public class NewSwingUI implements UIContext {
  private Graphics graphics;
  private static NewSwingUI swingUI;
  /**
   * For the singleton pattern
   */
  private NewSwingUI() {
  }
  /**
   * Returns the instance
   * @return the instance
   */
  public static NewSwingUI getInstance() {
    if (swingUI == null) {
      swingUI = new NewSwingUI();
    }
    return swingUI;
  }
  /**
   * The Graphics object for drawing
   * @param graphics the Graphics object
   */
  public  void setGraphics(Graphics graphics) {
    this.graphics = graphics;
  }
  /**
   * Draws a label
   * @param label the label
   */
  public void draw(Label label) {
    if (label.getStartingPoint() != null) {
      if (label.getText() != null) {
        graphics.drawString(label.getText(), (int) label.getStartingPoint().getX(), (int) label.getStartingPoint().getY());
      }
    }
    int length = graphics.getFontMetrics().stringWidth(label.getText());
    graphics.drawString("_", (int) label.getStartingPoint().getX() + length, (int) label.getStartingPoint().getY());
  }
  /**
   * Draws a line
   * @param line the line to be drawn
   */
  public void draw(Line line) {
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    if (line.getPoint1() != null) {
      i1 = Math.round((float) (line.getPoint1().getX()));
      i2 = Math.round((float) (line.getPoint1().getY()));
      if (line.getPoint2() != null) {
        i3 = Math.round((float) (line.getPoint2().getX()));
        i4 = Math.round((float) (line.getPoint2().getY()));
      } else {
        i3 = i1;
        i4 = i2;
      }
      graphics.drawLine(i1, i2, i3, i4);
    }
  }
 
  /**
   * Draws an oval
   * @param line the line to be drawn
   */
  public void draw(Oval oval){
      int xPt = 0;
      int yPt = 0;
      int width = 0;
      int height = 0;
      if(oval.getPoint1() != null){
          xPt = oval.getXCoord();
          yPt = oval.getYCoord();
          if (oval.getPoint2() != null){
              width = oval.getWidth();
              height = oval.getHeight();
          }
          else{
              width = 0;
              height = 0;
          }
          graphics.drawOval(xPt, yPt, width, height);
      }
  }
  
  /**
   * Captures undefined items
   * @param item the item
   */
  public void draw(Item item) {
      System.out.println( "Can't draw unknown Item \n");
  }
}