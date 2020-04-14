package Plague;

import Simstation.*;
import mvc.*;

public class PlagueFactory extends SimstationFactory {

	public PlagueFactory() {super();}
	
	@Override
	public Model makeModel() {
		return new PlagueSim("Plague Simulation");
		
	}
	
	public View getView(Model model) {
		return new PlagueView(model);
	}
	
	
}
