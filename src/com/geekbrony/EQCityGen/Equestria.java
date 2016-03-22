package com.geekbrony.EQCityGen;

public class Equestria {
	
	public final static int NUM_CITIES_TO_GENERATE = 10;
	public final static boolean ADVANCED_MODE = true;
	
	public static PonyCity[] c;
	
	/* THIS IS THE MAIN METHOD THAT JAVA WILL RUN */
	public static void main(String[] args) {
		onEnable();
		
		doGeneration(NUM_CITIES_TO_GENERATE, ADVANCED_MODE);
		Tools.print(Tools.cityArrayToString(c));
		
		onDisable();
	}

	private static void onEnable() {
		Tools.loggerEnabled(true);
		Tools.log("Starting EQCityGen v" + Tools.getVersion() + ".");
	}
	
	private static void onDisable() {
		Tools.log("Stopping EQCityGen v" + Tools.getVersion() + ".");
		Tools.loggerEnabled(false);
	}
	
	private static void doGeneration(int num, boolean adv) {
		int x = 0, in = 0;
		c = new PonyCity[num];
		Tools.log("Generating cities.");
		while (x < num) {
			PonyCity city = new PonyCity();
			c[x] = city;
			if(x != 0) {
				int i = 0;
				while(i < x) {
					if(c[x].name.equalsIgnoreCase(c[i].name)) {
						c[x] = new PonyCity();
						in++;
					}
					i++;
				}
			}
			x++;
		}
		if(in != 0) {
			Tools.log("Recreated "+in+" cities because of duplicate names.");
		}
		Tools.log("Generating ponies.");
		for(int n = 0; n < c.length; n++) {
			c[n].generatePonies(c[n].population);
			c[n].setAdvancedMode(adv);
		}
	}

}
