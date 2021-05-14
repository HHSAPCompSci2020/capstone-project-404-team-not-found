import java.util.ArrayList;

import processing.core.PApplet;

/**
 * 
 * @author Tarini Maram
 *
 */
public class Tetris {

	private ArrayList<TetrisBlock> placedBlocks;
	private TetrisBlock fallingBlock;
	private int points;
	
	public Tetris() {
		placedBlocks = new ArrayList<TetrisBlock>();
		points = 0;
		resetFallingBlock();
	}
	
	public void act(PApplet marker) {
		Line left = new Line(0, 0, 0, marker.height);
		Line right = new Line(marker.width, 0, marker.width, marker.height);
		Line top = new Line(0, 0, marker.width, 0);
		Line bottom = new Line(0, marker.height, marker.width, marker.height);
		
		fallingBlock.fall();
		if (fallingBlock.isTouching(bottom)) {
			placedBlocks.add(fallingBlock);
			resetFallingBlock();
		} 
		
		for (int i = 0; i < placedBlocks.size(); i++) {
			if (placedBlocks.get(i).isTouching(top)) {
				end();
			}
			
			if (fallingBlock.isTouching(placedBlocks.get(i))) {
				placedBlocks.add(fallingBlock);
				resetFallingBlock();
			}
		}
		
		if (detectRow()) {
			points+=50;
		}
//		while (!()) {
//			for (int i = 0; i < placedBlocks.size(); i++) {
//				if (!(fallingBlock.isTouching(placedBlocks.get(i)))) {
//				}
//			}
//		}
	}
	
	public int end() {
		return points;
	}
	
	public void resetFallingBlock() {
		fallingBlock = new TetrisBlock(0, 0, (int)(Math.random()*4));
	}
	
	public boolean detectRow() {
		
		return false;
	}
}
