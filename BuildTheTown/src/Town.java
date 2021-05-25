import processing.core.PApplet;
import java.util.ArrayList;

/**
 * 
 * @author Joanna Huang
 *
 */
public class Town {
	
	/**
	 * All the building blocks in the town
	 */
	private ArrayList<BuildingBlock> blocks;
	
	/**
	 * The number of blocks that can be placed in the town
	 */
	private int blockCount;
	
	/**
	 * Whether or not the town part of the game has started
	 */
	private boolean started;
	
	/**
	 * Whether or not it is daytime in the town
	 */
	private boolean daytime;
	
	private int counter;
	
	public Town() {
		blocks = new ArrayList<BuildingBlock>();
		started = false;
		daytime = true;
		counter = 0;
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
	public void draw(PApplet marker) {
		//switches day and night every 10 seconds
		counter++;
		if(counter % 1200 == 0)
			daytime = true;
		else if(counter % 1200 == 600)
			daytime = false;
		
		if(daytime) {
			marker.background(255); //turn background white
			marker.stroke(0);
		} else {
			marker.background(100, 100, 230); //turn background dark blue
			marker.stroke(255);
		}
	
		for(int i = 0; i < blocks.size(); i++) {
				blocks.get(i).draw(marker, daytime);
		}
		
		if(daytime) {
			marker.fill(0);
			marker.text("DAY", marker.width/2, marker.height/6);
			marker.text(blockCount - blocks.size(), marker.width/2, marker.height/4);
		}
		else {
			marker.fill(255);
			marker.text("NIGHT", marker.width/2, marker.height/6);
			marker.text(blockCount - blocks.size(), marker.width/2, marker.height/4);
		}
		
		marker.line((float)(0), (float)(9 * marker.height/10), (float)(marker.width), (float)(9 * marker.height/10));
	}
	
	/**
	 * Moves the blocks in the Town with physics
	 * @param marker The PApplet with which the floor's y-coordinate will be generated
	 */
	public void act(PApplet marker) {
		for(int i = 0; i < blocks.size(); i++) {
			blocks.get(i).act(blocks, 9 * marker.height/10);
		}
	}
	
	/**
	 * Places a block centered at the point clicked (pX, pY)
	 * @param pX The x-coordinate of the point that has been clicked
	 * @param pY The y-coordinate of the point that has been clicked
	 */
	public void placeBlock(double pX, double pY) {
		if(blocks.size() < blockCount)
			blocks.add(new BuildingBlock(pX - 15, pY - 15)); // block width is 30
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
	}
	
	/**
	 * Returns whether or not the town part of the game has started
	 * @return Whether or not the town part of the game has started
	 */
	public boolean getStarted() { return started; } 
	
	/**
	 * Returns whether or not it is daytime in the town
	 * @return whether or not it is daytime in the town
	 */
	public boolean getDaytime() { return daytime; }
}
