/** 
 * This class is a java applet called ShapesApplet that randomly draws Ovals and Rectangles of varying colors. 
 * @author Alec Fenichel 
 * @version 1
 */ 

//import statements
import javax.swing.JApplet;
import java.util.Random;
import java.awt.*;

public class ShapesApplet extends JApplet{ //class that extends JApplet

	public void paint(Graphics canvas) { //paint method
		Random rand = new Random(); //random generator
		
		int numShapes = rand.nextInt(26)+10; //random number of shapes from 10 to 35
		
		//initial shape counts
		int Ovals = 0;
		int Rects = 0;
	
		
		for(int i = 0; i < numShapes; i++) { //loop that runs numShapes times
			int r = rand.nextInt(256); //random red value
			int g = rand.nextInt(256); //random green value
			int b = rand.nextInt(256); //random blue value
			Color randomColor = new Color(r,g,b); //random color based on random r,g,b values
			canvas.setColor(randomColor); //set canvas to random color
			
			int d = rand.nextInt(3)+1; //makes shapes size more varying
			
			int x = rand.nextInt(getWidth()); //random x starting point from 0 to width
			int y = rand.nextInt(getHeight()); //random y starting point from 0 to height
			int w = (int) Math.ceil(((double)(rand.nextInt(getWidth()-x)+1))/d); //random width that keeps shapes in window
			int l = (int) Math.ceil(((double)(rand.nextInt(getHeight()-y)+1))/d); //random length that keeps shapes in window
			

			int s = rand.nextInt(4); //random value for deciding shape
			
			if(s==0){
				canvas.drawOval(x,y,w,l); //draw oval
				Ovals++; //increase count by one
			}
			else if(s==1){
				canvas.fillOval(x,y,w,l); //draw filled oval
				Ovals++; //increase count by one
			}
			else if(s==2){
				canvas.drawRect(x,y,w,l); //draw rectangle
				Rects++; //increase count by one
			}
			else{
				canvas.fillRect(x,y,w,l); //draw filled rectangle
				Rects++; //increase count by one
			}
		}
		
		canvas.setColor(Color.black); //set canvas color to black
		
		canvas.drawString("We drew "+numShapes+" shapes.", 10, 15); //output total number of shapes
		canvas.drawString(Ovals+" Ovals.", 10, 30); //output total number of ovals (filled and unfilled)
		canvas.drawString(Rects+" Rectangles.", 10, 45); //output total number of rectangles (filled and unfilled)
	}
}
