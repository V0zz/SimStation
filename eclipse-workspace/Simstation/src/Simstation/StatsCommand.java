package Simstation;

import mvc.Command;
import mvc.Model;
import mvc.Utilities;

public class StatsCommand extends Command {

	public StatsCommand(Model model) {
		super(model);
	}

	@Override
	public void execute() {
		if(model.getClass() == Simulation.class) {
			Simulation sim = (Simulation)model;
			Utilities.inform(sim.getStats());
		}
	}

}
