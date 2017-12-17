import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class ShowShapes extends PositionalGraphic
{

// The ArrayList shapes is declared using the parent class (PositionalGraphic).
// You will fill it (below) with objects of the child classes.

ArrayList<PositionalGraphic> shapes = new ArrayList<PositionalGraphic>();

// Note: this is an instance variable so addScoop() can access it

IceCreamConePG iceCreamCone = new IceCreamConePG();

public ShowShapes()
{
    // ---------- You write the code

    // Update this section to instantiate each of your shapes (the child classes),
    // using whatever constructors you want.

    DiamondPG diamond = new DiamondPG();
    CirclePG circle = new CirclePG();
    TrianglePG triangle = new TrianglePG();
    HalfCirclePG halfCircle = new HalfCirclePG();
    LinePG line = new LinePG();
    HatPG hat = new HatPG();
    HeartPG heart = new HeartPG();

    // --------- You write the code

    // for each shape, use your setters and getters to position them,
    // set their colors, and set their sizes. I've done IceCreamConePG
    // for you, but you should use the setters you have with values that
    // you like.

    iceCreamCone.setNewLocation(200, 600,200,400);

    diamond.setNewLocation(200, 200, 400, 400);
    diamond.setDiaColor("pink");
    
    circle.setNewLocation(300, 300, 200, 400);
    circle.setCirColor("pink");
    
    triangle.setNewLocation(650,600, 80, 80);
    triangle.setTriColor("green");
    
    halfCircle.setNewLocation(890, 100, 200, 200);
    halfCircle.setHalfCircleColor("yellow");

    
    line.setNewLocation(800, 500, 600, 600);
    line.setLineColor(Color.BLUE);

    hat.setNewLocation(800, 400, 200, 200);
    hat.setHatColor("yellow");

    heart.setNewLocation(390, 480, 80, 80);
    
    

    // --------- You write the code
    
    // Add each one of your shapes to the ArrayList of shapes.

    shapes.add(heart);
    shapes.add(diamond);
    shapes.add(circle);
    shapes.add(halfCircle);
    shapes.add(triangle);
    shapes.add(line);
    shapes.add(hat);
    shapes.add(iceCreamCone);
}

public void addScoop(String color)
{
	iceCreamCone.addScoop(color);
}

// ----------- You write the code
// Finish up this method to add the argument. You may choose the signature:
//      public void addScoop(String color)
//      public void addScoop(Color color)
// It should call your IceCreamConePG class's addScoop() method (that you write).


@Override
public void paint(Graphics g)
{
    // This code loops through and paints all of the shapes.

    // It works through the "magic of polymorphism".

    // The ArrayList shapes is declared using the parent class (PositionalGraphic).
    // The object used in the loop (shape) is also declared as the parent class.
    // When the paint() method is called, it knows the real class of the object,
    // which is one of your child classes, and will call the proper child class's
    // paint() method.

    for (PositionalGraphic shape:shapes)
    {
        shape.paint(g);
    }
}

}

