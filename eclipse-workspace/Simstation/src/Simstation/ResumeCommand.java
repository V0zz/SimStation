package Simstation;

import mvc.Command;
import mvc.Model;

public class ResumeCommand extends Command {

	public ResumeCommand(Model model) {
		super(model);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		Simulation sim = (Simulation) model;
		sim.resume();
	}

}
