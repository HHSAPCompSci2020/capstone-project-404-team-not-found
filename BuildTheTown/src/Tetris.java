import java.util.ArrayList;

import processing.core.PApplet;

public class Tetris {
	private TetrisBlock fallingBlock;
	private boolean[][] grid; 
	private int points;
	
	
	public Tetris(PApplet marker) {
		resetFallingBlock(marker.width);
	}
	
	public void resetFallingBlock(int windowWidth) {
		int type = (int)(Math.random()*2);
		switch (type) {
			case 1: 
				fallingBlock = new RectangleBlock((int)(Math.random()*windowWidth), 0);
				break;
			case 2: 
				fallingBlock = new SquareBlock((int)(Math.random()*windowWidth), 0);
				break;
		}
	}
	
	public void placeBlock() {
		ArrayList<Square> squares = fallingBlock.getSquares();
		for (int i = 0; i < squares.size(); i++) {
			grid[(int)(squares.get(i).getX()/30)][(int)(squares.get(i).getY()/30)] = true;
		}
	}
	
}