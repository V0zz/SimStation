/*
 * Edit history:
 *   Dylan, 4/12: created AlwaysCooperateStrategy
 *
*/
package PrisonersDilemma;

public class AlwaysCooperateStrategy extends Strategy {

    public AlwaysCooperateStrategy(Prisoner owner) {
        super(owner);
    }


    @Override
    public boolean doICooperate() {
        return true;
    }
}
