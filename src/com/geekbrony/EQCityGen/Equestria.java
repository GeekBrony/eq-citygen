package com.geekbrony.EQCityGen;

import java.util.Scanner;

public class Equestria {
	
	public final static int NUM_CITIES_TO_GENERATE = 10;
	public final static boolean ADVANCED_MODE = false;
	
	private static boolean continuePrompting = true;
	
	private final static String[] commands = {"quit", "exit", "list", "go", "select"};
	
	public static PonyCity[] c;
	
	private static int selectedCity = -1;
	
	/* THIS IS THE MAIN METHOD THAT JAVA WILL RUN */
	public static void main(String[] args) {
		onEnable();
		
		doGeneration(NUM_CITIES_TO_GENERATE, ADVANCED_MODE);
		
		Scanner scan = new Scanner(System.in);
		String sc = "";
		
		while(continuePrompting) {
			System.out.print("> ");
			sc = scan.nextLine();
			String arg[] = sc.split(" ");
			for(int nx = 0; nx < commands.length; nx++) {
				if(arg[0].equalsIgnoreCase(commands[nx])) {
					commandAction(sc, arg);
				}
			}
		}
		scan.close();
		
		onDisable();
	}
	
	private static void commandAction(String sc, String[] arg) {
		String aa = sc.replace(" ", "");
		if(arg[0].equalsIgnoreCase("quit") || arg[0].equalsIgnoreCase("exit")) {
			continuePrompting = !continuePrompting;
			// Exit
		} else if(arg[0].equalsIgnoreCase("list")) {
			if(aa.equalsIgnoreCase("list")) {
				Tools.print("Usage: list [cities / ponies {only in city}]");
			} else if(arg[1].equalsIgnoreCase("cities")) {
				Tools.print(Tools.cityArrayToString(c));
			} else if(arg[1].equalsIgnoreCase("ponies")) {
				if(selectedCity == -1) {
					Tools.print("You can't possibly list anypony without selecting a city!");
				} else {
					int g = 0;
					while (g < c.length) {
						if (c[g].id == selectedCity) {
							Tools.print("  " + Tools.ponyArrayToString(c[g].pA));
						}
						g++;
					}
				}
			}
		} else if(arg[0].equalsIgnoreCase("select")) {
			if(aa.equalsIgnoreCase("select")) {
				Tools.print("Usage: select city [ID]");
			} else if(arg[1].equalsIgnoreCase("city")) {
				selectedCity = Tools.changeToInt(arg[2]);
				if(selectedCity == -1) {
					Tools.print("No city with provided ID. (Are you using words instead of a number?)");
				} else {
					Tools.print("Selected city with id "+selectedCity+".");
				}
				
			}
			
		}
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
		Tools.log("Generating ponies.");
		int pR = 0;
		for(int n = 0; n < c.length; n++) {
			c[n].generatePonies(c[n].population);
			c[n].setAdvancedMode(adv);
			if(c[n].poniesRegenerated != 0) {
				pR = pR + c[n].poniesRegenerated;
			}
		}
		if(in != 0 || pR != 0) {
			String cT = " cities";
			String pN = " ponies";
			if(in == 1) {
				cT = " city";
			}
			if(pR == 1) {
				pN = " pony";
			}
			Tools.log("Recreated "+in+cT+" and "+pR+pN+" because of duplicate names.");
		}

	}

}
