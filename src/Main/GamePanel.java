package Main;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import GameState.GameStateManager;

import com.sun.glass.events.KeyEvent;
public class GamePanel extends JPanel implements Runnable,KeyListener {
	 //dimensions
	public static final int WIDTH=320,HEIGHT=240,SCALE=2;
	//game thread
	private Thread thread;
	private  boolean running;
	private int FPS=60;
	private long targetTime =1000/FPS;
	//image
	private BufferedImage image;
	private Graphics2D g;
	
	//Game state manager
	private GameStateManager gsm;
	
	public GamePanel() {
		super();
		setPreferredSize(new Dimension(WIDTH*SCALE,HEIGHT*SCALE));
		setFocusable(true);
		requestFocus();
	}
	 public void addNotify(){
		 super.addNotify();
		 if(thread==null){
			 thread = new Thread(this);
			 addKeyListener(this);
			 thread.start();
		 }
	 } 
	 private void init(){
		 image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		 g=(Graphics2D)image.getGraphics();
		 running=true;
		 gsm=new GameStateManager();
		 
		 
	 }
	 public void run(){
		 long start,elapsed,wait;
			init(); 
			//game loop
			while(running){
				start =System.nanoTime();
				update();
				draw();
				drawToScreen();
				elapsed=System.nanoTime()-start;
				wait=targetTime-elapsed/1000000;
				if(wait<0)wait=5;
				try{
					Thread.sleep(wait);
				}
				catch (Exception e){
					e.printStackTrace();
				}
			}
		 }
	 private void update(){
		 gsm.update();
	 }
	 private void draw(){
		 gsm.draw(g);
	 }
	 private void drawToScreen(){
		Graphics g2=getGraphics();
		g2.drawImage(image,0,0,WIDTH*SCALE,HEIGHT*SCALE,null);
		g2.dispose();
	 }
	 
	@Override
	public void keyPressed(java.awt.event.KeyEvent key) {
		gsm.keyPressed(key.getKeyCode());
		
	}
	@Override
	public void keyReleased(java.awt.event.KeyEvent key) {
		gsm.keyReleased(key.getKeyCode());
		
	}
	@Override
	public void keyTyped(java.awt.event.KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	 
}
