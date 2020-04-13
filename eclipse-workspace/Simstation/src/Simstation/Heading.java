package Simstation;

import java.util.Random;

public enum Heading {
	NORTH, EAST, SOUTH, WEST;

	public static Heading random() {
		Heading[] h = {NORTH,EAST, SOUTH, WEST};
		Random random = new Random(); // creating Random object
		return h[random.nextInt(3)];
		
			
		
	}
}
