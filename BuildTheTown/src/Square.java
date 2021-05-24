import java.util.ArrayList;

import processing.core.PApplet;

/**
 * 
 * @author Tarini Maram
 *
 */
public class Square {
	private ArrayList<Line> lines;
	private double x, y;
	
	/**
	 * Creates a new Square at the specified coordinates of the top left corner
	 * and with side length 30
	 * The Square is constructed using 4 Lines
	 * @param x X-coordinate of the top-left corner of this Square
	 * @param y Y-coordinate of the top-left corner of this Square
	 */
	public Square(double x, double y) {
		this.x = x;
		this.y = y;
		lines = new ArrayList<Line>();
		lines.add(new Line(x, y, x+30, y));
		lines.add(new Line(x+30, y, x+30, y+30));
		lines.add(new Line(x+30, y+30, x, y+30));
		lines.add(new Line(x, y+30, x, y));
	}
	
	/**
	 * Rotates this square 90 degrees clockwise
	 */
	public void rotate() {
		for (int i = 0; i < lines.size(); i++) {
			lines.get(i).rotate();
		}
		double tempX = x;
		x = y;
		y = tempX;
	}
	
	/**
	 * Draws this square
	 * @param marker PApplet to be used to draw the square with
	 */
	public void draw(PApplet marker) {
		marker.rect((float)x, (float)y, 30, 30);
	}
	
	/**
	 * Moves this square by the specified horizontal and vertical translations
	 * @param x the horizontal shift that this Square should move by
	 * @param y the vertical shift that this Square should move by
	 */
	public void move(double x, double y) {
		for (int i = 0; i < lines.size(); i++) {
			lines.get(i).move(x, y);
		}
		this.x += x;
		this.y += y;
	}
	
	/**
	 * Determines if a side of this Square is touching a side of another Square
	 * @param block Square to test the touching with
	 * @return true if this Square is touching the other Square, false if not
	 */
	public boolean isTouching(Square block) {
		for (int i = 0; i < lines.size(); i++) {
			for (int j = 0; j < block.getLines().size(); j++) {
				if (lines.get(i).overlaps(block.getLines().get(j))) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Determines if a side of this Square is overlapping with a Line
	 * @param line Line to test the overlapping with
	 * @return true if this Square is touching the Line, false if not
	 */
	public boolean isTouching(Line line) {
		for (int i = 0; i < lines.size(); i++) {
			if (lines.get(i).overlaps(line)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * @return X-coordinate of the top left corner of this Square
	 */
	public double getX() {
		return x;
	}
	
	/**
	 * @return Y-coordinate of the top left corner of this Square
	 */
	public double getY() {
		return y;
	}
	
	/**
	 * @return width of this square, which is 30
	 */
	public double getWidth() {
		return 30;
	}
	
	/**
	 * @return the sides of this square that are horizontal lines
	 */
	public Line[] getHorizontalLines() {
		Line[] lines = new Line[2];
		lines[0] = this.lines.get(0);
		lines[1] = this.lines.get(2);
		return lines;
	}
	
	/**
	 * 
	 * @return the sides of this square that are vertical lines
	 */
	public Line[] getVerticalLines() {
		Line[] lines = new Line[2];
		lines[0] = this.lines.get(1);
		lines[1] = this.lines.get(3);
		return lines;
	}
	
	public boolean isPartiallyOverlapping(Square block) {
		for (int i = 0; i < lines.size(); i++) {
			for (int j = 0; j < block.getLines().size(); j++) {
				if (lines.get(i).isPartiallyOverlapping(block.getLines().get(j))) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @return the 4 lines that make up the sides of this square
	 */
	public ArrayList<Line> getLines() {
		return lines;
	}
	
}
