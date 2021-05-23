import java.awt.Dimension;
import java.awt.Toolkit;
import processing.core.PApplet; 

public class DrawingSurface extends PApplet{
	
	private Tetris tetris;
	private Town town;
	TetrisBlock tetrisBlock;
	TetrisBlock block2;
	Dimension r = Toolkit.getDefaultToolkit().getScreenSize();
	private boolean fall;
	public DrawingSurface() {
		town = new Town(r.getWidth());
		fall = true;
	}
	
	public void settings() {
		size(800, 600);
	}
	
	public void setup() {
		tetrisBlock = new SquareBlock(90, 300);
		block2 = new RectangleBlock(90, 0);
		tetris = new Tetris(this);
		
	}
	
	/**
	 * Draws all the Tetris and Town on to the window 
	 */
	public void draw() {
		background(255);
		tetris.draw(this);
		tetris.act(this);
	}
	
	public void keyPressed() {
		 if (key == 'r' || key == 'R') {
			 tetris.getFallingBlock().rotate();
		 }
		 if (keyCode == RIGHT) {
			 Line right = new Line(780, 0, 780, 561);
			 //System.out.println(width);
			 //System.out.println(height);
			 if (!tetris.getFallingBlock().isTouchingVertical(right)) {
				 tetris.getFallingBlock().move(true);
			 }
			 
		 }
		 if (keyCode == LEFT) {
			 Line left = new Line(0, 0, 0, height);
			 if (!tetris.getFallingBlock().isTouchingVertical(left)) {
				 tetris.getFallingBlock().move(false);
			 }
			 
		 }
	}
	
}














