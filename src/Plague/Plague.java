package Plague;

import Simstation.*;

public class Plague extends Agent
{
	private boolean infected;
	private boolean resistant;
	private int speed;
	double radius = 20;

	public Plague(Simulation sim)
	{
		super(sim); 
		
		int luck = mvc.Utilities.rng.nextInt(100);
		resistant = luck < PlagueSim.RESISTANCE;
		heading = Heading.randomHeading();
		speed = mvc.Utilities.rng.nextInt(5);
		infected();
		
		/*
		 * if(Utilities.rng.nextInt(100) + 1 < 10) { isInfected = true; } else
		 * isInfected = false;
		 */
	}

	private void infected() {
	if(!resistant) {
		int luck = mvc.Utilities.rng.nextInt(100);
		this.infected = (luck < PlagueSim.VIRULENCE);
	}
		
	}

	@Override
	public void update() {
		
		Plague neighbor = (Plague) world.getNeighbor(this, radius);
		if (neighbor != null ) {
		if(this.isInfected() && !neighbor.isResistant()) {
			neighbor.infected = true;
		}
		
		else if (!this.isResistant() && neighbor.isInfected()) {
			this.infected = true;
		}
		
		}
		heading = Heading.randomHeading();
		move(speed);
		world.changed();
		
	}
	
	public boolean isInfected() {
		return infected;
	}
	
	public boolean isResistant() {
		return resistant;
		
	}
	
	
		  
		
}
