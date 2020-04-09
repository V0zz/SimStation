package Simstation;

import java.util.*;
import mvc.*;

public class Simulation extends Model {
	private Timer timer;
	protected int clock;
	protected String name;
	private AgentState state;
	private Thread thread;
	private Agent[] agents;
	
	public Simulation(String name) {
		this.name = name;
		
	}

	private void startTimer() {
		timer = new Timer();
		timer.scheduleAtFixedRate(new ClockUpdater(), 1000, 1000);
	}
	private void stopTimer() {
		timer.cancel();
		timer.purge();
	}
	private class ClockUpdater extends TimerTask {
		public void run() {
			clock++;
		}
	}

	public synchronized void start() {
		for(Agent a : agents)
			a.start();
	}
	public synchronized void suspend() {
		for(Agent a : agents)
			a.suspend();
	}
	public synchronized void resume() {
		for(Agent a : agents)
			a.resume();
	}
	public synchronized void stop() {
		for(Agent a : agents)
			a.stop();
	}
	public void stats() {

	}
	public void getNeighbor(Agent nextAgent) {
		
	}
	public void populate() {
		
	}
}
