import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Random;

import processing.core.PApplet; 

/**
 * 
 * @author Anya Agrawal
 *
 */

public class DrawingSurface extends PApplet{
	
	private Tetris tetris;
	private Town town;
	private Menu menu;
//	private boolean townPlay; 
	Dimension r = Toolkit.getDefaultToolkit().getScreenSize();
	private Line top;
//	private Random random;
//	private boolean townPlay;

	public DrawingSurface() {
		top = new Line(0, 60, width, 60);
//		random = new Random();
//		townPlay = false;
	}
	
	/* 
	 * Instantiates the menu, tetris and town classes. 
	 */
	public void setup() {
		tetris = new Tetris(this); 
		town = new Town();
		menu = new Menu();
	}
	
	public void settings() {
		size(800, 600);
	}
	
	/**
	 * Draws Menu, Tetris, and the Town on to the window and shifts between each appropriately when the circumstances are fulfilled.  
	 */
	public void draw() {
		background(255);
//		TetrisBlock block = new LBlock(50, 50);
//		block.draw(this);
		
		if (!(menu.getDone())) {
			runMenu();
		}
		else if (menu.getDone() && !(tetris.isGameOver(top))) {
			runTetris();
		}
		else { 
//			townPlay = true;
			runTown();
		}
		
	}
	
	/* 
	 * Draws the menu onto the window. 
	 */
	private void runMenu() {
		menu.draw(this);
		
	}
	
	/* 
	 * Draws the Tetris game onto the window. 
	 */
	private void runTetris() {
		this.line((float) 0, (float)60, (float)r.getWidth(), (float)60);
//		int colorInt = random.nextInt(256);
//		marker.fill(colorInt);
		tetris.draw(this);
		tetris.act(this);
				
		
	}
	
	/* 
	 * Draws the Town game onto the window. 
	 */
	private void runTown() {
		town.start(tetris.getNumFallenBlocks());
		town.draw(this);
		town.act(this);
	}
	
	
	/* 
	 * An active listener method that checks for what button on the keyboard is pushed and performs the corresponding action
	 */
	public void keyPressed() { 
//		 if (key == 'r' || key == 'R') {
//			 tetris.getFallingBlock().rotate();
//		 }
		 if (keyCode == RIGHT) {
			 Line right = new Line(780, 0, 780, 561);
			 //System.out.println(width);
			 //System.out.println(height);
			 if (!tetris.getFallingBlock().isTouchingVertical(right) && !tetris.isFallingBlockTouchingBlocks()) {
				 tetris.getFallingBlock().move(true);
			 }
			 
		 }
		 if (keyCode == LEFT) {
			 Line left = new Line(0, 0, 0, height);
			 if (!tetris.getFallingBlock().isTouchingVertical(left) && !tetris.isFallingBlockTouchingBlocks()) {
				 tetris.getFallingBlock().move(false);
			 }
			 
		 }
	}
	
	
	/* 
	 * An active listener method that checks for what button on the mouse is clicked and performs the corresponding action
	 */
	public void mouseClicked() {
		if (mouseButton == LEFT && !(town.getStarted())) {
			menu.mouseClicked(this, mouseX, mouseY);
		}
		if (mouseButton == LEFT && town.getStarted()) {
			town.placeBlock(mouseX, mouseY);
		}
		if (mouseButton == RIGHT && town.getStarted()) {
			town.deleteBlock(mouseX, mouseY);
		}
	}
	
}














