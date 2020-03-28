import acm.graphics.*; // GOval GRect
import java.awt.Color;

public class Car extends GCompound
{
    private double speed;
    
    // parameterized constructor for Car pass in speed
    public Car(double speed)
    {
        // initialize speed
        this.speed = speed;
        
        //create a top for car GOval
        GOval top = new GOval(30,15,30,25);
        top.setFillColor(Color.BLACK);
        top.setFilled(true);
        
        // create a car body
        GRect body = new GRect(15,25,60,20);
        body.setFillColor(Color.RED);
        body.setFilled(true);
        
        // create wheel1
        GOval wheel1 = new GOval(20,40,10,10);
        wheel1.setFillColor(Color.BLACK);
        wheel1.setFilled(true);
        
        // create wheel2
        GOval wheel2 = new GOval(60,40,10,10);
        wheel2.setFillColor(Color.BLACK);
        wheel2.setFilled(true);
        
        // glue car parts together
        add(top);
        add(body);
        add(wheel1);
        add(wheel2);
    
    }// end of constructor


   //getter for speed
   public double getSpeed()
   {
      return this.speed;
   
   }
   
   // setter for speed
   public void setSpeed(double speed)
   {
      this.speed = speed;
   }


}// end of class
