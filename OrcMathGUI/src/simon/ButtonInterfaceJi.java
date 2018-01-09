package simon;

import java.awt.Color;

import guiTeacher.components.Action;
import guiTeacher.interfaces.Clickable;

public interface ButtonInterfaceJi extends Clickable{
	
	void setAction(Action a);

	void setColor(Color color);

	void highlight();

	void dim();

}