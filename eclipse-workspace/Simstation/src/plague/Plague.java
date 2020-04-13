package plague;
import Simstation.*;
import mvc.Utilities;
public class Plague extends Agent{
	private boolean isInfected;
	private boolean isResistant;
	
	public Plague(Simulation sim) {
		super(sim);
		
		if(Utilities.rng.nextInt(100) + 1 < 10) {
			isInfected = true;
		}else {
			isInfected = false;
		}
		heading = Heading.NORTH;//random heading;
	}
	public boolean getInfectedStatus() {
		if(isInfected == true)
			return true;
		else 
			return false;
	}
	@Override
	public void update() {
		Plague neighbor = (Plague)simulation.getNeighbor(this);
		if(neighbor.isInfected && isResistant != true) {
			int infectChance = Utilities.rng.nextInt(99)+1;
			if(infectChance <= PlagueSimulation.VIRULENCE) {
				int killVirusChance = Utilities.rng.nextInt(99)+1;
				if(killVirusChance <= PlagueSimulation.RESISTANCE) {
					isInfected = false;
					isResistant = true;
				}else {
					isInfected = true;
				}
			}
		}
	}
}
