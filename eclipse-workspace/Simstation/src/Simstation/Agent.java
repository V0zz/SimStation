
package Simstation;

import java.io.Serializable;
import mvc.Utilities;

public abstract class Agent implements Runnable, Serializable {
	protected Simulation simulation;
	private Thread myThread;
	protected String name; // name of the agent
	protected Simulation world;
	private AgentState state; // state
	protected Heading heading; // Agent heading
	protected static int xc; // x coordinate
	protected static int yc; // y coordinate\
	public boolean finished;

	public Agent(Simulation simulation) {
		this.simulation = simulation;
		finished = false;
		this.state = null;
		myThread = new Thread();
		xc = Utilities.rng.nextInt(Simulation.SIZE);
		yc = Utilities.rng.nextInt(Simulation.SIZE);
		this.heading = Heading.random();
	}

	

	public void run() {
		myThread = Thread.currentThread();
			while (!finished) {
				state = AgentState.RUNNING;
				update();
				try {
				Thread.sleep(20); // Cooperative
				synchronized (this) {
					while (state == AgentState.SUSPENDED) {
						wait();
					}
				}
			
		} catch (InterruptedException e) {
			onInterrupted();
		}
			}
		//onExit();
	}

	public void start() {
		onStart();
		state = AgentState.READY;
		if (myThread == null)
			myThread = new Thread(this);
		myThread.start();
	}

	public synchronized void suspend() {
		state = AgentState.SUSPENDED;
	}

	public synchronized void resume() {
		if (state != AgentState.STOPPED)
			state = AgentState.READY;
		notify();
	}

	public synchronized void stop() {
		state = AgentState.STOPPED;
	}

	public abstract void update();
	// overridables

	protected synchronized void onStart() {
		//System.out.println(name + "starting");
	}

	protected synchronized void onExit() {
		//System.out.println(name + "exiting");
	}

	protected synchronized void onInterrupted() {
		//System.out.println(name + "interrupted");
	}

	
	  public synchronized boolean finished() 
	  { return (state == AgentState.STOPPED) || myThread != null && myThread.getState() == Thread.State.TERMINATED; }
	 
	 
	public synchronized boolean inSuspended() {
		return state == AgentState.SUSPENDED;
	}

	public void join() throws InterruptedException {
		if (myThread != null)
			myThread.join();
	}

	public synchronized String getName() {
		return name;
	}

	public void move(int steps) {
		switch (heading) {
		
		case NORTH: 
			yc -= steps;
			if(yc <0)
				yc = Simulation.SIZE + yc;
			break;
		case EAST:
			xc = (xc + steps) % Simulation.SIZE;
		case WEST:
			xc -= steps;
			if(xc <0)
				xc = Simulation.SIZE + xc;
			
		case SOUTH:
			yc = (yc + steps) % Simulation.SIZE;
			break;
		}
	
		
	}

	
	  public boolean outofBounds() {
		  if(xc > Simulation.SIZE + SimstationView.XC) {
			  return true; 
			  } 
	  	else if (xc < SimstationView.XC) {
	  		return true;
	  
	  } else if(yc > Simulation.SIZE + SimstationView.YC) {
		  return true;
	  
	  } else if (yc < SimstationView.YC) 
		  return true; 
		  
	  	return false; }
	 
	public AgentState getState() {
		return state;
	}

	
	  public void setWorld(Simulation simulation2) { 
		  return;
	  
	  }
	  
	  public double distance(Agent candidate) { // TODO Auto-generated method stub
	  return 0; }
	 

	public int getXCoordinate() {
		// TODO Auto-generated method stub
		return xc;
	}
	
	public int getYCoordinate() {
		// TODO Auto-generated method stub
		return yc;
	}
	
	public double getDistance(Agent a) {
		return Math.sqrt(Math.pow(this.xc - a.xc,2) + Math.pow(this.yc - a.yc , 2));
		
	}
}
