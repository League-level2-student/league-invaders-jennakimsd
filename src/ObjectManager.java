import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	
	Rocketship rocket;
	Projectile projectiles;
	Alien aliens;
	Random random= new Random();
	
	ObjectManager(Rocketship r, ArrayList p, ArrayList a){
		this.rocket=r;
		//p.add(projectiles);
		//a.add(aliens);
	}
	
	void addProjectile(Projectile p) {
		
	}
	
	void addAlien(){
		//aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH),0,50,50));
	}
	
	void update() {
		
	}
	
	void draw(Graphics graphics){
		
	}
	
	void purgeObjects(){
		
	}
}
