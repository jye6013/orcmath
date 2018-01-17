package test;

import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class ZScreen extends ClickableScreen implements Runnable{

	private Button loseBtn;
	private Button winBtn;
	private TextArea status;

	public ZScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		loseBtn = new Button(50, 60, 50, 50, "Lose", new Action() {
			
			@Override
			public void act() {
				status.setText("You lose!");
				loseBtn.setEnabled(false);
				winBtn.setEnabled(false);
			}
		});
		
		winBtn = new Button(50, 130, 50, 50, "Win", new Action() {
			
			@Override
			public void act() {
				status.setText("You win!");
				loseBtn.setEnabled(false);
				winBtn.setEnabled(false);
			}
		});
		
		status = new TextArea(150, 100, 200, 200, "");
		
		viewObjects.add(loseBtn);
		viewObjects.add(winBtn);
		viewObjects.add(status);
		
	}

}
