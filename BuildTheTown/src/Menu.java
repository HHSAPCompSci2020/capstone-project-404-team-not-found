import processing.core.PApplet;
import processing.core.PFont;

/**
 * 
 * @author Joanna Huang
 *
 */
public class Menu{
	
	/**
	 * True if the start button has been clicked, false if not
	 */
	private boolean done;
	private PFont font;
	
	public Menu() {
		done = false;
	}
	
	/**
	 * Draws the menu, with the word "MENU" and a button that says "START"
	 * @param marker The PApplet with which to draw the menu
	 */
	public void draw(PApplet marker) {
		marker.background(212,235,242);
		font = marker.createFont("Lemon", 32);
		double width = marker.width;
		double height = marker.height;
		
		marker.textFont(font);
		marker.textAlign(marker.CENTER, marker.CENTER);
		marker.textSize(50);
		marker.fill(230,187,173);
		marker.text("BUILD THE TOWN", (float)(width/2), (float)(height/6));
		
		marker.fill(134,197,218);
		marker.rect(3 * marker.width/8, 3 * marker.height/4, marker.width/4, marker.height/8);
		font = marker.createFont("Roboto", 32);
		marker.textFont(font);
		marker.textSize(30);
		marker.fill(218,155,134);
		marker.text("start", (float)(width/2), (float)(12.9 * height/16));
		
	}
	
	/**
	 * Sets done to true if the button has been clicked
	 * @param marker The PApplet from which the width and height will be gotten
	 * @param pX The x-coordinate of the point clicked
	 * @param pY The y-coordinate of the point clicked
	 */
	public void mouseClicked(PApplet marker, double pX, double pY) {
		boolean ifX = 3 * marker.width/8 < pX && pX < 3 * marker.width/8 + marker.width/4;
		boolean ifY = 3 * marker.height/4 < pY && pY < 3 * marker.height/4 + marker.height/8;
		if(ifX && ifY)
			done = true;
	}
	
	/**
	 * Returns true if the start button has been clicked, false if not
	 * @return true if the start button has been clicked, false if not
	 */
	public boolean getDone() { return done; }

}