/*
 * Edit history:
 *   Veida, 4/8: created Drunks
 *
*/
package Drunks;

import Simstation.*;
import mvc.*;

public class Drunks extends Agent {
	
	private int speed;
	public final int SPEED  = 10;

	public Drunks(Simulation sim) {
		super(sim);
		this.heading = Heading.randomHeading();
		this.speed = Utilities.rng.nextInt(SPEED) + 1;
		
	}

	@Override
	public void update() {
		heading = Heading.randomHeading();
		speed = Utilities.rng.nextInt(SPEED);
		move(speed);
	}
}
