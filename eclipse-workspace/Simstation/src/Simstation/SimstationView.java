package Simstation;

import mvc.*;

import java.awt.*;
//import java.util.Iterator;

public class SimstationView extends View {

	public SimstationView(Model model) {
		super(model);
		
	}
	public void paintComponent(Graphics gc) {		//only plague overwrites
		Simulation sim = (Simulation)model;
		Color oldColor = gc.getColor();

		
		gc.setColor(oldColor);
	}
}
