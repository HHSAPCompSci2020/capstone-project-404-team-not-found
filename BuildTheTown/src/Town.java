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
	private double floorYCoord;
	private boolean started;
	
	public Town(double windowHeight) {
		blocks = new ArrayList<BuildingBlock>();
		floorYCoord = 9 * windowHeight/10;
		started = false;
	}
	
	/**
	 * Starts the town-building part of the game
	 * @param blockCount The number of blocks gained from Tetris
	 */
	public void start(int blockCount) {
		this.blockCount = blockCount;
		started = true;
	}
	
	/**
	 * Draws the array of blocks
	 * @param marker The PApplet with which to draw the blocks
	 * @param windowWidth The width of the window
	 */
	public void draw(PApplet marker, double windowWidth) {
		if(started) {
			for(int i = 0; i < blocks.size(); i++) {
				blocks.get(i).draw(marker);
			}
			marker.line((float)(0), (float)(floorYCoord), (float)(windowWidth), (float)(floorYCoord));
		}
	}
	
	/**
	 * Moves the blocks in the Town with physics
	 */
	public void act() {
		if(started) {
			for(int i = 0; i < blocks.size(); i++) {
				blocks.get(i).act(blocks, floorYCoord);
			}
		}
	}
	
	/**
	 * Places a block centered at the point clicked (pX, pY)
	 * @param pX The x-coordinate of the point that has been clicked
	 * @param pY The y-coordinate of the point that has been clicked
	 */
	public void placeBlock(double pX, double pY) {
		if(started) {
			if(blockCount > 0) {
				blocks.add(new BuildingBlock(pX - 25, pY - 25)); // block width is 50
				blockCount--;
			}
		}
	}
	
	/**
	 * Removes the block containing the point clicked (pX, pY)
	 * @param pX The x-coordinate of the point that has been clicked
	 * @param pY the y-coordinate of the point that has been clicked
	 */
	public void deleteBlock(double pX, double pY) {
		if(started) {
			for(int i = 0; i < blocks.size(); i++) {
				if(blocks.get(i).isPointInRect(pX, pY))
					blocks.remove(i);
			}
			blockCount++;
		}
	}
}
