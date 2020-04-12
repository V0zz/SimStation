package Simstation;

import java.io.Serializable;

public abstract class Agent implements Runnable, Serializable {
	private Simulation world;
	private String name;		//name of the agent
	private Heading heading;	//Agent heading
	private AgentState state;	//state
	private int xc; 	//x coordinate
	private int yc;		//y coordinate
	
	public void run() {
		while (state.equals(AgentState.RUNNING))
		{

		}
	}
	public void start() {
		this.state = AgentState.READY;
	}
	public void suspend() {
		this.state = AgentState.SUSPENDED;
	}
	public void resume() {
		this.state = AgentState.READY;
	}
	public void stop() {
		this.state = AgentState.STOPPED;
	}
	public abstract void update();
	
	public void move(int steps) {
		if(heading == Heading.NORTH) {
			yc = yc - steps;
		}
		else if(heading == Heading.SOUTH) {
			yc = yc + steps;
		}
		else if(heading == Heading.EAST) {
			xc = xc + steps;
		}
		else {	//West
			xc = xc - steps;
		}
		world.changed();
	}
}
