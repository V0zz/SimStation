/*
 * Edit history:
 *   Veida, 4/1: created StartCommand, execute
 *
*/
package Simstation;

import mvc.Command;
import mvc.Model;

public class StartCommand extends Command {

	public StartCommand(Model model) {
		super(model);
	}

	@Override
	public void execute() {
		Simulation sim = (Simulation) model;
		sim.start();
	}

}
