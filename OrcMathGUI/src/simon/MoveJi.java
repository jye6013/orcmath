package simon;

public class MoveJi implements MoveInterfaceJi{

	@Override
	public ButtonInterfaceJi getButton() {
		// TODO Auto-generated method stub
		return new ButtonJi(50, 50, 50, 50, "", null);
	}

}
