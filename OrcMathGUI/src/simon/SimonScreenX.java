package simon;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;
import holiday.HolidayCard;

public class SimonScreenX extends ClickableScreen implements Runnable{

	ArrayList<MoveInterfaceX> sequence = new ArrayList<MoveInterfaceX>();
	public static SimonScreenX simon;
	
	private TextLabel label;
	private ButtonInterfaceX[] buttons;
	private ProgressInterfaceX progress;
	private int roundNumber;
	private int sequenceIndex;
	private int lastSelectedButton = -1;
	private boolean acceptingInput;
	private Color[] color;
	
	public SimonScreenX(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
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
	
	private MoveInterfaceX randomMove() {
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
		
		for(int i = 0; i < numberOfButtons; i++) {
			ButtonInterfaceX b = getAButton();
			buttons[i] = b;
			b.setColor(Color.BLACK);
		    b.setX(30);
		    b.setY(30);
		}
		
	}

	private ButtonInterfaceX getAButton() {
		
	}

	public static void main(String[] args) {
		simon = new SimonScreenX(800, 500);
		Thread runner = new Thread(simon);
		runner.start();
	}

}
