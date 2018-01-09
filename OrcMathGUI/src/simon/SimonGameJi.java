package simon;

import guiTeacher.GUIApplication;

public class SimonGameJi extends GUIApplication{
	//
	public static SimonScreenJi simon;

	public SimonGameJi(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initScreen() {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		Thread runner = new Thread(simon);
		runner.start();
	}

}