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
	
	public TetrisBlock (int type) {
		velocity = 1.2;
		switch (type) {
			case 1: 
				lines.add(new Line(x, y, x+120, y));
				lines.add(new Line(x+120, y, x+120, y+30));
				lines.add(new Line(x+120, y+30, x, y+30));
				lines.add(new Line(x, y+30, x, y));
				break;
			case 2: 
				lines.add(new Line(x, y, x+30, y));
				lines.add(new Line(x+30, y, x+30, y+60));
				lines.add(new Line(x+30, y+60, x+60, y+60));
				lines.add(new Line(x+60, y+60, x+60, y+90));
				lines.add(new Line(x+60, y+90, x, y+90));
				lines.add(new Line(x, y+90, x, y));
				break;
			case 3: 
				lines.add(new Line(x, y, x+60, y));
				lines.add(new Line(x+60, y, x+60, y+30));
				lines.add(new Line(x+60, y+30, x+30, y+30));
				lines.add(new Line(x+30, y+30, x+30, y+90));
				lines.add(new Line(x+30, y+90, x, y+90));
				lines.add(new Line(x, y+90, x, y));
				break;
			case 4: 
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
		
	}
	
	public void act() {
		y += y*velocity;
	}
	
	public void move(boolean isRight) {
		if (isRight) {
			x += 10;
		} else {
			x -= 10;
		}
	}
	
	public boolean isTouching(TetrisBlock block) {
		return false;
	}
}
