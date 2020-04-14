/*
 * Edit history:
 *   Dylan, 4/12: created AlwaysCheatStrategy
 *
*/
package PrisonersDillema;

public class AlwaysCheatStrategy extends Strategy {
    public AlwaysCheatStrategy(Prisoner owner) {
        super(owner);
    }

    @Override
    public boolean doICooperate() {
        return false;
    }
}
