package guiPlayer;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Component;

public class Places extends AnimatedComponent {
private String location;
private String country;
private int timesVisited;

//component
	public Places(String location, String country, int timesVisited) {
		super(40, 40, 100, 83);
		this.location = location;
		this.country = country;
		this.timesVisited = timesVisited;
		update();
	}

	@Override
	public void update(Graphics2D g) {
		g.setColor(Color.magenta);
		g.fillRect(0, 0, getWidth(), getHeight());
		//super.update(g);
	}
	
	public String toString() {
		return location + "," + country + "," + timesVisited;
		
	}
}
