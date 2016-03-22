package com.geekbrony.EQCityGen;

public class Equestria {
	
	public final static int NUM_CITIES_TO_GENERATE = 10;
	
	/* THIS IS THE MAIN METHOD THAT JAVA WILL RUN */
	public static void main(String[] args) {
		int x = 0;
		PonyCity[] c = new PonyCity[NUM_CITIES_TO_GENERATE];
		while (x < NUM_CITIES_TO_GENERATE) {
			PonyCity city = new PonyCity();
			city.setAdvancedMode(false);
			c[x] = city;
			x++;
		}
		Tools.print("Equestria: " + Tools.cityArrayToString(c));
		// In theory, this will print the cities AND the ponies in them :D
	}

}
