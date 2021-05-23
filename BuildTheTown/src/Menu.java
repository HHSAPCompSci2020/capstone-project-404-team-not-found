import processing.core.PApplet;

/**
 * 
 * @author Joanna Huang
 *
 */
public class Menu{
	
	/**
	 * True if start button has been clicked, false if not
	 */
	private boolean done;
	
	
	public Menu() {
		done = false;
	}
	
	/**
	 * Draws the menu, with the word "MENU" and a button that says "START"
	 * @param marker The PApplet with which to draw the menu
	 * @param width The width of the window
	 * @param height The height of the window
	 */
	public void draw(PApplet marker) {
		double width = marker.width;
		double height = marker.height;
		
		marker.textAlign(marker.CENTER, marker.CENTER);
		marker.textSize(50);
		marker.fill(0);
		marker.text("MENU", (float)(width/2), (float)(height/6));
		
		marker.fill(200);
		marker.rect(3 * marker.width/8, 3 * marker.height/4, marker.width/4, marker.height/8);
		marker.textSize(30);
		marker.fill(0);
		marker.text("START", (float)(width/2), (float)(13 * height/16));
		
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
	
	public boolean getDone() { return done; }

}