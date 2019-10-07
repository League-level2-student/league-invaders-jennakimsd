import javax.swing.JFrame;

public class LeagueInvaders {
	JFrame frame;
	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;
	GamePanel panel;
	public LeagueInvaders() {
		frame = new JFrame();
		panel = new GamePanel();
	}
	
	public static void main(String[] args) {
		LeagueInvaders object = new LeagueInvaders();
		object.setup();
	}
	void setup() {
		frame.add(panel);
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(panel);
		
	}
}
