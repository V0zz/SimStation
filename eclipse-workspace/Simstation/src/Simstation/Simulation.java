package Simstation;
import java.util.*;


import mvc.*;


public class Simulation extends Model {
	
	public static int SIZE = 250;
	protected ArrayList<Agent> agents;
	private Timer timer;
	protected int clock;
	public Simulation() {
		this.agents = new ArrayList<>();
		//agents = new ArrayList<Agent>();
		clock = 0;
		timer = new Timer();
		new Thread();
		
	}
	
	public void addAgent(Agent a) {
		agents.add(a);
		a.setWorld(this);
	}
	
	public synchronized Agent getNeighbor(Agent asker, double radius) {
		Agent neighbor = null;
		boolean found = false;
		int i = Utilities.rng.nextInt(agents.size());
		int start = i;
		while(!found) {
			Agent candidate = agents.get(i);
			
			if(candidate != asker && asker.distance(candidate) < radius) {
				neighbor = agents.get(i);
				found = true;
			} else {
				i = (i+1) % agents.size();
				if(i == start) 
					break;
			}
		}
		return neighbor;
		
	}
	

	
	/*
	 * private Agent[] agents;
	 * 
	 * public Simulation(String name) { this.name = name;
	 * 
	 * }
	 */

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
		agents.clear();
		populate();
		startTimer();
		for(Agent a : agents) {
			a.start();
		}
		changed();
	}
	public synchronized void suspend() {
		if(agents.get(0).getState() == AgentState.STOPPED)
			return;
		stopTimer();
		for(Agent a : agents)
			a.suspend();
		
		/* changed(); */
	}
	public synchronized void resume() {
		if(agents.get(0).getState() == AgentState.SUSPENDED)
			startTimer();
		for(Agent a : agents)
			a.resume();
		
		changed();
	}
	public synchronized void stop() {
		stopTimer();
		for(Agent a : agents) {
			a.stop();
		}
		
		 changed(); 
	}


	public void populate() {
		
	}
	
	public String[] getStats() {
		  String[] stats = new String[2];
		  stats[0] = "#agents = " + agents.size();
		  stats[1] = "clock = " + clock;
		  return stats;
		}
	


	public ArrayList<Agent> getAgents() {
		// TODO Auto-generated method stub
		return agents;
	}
	
	public int getClock() {
		return clock;
	}
}