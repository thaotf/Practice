package mcv;
/**
 * Class: ICS 372-01
 * @author Ian, Kyle, Chelsea, Kevin, 
 * based upon code by Brahma Dathan and Sarnath Ramnath
 * Last modified: 11/27/2015
 * Project Name: Project #3
 * Class Name: NewSwingUI
 * Description: The button to create Ovals. Processes the mouse movements and clicks calling
 * the appropriate methods of controller.
 */
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class OvalButton extends JButton implements ActionListener {

    private static final long serialVersionUID = 1L;
    protected JPanel drawingPanel;
    protected View view;
    private MouseHandler mouseHandler;

    /**
     * Creates the button for the Oval
     * 
     * @param jFrame
     *            the frame where the label is put
     * @param jPanel
     *            the panel within the frame
     */
    public OvalButton(View jFrame, JPanel jPanel) {
        super("Oval");
        addActionListener(this);
        view = jFrame;
        drawingPanel = jPanel;
    }

    /**
     * Handle click for creating a new Oval
     */
    public void actionPerformed(ActionEvent event) {
        drawingPanel.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        mouseHandler = new MouseHandler();
        // Change cursor when button is clicked
        Controller.instance().makeOval();
        drawingPanel.addMouseListener(mouseHandler);
        // Start listening for mouseclicks on the drawing panel
    }

    /**
     * Handles mouse click so that the points can now be captured.
     * 
     */
    private class MouseHandler extends MouseAdapter {
        private int pointCount;

        public void mouseClicked(MouseEvent event) {
            Controller.instance().setOvalPoint(View.mapPoint(event.getPoint()));
            if (++pointCount == 2) {
                pointCount = 0;
                drawingPanel.removeMouseListener(this);
                drawingPanel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        }
    }
}