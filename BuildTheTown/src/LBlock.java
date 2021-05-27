import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import processing.core.PApplet;
import processing.core.PShape;

public class LBlock extends TetrisBlock {
	
	//private double x, y;
	private ArrayList<Square> squares = new ArrayList<Square>();
	private int numRotate;
	
	/**
	 * Creates a new Tetris Block that is shaped like the letter L 
	 * 3 Squares tall and one Square sticking out horizontally to the right of the bottom Square
	 * @param x X-coordinate of the top-left corner of this L-Block
	 * @param y Y-coordinate of the top-left corner of this L-Block
	 */
	public LBlock(int x, int y) {
		super(x, y);
		numRotate = 0;
		squares.add(new Square(x, y, Color.RED));
		squares.add(new Square(x, y+30, Color.RED));
		squares.add(new Square(x, y+60, Color.RED));
		squares.add(new Square(x+30, y+60, Color.RED));
		setSquares(squares);
		super.setColor(Color.RED);
	}

	public void rotate() {
		if (numRotate % 4 == 0) {
			squares.set(0, new Square(getX(), getY(), Color.RED));
			squares.set(1, new Square(getX(), getY()+30, Color.RED));
			squares.set(2, new Square(getX()+30, getY(), Color.RED));
			squares.set(3, new Square(getX()+60, getY(), Color.RED));
			setSquares(squares);
		} else if (numRotate % 4 == 1) {
			squares.set(0, new Square(getX(), getY(), Color.RED));
			squares.set(1, new Square(getX()+30, getY(), Color.RED));
			squares.set(2, new Square(getX()+30, getY()+30, Color.RED));
			squares.set(3, new Square(getX()+30, getY()+60, Color.RED));
			setSquares(squares);
		} else if (numRotate % 4 == 2) {
			squares.set(0, new Square(getX(), getY(), Color.RED));
			squares.set(1, new Square(getX()+30, getY(), Color.RED));
			squares.set(2, new Square(getX()+60, getY(), Color.RED));
			squares.set(3, new Square(getX()+60, getY()-30, Color.RED));
			setSquares(squares);
		} else if (numRotate % 4 == 3) {
			squares.set(0, new Square(getX(), getY(), Color.RED));
			squares.set(1, new Square(getX(), getY()+30, Color.RED));
			squares.set(2, new Square(getX(), getY()+60, Color.RED));
			squares.set(3, new Square(getX()+30, getY()+60, Color.RED));
			setSquares(squares);
		}
		System.out.println(getX());
		numRotate++;
	}

}
