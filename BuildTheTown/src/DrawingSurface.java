import java.awt.Dimension;
import java.awt.Toolkit;
import processing.core.PApplet; 

public class DrawingSurface extends PApplet{
	
	private Tetris tetris;
	private Town town;
	private Menu menu;
	Dimension r = Toolkit.getDefaultToolkit().getScreenSize();
	private Line top;

	
	public DrawingSurface() {
		town = new Town();
		tetris = new Tetris(this);
		menu = new Menu();
		top = new Line( 0, 100, r.getWidth(), 100);
	}
	
	public void settings() {
		size(800, 600);
	}
	
	public void setup() {
		
	}
	
	/**
	 * Draws all the Tetris and Town on to the window 
	 */
	public void draw() {
		background(255);
//		this.line((float) 0, (float)100, (float)r.getWidth(), (float)100);
		
		if (!(menu.getDone())) {
			runMenu();
		}
		else if (menu.getDone() && !(tetris.isGameOver(top))) {
			runTetris();
		}
	}
	
	private void runMenu() {
		menu.draw(this);
		
	}
	
	private void runTetris() {
		tetris.draw(this);
		tetris.act(this);
	}
	
	private void runTown() {
		
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
	
	public void mouseClicked() {
		if (mouseButton == LEFT) {
			menu.mouseClicked(this, mouseX, mouseY);
		}
	}
	
}














