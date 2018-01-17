package test;

import guiTeacher.GUIApplication;

public class X extends GUIApplication{

	public X(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	public static void main(String[] args) {
		X game = new X(800, 500);
		Thread runner = new Thread(game);
		runner.start();

	}

	@Override
	public void initScreen() {
		Screen screen = new Screen(getWidth(), getHeight());
		setScreen(screen);
		
	}

}
