import java.util.ArrayList;
import java.util.Random;

public class RectangleBlock extends TetrisBlock {

	private double x,y;
	private ArrayList<Square> squares = new ArrayList<Square>();
	private Random random = new Random();
	private int colorInt;
	
	/**
	 * Creates a four-square long horizontal Tetris Block at the specified coordinate
	 * @param x X-coordinate of the top-left corner of this Rectangle Block
	 * @param y Y-coordinate of the top-left corner of this Rectangle Block
	 */
	public RectangleBlock(int x, int y) {
		super(x, y);
		this.x = x;
		this.y = y;
		squares.add(new Square(x, y));
		squares.add(new Square(x+30, y));
		squares.add(new Square(x+60, y));
		squares.add(new Square(x+90, y));
		setSquares(squares);
		colorInt = random.nextInt(256);
		super.setColor(colorInt);
	}

	@Override
	public void rotate() {
		for (int i = 0; i < squares.size(); i++) {
			squares.get(i).rotate();
		}
		
		double tempX = x;
		x = y;
		y = tempX;
		
	}
	
	public void setColor() {
		super.setColor(colorInt);
	}



}
