import java.util.ArrayList;

import processing.core.PApplet;

public class Tetris {
	private TetrisBlock fallingBlock;
	private Square[][] grid; 
	private int points;
	
	
	public Tetris(PApplet marker) {
		grid = new Square[(int)(marker.width/30)][(marker.height/30)];
		resetFallingBlock(marker.width);
	}
	
	
	public void act() {
		detectRow();
	}
	
	public void draw(PApplet marker) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] != null) {
					grid[i][j].draw(marker);
				}
			}
		}
	}
	
	public void resetFallingBlock(int windowWidth) {
		int type = (int)(Math.random()*2);
		switch (type) {
			case 1: 
				int n = (int)(Math.random()*windowWidth/30);
				fallingBlock = new RectangleBlock(n*30, 0);
				break;
			case 2: 
				n = (int)(Math.random()*windowWidth/30);
				fallingBlock = new SquareBlock(n*30, 0);
				break;
		}
	}
	
	public void placeBlock() {
		ArrayList<Square> squares = fallingBlock.getSquares();
		for (int i = 0; i < squares.size(); i++) {
			grid[(int)(squares.get(i).getX()/30)][(int)(squares.get(i).getY()/30)] = squares.get(i);
		}
	}
	
	public void detectRow() {
		boolean isFull = true;
		for (int i = 0; i < grid.length; i++) {
			isFull = true;
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == null) {
					isFull = false;
					j = grid[0].length;
				} 
			}
			if (isFull) {
				points+=50;
				deleteRow(i);
			}
		}
	}
	
	public void deleteRow(int r) {
		for (int i = r; i >= 0; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (i == 0) {
					grid[i][j] = null;
				} else {
					grid[i][j] = grid[i-1][j];
				}
			}
		}
	}
}