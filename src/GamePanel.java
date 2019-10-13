import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.Timer;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
	Font titleFont;
	Font regularFont;
	Timer frameDraw;
	Rocketship rocket = new Rocketship(250, 700, 50, 50);
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	
	public GamePanel() {
		titleFont = new Font("Arial", Font.PLAIN, 48);
		regularFont = new Font("Arial", Font.PLAIN, 30);
		frameDraw = new Timer(1000/60,this);
		frameDraw.start();
		if (needImage) {
		    loadImage ("space.png");
		}

	}
	
	void updateMenuState() {  
		
	}
	void updateGameState() {  
		
	}
	void updateEndState()  {  
		
	}
	
	void drawMenuState(Graphics g) {  
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.WHITE);
		g.drawString("LEAGUE INVADERS", 20, 100);
		g.setFont(regularFont);
		g.drawString("Press ENTER to start", 100, 345);
		g.drawString("Press SPACE for instructions", 50, 515);
	}
	void drawGameState(Graphics g) {  
		 if (gotImage) {
	        g.drawImage(image, 0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT, null);	
	        }
		else {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT); 
			rocket.draw(g);
		}
	}
	void drawEndState(Graphics g)  {  
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("Game Over", 120, 100);
		g.setFont(regularFont);
		g.drawString("You killed " + " enemies", 110, 345);
		g.drawString("Press ENTER to restart", 80, 515);
	}
	
	@Override
	public void paintComponent(Graphics g){
		if(currentState == MENU) {
		    drawMenuState(g);
		}
		else if(currentState == GAME) {
		    drawGameState(g);
		}
		else if(currentState == END) {
		    drawEndState(g);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(currentState == MENU){
		    updateMenuState();
		}else if(currentState == GAME){
		    updateGameState();
		}else if(currentState == END){
		    updateEndState();
		}
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
		    if (currentState == END) {
		        currentState = MENU;
		    } else {
		        currentState++;
		    }
		}  
		if (e.getKeyCode()==KeyEvent.VK_UP) {
		    System.out.println("UP");
		    if(rocket.y<=0) {
		    	rocket.y=0;
		    }
		    rocket.up();
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN) {
		    System.out.println("DOWN");
		    if(rocket.y + rocket.height >=LeagueInvaders.HEIGHT) {
		    	rocket.y=LeagueInvaders.HEIGHT - rocket.height;
		    }
		    rocket.down();
		}
		if (e.getKeyCode()==KeyEvent.VK_LEFT) {
		    System.out.println("LEFT");
		    if(rocket.x<=0) {
		    	rocket.x=0;
		    }
		    rocket.left();
		}
		if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
		    System.out.println("RIGHT");
		    if(rocket.x + rocket.width>=LeagueInvaders.WIDTH) {
		    	rocket.x=LeagueInvaders.WIDTH -rocket.width;
		    }
		    rocket.right();
		}
	}
	
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
