package myStuff;

import java.util.List;

import guiPlayer.Book;
import guiPlayer.CatalogMaker;
import guiPlayer.CatalogMaker3;
import guiPlayer.Places;
import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.TextArea;
import guiTeacher.components.TextField;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import guiTeacher.userInterfaces.*;

public class CatalogScreen extends FullFunctionScreen {

	private TextField description;
	private TextField description2;
	private TextField description3;
	private Button add;
	private CatalogMaker3 catalog;
	private TextArea area;
	
	public CatalogScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		// TODO Auto-generated method stub
		catalog = new CatalogMaker3();
		description = new TextField(40, 40, 200, 30, "Enter the location.", "Location");
		description2 = new TextField(40, 100, 200, 30, "Enter the country.", "Country");
		description3 = new TextField(40, 160, 200, 30, "Enter a number.", "# of Times Visited");
		description3.setInputType(TextField.INPUT_TYPE_NUMERIC);
		area = new TextArea(400, 40, 300, 30, "This is a box of text.");
		add = new Button(10, 190, 100, 40, "Add", new Action() {
			
			@Override
			public void act() {
				addButtonClicked();
			}
		});
		viewObjects.add(description);
		viewObjects.add(description2);
		viewObjects.add(description3);
		viewObjects.add(add);
		viewObjects.add(area);
	}
	
	public void addButtonClicked() {
		//description.setText("You clicked the button!");
		Places b = new Places(description.getText(), description2.getText(), 1000);
		String s = area.getText() + b + "\n";
		area.setText(s);
		catalog.addPlaces(b);
		description.setText("");
		description2.setText("");
		description3.setText("");
		area.setText("");
	}
}
