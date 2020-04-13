package Simstation;

import mvc.*;


import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
//import java.util.Iterator;
import java.util.Iterator;

public class SimstationView extends View {

	public static final Integer XC = 10;
	public static final Integer YC = 10;
	public SimstationView(Model model) {
		super(model);
		setSize(Simulation.SIZE,Simulation.SIZE);
		
	}
	
	
	@Override
	public void paintComponent(Graphics gc) {
		super.paintComponent(gc);
		
		Graphics2D g2 = (Graphics2D) gc;
		Color oldColor = gc.getColor();
		
		Simulation sim = (Simulation)model;
		ArrayList<Agent> agents = sim.getAgents();
		g2.setColor(Color.RED);
		
		for(int i = 0; i < agents.size(); i++) {
			g2.fillOval(agents.get(i).getXCoordinate(), agents.get(i).getYCoordinate(), 4, 4);
			
			
		}
		
		g2.setColor(Color.BLACK);
		
		g2.setStroke(new BasicStroke(2));
		g2.draw(new Rectangle2D.Double(XC, YC, Simulation.SIZE, Simulation.SIZE));
		g2.setColor(oldColor);

}
}
