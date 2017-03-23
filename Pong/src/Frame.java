import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
	static Background background = new Background();
	static MainMenu mainmenu;
	static Frame frame;
	static double size;
	static Game game;
	int playerwalkingkeycode;
	public Home(){
		super(true);
		addMouseListener(this);
		addKeyListener(this);
		this.setFocusable(true);

	}
	

	
	
	public static void main(String[] args) {
		frame = new Frame("Scrooms");
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
		if(background!=null)background.update();
		if(mainmenu!=null)mainmenu.update();
		if(game!=null){
			game.update();
		}
		repaint();
	}
	public void paint(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.BLACK);
		if(size==0){
			size=g.getClipBounds().height;
			mainmenu=new MainMenu();
		}
		g2.fillRect(0, 0, g.getClipBounds().width, g.getClipBounds().height);
		if(background!=null)background.paint(g2);
		if(mainmenu!=null)mainmenu.paint(g2);
		if(game!=null){
			game.paint(g2);
		}
		g.dispose();
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
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
	public void keyPressed(KeyEvent e) {
		//controls main menu option scrolling
		int keycode = e.getKeyCode();
		if(mainmenu!=null){
			if(keycode==38)mainmenu.indexUp();
			else if(keycode==40)mainmenu.indexDown();
			if(keycode==10)mainmenu.enterKeyPressed();
		}
		else{
			if(game!=null){
				if(game.player!=null){
					if(keycode==40){
						game.player.setDirection(0);
						playerwalkingkeycode=40;
					}
					else if(keycode==37){
						game.player.setDirection(2);
						playerwalkingkeycode=37;
					}
					else if(keycode==38){
						game.player.setDirection(1);
						playerwalkingkeycode=38;
					}
					else if(keycode==39){
						game.player.setDirection(3);
						playerwalkingkeycode=39;
					}
				}
				if(keycode==32){
					boolean go = false;//checks if the spacebar destroys a textbox
					for(int i = 0; i < game.objects.length;i++){
						if(game.objects[i]!=null){
							if(game.objects[i].textbox!=null){
								if(game.objects[i].textbox.finished){
									game.objects[i].textbox=null;
									go = true;
									break;
								}
							}
						}
					}
					if(!go){//if the spacebar does not kill a textbox, see if it creates one.
						for(int i = 0; i < game.objects.length;i++){
							if(game.objects[i]!=null)game.objects[i].spacePressed();
						}
					}
				}
			}
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		int keycode = e.getKeyCode();
		if(game!=null){
			if(game.player!=null){
				if(keycode==playerwalkingkeycode)game.player.stopWalking();
			}
		}
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
