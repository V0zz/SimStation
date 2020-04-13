package Simstation;

import mvc.*;

/* public class SimstationFactory implements SimFactory { */
public class SimstationFactory implements SimFactory {
	
	@Override
	public Model makeModel() 
	{ 
		return new Simulation("test");
	}

	@Override
	public String[] getEditCommands() 
	{ 
		return new String[] {"Start", "Suspend", "Resume", "Stop", "Stats"};
	}

	@Override
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
	
	@Override
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

	@Override
	public String about()
	{
		return "SimStation version 1.0. Copyright 2020 by Cyberdellic Designs";
	}



	@Override
	public View getView(Model model) {
		// TODO Auto-generated method stub
		return new SimstationView(model);
	}
}
