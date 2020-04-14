/*
 * Edit history:
 *   Veida, 4/8: created DrunkFactory
 *   Veida, 4/8: added "Drunk Simulation"
*/
package Drunks;

import Simstation.*;
import mvc.*;

public class DrunkFactory extends SimstationFactory {

	public DrunkFactory() {
		super();
	}
	
	@Override
	public Model makeModel() {
		return new DrunkSimulation("Drunk Simulation");
	}
}
