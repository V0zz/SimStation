/*
 * Edit history:
 *   Veida, 4/8: created DrunkSimulation
 *
*/
package Drunks;

import Simstation.*;

public class DrunkSimulation extends Simulation {

	public static final int POP_SIZE = 50;

	public DrunkSimulation(String name) {
		super(name);
	}

	@Override
	public void populate() {
		for(int i = 0; i < POP_SIZE; i++) {
			agents.add(new Drunks(this));
		}
	}
}
