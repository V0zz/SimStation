package Simstation;

import mvc.*;
import javax.swing.*;
import java.awt.*;

public class SimstationPanel extends AppPanel {

	
	public SimstationPanel(AppFactory factory) {
		super(factory);
		this.setLayout(new GridLayout(1, 2));
		
		JPanel buttons = new JPanel();
		buttons.setLayout(new GridLayout(5, 1));
		
		Panel p = new Panel();
		JButton b = new JButton("Start");
		b.addActionListener(this);
		p.add(b);
		buttons.add(p);
		
		p = new Panel();
		b = new JButton("Suspend");
		b.addActionListener(this);
		p.add(b);
		buttons.add(p);
		
		p = new Panel();
		b = new JButton("Resume");
		b.addActionListener(this);
		p.add(b);
		buttons.add(p);
		
		p = new Panel();
		b = new JButton("Stop");
		p.setLayout(new FlowLayout());
		b.addActionListener(this);
		p.add(b);
		buttons.add(p);
		
		p = new Panel();
		b = new JButton("Stats");
		p.setLayout(new FlowLayout());
		b.addActionListener(this);
		p.add(b);
		buttons.add(p);
		
		JPanel westPanel = new JPanel();
		westPanel.setLayout(new BorderLayout());
		westPanel.add(buttons, "North");
		this.add(westPanel, "West");
		SimstationView view = new SimstationView((Simulation)model);
		addView(view);
		this.add(view, "East");
		
	}
	
	
	/*
	 * public static void main(String[] args) { AppPanel panel = new
	 * SimstationPanel(new SimstationFactory()); panel.display(); }
	 */
	 
	
}
