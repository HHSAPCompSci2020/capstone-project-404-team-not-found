import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

import processing.core.PApplet;

public class Tetris {
	private TetrisBlock fallingBlock;
	private Square[][] grid;
	Dimension r = Toolkit.getDefaultToolkit().getScreenSize();
	private int points;
	
	
	public Tetris(PApplet marker) {
//		System.out.println("width: " + (marker.width));
//		System.out.println("height: " + (marker.height));
		//grid = new Square[(int)(r.getWidth()/30)][(int)(r.getHeight()/30)];
		grid = new Square[(int)(marker.height/15)][(int)(marker.width/15)];
		System.out.println("width: " + marker.width);
		System.out.println("height: " + marker.height);
		
		//grid = new Square[30][30];
		resetFallingBlock(marker.width);
		System.out.println(fallingBlock);
	}
	
	/**
	 * places falling block whenever it touches the bottom or falls on top of a block
	 * drops another random block once the previous block was placed
	 * detects when rows are filled, adds points, deletes them from the screen and rearranges the rows above to fall down
	 */
	public void act(PApplet drawer) {
		detectRow();
		Line bottom = new Line(0, drawer.height-2, drawer.width, drawer.height-2);
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (fallingBlock.isTouchingHorizontal(grid[i][j]) || fallingBlock.isTouchingHorizontal(bottom)) {
					fallingBlock.stopFall();
					placeBlock();
					j = grid[0].length;
					i = grid.length;
					resetFallingBlock(drawer.width);
				}
			}
		}
		
	}
	
	/**
	 * draws the placed tetrisBlocks and the falling block
	 * @param marker
	 */
	public void draw(PApplet marker) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] != null) {
					grid[i][j].draw(marker);
				}
			}
		}
		fallingBlock.draw(marker);
		fallingBlock.fall();
	}
	
	/**
	 * creates a new random tetris block and drops it from a random x at the top of the screen
	 * @param windowWidth width of the window
	 */
	public void resetFallingBlock(int windowWidth) {
		int type = (int)(Math.random()*2) + 1;
		System.out.println(type);
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
	
	/**
	 * adds the falling block to the array of placed blocks in this tetris game
	 */
	public void placeBlock() {
		ArrayList<Square> squares = fallingBlock.getSquares();
		//System.out.println(grid.length);
		//System.out.println(grid[0].length);
		for (int i = 0; i < squares.size(); i++) {
			grid[(int)(squares.get(i).getY()/30)][(int)(squares.get(i).getX()/30)] = squares.get(i);
			//grid[(int)(squares.get(i).getY()/30)][(int)(squares.get(i).getX()/30)] = squares.get(i);
		}
	}
	
	/**
	 * detects when a row of placed blocks is full, updates points, and deletes it
	 */
	public void detectRow() {
		//System.out.println("searching for a row");
//		System.out.println("height: " + grid.length);
//		System.out.println("width: " + grid[0].length);
		boolean isFull = true;
		for (int i = 0; i < grid.length; i++) {
			isFull = true;
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == null) {
					isFull = false;
					//System.out.println("block at " + i + "," + j+ "is not full"); 
					//j = grid[0].length;
					break;
				} else {
					//System.out.println("block at " + i + "," + j + " is not null");
				}
			}
			//System.out.println(i + " " + isFull);
			if (isFull) {
				points+=50;
				System.out.println("points: " + points);
				deleteRow(i);
			}
		}
	}
	
	public TetrisBlock getFallingBlock() {
		return fallingBlock;
	}
	
	/**
	 * deletes the row of placed blocks, moves the rows above down 1 so that everything falls black into place
	 * @param r row to be deleted
	 */
	public void deleteRow(int r) {
		System.out.println("detected a row to be deleted");
		for (int i = r; i >= 0; i--) {
			for (int j = 0; j < grid[0].length; j++) {
				if (i == 0) {
					grid[i][j] = null;
				} else {
					grid[i][j] = grid[i-1][j];
					if (grid[i][j] != null) {
						grid[i][j].move(0, 30);
					}
				}
			}
		}
	}
	/**
	 * determines when this tetris game is over 
	 * the game is over when at least one of the placed blocks touches the top of the window
	 * @param top the top Line of the window
	 * @return false if there are no blocks touching the top of the window, true if there are 
	 */
	public boolean isGameOver(Line top) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j].isTouching(top)) {
					return true;
				}
			}
		}
		return false;
	}
}