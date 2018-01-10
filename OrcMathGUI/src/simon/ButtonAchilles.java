package simon;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class ButtonAchilles extends Button implements ButtonInterfaceJi {

	public ButtonAchilles(int x, int y, int w, int h, String text, Action action) {
		super(x, y, w, h, "", null);
		update();
	}


	@Override
	public void setColor(Color color) {
		setBackground(color);
		update();
	}

	@Override
	public void highlight() {
		setBackground(Color.yellow);
		update();
	}

	@Override
	public void dim() {
		setBackground(Color.darkGray);
		update();
	}
	
	public void drawButton(Graphics2D g, boolean hover) {
		g.drawOval(50, 50, 50, 50);
		
		//update();
	}


}
