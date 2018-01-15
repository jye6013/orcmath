package test;

import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.StyledComponent;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class Screen extends ClickableScreen implements Runnable {

	private TextArea text;
	private TextArea timerTxt;
	private Button btn;
	private boolean gameStarted = false;
	private int currentScore = 0;
	private int timeLeft = 5;

	public Screen(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	//public synchronized int readSeconds() {

	//}


	private void changeText(String string) {
		Thread blink = new Thread(new Runnable() {

			@Override
			public void run() {
				btn.setText(string);
				try {
					Thread.sleep(1000);
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		blink.start();
		try {
			blink.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void changeText2(String string) {
		Thread blink = new Thread(new Runnable() {

			@Override
			public void run() {
				timerTxt.setText(string);
				//countdownText.setText(string);
				try {
					Thread.sleep(1000);
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		blink.start();
		try {
			blink.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		StyledComponent.setButtonOutline(true);
		text = new TextArea(50, 50, 100, 50, "Score: 0");
		timerTxt = new TextArea(50, 70, 100, 50, "");
		btn = new Button(100, 100, 150, 100, "Ready", new Action() {

			@Override
			public void act() {
				if(gameStarted) {
					addScore();
				}else {
					if (btn.getText().equals("Ready")) {
						Thread buttonTextUpdate = new Thread(new Runnable() {
							public void run() {
								changeText("3...");
								changeText("3...2...");
								changeText("3...2...1...");
								changeText("3...2...1... GO!");
								btn.setText("Click me!");

								gameStarted = true;
								changeText2("Time Left: 5");
								changeText2("Time Left: 4");
								changeText2("Time Left: 3");
								changeText2("Time Left: 2");
								changeText2("Time Left: 1");
								timerTxt.setText("Time Left: 0");
								timeLeft = 0;
								btn.setText("Done");
								btn.setEnabled(false);
							}
						});
						buttonTextUpdate.start();
					}
				}
			}

			private void addScore() {
				currentScore++;
				text.setText("Score:" + currentScore);	
			}

			private void timer(int i) {
				try {
					Thread.sleep(i);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		viewObjects.add(text);
		viewObjects.add(timerTxt);
		//viewObjects.add(score);
		viewObjects.add(btn);

	}

}