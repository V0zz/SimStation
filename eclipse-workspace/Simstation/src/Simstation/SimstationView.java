package Simstation;

import mvc.*;

import java.awt.*;
//import java.util.Iterator;

public class SimstationView extends View {

	public SimstationView(Model model) {
		super(model);
		
	}
	public void paintComponent(Graphics gc) {
		Simulation sim = (Simulation)model;
		Color oldColor = gc.getColor();
		//gc.fillOval(12,  12, 15, 15);
		//Iterator<sim.Point> it = sim.iterator();
		//while(it.hasNext()) {
			//sim.Point point = it.next();
			//gc.setColor(point.color);
			//gc.fillOval(point.x,  point.y, 5, 5);
		//}
		
		gc.setColor(oldColor);
	}
}
