package Plauge;

import Simstation.*;
import mvc.Utilities;

public class Plauge extends Agent
{
	private boolean infected;
	private boolean resistant;
	private int speed;
	double radius = 20;
	
	

	
	public Plauge(Simulation sim)
	{
		super(sim); 
		
		int luck = mvc.Utilities.rng.nextInt(100);
		resistant = luck < PlaugeSim.RESISTANCE;
		speed = mvc.Utilities.rng.nextInt(5);
		infected();
		
		/*
		 * if(Utilities.rng.nextInt(100) + 1 < 10) { isInfected = true; } else
		 * isInfected = false;
		 * 
		 * heading = Heading.random();
		 */
	}

	private void infected() {
	if(!resistant) {
		int luck = mvc.Utilities.rng.nextInt(100);
		this.infected = (luck < PlaugeSim.VIRULENCE);
	}
		
	}

	@Override
	public void update() {
		
		Plauge neighbor = (Plauge)simulation.getNeighbor(this, radius);
		if (neighbor != null ) {
		if(this.isInfected() && !neighbor.isResistant()) {
			neighbor.infected = true;
		}
		
		else if (!this.isResistant() && neighbor.isInfected()) {
			this.infected = true;
		}
		
		}
		
		move(speed);
		heading = Heading.random();
		world.changed();
		
	}
	
	public boolean isInfected() {
		return infected;
	}
	
	public boolean isResistant() {
		return resistant;
		
	}
	
	
		  
		
}
