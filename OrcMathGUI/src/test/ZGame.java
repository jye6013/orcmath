package test;

import guiTeacher.GUIApplication;

public class ZGame extends GUIApplication{

	public ZGame(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		ZScreen screen = new ZScreen(getWidth(), getHeight());
		setScreen(screen);
	}

	public static void main(String[] args) {
		ZGame game = new ZGame(800, 500);
		Thread runner = new Thread(game);
		runner.start();
	}
}
