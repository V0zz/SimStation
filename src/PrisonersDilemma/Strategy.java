/*
 * Edit history:
 *   Dylan, 4/12: created Strategy
 *
*/
package PrisonersDilemma;

public abstract class Strategy {
    protected Prisoner owner;
    public Strategy(Prisoner owner) {
        this.owner = owner;
    }
    public abstract boolean doICooperate();
}
