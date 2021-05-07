import processing.core.PApplet;

/**
 * 
 * @author Joanna Huang
 *
 */
public class BuildingBlock {
	
	private double x, y;
	private double width;
	private final double GRAVITY;
	
	public BuildingBlock() {
		width = 0;
		GRAVITY = 0;
	}
	
	public void draw(PApplet marker) {
		
	}
	
	public boolean isTouching(BuildingBlock block2) {
		return false;
	}
	
	private double getX() { return x; }
	
	private double getY() { return y; }
	
	private void setX(double newX) {x = newX; }
	
	private void setY(double newY) {x = newY; }
}
