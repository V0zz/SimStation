/*
 * Edit history:
 *   Dylan, 4/12: created PrisonerFactory
 *
*/
package PrisonersDilemma;

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
