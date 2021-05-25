import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import processing.core.PApplet;
import processing.core.PShape;

public class LBlock extends TetrisBlock {
	
	private double x, y;
	private ArrayList<Square> squares = new ArrayList<Square>();
	
	/**
	 * Creates a new Tetris Block that is shaped like the letter L 
	 * 3 Squares tall and one Square sticking out horizontally to the right of the bottom Square
	 * @param x X-coordinate of the top-left corner of this L-Block
	 * @param y Y-coordinate of the top-left corner of this L-Block
	 */
	public LBlock(int x, int y) {
		super(x, y);
		this.x = x;
		this.y = y;
		squares.add(new Square(x, y, Color.RED));
		squares.add(new Square(x, y+30, Color.RED));
		squares.add(new Square(x, y+60, Color.RED));
		squares.add(new Square(x+30, y+60, Color.RED));
		setSquares(squares);
		super.setColor(Color.RED);
	}

	public void rotate() {
		
	}

}
