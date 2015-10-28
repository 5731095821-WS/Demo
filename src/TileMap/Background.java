package TileMap;
import java. awt.*;

import javax.imageio.*;

import java.awt.image.BufferedImage;

public class Background {
	private BufferedImage image;
	private double x,y,dx,dy;
	private double moveScale;
	public Background(String s,double moveScale){
		try {
			image=ImageIO.read(getClass().getResourceAsStream(s));
		}
		catch(Exception e){
			
		}
	}
} 
