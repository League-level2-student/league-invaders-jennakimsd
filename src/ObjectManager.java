import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	
	Rocketship rocket;
	ArrayList<Projectile> projectiles= new ArrayList<Projectile>();
	ArrayList<Alien> aliens= new ArrayList<Alien>();
	Random random= new Random();
	
	ObjectManager(Rocketship r){
		this.rocket=r;
	}
	
	void addProjectile(Projectile p) {
		projectiles.add(p);
		for(Projectile j : projectiles) {
			j.update();
			if(j.y<=0) {
				j.isActive = false;
			}
		}
	}
	
	void addAlien(){
		aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH),0,50,50));
	}
	
	void update() {
		for(Alien i : aliens) {
			i.update();
			if(i.y>=LeagueInvaders.HEIGHT) {
				i.isActive =false;
			}
		}
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
	
	void purgeObjects(){
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
}
