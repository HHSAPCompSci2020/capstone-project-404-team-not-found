import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class JBlock extends TetrisBlock {

	//private double x,y;
	private ArrayList<Square> squares = new ArrayList<Square>();
	private int numRotate;
	
	/**
	 * Creates a new Tetris Block that is 3 Squares tall and has one Square sticking out horizontally to the right of the top Square
	 * @param x X-coordinate of the top-left corner of this J-Block
	 * @param y Y-coordinate of the top-left corner of this J-Block
	 */
	public JBlock(int x, int y) {
		super(x, y);
		numRotate = 0;
		squares.add(new Square(x, y, Color.YELLOW));
		squares.add(new Square(x+30, y, Color.YELLOW));
		squares.add(new Square(x, y+30, Color.YELLOW));
		squares.add(new Square(x, y+60, Color.YELLOW));
		setSquares(squares);
		super.setColor(Color.YELLOW);
	}

	@Override
	public void rotate() {
		// TODO Auto-generated method stub
		if (numRotate % 4 == 0) {
			squares.set(0, new Square(getX(), getY(), Color.YELLOW));
			squares.set(1, new Square(getX()+30, getY(), Color.YELLOW));
			squares.set(2, new Square(getX()+60, getY(), Color.YELLOW));
			squares.set(3, new Square(getX()+60, getY()+30, Color.YELLOW));
			setSquares(squares);
		} else if (numRotate % 4 == 1) {
			squares.set(0, new Square(getX(), getY(), Color.YELLOW));
			squares.set(1, new Square(getX(), getY()+30, Color.YELLOW));
			squares.set(2, new Square(getX(), getY()+60, Color.YELLOW));
			squares.set(3, new Square(getX()-30, getY()+60, Color.YELLOW));
			setSquares(squares);
		} else if (numRotate % 4 == 2) {
			squares.set(0, new Square(getX(), getY(), Color.YELLOW));
			squares.set(1, new Square(getX(), getY()+30, Color.YELLOW));
			squares.set(2, new Square(getX()+30, getY()+30, Color.YELLOW));
			squares.set(3, new Square(getX()+60, getY()+30, Color.YELLOW));
			setSquares(squares);
		} else if (numRotate % 4 == 3) {
			squares.set(0, new Square(getX(), getY(), Color.YELLOW));
			squares.set(1, new Square(getX()+30, getY(), Color.YELLOW));
			squares.set(2, new Square(getX(), getY()+30, Color.YELLOW));
			squares.set(3, new Square(getX(), getY()+60, Color.YELLOW));
			setSquares(squares);
		}
		System.out.println(getX());
		numRotate++;
	}

}
