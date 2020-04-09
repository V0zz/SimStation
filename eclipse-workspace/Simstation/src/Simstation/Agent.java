package Simstation;


public abstract class Agent {
	private String name;		//name of the agent
	private Heading heading;	//Agent heading
	private AgentState state;	//state
	private int xc; 	//x coordinate
	private int yc;		//y coordinate
	
	public void run() {
		
	}
	public void start() {
		
	}
	public void suspend() {
		
	}
	public void resume() {
		
	}
	public void stop() {
		
	}
	public abstract void update();
	
	public void move(int steps) {
		if(heading == Heading.NORTH) {
			yc = yc - steps;
		}
		else if(heading == Heading.SOUTH) {
			yc = yc + steps;
		}
		else if(heading == Heading.EAST) {
			xc = xc + steps;
		}
		else {	//West
			xc = xc - steps;
		}
	}
}
