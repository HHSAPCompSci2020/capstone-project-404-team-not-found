import java.util.ArrayList;

public class SquareBlock extends TetrisBlock {

	private ArrayList<Square> squares = new ArrayList<Square>();
	
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
	}

	@Override
	public void rotate() {
		// TODO Auto-generated method stub
		
	}


}
