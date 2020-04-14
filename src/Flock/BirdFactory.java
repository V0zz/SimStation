package Flock;


import Simstation.*;
import mvc.*;

public class BirdFactory extends SimstationFactory {
	public BirdFactory() {
		super();
	}
	
	@Override
	public Model makeModel() {
		return new BirdSim("Bird Simulation");
	}
}
