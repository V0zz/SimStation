package PrisonersDillema;

import Simstation.SimFactory;
import Simstation.SimstationPanel;

public class PrisonerPanel extends SimstationPanel {
    private static final long serialVersionUID = 1L;

    public PrisonerPanel(SimFactory factory)
    {
        super (factory);
    }

    public static void main(String[] args) {
        SimFactory factory = new PrisonerFactory();
        SimstationPanel panel = new SimstationPanel(factory);
        panel.display();
    }

}
