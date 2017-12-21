package festiveCard;

import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class CardScreen2 extends FullFunctionScreen {

	private Button switchScreen;
	
	public CardScreen2(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		switchScreen = new Button(350, 480, 100, 40, "Go back", new Action() {
			

			@Override
			public void act() {
				 CardGUI.card.setScreen(CardGUI.screen1);
			}
		});
		viewObjects.add(switchScreen);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
