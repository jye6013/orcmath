package festiveCard;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.StyledComponent;
import guiTeacher.components.TextArea;
import guiTeacher.components.TextField;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;


public class CardScreen extends FullFunctionScreen{

	private TextArea title;
	private Button switchScreen;

	public CardScreen(int width, int height) {
		super(width, height);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		viewObjects.add(new Graphic(0, 0, getWidth(),getHeight(),"resources/holiday_background_310742.jpg"));
		try {

			File fontFile = new File("resources//mellony_dry_brush.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			Font baseFont=font.deriveFont(16f);
			StyledComponent.setBaseFont(baseFont);
		} catch (Exception e) {
			e.printStackTrace();
		}

		StyledComponent.setButtonOutline(true);
		title = new TextArea(350, 40, 300, 30, "Happy Holidays!");
		title.setCustomTextColor(new Color(100, 100, 100));
		switchScreen = new Button(350, 480, 100, 40, "View More", new Action() {


			@Override
			public void act() {
				CardGUI.card.setScreen(CardGUI.screen2);
			}
		});


		viewObjects.add(title);
		viewObjects.add(switchScreen);
		viewObjects.add(new Banner(550));
		viewObjects.add(new Snowflake(1000, 1000));
	}


}
