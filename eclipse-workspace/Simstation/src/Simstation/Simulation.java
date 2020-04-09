package Simstation;

import mvc.*;

public class Simulation extends Model {
	public static Integer WORLD_SIZE = 250; // height & width of the world (& view)
	protected long clock;
	protected String name;
	private AgentState state;
	private Thread thread;
	
	public Simulation(String name) {
		this.name = name;
		Simulation();
	}
	public Simulation() {
		clock = 0;
		state = AgentState.READY;
	}
	public void start() {
		
	}
	public void suspend() {
		
	}
	public void resume() {
		
	}
	public void stop() {
		
	}
	public void getNeighbor(Agent nextAgent) {
		
	}
	public void populate() {
		
	}
}
