import java.awt.Color;
import java.awt.Graphics;


public class Ball {
	int size = Home.width/40;
	double x;
	double y;
	double xvelocity;
	double yvelocity;
	public Ball(){
		xvelocity=0;
		yvelocity=0;
		x=Home.width/2 - size/2;
		y=Home.height/2 - size/2;
	}
	public void update(){
		//called 40 times a second
	}
	public void collided(Paddle paddle){
		//called when ball interacts with paddle
	}
	public void paint(Graphics g){
		g.setColor(Color.WHITE);
		g.fillRect((int)x, (int)y, size, size);
	}
}
