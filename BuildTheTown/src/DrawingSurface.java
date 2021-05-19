import java.awt.Dimension;
import java.awt.Toolkit;
import processing.core.PApplet; 

public class DrawingSurface extends PApplet{
	
	private Tetris tetris;
	private Town town;
	TetrisBlock tetrisBlock;
	Dimension r = Toolkit.getDefaultToolkit().getScreenSize();
	private boolean fall;
	public DrawingSurface() {
		tetris = new Tetris(this);
		town = new Town(3, width);
		fall = true;
	}
	
	
	public void setup() {
		tetrisBlock = new SquareBlock(400, 200);
	}
	
	/**
	 * Draws all the Tetris and Town on to the window 
	 */
	public void draw() {
		background(255);
		tetrisBlock.draw(this);
		tetrisBlock.fall();
//		Line bottom = new Line(0, height-2, width, height-2);
//		//System.out.println(height);
//		if (tetrisBlock.isTouchingHorizontal(bottom)) {
//			System.out.println("touched bottom");
//			tetrisBlock.stopFall();
//		}
//		SquareBlock block = new SquareBlock(100, 100);
//		block.draw(this);
//		block.rotate();
//		block.draw(this);
//		Line l = new Line(100, 150, 200, 150);
//		line((float)l.getX(), (float)l.getY(), (float)l.getX2(), (float)l.getY2());
//		System.out.println("(" + l.getX() + "," + l.getY() + ") (" + l.getX2() + "," + l.getY2() + ")");
//		l.rotate();
//		line((float)l.getX(), (float)l.getY(), (float)l.getX2(), (float)l.getY2());
//		System.out.println("(" + l.getX() + "," + l.getY() + ") (" + l.getX2() + "," + l.getY2() + ")");
//		TetrisBlock block2 = new TetrisBlock(0, 0, 3);
//		tetrisBlock.move(true);
//		tetrisBlock.move(true);

//		TetrisBlock block2 = new TetrisBlock(0, 0, 2);
		//tetrisBlock.move(true);
		//tetrisBlock.move(true);
		//tetrisBlock.fall();
////		tetrisBlock.rotate();
//		tetrisBlock.draw(this);
//
//		town.draw(this, width);
//		town.act();
//		
//		if(fall) {
//			tetrisBlock.fall();
//		}
//		
//		Line bottom = new Line(0, height, width, height);
//		if(tetrisBlock.isTouching(bottom)) {
//			fall = false;
//			tetrisBlock.stopFall();
//		}
////		town.act(getWidth(), windowHeight);
//		block2.draw(this);
//		System.out.println(tetrisBlock.isTouching(block2));
		
		
	}
	
	public void keyPressed() {
		 if (key == 'r' || key == 'R') {
			 tetrisBlock.rotate();
		 }
		 if (keyCode == RIGHT) {
			 tetrisBlock.move(true);
		 }
		 if (keyCode == LEFT) {
			 tetrisBlock.move(false);
		 }
	}
	
}














