import java.awt.Color;
import java.awt.event.KeyEvent;

import acm.graphics.*; // wildcard all classes in acm.graphics package
import acm.program.GraphicsProgram;
/**
 * 
 * @author susan
 * This class displays a highway with a moving car that will reappear on the left side
 * when it drives off the right side. 
 */
public class Highway extends GraphicsProgram
{
   
   // declare and initialize an array of cars
   Car[] cars = { new Car(30), new Car(10), new Car(20) };
   
   //declare a Frog GImage
   private GImage frog; //null
	
	public void init() 
   {
		// set window background color
		this.setBackground(Color.GREEN);

		// set window size 800 pixels wide, 600 pixels high
		this.setSize(800, 600);
      
      // tell the GraphicsProgram to listen for key events
      this.addKeyListeners();
	}

   // this method gets called for us and is passed information
   // about the key that was pressed
   public void keyPressed(KeyEvent e)
   {
       System.out.println(e);
       
       final int SPEED = 5;
       switch(e.getKeyCode())
       {
           case KeyEvent.VK_UP:
               frog.move(0, -SPEED);
               break;
               
           case KeyEvent.VK_DOWN:
               frog.move(0, SPEED);
               break; 
                
           case KeyEvent.VK_LEFT:
               frog.move(-SPEED, 0);
               break;
       
            case KeyEvent.VK_RIGHT:
               frog.move(SPEED, 0);
               break;
       
       
       } //end of switch
   
   
   }

	public void drawRoad()
   {
		// draw Road
		GRect road = new GRect(0, this.getHeight() / 3, this.getWidth(), this.getHeight() / 3);
		road.setColor(Color.GRAY);
		road.setFilled(true);
		this.add(road);
	}

	public void run()
   {
		// draw road before vehicles so you don't cover them up
		drawRoad();
      
      frog = new GImage("frogsmall.png");
      add(frog,this.getWidth() / 2,this.getHeight() - frog.getHeight());
      
      // add each car in the array to the window
      //int x = 200;
      int y = 175; // set initial y location
      for (Car c : cars)
      {
         // add c to GraphicsProgram Window at x=200, y=175
         add(c,200,y);
         y += 25;
         //x += 50;
         
      }

      boolean gameOver = false;
      
      while(gameOver == false)
      {
         for (int i=0; i<cars.length; i++)
         {
            cars[i].move(cars[i].getSpeed(),0);
             // if the frog runs into the car
            if(frog.getBounds().intersects(cars[i].getBounds()))
            {
               gameOver = true;
            }
            // if car exits right
            if(cars[i].getX() > this.getWidth())
            {
               //set the car back to left side
               cars[i].setLocation(-10,cars[i].getY());
            }
          }
          /* Using enhanced for each loop
          for (Car c : cars)
          {
            c.move(c.getSpeed(),0);
             // if the frog runs into the car
            if(frog.getBounds().intersects(c.getBounds()))
            {
               gameOver = true;
            }
            // if car exits right
            if(c.getX() > this.getWidth())
            {
               //set the car back to left side
               c.setLocation(-10,c.getY());
            }
          }
       
          */
          pause(200);
   
      }// end of while
      
      System.out.println("Game Over");
      this.remove(frog);
      
	}
   
	public static void main(String[] args) {
		new Highway().start();
	}

}
