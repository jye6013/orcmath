package festiveCard;

import guiTeacher.GUIApplication;

public class CardGUI extends GUIApplication {

	public static CardGUI card;
	public static CardScreen screen1;
	public static CardScreen2 screen2;
	
	public CardGUI(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		screen1 = new CardScreen(getWidth(), getHeight());
		setScreen(screen1);
		screen2 = new CardScreen2(getWidth(), getHeight());
		
		
	}

	public static void main(String[] args) {
		card = new CardGUI(800, 550);
		Thread go = new Thread(card);
		go.start();

	}

}
