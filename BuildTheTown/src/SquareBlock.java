import java.util.ArrayList;
import java.util.Random;

public class SquareBlock extends TetrisBlock {

	private ArrayList<Square> squares = new ArrayList<Square>();
	private Random random = new Random();
	private int colorInt;
	
	/**
	 * Creates a new 2x2 Square Tetris Block that is made up of 4 Squares
	 * @param x X-coordinate of the top-left corner of this Square Block
	 * @param y Y-coordinate of the top-left corner of this Square Block
	 */
	public SquareBlock(int x, int y) {
		super(x, y);
		squares.add(new Square(x, y));
		squares.add(new Square(x+30, y));
		squares.add(new Square(x, y+30));
		squares.add(new Square(x+30, y+30));
		setSquares(squares);
		colorInt = random.nextInt(256);
		super.setColor(colorInt);
	}

	@Override
	public void rotate() {
		// TODO Auto-generated method stub
		
	}
	
	public void setColor() {
		super.setColor(colorInt);
	}


}
