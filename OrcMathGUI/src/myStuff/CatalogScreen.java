package myStuff;

import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.TextField;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import guiTeacher.userInterfaces.*;

public class CatalogScreen extends FullFunctionScreen {

	private TextField description;
	private TextField description2;
	private Button add;
	
	public CatalogScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		// TODO Auto-generated method stub
		description = new TextField(40, 40, 200, 30, "Enter", "Text");
		description2 = new TextField(40, 100, 200, 30, "Enter", "Text");
		add = new Button(40, 120, 100, 40, "Button", new Action() {
			
			@Override
			public void act() {
				description.setText("You clicked the button!");
			}
		});
		viewObjects.add(description);
		viewObjects.add(description2);
	}

}
