package simon;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import guiTeacher.components.Component;

public class ProgressAchilles implements ProgressInterfaceJi {

	private boolean isGameOver = false;

	public ProgressAchilles() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public BufferedImage getImage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void update(Graphics2D g) {
		if(isGameOver ) {
			g.setColor(Color.red);
		}else {
			g.setColor(Color.green);
		}
	}

	@Override
	public void hoverAction() {
		// TODO Auto-generated method stub

	}

	@Override
	public void gameOver() {
		isGameOver = true;
		update();
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setX(int x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setY(int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isAnimated() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public float getAlpha() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setAlpha(float f) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unhoverAction() {
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

}
