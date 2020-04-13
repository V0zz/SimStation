package Drunks;

import Simstation.*;
import mvc.*;

public class Drunks extends Agent {
	
	private int speed;
	public final int SPEED  = 10;

	public Drunks(Simulation sim) {
		super(sim);
		this.heading = Heading.random();
		this.speed = Utilities.rng.nextInt(SPEED) + 1;
		
	}

	@Override
	public void update() {
		heading = Heading.random();
		move(speed);
		speed = Utilities.rng.nextInt(SPEED);
		
	}
	

}
