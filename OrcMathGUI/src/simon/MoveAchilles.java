package simon;

public class MoveAchilles implements MoveInterfaceJi {

	ButtonInterfaceJi button;
	
	public MoveAchilles() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ButtonInterfaceJi getButton() {
		// TODO Auto-generated method stub
		return new ButtonAchilles(50, 50, 50, 50, "", null);
	}

}
