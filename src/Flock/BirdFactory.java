/*
 * Edit history:
 *   Veida, 4/8: created BirdFactory
 *   
*/
package Flock;

import Simstation.*;
import mvc.*;

public class BirdFactory extends SimstationFactory {

	public BirdFactory() {
		super();
	}


	@Override
	public Model makeModel() {
		return new BirdSimulation("Bird Simulation");
	}
}
