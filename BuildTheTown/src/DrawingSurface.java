import processing.core.PApplet;

public class DrawingSurface extends PApplet{
	
	private Tetris tetris;
	private Town town;
	TetrisBlock tetrisBlock = new TetrisBlock(0, 0, 2);
	
	public DrawingSurface() {
		tetris = new Tetris();
		town = new Town();
	}
	
	
	public void setup() {

	}
	
	/**
	 * Draws all the Tetris and Town on to the window 
	 */
	public void draw() {
		background(255);

		TetrisBlock block2 = new TetrisBlock(0, 0, 2);
		//tetrisBlock.move(true);
		//tetrisBlock.move(true);
		//tetrisBlock.fall();
		tetrisBlock.rotate();
		tetrisBlock.draw(this);
		//block2.draw(this);
		//System.out.println(tetrisBlock.isTouching(block2));
		
		
//		Line l1 = new Line(60, 0, 60, 30);
//		Line l2 = new Line(60, 90, 60, 0);
//		stroke(255, 0, 0);
//		line((float)l2.getX(), (float)l2.getY(), (float)l2.getX2(), (float)l2.getY2());
//		stroke(0);
//		line((float)l1.getX(), (float)l1.getY(), (float)l1.getX2(), (float)l1.getY2());
//		System.out.println(l1.overlaps(l2));
	}
	
	public void mousePressed() {
		 
	}
	
}
