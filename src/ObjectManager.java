import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener {
	
	Rocketship rocket;
	ArrayList<Projectile> projectiles= new ArrayList<Projectile>();
	ArrayList<Alien> aliens= new ArrayList<Alien>();
	Random random= new Random();
	int score= 0;
	
	ObjectManager(Rocketship r){
		this.rocket=r;
	}
	
	int getScore(){
		return this.score;
	}
	
	public void addProjectile(Projectile p) {
		projectiles.add(p);
		for(Projectile j : projectiles) {
			j.update();
			if(j.y<=0) {
				j.isActive = false;
			}
		}
	}
	
	public void addAlien(){
		aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH),0,50,50));
	}
	
	public void update() {
		for(Alien i : aliens) {
			i.update();
			if(i.y>=LeagueInvaders.HEIGHT) {
				i.isActive =false;
			}
		}
		for(Projectile i : projectiles) {
			i.update();
			if(i.y>=LeagueInvaders.HEIGHT) {
				i.isActive =false;
			}
		}
		rocket.update();
		checkCollision();
		purgeObjects();
	}
	
	void draw(Graphics g){
		rocket.draw(g);
		for(Alien a : aliens) {
			a.draw(g);
		}
		for(Projectile p : projectiles) {
			p.draw(g);
		}
	}
	
	public void purgeObjects(){
		for(int i=0; i<aliens.size(); i++) {
			if(aliens.get(i).isActive ==false) {
				aliens.remove(i);
			}
		}
		
		for(int i=0; i<projectiles.size(); i++) {
			if(projectiles.get(i).isActive ==false) {
				projectiles.remove(i);
			}
		}
	}
	public void checkCollision() {
		for(Alien a : aliens) {
			for(Projectile p : projectiles) {
				if(p.collisionBox.intersects(a.collisionBox)) {
					p.isActive=false;
					a.isActive=false;
					score++;
				}
			}
			if(rocket.collisionBox.intersects(a.collisionBox)) {
				a.isActive=false;
				rocket.isActive=false;
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		addAlien();
	}
}
