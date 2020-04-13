package Plauge;

import Simstation.*;

public class PlaugeSim extends Simulation

{

	  public static int VIRULENCE = 50; // % chance of infection
	  public static int RESISTANCE = 2; // % chance of resisting infection
	  public static int POP_SIZE = 50;
	  
	  public void populate()
	  {
		  for(int i = 0; i < POP_SIZE; i++)
		  {
			  agents.add(new Plauge(this));
		  }
	  }
	  
	  public String[] getStats() {
		  double count = 0;
		  for (Agent a: agents ) {
			  Plauge p = (Plauge)a;
			  if(p.isInfected())
			  {
				  count++;
			  }
			  
		  }
		  String[] stats = new String[2];
		  stats[0] = "# agents = " +agents.size();
		  stats[1] = "clock = " + clock;
		  stats[2] = "Precent of infected: " + Math.round(count/POP_SIZE *100);
		return stats;
	  }
	  
}
