package simon;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.TextArea;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;
import simon.ButtonInterfaceX;

public class SimonScreenX extends ClickableScreen implements Runnable{

	private TextLabel label;
	private ButtonInterfaceX[] buttons;
	private ProgressInterfaceX progress;
	ArrayList<MoveInterfaceX> sequence = new ArrayList<MoveInterfaceX>();

	private int roundNumber;
	private boolean acceptingInput;
	private int sequenceIndex;
	private int lastSelectedButton;
	private Color[] color;
	//private static int NUM_BUTTONS;

	public SimonScreenX(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		addButtons();
		for(ButtonInterfaceX b: buttons){ 
			viewObjects.add(b); 
		}
		progress = getProgress();
		label = new TextLabel(130,230,300,40,"Let's play Simon!");
		sequence = new ArrayList<MoveInterfaceX>();
		//add 2 moves to start
		lastSelectedButton = -1;
		sequence.add(randomMove());
		sequence.add(randomMove());
		roundNumber = 0;
		viewObjects.add(progress);
		viewObjects.add(label);

	}

	private simon.MoveInterfaceX randomMove() {
		int bIndex = (int)(Math.random()*buttons.length);
		while(bIndex == lastSelectedButton){
			bIndex = (int)(Math.random()*buttons.length);
		}
		return getMove(bIndex);
	}

	private MoveInterfaceX getMove(int bIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	Placeholder until partner finishes implementation of ProgressInterface
	 */
	private ProgressInterfaceX getProgress() {
		// TODO Auto-generated method stub
		return null;
	}

	private void addButtons() {
		int numberOfButtons = 3;
		buttons = new ButtonInterfaceX[numberOfButtons];
		color = new Color[numberOfButtons];
		color[0] = Color.red;
		color[1] = Color.green;
		color[2] = Color.blue;

		for(int i = 0; i < numberOfButtons; i++) {
			final ButtonInterfaceX b = getAButton();
			buttons[i] = b;
			b.setColor(Color.darkGray);
			b.setX(0);
			b.setY(0);
			b.setAction(new Action(){

				public void act(){
					if(acceptingInput) {
						Thread blink = new Thread(new Runnable(){

							public void run(){
								b.highlight();
								try {
									Thread.sleep(800);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								b.dim();
							}});
						blink.start();
					}
				}
			});
		}
	}

	private ButtonInterfaceX getAButton() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}
	//
}