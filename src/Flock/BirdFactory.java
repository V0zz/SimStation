/*
 * Edit history:
 *   Veida, 4/8: created BirdFactory
 *   Arlan, 4/10: Changed to SimFactory
*/
package Flock;


import Simstation.*;
import mvc.*;

public class BirdFactory extends SimstationFactory {
	public BirdFactory(SimFactory factory) {
		super(factory);
	}
	
	public static void main(String[] args){
	SimFactory factory = new BirdFactory();
	SimstationPanel panel = new SimstationPanel(factory);
	panel.display();
	}
}
