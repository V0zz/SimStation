/*
* Edit history:
* Veida, 4/1: ResumeCommand, execute
* 
*/
package Simstation;

import mvc.Command;
import mvc.Model;

public class ResumeCommand extends Command {

	public ResumeCommand(Model model) {
		super(model);
	}

	@Override
	public void execute() {
		Simulation sim = (Simulation) model;
		sim.resume();
	}

}
