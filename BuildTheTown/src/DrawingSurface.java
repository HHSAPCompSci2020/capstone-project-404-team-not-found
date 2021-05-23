import java.awt.Dimension;
import java.awt.Toolkit;
import processing.core.PApplet; 

public class DrawingSurface extends PApplet{
	
	private Tetris tetris;
	private Town town;
	private Menu menu;
	private boolean townPlay; 
	Dimension r = Toolkit.getDefaultToolkit().getScreenSize();
	private Line top;

	
	public DrawingSurface() {
		town = new Town();
		tetris = new Tetris(this);
		menu = new Menu();
		top = new Line( 0, 70, r.getWidth(), 70);
		townPlay = false;
	}
	
	
	public void setup() {
		
	}
	
	/**
	 * Draws all the Tetris and Town on to the window 
	 */
	public void draw() {
		background(255);
		
		if (!(menu.getDone())) {
			runMenu();
		}
		else if (menu.getDone() && !(tetris.isGameOver(top))) {
			runTetris();
		}
		else { 
			townPlay = true;
			runTown();
		}
		
	}
	
	private void runMenu() {
		menu.draw(this);
		
	}
	
	private void runTetris() {
		this.line((float) 0, (float)70, (float)r.getWidth(), (float)70);
		tetris.draw(this);
		tetris.act(this);
				
		
	}
	
	private void runTown() {
		town.start(tetris.getNumFallenBlocks());
		town.draw(this);
		town.act(this);
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
		if (mouseButton == LEFT && !(townPlay)) {
			menu.mouseClicked(this, mouseX, mouseY);
		}
		if (mouseButton == LEFT && townPlay) {
			town.placeBlock(mouseX, mouseY);
		}
		if (mouseButton == RIGHT && townPlay) {
			town.deleteBlock(mouseX, mouseY);
		}
	}
	
}














