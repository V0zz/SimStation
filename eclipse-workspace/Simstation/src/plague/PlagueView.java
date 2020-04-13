package plague;

import java.awt.Color;
import java.awt.Graphics2D;

import Simstation.Simulation;

public class PlagueView extends SimulationView{
	public static final Integer X_BORDER_CORNER = 10;
	public static final Integer Y_BORDER_CORNER = 10;
	
	public PlagueView(Model model) {
		super(model);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setColor(Color.BLACK);
		g2.draw(new Rectangle2D.Double(X_BORDER_CORNER, Y_BORDER_CORNER, Simulation.WORLD_SIZE, Simulation.WORLD_SIZE));
		g2.setColor(Color.RED);
		
		PlagueSim sim = (PlagueSim) model;
		ArrayList<Agent> agentList = sim.getAgents();
		
		for(Agent a : agentList) {
			Plague p = (Plague)a;
			if(p.getInfectedStatus()) {
				g2.setColor(Color.RED);
				g2.fillOval(p.getX(), p.getY(), Plague.AGENT_SIZE, Plague.AGENT_SIZE){
					
				}
			}
		}
	}
}
