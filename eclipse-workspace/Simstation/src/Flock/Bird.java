package Flock;

import Simstation.*;
import mvc.Utilities;

public class Bird extends Agent {

	private int speed;
	public final int SPEED = 10;
	public final int RADIUS = 40;
	
	
	public Bird(Simulation sim) {
		
		super(sim);
		this.heading = Heading.random();
		this.speed = Utilities.rng.nextInt(SPEED) + 1;
	}

	@Override
	public void update() {
		Bird neighbor = (Bird) world.getNeighbor(this, RADIUS);
		if(neighbor != null)
		{
			speed = neighbor.getSpeed();
			heading = neighbor.getHeading();
		}
		
		move(speed);
		world.changed();
		
	}
	
	public int getSpeed() {
		return speed;
		}

	public Heading getHeading() {
		return heading;
	}
}
