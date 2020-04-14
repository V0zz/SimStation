/*
 * Edit history:
 *   Arlan, 4/10: created PlaguePanel
 *   Arlan, 4/10: added SimFactory
*/
package Plague;

import Simstation.*;
import mvc.AppFactory;

public class PlaguePanel extends SimstationPanel{

	public PlaguePanel(SimFactory factory) {
		super(factory);
		
	}
	
	public static void main (String[] args) {
		SimFactory factory = new PlagueFactory();
		SimstationPanel panel = new SimstationPanel(factory);
		panel.display();
	}

}
