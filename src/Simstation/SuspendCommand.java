/*
 * Edit history:
 *   Veida, 4/1: created SuspendCommand
 *
*/
package Simstation;

import mvc.Command;
import mvc.Model;

public class SuspendCommand extends Command {

	public SuspendCommand(Model model) {
		super(model);
	}

	@Override
	public void execute() {
		Simulation sim = (Simulation) model;
		sim.suspend();
	}

}
