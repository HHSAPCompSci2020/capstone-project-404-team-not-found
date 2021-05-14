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
		double tempX = x;
		double tempX2 = x2;
		x = -y;
		y = tempX;
		x = -y2;
		y2 = tempX2;
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
			System.out.println("smaller: this");
		} else {
			System.out.println("smaller: other");
			result = other;
		}
		return result;
	}
	
	private Line getBiggerLine(Line other) {
		double length1 = Math.sqrt((y2-y)*(y2-y) + (x2-x)*(x2-x));
		double length2 = Math.sqrt((other.y2-other.y)*(other.y2-other.y) + (other.x2-other.x)*(other.x2-other.x));
		Line result;
		if (length1 >= length2) {
			System.out.println("bigger: this");
			result = this;
		} else {
			System.out.println("bigger: other");
			result = other;
		}
		return result;
	}
	
}
