import java.awt.Dimension;
import java.awt.Toolkit;
import processing.core.PApplet; 

public class DrawingSurface extends PApplet{
	
	private Tetris tetris;
	private Town town;
	TetrisBlock tetrisBlock = new TetrisBlock(0, 0, 2);
	Dimension r = Toolkit.getDefaultToolkit().getScreenSize();
	
	public DrawingSurface() {
		tetris = new Tetris(this);
		town = new Town(3, r.getHeight());

		tetris = new Tetris(this);
		town = new Town(3, r.getHeight());
	}
	
	
	public void setup() {

	}
	
	/**
	 * Draws all the Tetris and Town on to the window 
	 */
	public void draw() {
		background(255);


//		TetrisBlock block2 = new TetrisBlock(0, 0, 3);
//		tetrisBlock.move(true);
//		tetrisBlock.move(true);
		tetrisBlock.fall();
//		TetrisBlock block2 = new TetrisBlock(0, 0, 2);
		//tetrisBlock.move(true);
		//tetrisBlock.move(true);
		//tetrisBlock.fall();
//		tetrisBlock.rotate();
		tetrisBlock.draw(this);
		town.draw(this, r.getWidth());
		town.act();
		
//		town.act(getWidth(), windowHeight);
//		block2.draw(this);
//		System.out.println(tetrisBlock.isTouching(block2));
		
		
//		Line l1 = new Line(60, 0, 60, 30);
//		Line l2 = new Line(60, 90, 60, 0);
//		stroke(255, 0, 0);
//		line((float)l2.getX(), (float)l2.getY(), (float)l2.getX2(), (float)l2.getY2());
//		stroke(0);
//		line((float)l1.getX(), (float)l1.getY(), (float)l1.getX2(), (float)l1.getY2());
//		System.out.println(l1.overlaps(l2));
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














