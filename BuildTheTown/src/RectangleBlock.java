import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class RectangleBlock extends TetrisBlock {

	private double x,y;
	private ArrayList<Square> squares = new ArrayList<Square>();
	
	/**
	 * Creates a four-square long horizontal Tetris Block at the specified coordinate
	 * @param x X-coordinate of the top-left corner of this Rectangle Block
	 * @param y Y-coordinate of the top-left corner of this Rectangle Block
	 */
	public RectangleBlock(int x, int y) {
		super(x, y);
		this.x = x;
		this.y = y;
		squares.add(new Square(x, y, Color.GREEN));
		squares.add(new Square(x+30, y, Color.GREEN));
		squares.add(new Square(x+60, y, Color.GREEN));
		squares.add(new Square(x+90, y, Color.GREEN));
		setSquares(squares);
		setColor(Color.GREEN);
	}

//	@Override
//	public void rotate() {
//		for (int i = 0; i < squares.size(); i++) {
//			squares.get(i).rotate();
//		}
//		
//		double tempX = x;
//		x = y;
//		y = tempX;
//		
//	}



}
