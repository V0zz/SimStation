package Simstation;

import java.util.*;
import mvc.*;

public class Simulation extends Model {
	private Timer timer;
	protected int clock;
	protected String name;
	private AgentState state;
	private List<Agent> agents;
	
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
		state = AgentState.READY;
		populate();
		for(Agent a : agents)
			a.start();
	}
	public synchronized void suspend() {
		state = AgentState.SUSPENDED;
		for(Agent a : agents)
			a.suspend();
	}
	public synchronized void resume() {
		state = AgentState.READY;
		for(Agent a : agents)
			a.resume();
	}
	public synchronized void stop() {
		state = AgentState.STOPPED;
		for(Agent a : agents)
			a.stop();
	}
	public void stats() {

	}
	public Agent getNeighbor(Agent findNext) {
		int initialIndex = agents.indexOf(findNext);
		//If the agent is the last one, return the first
		if(initialIndex == agents.size() - 1)
			return agents.get(0);
		//Otherwise return the next
		else
			return agents.get(initialIndex + 1);
	}
	public void populate() { }
}
