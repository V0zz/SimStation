/*
* Edit History:
* Veida, 4/1: created Heading, randomHeading
*/
package Simstation;

import mvc.Utilities;

public enum Heading {
	NORTH, EAST, SOUTH, WEST;
	
	public static Heading randomHeading() {
		Heading[] h = {NORTH,EAST,SOUTH,WEST};
		int random = Utilities.rng.nextInt(3);
		return h[random];
	}
}
