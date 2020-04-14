/*
 * Edit history:
 *   Arlan, 4/10: created PlaguePanel
 *
*/
package Plague;

import Simstation.*;
import mvc.AppFactory;

public class PlaguePanel extends SimstationPanel{

	public PlaguePanel(AppFactory factory) {
		super(factory);
		
	}
	
	public static void main (String[] args) {
		PlagueFactory factory = new PlagueFactory();
		SimstationPanel panel = new SimstationPanel(factory);
		panel.display();
	}

}
