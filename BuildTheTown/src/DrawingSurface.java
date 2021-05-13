import processing.core.PApplet;

public class DrawingSurface extends PApplet{
	
	private Tetris tetris;
	private Town town;
	
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
		TetrisBlock tetrisBlock = new TetrisBlock(4);
		tetrisBlock.move(true);
		tetrisBlock.draw(this);
	}
	
	public void mousePressed() {
		 
	}
	
}
