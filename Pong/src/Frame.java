import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Home extends JPanel implements KeyListener, MouseListener{
	static Frame frame;
	public static int width;
	public static int height;
	Paddle paddle[] = new Paddle[2];
	Ball ball;
	int counter = 0;
	private boolean gamestate = false;
	public Home(){
		super(true);
		addMouseListener(this);
		addKeyListener(this);
		this.setFocusable(true);

	}
	public static void main(String[] args) {
		frame = new Frame("Pong - By Zane, Andrew, and Manoli");
		frame.addWindowListener(new WindowAdapter() {
	        public void windowClosing(WindowEvent we) {
	            frame.dispose();
	            System.exit(0);
	         }
	     }
		);
		final Home game = new Home();
		frame.add(game);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setUndecorated(true);
		frame.setVisible(true);
		Graphics g = frame.getGraphics();
		frame.paint(g);
		Timer t = new Timer();
        t.schedule(new TimerTask() {
            public void run() {
                game.update();
            }
        }, 0, 25); 
	}
	public void update(){
		counter++;
		if(paddle[0]!=null){
			paddle[0].update();
			paddle[1].update();
		}
		if(ball!=null)ball.update();
		repaint();
	}
	public void paint(Graphics g){
		width = g.getClipBounds().width;
		height = g.getClipBounds().height;
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, height);
		Font font1 = new Font("Monospaced Bold", Font.BOLD, 80);
		g.setFont(font1);
		if(!gamestate && counter%20<10){
			int textwidth = g.getFontMetrics().stringWidth("'Space' to start");
			int x = width/2 - textwidth/2;
			g.setColor(Color.white);
			g.drawString("'Space' to start", x, height/2-40);
		}
		else if(gamestate){
			if(paddle[1]!=null){
				paddle[0].paint(g);
				paddle[1].paint(g);
			}
			if(ball!=null)ball.paint(g);
		}
	}
	public void startgame(){
		ball = new Ball();
		paddle[0]=new Paddle(false);
		paddle[1]=new Paddle(true);
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		if(!gamestate){
			gamestate=true;
			startgame();
		}
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		if(!gamestate){
			gamestate=true;
			startgame();
		}
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
