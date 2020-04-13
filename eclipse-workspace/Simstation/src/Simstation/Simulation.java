package Simstation;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import mvc.*;

public class Simulation extends Model {
	public static Integer WORLD_SIZE = 250; // height & width of the world (& view)
	private int agentPopulation;
	protected ArrayList<Agent> agentList;
	private Timer timer;
	protected int clock;


	public Simulation() {
		clock = 0;
		populate();
		agentList = new ArrayList<Agent>();
		timer = new Timer();
	}
	
	public void start() {
		state = AgentState.READY;
		for(Agent a : agents)
			a.start();
		changed();
	}

	public void suspend() {
		if(agentList.get(0).getState() == AgentState.STOPPED) {
			Utilities.error("Is stopped");
			return;
		}
		stopTimer();
		state = AgentState.SUSPENDED;
		for(Agent a : agents)
			a.suspend();
		changed();
	}

	public void resume() {
		if(agentList.get(0).getState() == AgentState.STOPPED) {
			Utilities.error("Is stopped");
			return;
		}
		state = AgentState.READY;
		startTimer();
		for(Agent a : agents)
			a.resume();
		changed();
	}

	public void stop() {
		state = AgentState.STOPPED;
		stopTimer();
		for(Agent a : agents)
			a.stop();
		changed();
	}

	public String[] getStats() {
		  String[] stats = new String[2];
		  stats[0] = "#agents = " + agentList.size();
		  stats[1] = "clock = " + clock;
		  return stats;
	}

	public synchronized Agent getNeighbor(Agent thisAgent) {
		Agent nextAgent = null;
		int thisX = thisAgent.getX(); int thisY = thisAgent.getY();
		
		for(int i = 0; i < agentList.size(); i++) {
			Agent a = agentList.get(i);
			if(i == 0) {
				nextAgent = a;
				continue;
			}
			
			double diffAX = Math.abs(a.getX() - thisX);
			double diffAY = Math.abs(a.getY() - thisY);
			double distAthis = Math.sqrt((diffAX * diffAX) + (diffAY * diffAY));
			
			double diffNearX = Math.abs(nextAgent.getX() - thisX);
			double diffNearY = Math.abs(nextAgent.getY() - thisY);
			double distNearthis = Math.sqrt((diffNearX * diffNearX) + (diffNearY * diffNearY));
			
			if(distAthis < distNearthis) {
				nextAgent = a;
			}
		}
		return nextAgent;
	}

	public void populate() {		//write in the demos
		
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
}
