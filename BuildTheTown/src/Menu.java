import processing.core.PApplet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 * @author Joanna Huang
 *
 */
public class Menu extends JFrame implements ActionListener{
	
	/**
	 * True if next button has been clicked, false if not
	 */
	private boolean done;
	private JButton button;
	private JPanel panel;
	private JFrame frame;
	
	public Menu(PApplet marker) {
		done = false;
		
		panel = new JPanel();
		frame = (JFrame) ((processing.awt.PSurfaceAWT.SmoothCanvas)marker.getSurface().getNative()).getFrame();
		button = new JButton("NEXT");
		button.setBounds(0, 0, 0, 0);
		button.addActionListener(this);
		panel.add(button);
		frame.add(panel);
		//frame.setContentPane(panel);
	}
	
	/**
	 * Draws the menu
	 * @param marker The PApplet with which to draw the menu
	 * @param width The width of the window
	 * @param height The height of the window
	 */
	public void draw(PApplet marker, double width, double height) {
		marker.textAlign(marker.CENTER, marker.CENTER);
		marker.textSize(50);
		marker.fill(0);
		marker.text("MENU", (float)(width/2), (float)(height/6));
	}
	
	public void actionPerformed(ActionEvent e) {
		done = true;
	}
	
	public boolean getDone() {	return done;	}

}