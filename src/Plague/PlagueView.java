/*
 * Edit history:
 *   Arlan, 4/10: created Plague
 *   Dylan, 4/11: fixed a paintComponent bug
*/
package Plague;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import Simstation.Agent;
import Simstation.Simulation;
import mvc.*;

public class PlagueView extends View {

	public static final Integer xc = 10;
	public static final Integer yc = 10;
	public static final Integer SIZE = 300;
	public static int BOX_X_CORNER = 5;
	public static int BOX_Y_CORNER = 5;
	public static int LINE_THICKNESS = 3;
	
	public PlagueView(Model model) {
		super(model);
		setSize(Simulation.WORLD_SIZE,Simulation.WORLD_SIZE);
	}
	
	public void paintComponent(Graphics gc) {
		super.paintComponent(gc);
		Graphics2D g2 = (Graphics2D) gc;
		Color oldColor = gc.getColor();

		PlagueSim sim = (PlagueSim) model;
		ArrayList<Agent> agents = sim.getAgents();
		
		for (Agent a: agents) {
			Plague p = (Plague)a;
			if(p.isInfected()) {
				g2.setColor(Color.RED);
			}
			else {
				g2.setColor(Color.GREEN);
			}
			g2.fillOval(p.getX(), p.getY(), 4, 4);

		}
		g2.setColor(Color.BLACK);
		g2.setStroke(new BasicStroke(2));
		g2.draw(new Rectangle2D.Double(BOX_X_CORNER, BOX_Y_CORNER, Simulation.WORLD_SIZE, Simulation.WORLD_SIZE));
		g2.setColor(oldColor);
	}
}
