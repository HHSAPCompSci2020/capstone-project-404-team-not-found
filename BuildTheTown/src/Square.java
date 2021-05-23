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
		double centerX = x+15;
		double centerY = x+15;
		double tempX = x-centerX;
		double tempY = y-centerY;
		x = tempY+centerX;
		y = centerY-tempX;
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
		for (int i = 0; i < lines.size(); i++) {
			lines.get(i).move(x, y);
		}
		this.x += x;
		this.y += y;
	}
	
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
		Line[] horiLines = new Line[2];
		int index = 0; 
		for (int i = 0; i < lines.size(); i++) {
			if (lines.get(i).isHorizontal() && index == 0) {
				horiLines[0] = lines.get(i);
				index++;
			} else if (lines.get(i).isHorizontal() && index == 1) {
				horiLines[1] = lines.get(i);
				i = lines.size();
			}
		}
//		lines[0] = this.lines.get(0);
//		lines[1] = this.lines.get(2);
		return horiLines;
	}
	
	public Line[] getVerticalLines() {
		Line[] vertiLines = new Line[2];
		int index = 0; 
		for (int i = 0; i < lines.size(); i++) {
			if (lines.get(i).isVertical() && index == 0) {
				vertiLines[0] = lines.get(i);
				index++;
			} else if (lines.get(i).isVertical() && index == 1) {
				vertiLines[1] = lines.get(i);
				i = lines.size();
			}
		}
//		lines[0] = this.lines.get(1);
//		lines[1] = this.lines.get(3);
		return vertiLines;
	}
	public ArrayList<Line> getLines() {
		return lines;
	}
	
}
