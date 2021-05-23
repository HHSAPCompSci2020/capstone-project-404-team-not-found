import java.util.ArrayList;

public class RectangleBlock extends TetrisBlock {

	private double x,y;
	private ArrayList<Square> squares = new ArrayList<Square>();
	
	public RectangleBlock(int x, int y) {
		super(x, y);
		this.x = x;
		this.y = y;
		squares.add(new Square(x, y));
		squares.add(new Square(x+30, y));
		squares.add(new Square(x+60, y));
		squares.add(new Square(x+90, y));
		setSquares(squares);
	}

	@Override
	public void rotate() {
		// TODO Auto-generated method stub
		for (int i = 0; i < squares.size(); i++) {
			squares.get(i).rotate();
		}
		System.out.println("rotated");   
		double centerX = x+45;
		double centerY = y+15;
		double tempX = x-centerX;
		double tempY = y-centerY;
		x = tempY+centerX;
		y = centerY-tempX;
	}



}
