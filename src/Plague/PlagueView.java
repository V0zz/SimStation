package Plague;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import Simstation.Agent;
import mvc.*;

public class PlagueView extends View {

	public static final Integer xc = 10;
	public static final Integer yc = 10;
	public static final Integer SIZE = 300;
	
	public PlagueView(Model model)
	{
		super(model);
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		Color oldColor = g2.getColor();
		g2.draw(new Rectangle2D.Double(xc, yc, SIZE,SIZE));
		g2.setColor(Color.RED);
		
		PlagueSim sim = (PlagueSim) model;
		ArrayList<Agent> agents = sim.getAgents();
		
		for (Agent a: agents) {
			Plague p = (Plague)a;
			
			if(p.isInfected()) {
				g2.setColor(Color.RED);
				g2.fillOval(p.getX(), p.getX(), 4, 4);
			}
			else {
				g2.setColor(Color.GREEN);
				g2.fillOval(p.getX(), p.getX(), 4, 4);
			}
			
		}
		
		g2.setColor(oldColor);
	}
}
