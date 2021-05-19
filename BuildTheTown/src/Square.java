import java.util.ArrayList;

import processing.core.PApplet;

public class Square {
	private ArrayList<Line> lines;
	private double x, y;
	
	public Square(double x, double y) {
		this.x = x;
		this.y = y;
		lines = new ArrayList<Line>();
		lines.add(new Line(x, y, x+30, y));
		lines.add(new Line(x+30, y, x+30, y+30));
		lines.add(new Line(x+30, y+30, x, y+30));
		lines.add(new Line(x, y+30, x, y));
	}
	
	public void rotate() {
		for (int i = 0; i < lines.size(); i++) {
			lines.get(i).rotate();
		}
	}

	
	public void draw(PApplet marker) {
		marker.rect((float)x, (float)y, 30, 30);
	}
	
//	public void move(boolean isRight) {
//		for (int i = 0; i < lines.size(); i++) {
//			if (isRight) {
//				lines.get(i).move(30, 0);
//				x += 30;
//			} else {
//				lines.get(i).move(-30, 0);
//				x -= 30;
//			}
//		}
//	}
	
	public void move(double x, double y) {
		System.out.println("Y: " + getY());
		for (int i = 0; i < lines.size(); i++) {
			lines.get(i).move(x, y);
			//System.out.println("line: " + i);
		}
		this.x += x;
		this.y += y;
	}
	
	public boolean isTouching(Square block) {
		for (int i = 0; i < lines.size(); i++) {
			for (int j = 0; j < block.getLines().size(); j++) {
				//System.out.println("i: " + i + "j: " + j);
				if (lines.get(i).overlaps(block.getLines().get(j))) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean isTouching(Line line) {
		for (int i = 0; i < lines.size(); i++) {
			if (lines.get(i).overlaps(line)) {
				return true;
			}
		}
		return false;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public double getWidth() {
		return 30;
	}
	
	public Line[] getHorizontalLines() {
		Line[] lines = new Line[2];
		lines[0] = this.lines.get(0);
		lines[1] = this.lines.get(2);
		return lines;
	}
	
	public Line[] getVerticalLines() {
		Line[] lines = new Line[2];
		lines[0] = this.lines.get(1);
		lines[1] = this.lines.get(3);
		return lines;
	}
	public ArrayList<Line> getLines() {
		return lines;
	}
	
}
