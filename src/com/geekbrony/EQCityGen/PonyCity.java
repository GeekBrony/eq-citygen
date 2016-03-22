package com.geekbrony.EQCityGen;

import java.util.ArrayList;
import java.util.List;

public class PonyCity {

	// Define acceptable city parameters.
	public final String TYPE_FOREST = "CITY_FOREST";
	public final String TYPE_VILLAGE = "CITY_VILLAGE";
	public final String TYPE_OCEAN = "CITY_OCEAN";
	public final String TYPE_ROYAL = "CITY_ROYAL";

	public final String[] CityPrefixes = { "Pony", "Canter", "Whinny", "Neigh", "Mane", "New", "Apple", "Saddle",
			"Prance", "Filly", "Clouds", "Dream", "Stallion", "Mare" };
	
	public final String[] CitySuffixes = {"ville"," Village"," Town"," City"};

	public final String[] ForestPrefixes = { "Everfree", "Leaf-a-lot", "Wooden", "Oak", "Evershade", "Hallow",
			"Starry" };

	// Define field
	public int seed;
	public String name;
	public long population;
	public PopulationType population_type;
	public String cityType;
	public Pony[] pA;
	public boolean advancedMode;

	/* --------------------------------------------------------------------------
	 * | New City with no variables defined means that it randomizes the values |
	 * --------------------------------------------------------------------------
	 */
	public PonyCity() {
		
		advancedMode = false;

		// Randomize seed and population type
		int population = Tools.randomizeInclZero(3);

		// Determine the population
		if (population == PopulationType.VACANT_CITY.numVal) {
			this.population = 0;
			this.population_type = PopulationType.VACANT_CITY;
		} else if (population == PopulationType.LOW_POPULATION.numVal) {
			this.population = Tools.random(1, 50);
			this.population_type = PopulationType.LOW_POPULATION;
		} else if (population == PopulationType.MED_POPULATION.numVal) {
			this.population = Tools.random(51, 250);
			this.population_type = PopulationType.MED_POPULATION;
		} else if (population == PopulationType.MAX_POPULATION.numVal) {
			this.population = Tools.random(251, 500);
			this.population_type = PopulationType.MAX_POPULATION;
		}

		// Determine the name
		this.cityType = determineCityType(this.population);
		String suffix = "";
		if (this.cityType == TYPE_FOREST) {
			suffix = "Forest";
			this.name = constructName(suffix, true, false);
		} else if (this.cityType == TYPE_VILLAGE) {
			suffix = this.CitySuffixes[Tools.randomizeInclZero(3)];
			this.name = constructName(suffix, false, true);
		} else if (this.cityType == TYPE_ROYAL) {
			suffix = "lot";
			this.name = constructName(suffix, false, true);
		}

	}

	public PonyCity(String name, PopulationType populationType) {

		advancedMode = false;
		
		// Determine the population
		if (populationType == PopulationType.VACANT_CITY) {
			this.population = 0;
			this.population_type = PopulationType.VACANT_CITY;
		} else if (populationType == PopulationType.LOW_POPULATION) {
			this.population = Tools.random(1, 50);
			this.population_type = PopulationType.LOW_POPULATION;
		} else if (populationType == PopulationType.MED_POPULATION) {
			this.population = Tools.random(51, 250);
			this.population_type = PopulationType.MED_POPULATION;
		} else if (populationType == PopulationType.MAX_POPULATION) {
			this.population = Tools.random(251, 500);
			this.population_type = PopulationType.MAX_POPULATION;
		}

		// Determine the name
		this.cityType = determineCityType(this.population);
		this.name = name;

	}
	
	public boolean isAdvancedMode() {
		return this.advancedMode;
	}
	
	public void setAdvancedMode(boolean b) {
		this.advancedMode = b;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void generatePonies(long population) {
		if(!(population == 0)) {
			//Tools.log("Creating "+population+" random ponies in city \""+this.name+"\".");
		}
		int x = 0, pop = Tools.makeInt(population), in = 0;
		pA = new Pony[pop]; 
		while(x < population) {
			pA[x] = new Pony();
			if(x != 0) {
				int i = 0;
				while(i < x) {
					if(pA[x].name.equalsIgnoreCase(pA[i].name)) {
						pA[x] = new Pony();
						in++;
					}
					i++;
				}
			}
			x++;
		}
		if(in != 0) {
			Tools.log("Recreated "+in+" ponies because of duplicate names.");
		}
	}

	public String determineCityType(long population) {
		if (population <= 500 && population > 10) {
			if (Tools.randomize(4) < 1) {
				return TYPE_ROYAL;
			} else {
				return TYPE_VILLAGE;
			}
		} else {
			return TYPE_FOREST;
		}
	}

	public String stringifyPopulationType(PopulationType pop) {
		int n = pop.getNumVal();
		if (n == PopulationType.VACANT_CITY.numVal) {
			return "Vacant";
		} else if (n == PopulationType.LOW_POPULATION.numVal) {
			return "Low Population";
		} else if (n == PopulationType.MED_POPULATION.numVal) {
			return "Medium Population";
		} else {
			return "Low Population";
		}
	}

	public String constructName(String suffix, boolean shouldUseSpaces, boolean isNormalCity) {
		if (isNormalCity) {
			if (shouldUseSpaces) {
				return CityPrefixes[(int) (Math.random() * CityPrefixes.length)] + " " + suffix;
			} else {
				return CityPrefixes[(int) (Math.random() * CityPrefixes.length)] + suffix;
			}
		} else {
			return ForestPrefixes[(int) (Math.random() * ForestPrefixes.length)] + " " + suffix;
		}
	}

	public String toString() {
		List<String> st = new ArrayList<String>();
		st.add("Population: " + this.population);
		st.add("Type: " + this.cityType);
		if(isAdvancedMode()) {
			st.add("Population Type: \"" + stringifyPopulationType(population_type)+"\"");
			if(!(this.population == 0)) {
				st.add("Ponies: " + Tools.ponyArrayToString(pA));
			}
		}
		String p = String.join(";\n  ", st);
		return p;
	}

	public enum PopulationType {
		VACANT_CITY(0), LOW_POPULATION(1), MED_POPULATION(2), MAX_POPULATION(3);

		private int numVal;

		PopulationType(int numVal) {
			this.numVal = numVal;
		}

		public int getNumVal() {
			return numVal;
		}
	}

}
