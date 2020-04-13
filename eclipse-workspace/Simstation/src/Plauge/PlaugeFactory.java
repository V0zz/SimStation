package Plauge;

import Simstation.*;
import mvc.*;

public class PlaugeFactory extends SimstationFactory {

	public PlaugeFactory() {super();}
	
	@Override
	public Model makeModel() {
		return new PlaugeSim();
		
	}
	
	public View getView(Model model) {
		return new PlaugeView(model);
	}
	
	
}
