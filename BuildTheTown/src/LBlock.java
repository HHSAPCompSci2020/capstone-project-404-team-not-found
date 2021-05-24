import java.util.ArrayList;
import java.util.Random;

import processing.core.PApplet;
import processing.core.PShape;

public class LBlock extends TetrisBlock {
	
	private double x, y;
	private ArrayList<Square> squares = new ArrayList<Square>();
	private Random random = new Random();
	private int colorInt;
	
	public LBlock(int x, int y) {
		super(x, y);
		this.x = x;
		this.y = y;
		squares.add(new Square(x, y));
		squares.add(new Square(x, y+30));
		squares.add(new Square(x, y+60));
		squares.add(new Square(x+30, y+60));
		setSquares(squares);
		colorInt = random.nextInt(256);
		super.setColor(colorInt);
	}

	public void rotate() {
		
	}
	public void setColor() {
		super.setColor(colorInt);
	}

//	public void draw(PApplet marker) {
//		PShape block; 
//		block = marker.createShape(marker.GROUP);
//		PShape square1 = marker.createShape(marker.RECT, (float)x, (float)y, 30, 30);
//		PShape square2 = marker.createShape(marker.RECT, (float)x, (float)y+30, 30, 30);
//		PShape square3 = marker.createShape(marker.RECT, (float)x, (float)y+60, 30, 30);
//		PShape square4 = marker.createShape(marker.RECT, (float)x+30, (float)y+60, 30, 30);
//		block.addChild(square1);
//		block.addChild(square2);
//		block.addChild(square3);
//		block.addChild(square4);
//		marker.fill(0);
//		marker.shape(block);
//	}
}
