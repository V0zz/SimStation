package PrisonersDillema;

import Simstation.Agent;
import Simstation.Simulation;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrisonerSim extends Simulation {
    public static final int STRATEGY_POP_SIZE = 10;
    private List<String> strategyClasses;

    public PrisonerSim(String name) {
        super(name);
        strategyClasses = new ArrayList<>();
        strategyClasses.add("AlwaysCooperateStrategy");
        strategyClasses.add("AlwaysCheatStrategy");
        strategyClasses.add("CopyLastStrategy");
        strategyClasses.add("RandomlyCooperateStrategy");
    }

    public void populate() {
       for (int i = 0; i < STRATEGY_POP_SIZE; i++) {
            Prisoner alwaysCooperate = new Prisoner(this);
            alwaysCooperate.setStrategy(new AlwaysCooperateStrategy(alwaysCooperate));
            agents.add(alwaysCooperate);

            Prisoner alwaysCheat = new Prisoner(this);
            alwaysCheat.setStrategy(new AlwaysCheatStrategy(alwaysCheat));
            agents.add(alwaysCheat);

            Prisoner copyLast = new Prisoner(this);
            copyLast.setStrategy(new CopyLastStrategy(copyLast));
            agents.add(copyLast);

            Prisoner randomlyCooperate = new Prisoner(this);
            randomlyCooperate.setStrategy((new RandomlyCooperateStrategy(randomlyCooperate)));
            agents.add(randomlyCooperate);
        }
    }

    @Override
    public String[] getStats() {
        Map<String, Integer> strategyClassesAndTotalFitness = new HashMap<>();
        for(String s : strategyClasses) {
            strategyClassesAndTotalFitness.put(s, 0);
        }
        for(Agent a : agents) {
            Prisoner p = (Prisoner)a;
            String strategyName = p.strategy.getClass().getSimpleName();
            strategyClassesAndTotalFitness.computeIfPresent(strategyName, (key, val) -> val + p.getFitness());
        }
        String[] stats = new String[6];
        stats[0] = "# agents = " + agents.size();
        stats[1] = "clock = " + clock;
        stats[2] = "cooperators avg = " + strategyClassesAndTotalFitness.get("AlwaysCooperateStrategy") / 10;
        stats[3] = "cheater's avg = " + strategyClassesAndTotalFitness.get("AlwaysCheatStrategy") / 10;
        stats[4] = "copier's avg = " + strategyClassesAndTotalFitness.get("CopyLastStrategy") / 10;
        stats[5] = "random's avg = " + strategyClassesAndTotalFitness.get("RandomlyCooperateStrategy") / 10;
        return stats;
    }
}

