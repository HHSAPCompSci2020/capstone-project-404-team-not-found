/**
 * 
 * @author Tarini Maram
 *
 */
public class Line {

	private double x, y, x2, y2;
	
	/**
	 * Creates a new Line with default end points (0,0) and (0,0).
	 */
	public Line() {
		this.x = 0;
		this.y = 0;
		this.x2 = 0;
		this.y2 = 0;
	}
	
	/**
	 * Creates a new Line with specified endpoints
	 * @param x X-coordinate of the starting point
	 * @param y Y-coordinate of the starting point
	 * @param x2 X-coordinate of the ending point
	 * @param y2 Y-coordinate of the ending point
	 */
	public Line(double x, double y, double x2, double y2) {
		this.x = x;
		this.y = y;
		this.x2 = x2;
		this.y2 = y2;
	}
	
	/**
	 * Determines whether this Line is overlapping with another Line
	 * Overlapping means that one Line has to be completely contained within the other Line
	 * @param other the other Line to be checked for overlapping
	 * @return true if the two lines are overlapping, false if otherwise
	 * @pre this Line and the other Line have to both be either horizontal or vertical
	 */
	public boolean overlaps(Line other) {
		double smallX = getSmallerLine(other).getX();
		double smallY = getSmallerLine(other).getY();
		double smallX2 = getSmallerLine(other).getX2();
		double smallY2 = getSmallerLine(other).getY2();
		double bigX = getBiggerLine(other).getX();
		double bigY = getBiggerLine(other).getY();
		double bigX2 = getBiggerLine(other).getX2();
		double bigY2 = getBiggerLine(other).getY2();
		
		if (checkIfInBtwn(smallX, bigX, bigX2) && checkIfInBtwn(smallY, bigY, bigY2) && checkIfInBtwn(smallX2, bigX, bigX2) && checkIfInBtwn(smallY2, bigY, bigY2)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Determines if this vertical line is partially overlapping with another vertical line, in other words only a portion of each line is overlapping with each other
	 * @pre this Line and the other Line must be vertical
	 * @param other Line to test overlapping with 
	 * @return true if this line is partially overlapping, false if not
	 */
	public boolean isPartiallyOverlapping(Line other) {
		double smallX = getSmallerLine(other).getX();
		double smallY = getSmallerLine(other).getY();
		double smallY2 = getSmallerLine(other).getY2();
		double bigX = getBiggerLine(other).getX();
		double bigY = getBiggerLine(other).getY();
		double bigY2 = getBiggerLine(other).getY2();
		
		if(smallX == bigX && (checkIfInBtwn(smallY, bigY, bigY2) || checkIfInBtwn(smallY2, bigY, bigY2) || checkIfInBtwn(bigY, smallY, smallY2) || checkIfInBtwn(bigY2, smallY, smallY2))) {
			return true;
		}
		return false;
	}
	/**
	 * Moves this line by the specified horizontal and vertical translations 
	 * 
	 * @param x the horizontal shift that this Line should move by
	 * @param y the vertical shift that this Line should move by
	 */
	public void move(double x, double y) {
		this.x += x;
		this.y += y;
		this.x2 += x;
		this.y2 += y;
		
	}
	
	/**
	 * rotates this line 90 degrees clockwise
	 */
	public void rotate() {
		double tempX = x;
		double tempX2 = x2;
		x = y;
		y = tempX;
		x2 = y;
		y2 = tempX2;
	}
	
	/**
	 * @return true if this Line is horizontal, false if otherwise
	 */
	public boolean isHorizontal() {
		if (y == y2) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 
	 * @return true if this Line is vertical, false if otherwise
	 */
	public boolean isVertical() {
		if (x == x2) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 
	 * @return X-coordinate of the starting point of this Line
	 */
	public double getX() {
		return x;
	}
	
	/**
	 * 
	 * @return Y-coordinate of the starting point of this Line
	 */
	public double getY() {
		return y;
	}
	
	/**
	 * 
	 * @return X-coordinate of the ending point of this Line
	 */
	public double getX2() {
		return x2;
	}
	
	/**
	 * 
	 * @return Y-coordinate of the ending point of this Line
	 */
	public double getY2() {
		return y2;
	}
	
	/**
	 * Determines if this Line is equal to the specified Line
	 * @param l other Line to compare this Line with
	 * @return true if this Line and Line l are equal, false if not
	 */
	public boolean equals(Line l) {
		if (getX() == l.getX() && getY() == l.getY() && getX2() == l.getX2() && getY2() == l.getY2()) {
			return true;
		} else if (getX() == l.getX2() && getY() == l.getY2() && getX2() == l.getX() && getY2() == l.getY()) {
			return true;
		}
		return false;
	}
	
	private boolean checkIfInBtwn(double x, double a, double b) {
		boolean result = false;
		if (x >= Math.min(a, b) && x <= Math.max(a, b)) {
			result = true;
		}
		return result;
	}
	
	private Line getSmallerLine(Line other) {
		double length1 = Math.sqrt((y2-y)*(y2-y) + (x2-x)*(x2-x));
		double length2 = Math.sqrt((other.y2-other.y)*(other.y2-other.y) + (other.x2-other.x)*(other.x2-other.x));
		Line result;
		if (length1 < length2) {
			result = this;
			//System.out.println("smaller: this");
		} else {
			//System.out.println("smaller: other");
			result = other;
		}
		return result;
	}
	
	private Line getBiggerLine(Line other) {
		double length1 = Math.sqrt((y2-y)*(y2-y) + (x2-x)*(x2-x));
		double length2 = Math.sqrt((other.y2-other.y)*(other.y2-other.y) + (other.x2-other.x)*(other.x2-other.x));
		Line result;
		if (length1 >= length2) {
			//System.out.println("bigger: this");
			result = this;
		} else {
			//System.out.println("bigger: other");
			result = other;
		}
		return result;
	}
	
	public String toString() {
		return "(" + getX() + "," + getY() + ") (" + getX2() + "," + getY2() + ")";
	}
}
