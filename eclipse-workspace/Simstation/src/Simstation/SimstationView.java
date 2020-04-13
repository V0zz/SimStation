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
		setSize(Simulation.SIZE,Simulation.SIZE);
		
	}
	public void paintComponent(Graphics gc) {		//only plague overwrites
		Simulation sim = (Simulation)model;
		Color oldColor = gc.getColor();
		
		Graphics2D g2 = (Graphics2D)gc;
		Color strokeColor = Color.BLACK;
		g2.setStroke(new BasicStroke(LINE_THICKNESS));
		g2.drawRect(BOX_X_CORNER, BOX_Y_CORNER, Simulation.WORLD_SIZE, Simulation.WORLD_SIZE);
		
		gc.setColor(oldColor);
	}
}
