/*
 * Edit history:
 *   Veida, 4/8: created Drunks
 *
*/
package Drunks;

import Simstation.*;
import mvc.*;

public class Drunks extends Agent {

	public final int MAX_SPEED = 10;

	private int speed;


	public Drunks(Simulation sim) {
		super(sim);
		this.heading = Heading.randomHeading();
		this.speed = Utilities.rng.nextInt(MAX_SPEED) + 1;
	}


	@Override
	public void update() {
		heading = Heading.randomHeading();
		speed = Utilities.rng.nextInt(MAX_SPEED);
		move(speed);
	}
}
