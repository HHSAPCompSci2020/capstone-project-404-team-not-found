import processing.core.PApplet;
import java.util.ArrayList;

/**
 * 
 * @author Joanna Huang
 *
 */
public class Town {
	
	private ArrayList<BuildingBlock> blocks;
	private int blockCount;
	
	public Town(int blockCount) {
		blocks = new ArrayList<BuildingBlock>();
		this.blockCount = blockCount;
	}
	
	/**
	 * Draws the array of blocks
	 * @param marker The PApplet with which to draw the blocks
	 */
	public void draw(PApplet marker) {
		for(int i = 0; i < blocks.size(); i++) {
			blocks.get(i).draw(marker);
		}
	}
	
	/**
	 * Moves the blocks in the array with physics
	 * @param windowWidth The width of the window
	 * @param windowHeight The height of the window
	 */
	public void act(double windowWidth, double windowHeight) {
		for(int i = 0; i < blocks.size(); i++) {
			blocks.get(i).act(blocks, windowWidth, windowHeight);
		}
	}
	
	/**
	 * Places a block centered at the point clicked (pX, pY)
	 * @param pX The x-coordinate of the point that has been clicked
	 * @param pY The y-coordinate of the point that has been clicked
	 */
	public void placeBlock(double pX, double pY) {
		if(blockCount > 0) {
			blocks.add(new BuildingBlock(pX - 25, pY - 25)); // block width is 50
			blockCount--;
		}
	}
	
	/**
	 * Removes the block containing the point clicked (pX, pY)
	 * @param pX The x-coordinate of the point that has been clicked
	 * @param pY the y-coordinate of the point that has been clicked
	 */
	public void deleteBlock(double pX, double pY) {
		for(int i = 0; i < blocks.size(); i++) {
			if(blocks.get(i).isPointInRect(pX, pY))
				blocks.remove(i);
		}
		blockCount++;
	}
}
