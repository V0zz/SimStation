/*
 * Edit history:
 *   Veida, 4/1: created StopCommand
 *
*/
package Simstation;

import mvc.Command;
import mvc.Model;

public class StopCommand extends Command {

	public StopCommand(Model model) {
		super(model);
	}

	@Override
	public void execute() {
		Simulation sim = (Simulation) model;
		sim.stop();
	}
}
