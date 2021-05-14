import java.util.ArrayList;

import processing.core.PApplet;

/**
 * 
 * @author Tarini Maram
 *
 */
public class Tetris {

	private ArrayList<TetrisBlock> placedBlocks;
	private boolean[][] grid;
	private TetrisBlock fallingBlock;
	private int points;
	
	public Tetris(PApplet marker) {
		placedBlocks = new ArrayList<TetrisBlock>();
		points = 0;
		resetFallingBlock();
		grid = new boolean[marker.width/30][marker.height/30];
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
		
		if (detectRow() != -1) {
			points+=50;
			for (int i = 0; i < grid[0].length; i++) {
				grid[detectRow()][i] = false;
			}
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
	
	public void placeBlock() {
		if (fallingBlock.getType() == 2) {
			grid[(int)fallingBlock.getX()/30][(int)fallingBlock.getY()/30] = true;
			grid[(int)(fallingBlock.getX()/30) + 1][(int)(fallingBlock.getY()/30)] = true;
			grid[(int)(fallingBlock.getX()/30) + 1][(int)(fallingBlock.getY()/30) + 1] = true;
			grid[(int)(fallingBlock.getX()/30)][(int)(fallingBlock.getY()/30) + 1] = true;
		} else if (fallingBlock.getType() == 1 && !fallingBlock.getRotation()) {
			grid[(int)fallingBlock.getX()/30][(int)fallingBlock.getY()/30] = true;
			grid[(int)fallingBlock.getX()/30][(int)(fallingBlock.getX()/30) + 1] = true;
			grid[(int)fallingBlock.getX()/30][(int)(fallingBlock.getX()/30) + 2] = true;
			grid[(int)fallingBlock.getX()/30][(int)(fallingBlock.getX()/30) + 3] = true;
		} else if (fallingBlock.getType() == 1 && fallingBlock.getRotation()) {
			grid[(int)fallingBlock.getX()/30][(int)fallingBlock.getY()/30] = true;
			grid[(int)(fallingBlock.getX()/30) + 1][(int)fallingBlock.getY()/30] = true;
			grid[(int)(fallingBlock.getX()/30) + 2][(int)fallingBlock.getY()/30] = true;
			grid[(int)(fallingBlock.getX()/30) + 3][(int)fallingBlock.getY()/30] = true;
		}
		fallingBlock.stopFall();
		placedBlocks.add(fallingBlock);
	}
	
	public int detectRow() {
		int result = -1;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (!grid[j][i]) {
					j = grid[0].length;
					result = -1;
				} else {
					result = i;
				}
			}
		}
		return result;
	}
}
