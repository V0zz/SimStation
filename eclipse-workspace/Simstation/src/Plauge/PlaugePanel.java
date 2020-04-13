package Plauge;

import Simstation.*;
import mvc.AppFactory;

public class PlaugePanel extends SimstationPanel{

	public PlaugePanel(AppFactory factory) {
		super(factory);
		
	}
	
	public static void main (String[] args) {
		PlaugeFactory factory = new PlaugeFactory();
		SimstationPanel panel = new SimstationPanel(factory);
		panel.display();
	}

}
