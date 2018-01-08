package simon;

import java.awt.Graphics2D;

import guiTeacher.components.Component;

public class ProgressJi extends Component implements ProgressInterfaceJi{

	
	boolean gameOver = false;
	
	public ProgressJi(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void gameOver() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setRound(int num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSequenceSize(int num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Graphics2D g) {
		if(gameOver) {
			gameOver();
		}
		else {
			//drawButton();
		}
	}

}
