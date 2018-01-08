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
			
			if(b == sequence.get(sequenceIndex).getButton()) {
				sequenceIndex++;
			}else {
				progress.gameOver();
			}
			
			if(sequenceIndex == sequence.size()) {
				Thread nextRound = new Thread(SimonScreenX.this); 
				nextRound.start();
			}
		}
	}

	private ButtonInterfaceX getAButton() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void run() {
		label.setText("");
	    nextRound();
	}
	//

	private void nextRound() {
		acceptingInput = false;
		roundNumber++;
		randomMove();
		progress.setRound(roundNumber);
		progress.setSequenceSize(sequenceIndex);
		changeText("Simon's turn");
		label.setText("");
		playSequence();
		changeText("Your turn");
		acceptingInput = true;
		sequenceIndex = 0;
	}

	private void playSequence() {
		ButtonInterfaceX b = getAButton();
		for(MoveInterfaceX a: sequence){ 
			if(a != null) {
				b.dim();
				b = sequence.get(sequenceIndex).getButton();
				b.highlight();
				int sleepTime = (int) Math.exp(1000000 *(-1 * roundNumber));
				try {
					Thread.sleep(sleepTime);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		b.dim();
	}

	private void changeText(String str) {
		label.setText(str);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}