import java.util.ArrayList;
import java.util.Random;

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
	private int colorInt;
//	private Random random;
	
	public TetrisBlock (int x, int y) {
		this.x = x;
		this.y = y;
		velocity = 1;
		rotated = false;
//		random = new Random();
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
			PShape square = marker.createShape(marker.RECT, (float)squares.get(i).getX(), (float)squares.get(i).getY(), 30, 30);
			block.addChild(square);
		}
//		int colorInt = random.nextInt(256);
//		marker.fill(colorInt);
//		marker.fill();
		marker.fill(getColor());
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
			square.move(0, velocity);
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
			for (int j = i + 1; j < lines.size(); j++) {
				if (lines.get(i).equals(lines.get(j))) {
					lines.remove(j);
					lines.remove(i);
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
		//System.out.println(lines);
		for (int i = 0; i < lines.size(); i++) {
			for (int j = i + 1; j < lines.size(); j++) {
				if (lines.get(i).equals(lines.get(j))) {
					//System.out.println("i: " + i + "j: " + j);
					lines.remove(j);
					lines.remove(i);
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
	
	public boolean isTouchingHorizontal(Square square) {
		if (square == null) {
			return false;
		}
		ArrayList<Line> lines = this.getHorizontalLines();
		Line[] otherLines = square.getHorizontalLines();
		for (int i = 0; i < lines.size(); i++) {
			for (int j = 0; j < otherLines.length; j++) {
				if (lines.get(i).overlaps(otherLines[j])) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean isTouchingVertical(Square square) {
		ArrayList<Line> lines = this.getVerticalLines();
		Line[] otherLines = square.getVerticalLines();
		for (int i = 0; i < lines.size(); i++) {
			for (int j = 0; j < otherLines.length; j++) {
				if (lines.get(i).overlaps(otherLines[j])) {
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
	
	public void setColor(int color) {
		colorInt = color;
	}
	public int getColor() {
//		System.out.println("color" + colorInt);
		return colorInt;
	}
	
}
