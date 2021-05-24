import java.util.ArrayList;
import processing.core.PApplet;

/**
 * 
 * @author Joanna Huang
 *
 */
public class BuildingBlock {
	
	/**
	 * The x-coordinate of the top left corner of this block
	 */
	private double x;
	
	/**
	 * The y-coordinate of the top left corner of this block
	 */
	private double y;
	
	/**
	 * The width of this block
	 */
	private final double WIDTH;
	
	/**
	 * The gravity the block will have
	 */
	private final double GRAVITY;
	
	/**
	 * The velocity at which the block is moving up/down
	 */
	private double yVelocity;
	
	public BuildingBlock(double x, double y) {
		this.x = x;
		this.y = y;
		WIDTH = 30;
		GRAVITY = 0.1;
		yVelocity = 0;
	}
	
	/**
	 * Draws this block
	 * @param marker The PApplet with which to draw the block
	 */
	public void draw(PApplet marker) {
		marker.square((float)x, (float)y, (float)WIDTH);
	}
	
	/**
	 * Moves this block with physics
	 * @param blocks All the building blocks in the town
	 * @param floorYCoord The y-coordinate of the floor
	 */
	public void act(ArrayList<BuildingBlock> blocks, double floorYCoord) {
		yVelocity += GRAVITY;
		if(y + WIDTH > floorYCoord) {// if this block has crossed
			yVelocity = 0;//            the floor, stop falling
			y--;
		}
		
		for(int i = 0; i < blocks.size(); i++) {// if this block is touching any other block, stop
			if(isTouching(blocks.get(i)) && !blocks.get(i).equals(this))  //               falling
				yVelocity = 0;
		}
		
		y += yVelocity;
	}
	
	/**
	 * Checks if this block is touching block2 and returns the result as a boolean
	 * @param block2 The block to be checked for touching
	 * @return Whether or not this block is touching block2
	 */
	public boolean isTouching(BuildingBlock block2) {
		double bX = block2.getX();
		double bY = block2.getY();
		double bWidth = block2.getWidth();
		return (x < bX + bWidth) && (x + WIDTH > bX) && (y < bY + bWidth) && (y + WIDTH > bY);
	}
	
	/**
	 * Checks if a point is in this block and returns the result as a boolean
	 * @param pX The x-coordinate of the point to be checked for touching
	 * @param pY The y-coordinate of the point to be checked for touching
	 * @return Whether or not the point is touching block2
	 */
	public boolean isPointInRect(double pX, double pY) {
		return (pX > x) && (pX < x + WIDTH) && (pY > y) && (pY < y + WIDTH);
	}
	
	/**
	 * Returns the x-coordinate of the top left corner of this block
	 * @return The x-coordinate of the top left corner of this block
	 */
	private double getX() { return x; }
	
	/**
	 * Returns the y-coordinate of the top left corner of this block
	 * @return The y-coordinate of the top left corner of this block
	 */
	private double getY() { return y; }
	
	/**
	 * Returns the width of this block
	 * @return The width of this block
	 */
	private double getWidth() { return WIDTH; }
	
	/**
	 * Sets the x-coordinate of the top left corner of this block to newX
	 * @param newX The new x-coordinate of the top left corner of this block
	 */
	private void setX(double newX) {x = newX; }
	
	/**
	 * Sets the y-coordinate of the top left corner of this block to newY
	 * @param newY The new y-coordinate of the top left corner of this block
	 */
	private void setY(double newY) {x = newY; }
}
