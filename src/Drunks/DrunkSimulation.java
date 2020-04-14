/*
 * Edit history:
 *   Veida, 4/8: created DrunkSimulation
 *   Veida, 4/8: added population amd the size of the population
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
