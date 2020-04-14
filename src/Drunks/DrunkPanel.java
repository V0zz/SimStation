/*
 * Edit history:
 *   Veida, 4/8: created DrunkPanel
 *
*/
package Drunks;

import Simstation.*;

public class DrunkPanel extends SimstationPanel {
	private static final long serialVersionUID = 1L;

	public DrunkPanel(SimFactory factory)
	{
		super (factory);
	}
	
	public static void main(String[] args) {
		SimFactory factory = new DrunkFactory();
		SimstationPanel panel = new SimstationPanel(factory);
		panel.display();
		
	}



}
