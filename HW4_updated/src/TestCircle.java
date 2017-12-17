/**
 * 
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
/**
 * 
 * @author David Chukwuma & David Mawazo
 * Andrew ID: dchukwue
*  On my honor, as a Carnegie-Mellon Rwanda student, I have neither
*  given nor received unauthorized assistance on this work.

 */



/*
 *  This is a basic test harness to test a simple graphic.
 *
 *  @author Cathy Bishop
 *
 */

public class TestCircle 
{
	
	
public static void main(String argv[]) throws IOException
{

    /* 
     * The basics steps for a graphical application are:
     *
     * 1. Create a Frame.
     * 2. Create your graphical object (with whatever settings you want).
     *    Note: your class should extend JPanel.
     * 3. Add your object to the frame.
     *    Note: you can only add 1 object to the frame.
     * 4. Set up the frame (CloseOperation and size)
     * 5. Make the frame visible.
     *
     */
    
    JFrame frame = new JFrame();

    GraphicalCircle circle;
    circle = new GraphicalCircle();
    
    frame.add(circle);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 500);

    // Note: this sets the frame to be visible, which will automatically call 
    // paintComponent() in your GraphicalCircle class.

    frame.setVisible(true);
}
}
