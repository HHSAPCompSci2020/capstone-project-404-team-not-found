import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PShape;

/**
 * 
 * @author Tarini Maram
 *
 */
public abstract class TetrisBlock {
	private double x,y;
	private double velocity;
	private ArrayList<Square> squares = new ArrayList<Square>();
	private boolean rotated; 
	
	public TetrisBlock (int x, int y) {
		this.x = x;
		this.y = y;
		velocity = 1;
		rotated = false;
//		switch (type) {
//			case 1: 
//				squares.add(new Line(x, y, x+120, y));
//				squares.add(new Line(x+120, y, x+120, y+30));
//				squares.add(new Line(x+120, y+30, x, y+30));
//				squares.add(new Line(x, y+30, x, y));
//				break;
////			case 2: 
////				squares.add(new Line(x, y, x+30, y));
////				squares.add(new Line(x+30, y, x+30, y+60));
////				squares.add(new Line(x+30, y+60, x+60, y+60));
////				squares.add(new Line(x+60, y+60, x+60, y+90));
////				squares.add(new Line(x+60, y+90, x, y+90));
////				squares.add(new Line(x, y+90, x, y));
////				break;
////			case 3: 
////				squares.add(new Line(x, y, x+60, y));
////				squares.add(new Line(x+60, y, x+60, y+30));
////				squares.add(new Line(x+60, y+30, x+30, y+30));
////				squares.add(new Line(x+30, y+30, x+30, y+90));
////				squares.add(new Line(x+30, y+90, x, y+90));
////				squares.add(new Line(x, y+90, x, y));
////				break;
//			case 2: 
//				squares.add(new Line(x, y, x+60, y));
//				squares.add(new Line(x+60, y, x+60, y+60));
//				squares.add(new Line(x+60, y+60, x, y+60));
//				squares.add(new Line(x, y+60, x, y));
//				break;
//		}
	}
	
	public void draw(PApplet marker) {
		PShape block; 
		block = marker.createShape(marker.GROUP);
		for (int i = 0; i < squares.size(); i++) {
			PShape square = marker.createShape(marker.RECT, (float)squares.get(i).getX(), (float)squares.get(i).getY(), (float)squares.get(i).getWidth(), (float)squares.get(i).getWidth());
			block.addChild(square);
		}
		
		marker.fill(0);
		marker.shape(block);
	}
	
	// rotates by 90 degrees clockwise 
//	public void rotate() {
//		for (int i = 0; i < squares.size(); i++) {
//			squares.get(i).rotate();
//		}
//		rotated = !rotated;
//	}
	
	public abstract void rotate();
	
	public void fall() {
		for (int i = 0; i < squares.size(); i++) {
			Square square = squares.get(i);
			//System.out.println("square: " + i);
			square.move(0, velocity);
			//System.out.println(squares.get(i).getY());
		}
		
	}
	
	public void move(boolean isRight) {
		for (int i = 0; i < squares.size(); i++) {
			if (isRight) {
				squares.get(i).move(30, 0);
				x += 30;
			} else {
				squares.get(i).move(-30, 0);
				x -= 30;
			}
		}
	}
	
//	public boolean isTouching(TetrisBlock block) {
//		for (int i = 0; i < squares.size(); i++) {
//			for (int j = 0; j < block.getSquares().size(); j++) {
//				//System.out.println("i: " + i + "j: " + j);
//				if (squares.get(i).overlaps(block.getSquares().get(j))) {
//					return true;
//				}
//			}
//		}
//		return false;
//	}
	
	public ArrayList<Line> getHorizontalLines() {
		ArrayList<Line> lines = new ArrayList<Line>();
		for (int i = 0; i < squares.size(); i++) {
			for (int j = 0; j < squares.get(i).getHorizontalLines().length; j++) {
				lines.add(squares.get(i).getHorizontalLines()[j]);
			}
		}
		for (int i = 0; i < lines.size(); i++) {
			for (int j = i; j < lines.size(); j++) {
				if (lines.get(i).equals(lines.get(j))) {
					lines.remove(i);
					lines.remove(j);
				}
			}
		}
		return lines;
	}
	
	public ArrayList<Line> getVerticalLines() {
		ArrayList<Line> lines = new ArrayList<Line>();
		for (int i = 0; i < squares.size(); i++) {
			for (int j = 0; j < squares.get(i).getVerticalLines().length; j++) {
				lines.add(squares.get(i).getVerticalLines()[j]);
			}
		}
		for (int i = 0; i < lines.size(); i++) {
			for (int j = i; j < lines.size(); j++) {
				if (lines.get(i).equals(lines.get(j))) {
					lines.remove(i);
					lines.remove(j);
				}
			}
		}
		return lines;
	}
	
	public boolean isTouchingHorizontal(TetrisBlock block) {
		ArrayList<Line> lines = this.getHorizontalLines();
		ArrayList<Line> otherLines = block.getHorizontalLines();
		for (int i = 0; i < lines.size(); i++) {
			for (int j = 0; j < otherLines.size(); j++) {
				if (lines.get(i).overlaps(otherLines.get(j))) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean isTouchingVertical(TetrisBlock block) {
		ArrayList<Line> lines = this.getVerticalLines();
		ArrayList<Line> otherLines = block.getVerticalLines();
		for (int i = 0; i < lines.size(); i++) {
			for (int j = 0; j < otherLines.size(); j++) {
				if (lines.get(i).overlaps(otherLines.get(j))) {
					return true;
				}
			}
		}
		return false;
	}
	
	
	public boolean isTouchingHorizontal(Line line) {
		ArrayList<Line> lines = this.getHorizontalLines();
		for (int i = 0; i < lines.size(); i++) {
			if (lines.get(i).overlaps(line)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isTouchingVertical(Line line) {
		ArrayList<Line> lines = this.getVerticalLines();
		for (int i = 0; i < lines.size(); i++) {
			if (lines.get(i).overlaps(line)) {
				return true;
			}
		}
		return false;
	}
	
	public void stopFall() {
		velocity = 0;
	}
	
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public boolean getRotation() {
		return rotated;
	}
	
	public void setSquares(ArrayList<Square> squares) {
		this.squares = squares;
	}
	
	public ArrayList<Square> getSquares() {
		return squares;
	}
	
	
}
