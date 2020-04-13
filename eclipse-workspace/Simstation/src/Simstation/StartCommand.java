package Simstation;

import mvc.Command;
import mvc.Model;

public class StartCommand extends Command {

	public StartCommand(Model model) {
		super(model);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		if(model.getClass() == Simulation.class) {
			Simulation sim = (Simulation)model;
			sim.start();
		}
	}

}
