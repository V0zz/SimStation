package Simstation;

import java.io.Serializable;

import mvc.Utilities;

public abstract class Agent implements Runnable, Serializable{
	public static Integer AGENT_SIZE = 5; 	//size of each agent
	private String name;		//name of the agent
	protected Heading heading;	//Agent heading
	private AgentState state;	//state
	private int xc; 	//x coordinate
	private int yc;		//y coordinate
	private Thread thread;
	protected Simulation simulation;
	
	public Agent(Simulation sim) {
		heading = Heading.randomHeading();	//make random
		state = null;
		xc = Utilities.rng.nextInt(Simulation.WORLD_SIZE + 1); 
		yc = Utilities.rng.nextInt(Simulation.WORLD_SIZE + 1);
		thread = new Thread();		
		simulation = sim;
	}
	public void run() {
		thread = Thread.currentThread();
		while(state != AgentState.STOPPED) {
			state = AgentState.RUNNING;
			update();
			simulation.changed();
			try {
				thread.sleep(50);
				synchronized(this){
					while(state == AgentState.SUSPENDED) {
						wait();
					}
				}
			}catch(InterruptedException e){
				System.err.println(e);
			}
		}
	}
	public synchronized void start() {
		thread = new Thread(this);
		state = AgentState.READY;
		thread.start();
	}
	public synchronized void suspend() {
		state = AgentState.SUSPENDED;
	}
	public synchronized void resume() {
		if(state != AgentState.STOPPED) {
			state = AgentState.READY;
			notify();
		}
		
	}
	public synchronized void stop() {
		state = AgentState.STOPPED;
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
		outOfBoundsAdapter();
	}
	
	private void outOfBoundsAdapter() {
		if(yc > Simulation.WORLD_SIZE + SimstationView.BOX_Y_CORNER ) {	//If turtle hits south border
			yc = yc - Simulation.WORLD_SIZE;
		}
		else if(yc < SimstationView.BOX_Y_CORNER ) {		//If turtle hits north border
			yc = yc + Simulation.WORLD_SIZE;
		}
		else if(xc > Simulation.WORLD_SIZE + SimstationView.BOX_X_CORNER ) {		//If turtle hits east border 
			xc = xc - Simulation.WORLD_SIZE;
		}
		else if(xc < SimstationView.BOX_X_CORNER) {		//If turtle hits west border
			xc = xc + Simulation.WORLD_SIZE;
		}
	}
	
	public void join() throws InterruptedException {
		if(thread != null) {
			thread.join();
		}
	}
	public AgentState getState() {
		return state;
	}
	public int getX() {
		return xc;
	}
	public int getY() {
		return yc;
	}
}
