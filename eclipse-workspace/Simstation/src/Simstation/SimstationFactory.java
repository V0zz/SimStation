package Simstation;

import mvc.*;

public class SimstationFactory implements AppFactory {
	public Model makeModel() 
	{ 
		return new Simulation("test");
	}

	public String[] getEditCommands() 
	{ 
		return new String[] {"Start", "Suspend", "Resume", "Stop", "Stats"};
	}

	public Command makeEditCommand(Model model, String type)
	{
		if (type.equals("Start"))
			return new StartCommand(model);
		else if (type.equals("Suspend"))
			return new SuspendCommand(model);
		else if (type.equals("Resume"))
			return new ResumeCommand(model);
		else if (type.equals("Stop"))
			return new StopCommand(model);
		else if (type.equals("Stats"))
			return new StatsCommand(model);
		
		return null;
	}

	public String getTitle() 
	{ 
		return "SimStation"; 
	}

	public String[] getHelp() 
	{
		String[] cmmds = new String[5];
		cmmds[0] = "Start";
		cmmds[1] = "Suspend";
		cmmds[2] = "Resume";
		cmmds[3] = "Stop";
		cmmds[4] = "Stats";
		return cmmds;	}

	public String about()
	{
		return "SimStation version 1.0. Copyright 2020 by Cyberdellic Designs";
	}
}
