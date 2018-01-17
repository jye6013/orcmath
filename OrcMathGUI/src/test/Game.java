package test;

import java.awt.Color;

import guiPlayer.CatalogMakerGUI;
import guiPlayer.CatalogScreen;
import guiTeacher.GUIApplication;

public class Game extends GUIApplication {

	public Game(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override 
	public void initScreen() {
		TestingGame screen = new TestingGame(getWidth(), getHeight());
		setScreen(screen);
	}

	public static void main(String[] args) {
		Game game = new Game(800, 550);
		Thread runner = new Thread(game);
		runner.start();
	}

}