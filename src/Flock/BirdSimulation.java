/*
 * Edit history:
 *   Veida, 4/8: created BirdSim
 *
*/
package Flock;

import Simstation.*;

public class BirdSimulation extends Simulation {

	public static final int POP_SIZE = 50;


	public BirdSimulation(String name) {
		super(name);
	}


	@Override
	public void populate() {
		for(int i = 0; i< POP_SIZE; i++) {
			agents.add(new Bird(this));
		}
	}
}
