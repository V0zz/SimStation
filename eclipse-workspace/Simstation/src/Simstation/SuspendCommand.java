package Simstation;

import mvc.Command;
import mvc.Model;

public class SuspendCommand extends Command {

	public SuspendCommand(Model model) {
		super(model);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		Simulation sim = (Simulation) model;
		sim.suspend();
	}

}
