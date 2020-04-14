package PrisonersDillema;

import Simstation.SimstationFactory;
import mvc.Model;

public class PrisonerFactory extends SimstationFactory {
    public PrisonerFactory() {
        super();
    }

    @Override
    public Model makeModel() {
        return new PrisonerSim("Prisoner Simulation");
    }
}
