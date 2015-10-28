import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import com.sun.glass.ui.Size;

import GameState.GameState;
import GameState.GameStateManager;
import TileMap.Background;


public class MenuState extends GameState {
	private  Background bg;
	private int currentChoice=0;
	private String[] options ={
		"Start","Help","Quit"
	};
	private Color titleColor;
	private Font titleFont;
	private Font font;
	public MenuState(GameStateManager gsm) {
		super();
		this.gsm=gsm;
		try{
			bg= new Background("/Background/menubg.gif", 1);
			bg.setVector(-0.1, 0);
			titleColor=new Color(128,0,0);
			titleFont=new Font("Century Gothic",Font.PLAIN,28);
			font=new Font("Arial",Font.PLAIN,12);
			
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub

	}

	@Override
	public void KeyPressed(int k) {
		// TODO Auto-generated method stub

	}

	@Override
	public void KeyReleased(int k) {
		// TODO Auto-generated method stub

	}

}
