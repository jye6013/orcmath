package simon2;

import guiTeacher.GUIApplication;

public class SimonGameX extends GUIApplication{
	
	public static SimonScreenX simon;

	public SimonGameX(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initScreen() {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		simon = new SimonScreenX(800, 500);
		Thread runner = new Thread(simon);
		runner.start();
	}

}
