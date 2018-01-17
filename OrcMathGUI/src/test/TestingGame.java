package test;

import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class TestingGame extends ClickableScreen implements Runnable{

	private Button btn;
	private TextArea scoreTxt;
	private TextArea timerTxt;

	private boolean startedGame = false;
	private int score = 0;

	public TestingGame(int width, int height) {
		super(width, height);
		Thread testGame = new Thread(this);
		testGame.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	public void addScore() {
		score++;
		scoreTxt.setText("Score: " + score);
	}

	public void changeText(String str) {
		Thread txt = new Thread(new Runnable() {

			@Override
			public void run() {
				btn.setText(str);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		txt.start();
		try {
			txt.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void changeText2(String str) {
		Thread txt = new Thread(new Runnable() {
			
			@Override
			public void run() {
				timerTxt.setText(str);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		txt.start();
		try {
			txt.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		btn = new Button(75, 75, 200, 200, "Ready", new Action() {

			@Override
			public void act() {
				if(startedGame) {
					addScore();
				}else {
					if(btn.getText().equals("Ready")) {
						Thread updateButton = new Thread(new Runnable() {

							@Override
							public void run() {
								changeText("3..");
								changeText("3.. 2..");
								changeText("3.. 2.. 1..");
								changeText("3.. 2.. 1.. GO!");
								btn.setText("Click me!");

								startedGame = true;
								changeText2("Time Left: 5");
								changeText2("Time Left: 4");
								changeText2("Time Left: 3");
								changeText2("Time Left: 2");
								changeText2("Time Left: 1");
								timerTxt.setText("Time Left: 0");
								btn.setText("Done");
								btn.setEnabled(false);
							}
						});
						updateButton.start();
					}
				}

			}
		});

		scoreTxt = new TextArea(10, 10, 100, 30, "Score: 0");
		timerTxt = new TextArea(10, 50, 100, 30, "");

		viewObjects.add(btn);
		viewObjects.add(scoreTxt);
		viewObjects.add(timerTxt);
	}

}
