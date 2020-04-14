/*
 * Edit history:
 *   Veida, 4/1: created SimstationView
 *   Dylan, 4/3: minor changes to PaintComponent
 *   Dylan, 4/8: minor changes to PaintComponent
 *
*/
package Simstation;

import mvc.*;


import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Iterator;

public class SimstationView extends View {
	public static int BOX_X_CORNER = 5;
	public static int BOX_Y_CORNER = 5;
	public static int LINE_THICKNESS = 3;
	public SimstationView(Model model) {
		super(model);
		setSize(Simulation.WORLD_SIZE,Simulation.WORLD_SIZE);
		
	}
	public void paintComponent(Graphics gc) {
		super.paintComponent(gc);

		Graphics2D g2 = (Graphics2D) gc;
		Color oldColor = gc.getColor();

		Simulation sim = (Simulation)model;
		ArrayList<Agent> agents = sim.getAgents();
		g2.setColor(Color.RED);

		for (Agent a : agents) {
			g2.fillRect(a.getX(), a.getY(), Agent.AGENT_SIZE, Agent.AGENT_SIZE);
		}

		g2.setColor(Color.BLACK);

		g2.setStroke(new BasicStroke(2));
		g2.draw(new Rectangle2D.Double(BOX_X_CORNER, BOX_Y_CORNER, Simulation.WORLD_SIZE + Agent.AGENT_SIZE, Simulation.WORLD_SIZE + Agent.AGENT_SIZE));
		g2.setColor(oldColor);
	}
}
