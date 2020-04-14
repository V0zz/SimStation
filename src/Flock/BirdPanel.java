/*
 * Edit history:
 *   Veida, 4/8: created BirdPanel
 *   Arlan, 4/10: Changed to SimFactory
*/
package Flock;

import Simstation.*;
import mvc.AppFactory;

public class BirdPanel extends SimstationPanel {

	private static final long serialVersionUID = 1L;


	public BirdPanel(SimFactory factory) {
		super(factory);
	}


	public static void main(String[] args){
		SimFactory factory = new BirdFactory();
		SimstationPanel panel = new SimstationPanel(factory);
		panel.display();
	}
}
