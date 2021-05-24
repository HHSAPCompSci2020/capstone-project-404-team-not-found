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
	private int colorInt;
	
	/**
	 * Initializes a Tetris Block with a velocity of 1 and the specified coordinate of the top-left corner
	 * @param x X-coordinate of the top-left corner
	 * @param y Y-coordinate of the top-right corner
	 */
	public TetrisBlock (int x, int y) {
		this.x = x;
		this.y = y;
		velocity = 1;

	}
	
	/**
	 * Draws this Tetris Block
	 * @param marker PApplet with which to draw this Tetris Block with
	 */
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
	
	/**
	 * Rotates this Tetris Block 90 degrees clockwise
	 */
	public abstract void rotate();
	
	/**
	 * Makes this Tetris Block fall (increasing y-value) according to the velocity
	 */
	public void fall() {
		for (int i = 0; i < squares.size(); i++) {
			Square square = squares.get(i);
			square.move(0, velocity);
		}
		
	}
	
	/**
	 * Moves this Tetris Block 30 pixels horizontally
	 * 
	 * @param isRight true if the Tetris Block should move right, false if the Tetris Block is to move left
	 */
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
	
	/**
	 * 
	 * @return All the horizontal Lines from all the Squares in this Tetris Block 
	 */
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
	
	/**
	 * 
	 * @return All the vertical Lines from all the Squares in this Tetris Block
	 */
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
	
	/**
	 * Determines if one of the horizontal sides of this Tetris Block is overlapping with one of the horizontal sides of the other specified Tetris Block
	 * @param block the other Tetris Block to test the overlapping with 
	 * @return true if this Tetris Block is horizontally touching the other Tetris Block, false if not
	 */
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
	
	/**
	 * Determines if one of the vertical sides of this Tetris Block is overlapping with one of the vertical sides of the other specified Tetris Block
	 * @param block the other Tetris Block to test the overlapping with 
	 * @return true if this Tetris Block is vertically touching the other Tetris Block, false if not
	 */
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
	
	/**
	 * Determines if one of the horizontal sides of this Tetris Block is overlapping with one of the horizontal sides of the specified Square
	 * @param block the Square to test the overlapping with 
	 * @return true if this Tetris Block is horizontally touching the Square, false if not
	 */
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
	
	/**
	 * Determines if one of the vertical sides of this Tetris Block is overlapping with one of the vertical sides of the specified Square
	 * @param block the Square to test the overlapping with 
	 * @return true if this Tetris Block is vertically touching the Square, false if not
	 */
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
	
	/**
	 * Determines if one of the horizontal sides of this Tetris Block is overlapping with the specified Line
	 * @param line Line to test the overlapping with 
	 * @pre Line must be horizontal 
	 * @return true if this Tetris Block is horizontally touching this Line, false if not
	 */
	public boolean isTouchingHorizontal(Line line) {
		ArrayList<Line> lines = this.getHorizontalLines();
		for (int i = 0; i < lines.size(); i++) {
			if (lines.get(i).overlaps(line)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Determines if one of the vertical sides of this Tetris Block is overlapping with the specified Line
	 * @param line Line to test the overlapping with 
	 * @pre Line must be vertical 
	 * @return true if this Tetris Block is vertically touching this Line, false if not
	 */
	public boolean isTouchingVertical(Line line) {
		ArrayList<Line> lines = this.getVerticalLines();
		for (int i = 0; i < lines.size(); i++) {
			if (lines.get(i).overlaps(line)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Stops this tetris block from falling (moving down vertically) 
	 * Sets velocity to 0
	 */
	public void stopFall() {
		velocity = 0;
	}
	
	/**
	 * 
	 * @return X-coordinate of the top-left corner of this Tetris Block
	 */
	public double getX() {
		return x;
	}
	
	/**
	 * 
	 * @return Y-coordinate of the top-left corner of this Tetris Block 
	 */
	public double getY() {
		return y;
	}
	
	/**
	 * Sets the Squares that are used to construct this Tetris Block 
	 * @param squares Squares that make up this Tetris Block
	 */
	public void setSquares(ArrayList<Square> squares) {
		this.squares = squares;
	}
	
	/**
	 * 
	 * @return the Squares that make up this Tetris Block
	 */
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
