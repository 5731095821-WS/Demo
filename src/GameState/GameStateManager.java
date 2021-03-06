package GameState;
import java.awt.Graphics2D;
import java.util.*;
public class GameStateManager {
 private ArrayList<GameState> gameStates;
 private int currentState; 
 public static final int MENUSTATE=0,LEVEL1STATE=1;
public GameStateManager() {
	gameStates = new ArrayList<GameState>();
	currentState=MENUSTATE;
	gameStates.add(new MenuState(this));
}
  public void setState(int state){
	  currentState=state;
	  gameStates.get(currentState).init();
  }
  public void update(){
	  gameStates.get(currentState).update();
  }
  public void draw(Graphics2D g){
	  gameStates.get(currentState).draw(g);
  }
  public void keyPressed(int k){
	  gameStates.get(currentState).KeyPressed(k);
  }
 public void keyReleased(int k){
	 gameStates.get(currentState).KeyReleased(k);
  }
}
