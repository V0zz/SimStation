package Simstation;

import mvc.Command;
import mvc.Model;
import mvc.Utilities;

public class StatsCommand extends Command {

	public StatsCommand(Model model) {
		super(model);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		Simulation sim = (Simulation) model;
		Utilities.inform(sim.getStats());

	}

}
