package mcv;
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
import javax.swing.*;
import java.awt.event.*;
/**
 * The button to open a file.
 *
 */
public class OpenButton  extends JButton implements ActionListener {
  protected View view;
  /**
   * Creates the button
   * @param jFrame the frame where the button lives
   */
  public OpenButton(View jFrame) {
    super("Open");
    addActionListener(this);
    view = jFrame;
  }
  /**
   * Handles the click by notifying the controller
   * @param event the click event
   */
  public void actionPerformed(ActionEvent event){
    String string = JOptionPane.showInputDialog(view, "Please type new file name");
    Controller.instance().openFile(string);
    view.setFileName(string);
  }
}
