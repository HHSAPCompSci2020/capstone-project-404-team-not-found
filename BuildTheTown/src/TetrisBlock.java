import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PShape;

/**
 * 
 * @author Tarini Maram
 *
 */
public class TetrisBlock {
	private double x,y;
	private double velocity;
	private ArrayList<Line> lines = new ArrayList<Line>();
	private int type;
	private boolean rotated; 
	
	public TetrisBlock (int x, int y, int type) {
		this.x = x;
		this.y = y;
		velocity = 1.2;
		this.type = type;
		rotated = false;
		switch (type) {
			case 1: 
				lines.add(new Line(x, y, x+120, y));
				lines.add(new Line(x+120, y, x+120, y+30));
				lines.add(new Line(x+120, y+30, x, y+30));
				lines.add(new Line(x, y+30, x, y));
				break;
//			case 2: 
//				lines.add(new Line(x, y, x+30, y));
//				lines.add(new Line(x+30, y, x+30, y+60));
//				lines.add(new Line(x+30, y+60, x+60, y+60));
//				lines.add(new Line(x+60, y+60, x+60, y+90));
//				lines.add(new Line(x+60, y+90, x, y+90));
//				lines.add(new Line(x, y+90, x, y));
//				break;
//			case 3: 
//				lines.add(new Line(x, y, x+60, y));
//				lines.add(new Line(x+60, y, x+60, y+30));
//				lines.add(new Line(x+60, y+30, x+30, y+30));
//				lines.add(new Line(x+30, y+30, x+30, y+90));
//				lines.add(new Line(x+30, y+90, x, y+90));
//				lines.add(new Line(x, y+90, x, y));
//				break;
			case 2: 
				lines.add(new Line(x, y, x+60, y));
				lines.add(new Line(x+60, y, x+60, y+60));
				lines.add(new Line(x+60, y+60, x, y+60));
				lines.add(new Line(x, y+60, x, y));
				break;
		}
	}
	
	public void draw(PApplet marker) {
		PShape block; 
		block = marker.createShape(marker.GROUP);
		for (int i = 0; i < lines.size(); i++) {
			PShape line = marker.createShape(marker.LINE, (float)lines.get(i).getX(), (float)lines.get(i).getY(), (float)lines.get(i).getX2(), (float)lines.get(i).getY2());
			block.addChild(line);
		}
		
		marker.fill(0);
		marker.shape(block);
	}
	
	// rotates by 90 degrees clockwise 
	public void rotate() {
		for (int i = 0; i < lines.size(); i++) {
			lines.get(i).rotate();
		}
		rotated = !rotated;
	}
	
	public void fall() {
		for (int i = 0; i < lines.size(); i++) {
			Line line = lines.get(i);
			line.move(0, velocity);
			//System.out.println(lines.get(i).getY());
		}
		
	}
	
	public void move(boolean isRight) {
		for (int i = 0; i < lines.size(); i++) {
			if (isRight) {
				lines.get(i).move(30, 0);
				x += 30;
			} else {
				lines.get(i).move(-30, 0);
				x -= 30;
			}
		}
	}
	
	public boolean isTouching(TetrisBlock block) {
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
	
	public void stopFall() {
		velocity = 0;
	}
	
	public int getType() {
		return type;
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
	
	private ArrayList<Line> getLines() {
		return lines;
	}
	
}
