public class Line {

	private double x, y, x2, y2;
	
	public Line() {
		this.x = 0;
		this.y = 0;
		this.x2 = 0;
		this.y2 = 0;
	}
	
	public Line(double x, double y, double x2, double y2) {
		this.x = x;
		this.y = y;
		this.x2 = x2;
		this.y2 = y2;
	}
	
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
		double centerX = (x2-x)/2;
		double centerY = (y2-y)/2;
		double tempX = x-centerX;
		double tempX2 = x2-centerX;
		double tempY = y-centerY;
		double tempY2 = y2-centerY;
		x = tempY+centerX;
		y = centerY-tempX;
		x2 = tempY2+centerX;
		y2 = centerY-tempX2;
	}
	
	public boolean isHorizontal() {
		if (y == y2) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isVertical() {
		if (x == x2) {
			return true;
		} else {
			return false;
		}
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public double getX2() {
		return x2;
	}
	
	public double getY2() {
		return y2;
	}
	
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
