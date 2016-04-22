package mcv;
/**
 * /**
 * Class: ICS 372-01
 * @author Ian, Kyle, Chelsea, Kevin, 
 * based upon code by Brahma Dathan and Sarnath Ramnath
 * Last modified: 11/27/2015
 * Project Name: Project #3
 * Class Name: UIContext
 * Description: The view of the MVC architecture
 *
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class View extends JFrame implements Observer {
	private static final long serialVersionUID = 1L;
	private UIContext uiContext;
	private JPanel drawingPanel;
	private JPanel buttonPanel;
	private JButton lineButton;
	private JButton deleteButton;
	private JButton labelButton;
	private JButton selectButton;
	private JButton saveButton;
	private JButton openButton;
	private JButton drawOvalButton;

    private String fileName;
    // other buttons to be added as needed;
    private static Model model;
    /**
     * Returns the UIContext
     * @return the UIContext
     */
    public UIContext getUI() {
    	return uiContext;
    }
    /**
     * Sets the UIContext
     * @param uiContext the UIContext to be used
     */
    private void setUI(UIContext uiContext) {
    	this.uiContext = uiContext;
    }
    /**
     * Sets the mode
     * @param model the model
     */
    public static void setModel(Model model) {
    	View.model = model;
    }
    /**
     * The panel where drawing occurs
     *
     */
    private class DrawingPanel extends JPanel {
    	private MouseListener currentMouseListener;
    	private KeyListener currentKeyListener;
    	private FocusListener currentFocusListener;
    	/**
    	 * Paints the panel
    	 * @param graphics the Graphics object
    	 */
    	@Override
    	public void paintComponent(Graphics graphics) {
    		model.setUI(NewSwingUI.getInstance());
    		super.paintComponent(graphics);
    		(NewSwingUI.getInstance()).setGraphics(graphics);
    		graphics.setColor(Color.BLUE);
    		Enumeration enumeration = model.getItems();
    		while (enumeration.hasMoreElements()) {
    			((Item) enumeration.nextElement()).render();
    		}
    		graphics.setColor(Color.RED);
    		enumeration = model.getSelectedItems();
    		while (enumeration.hasMoreElements()) {
    			((Item) enumeration.nextElement()).render();
    		}
    	}
    	/**
    	 * Makes the given object the listener to mouse events
    	 * @param newListener the new listener
    	 */
    	public void addMouseListener(MouseListener newListener) {
    		removeMouseListener(currentMouseListener);
    		currentMouseListener =  newListener;
    		super.addMouseListener(newListener);
    	}
    	/**
    	 * Makes the given object the listener to keyboard events
    	 * @param newListener the new listener
    	 */
    	public void addKeyListener(KeyListener newListener) {
    		removeKeyListener(currentKeyListener);
    		currentKeyListener =  newListener;
    		super.addKeyListener(newListener);
    	}
    	/**
    	 * When the component gains or loses the keyboard focus,
		 * the relevant method in the listener object is invoked
		 * @param newListener the new listener
    	 */
    	public void addFocusListener(FocusListener newListener) {
    		removeFocusListener(currentFocusListener);
    		currentFocusListener =  newListener;
    		super.addFocusListener(newListener);
    	}
    }
    /**
     * Remembers the file name for storing in the title
     * @param fileName file name
     */
    public void setFileName(String fileName) {
    	this.fileName = fileName;
    	setTitle("Drawing Program 1.1  " + fileName);
    }
    /**
     * returns the file name
     * @return file name
     */
    public String getFileName() {
    	return fileName;
    }
    /**
     * Initializes the view by creating all the widgets
     */
    public View() {
    	super("Drawing Program 1.1  Untitled");
    	fileName = null;
    	addWindowListener(new WindowAdapter() {
    		public void windowClosing(WindowEvent event) {
    			System.exit(0);
    		}
    	});
    	drawingPanel = new DrawingPanel();
    	buttonPanel = new JPanel();
    	Container contentpane = getContentPane();
    	contentpane.add(buttonPanel, "North");
    	contentpane.add(drawingPanel);
    	lineButton= new LineButton(this, drawingPanel);
    	labelButton = new LabelButton(this, drawingPanel);
    	selectButton= new SelectButton(this, drawingPanel);
    	deleteButton= new DeleteButton();
    	saveButton= new SaveButton(this);
    	openButton= new OpenButton(this);
    	drawOvalButton = new OvalButton(this, drawingPanel); //oval
    	buttonPanel.add(lineButton);
        buttonPanel.add(drawOvalButton);
    	buttonPanel.add(labelButton);
    	buttonPanel.add(selectButton);
    	buttonPanel.add(deleteButton);
    	buttonPanel.add(saveButton);
    	buttonPanel.add(openButton);

    	this.setSize(600, 400);
    }
    /**
     * Catches updates from the model
     * @param model the source: it is the model
     * @param dummy: not used
     */
    public void update(Observable model, Object dummy) {
    	drawingPanel.repaint();
    }
    /**
	  * maps a point on the drawing panel to a point
	  * on the figure being created. 
	  * @param point the GUI point
	  * @return translated point
	  */
    public static Point mapPoint(Point point){
    	return point;
    }
}