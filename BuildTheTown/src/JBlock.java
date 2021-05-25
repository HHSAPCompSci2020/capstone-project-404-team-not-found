import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class JBlock extends TetrisBlock {

	private double x,y;
	private ArrayList<Square> squares = new ArrayList<Square>();
	
	/**
	 * Creates a new Tetris Block that is 3 Squares tall and has one Square sticking out horizontally to the right of the top Square
	 * @param x X-coordinate of the top-left corner of this J-Block
	 * @param y Y-coordinate of the top-left corner of this J-Block
	 */
	public JBlock(int x, int y) {
		super(x, y);
		this.x = x;
		this.y = y;
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
		
	}

}
