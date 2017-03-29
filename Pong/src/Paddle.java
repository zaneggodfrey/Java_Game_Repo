import java.awt.Color;
import java.awt.Graphics;


public class Paddle {
	boolean leftside;
  int counter = 0;
	final int distancefromside = Home.width/50;//inwardside
	final int height = Home.height/8;
	final int width = Home.width/100;
	int y = Home.height/2 - height/2;
	
	public Paddle(boolean leftside){//left side or right of paddle
		this.leftside = leftside;
	}
	public void update(){
		counter++;
		if(leftside){
			if(y<Home.height-height){
				y+=4;
			}
		}
		//called 40 times a second
	}
	public void keyPressed(int keycode){
		
	}
	public void paint(Graphics g){
		int x;
		if(leftside)x = distancefromside-width;
		else x=Home.width-distancefromside;
		g.setColor(Color.WHITE);
		g.fillRect(x, y, width, height);
	}
}
