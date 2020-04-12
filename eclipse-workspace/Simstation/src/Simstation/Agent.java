package Simstation;

import java.io.Serializable;

public abstract class Agent implements Runnable, Serializable {
	private Simulation world;
	private String name;		//name of the agent
	private Heading heading;	//Agent heading
	private AgentState state;	//state
	private Thread thread;
	private int xc; 	//x coordinate
	private int yc;		//y coordinate
	
	public void run() {
		thread = Thread.currentThread();
		while (!isStopped()) {
			update();
			try {
				Thread.sleep(100);
				synchronized(this) {
					while(isSuspended()) {
						wait();
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		state = AgentState.READY;
	}
	public synchronized void suspend() {
		state = AgentState.SUSPENDED;
	}
	public synchronized  boolean isSuspended() {
		return state == AgentState.SUSPENDED;
	}
	public synchronized void resume() {
		state = AgentState.READY;
	}
	public synchronized void stop() {
		if(!isStopped())
			notify();
		state = AgentState.STOPPED;
	}
	public synchronized boolean isStopped() {
		return state == AgentState.STOPPED;
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
