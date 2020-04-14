package Flock;

import Simstation.*;

public class BirdSim extends Simulation {
	public static final int POP_SIZE = 50;

	public BirdSim(String name) {
		super(name);
	}

	@Override
	public void populate() {
		for(int i = 0; i< POP_SIZE; i++) {
			agents.add(new Bird(this));
		}
	}

}
