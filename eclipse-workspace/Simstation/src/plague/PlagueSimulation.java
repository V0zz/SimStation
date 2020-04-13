package plague;
import Simstation.*;
public class PlagueSimulation extends Simulation {
	  public static int VIRULENCE = 50; // % chance of infection
	  public static int RESISTANCE = 2; // % chance of resisting infection
	  private int population = 50;
	  // etc.
	  
	  
	  public void populate() {
		  for(int i=0; i < population; i++) {
			  agentList.add(new Plague(this));
		  }
	  }
	  
	  public String[] getStats() {
		  int count = 0;
		  for(Agent a : agentList) {
			  Plague p = (Plague)a;
			  if(p.getInfectedStatus()) {
				  count++;
			  }
		  }
		  String[] stats = new String[2];
		  stats[0] = "#agents = " + agentList.size();
		  stats[1] = "clock = " + clock;
		  stats[2] = "Infected Percentage: " + count/population * 100;
		  return stats;
	  }
}