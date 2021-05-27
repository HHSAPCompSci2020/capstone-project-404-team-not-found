import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class RectangleBlock extends TetrisBlock {

	//private double x,y;
	private ArrayList<Square> squares = new ArrayList<Square>();
	private int numRotate;
	
	/**
	 * Creates a four-square long horizontal Tetris Block at the specified coordinate
	 * @param x X-coordinate of the top-left corner of this Rectangle Block
	 * @param y Y-coordinate of the top-left corner of this Rectangle Block
	 */
	public RectangleBlock(int x, int y) {
		super(x, y);
		numRotate = 0;
		squares.add(new Square(x, y, Color.GREEN));
		squares.add(new Square(x+30, y, Color.GREEN));
		squares.add(new Square(x+60, y, Color.GREEN));
		squares.add(new Square(x+90, y, Color.GREEN));
		setSquares(squares);
		setColor(Color.GREEN);
	}

	@Override
	public void rotate() {
		if (numRotate % 2 == 0) {
			squares.set(0, new Square(getX(), getY(), Color.GREEN));
			squares.set(1, new Square(getX(), getY()+30, Color.GREEN));
			squares.set(2, new Square(getX(), getY()+60, Color.GREEN));
			squares.set(3, new Square(getX(), getY()+90, Color.GREEN));
			setSquares(squares);
		} else if (numRotate % 2 == 1) {
			squares.set(0, new Square(getX(), getY(), Color.GREEN));
			squares.set(1, new Square(getX()+30, getY(), Color.GREEN));
			squares.set(2, new Square(getX()+60, getY(), Color.GREEN));
			squares.set(3, new Square(getX()+90, getY(), Color.GREEN));
			setSquares(squares);
		}
		System.out.println(getX());
		numRotate++;
	}


}
