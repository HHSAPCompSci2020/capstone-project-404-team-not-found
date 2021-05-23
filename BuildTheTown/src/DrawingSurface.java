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
		//tetris.act(this);
//		tetrisBlock.draw(this);
//		tetrisBlock.fall();
//		block2.draw(this);
//		block2.fall();
//		Line bottom = new Line(0, height-2, width, height-2);
//		//System.out.println(height);
//		if (tetrisBlock.isTouchingHorizontal(bottom)) {
//			//System.out.println("touched bottom");
//			tetrisBlock.stopFall();
//		}
//		if (block2.isTouchingHorizontal(bottom)) {
//			//System.out.println("touched bottom");
//			block2.stopFall();
//		}
//		//System.out.println(tetrisBlock.getVerticalLines());
////		Line l1 = new Line(30, 30, 30, 0);
////		Line l2 = new Line(30, 0, 30, 30);
////		if (l1.equals(l2)) {
////			System.out.println("true");
////		} else {
////			System.out.println("false");
////		}
//		if(block2.isTouchingHorizontal(tetrisBlock)) {
//			block2.stopFall();
//			System.out.println("touched other block");
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
			 tetris.getFallingBlock().move(true);
		 }
		 if (keyCode == LEFT) {
			 tetris.getFallingBlock().move(false);
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














