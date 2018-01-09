package simon;

import guiTeacher.GUIApplication;
import holiday.Front;
import holiday.HolidayCard;

public class SimonGameJi extends GUIApplication{
	//
	public static SimonGameJi simon;
	public static SimonScreenJi simonScreen;
	
	public SimonGameJi(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		simonScreen = new SimonScreenJi(getWidth(), getHeight());
		setScreen(simonScreen);
		
	}
	
	public static void main(String[] args) {
		simon = new SimonGameJi(800, 500);
		Thread runner = new Thread(simon);
		runner.start();
	}

}