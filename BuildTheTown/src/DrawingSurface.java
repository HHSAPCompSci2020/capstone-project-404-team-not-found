import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

import processing.core.PApplet; 

public class DrawingSurface extends PApplet{
	
	private Tetris tetris;
	private Town town;
	TetrisBlock tetrisBlock;
	TetrisBlock block2;
	private ArrayList<TetrisBlock> placedBlocks;
//	Dimension r = Toolkit.getDefaultToolkit().getScreenSize();
	private boolean fall;
	
	
	public DrawingSurface() {
		tetris = new Tetris(this);
		town = new Town(width);
		fall = true;
		placedBlocks = new ArrayList<TetrisBlock>();
	}
	
	
	public void setup() {
		
		tetrisBlock = new SquareBlock(90, 0);
//		block2 = new RectangleBlock(90, 0);
	}
	
	/**
	 * Draws all the Tetris and Town on to the window 
	 */
	public void draw() {
		background(255);
		
		tetris.draw(this);
		tetrisBlock.fall();
		tetris.act(this);
		this.color(0);
		Line top = new Line(20, 0, width, 20);
		if (tetris.isGameOver(top)) {
			background(255);
			
		}
		
		
		
		
		
		
//		tetrisBlock.draw(this);
//		tetrisBlock.fall();
////		block2.draw(this);
////		block2.fall();
//		Line bottom = new Line(0, height-2, width, height-2);
//		if (tetrisBlock.isTouchingHorizontal(bottom)) {
//			//System.out.println("touched bottom");
//			tetrisBlock.stopFall();
//			placedBlocks.add(tetrisBlock);
//		}
//		if (block2.isTouchingHorizontal(bottom)) {
//			//System.out.println("touched bottom");
//			block2.stopFall();
//		}

//		if(block2.isTouchingHorizontal(tetrisBlock)) {
//			block2.stopFall();
//			System.out.println("touched other block");
//		}

		
	}
	
	public void keyPressed() {
		 if (key == 'r' || key == 'R') {
			 tetrisBlock.rotate();
		 }
		 if (keyCode == RIGHT) {
			 block2.move(true);
		 }
		 if (keyCode == LEFT) {
			 block2.move(false);
		 }
	}
	
}














