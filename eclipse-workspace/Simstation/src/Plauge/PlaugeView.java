package Plauge;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import Simstation.Agent;
import mvc.*;

public class PlaugeView extends View {

	public static final Integer xc = 10;
	public static final Integer yc = 10;
	public static final Integer SIZE = 300;
	
	public PlaugeView(Model model)
	{
		super(model);
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		Color oldColor = g2.getColor();
		g2.draw(new Rectangle2D.Double(xc, yc, SIZE,SIZE));
		g2.setColor(Color.RED);
		
		PlaugeSim sim = (PlaugeSim) model;
		ArrayList<Agent> agents = sim.getAgents();
		
		for (Agent a: agents) {
			Plauge p = (Plauge)a;
			
			if(p.isInfected()) {
				g2.setColor(Color.RED);
				g2.fillOval(p.getXCoordinate(), p.getXCoordinate(), 4, 4);
			}
			else {
				g2.setColor(Color.GREEN);
				g2.fillOval(p.getXCoordinate(), p.getXCoordinate(), 4, 4);
			}
			
		}
		
		g2.setColor(oldColor);
	}
}
