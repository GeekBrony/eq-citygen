package com.geekbrony.EQCityGen;

import java.util.Arrays;
import java.util.List;

public class PonyCity {

	// Define acceptable city parameters.
	public final String TYPE_FOREST = "forest";
	public final String TYPE_VILLAGE = "village";
	public final String TYPE_OCEAN = "ocean";
	public final String TYPE_ROYAL = "royal";

	public final String[] CityPrefixes = { "Pony", "Canter", "Whinny", "Neigh", "Mane", "New", "Apple", "Saddle",
			"Prance", "Filly" };

	public final String[] ForestPrefixes = { "Everfree", "Leaf-a-lot", "Wooden", "Oak", "Evershade" };

	// Define field
	public int seed;
	public String name;
	public long population;
	public PopulationType population_type;
	public String cityType;

	/*
	 * -------------------------------------------------------------------------
	 * - | New City with no variables defined means that it randomizes the
	 * values |
	 * -------------------------------------------------------------------------
	 * -
	 */
	public PonyCity() {

		// Randomize seed and population type
		int population = (int) (Math.random() * 3);

		// Determine the population
		if (population == PopulationType.VACANT_CITY.numVal) {
			this.population = 0;
			this.population_type = PopulationType.VACANT_CITY;
		} else if (population == PopulationType.LOW_POPULATION.numVal) {
			this.population = (int) (Math.random() * (50 - 1 + 1) + 1);
			this.population_type = PopulationType.LOW_POPULATION;
		} else if (population == PopulationType.MED_POPULATION.numVal) {
			this.population = (int) (Math.random() * (250 - 51 + 1) + 51);
			this.population_type = PopulationType.MED_POPULATION;
		} else if (population == PopulationType.MAX_POPULATION.numVal) {
			this.population = (int) (Math.random() * (500 - 251 + 1) + 251);
			this.population_type = PopulationType.MAX_POPULATION;
		}

		// Determine the name
		this.cityType = determineCityType(this.population);
		String suffix = "";
		if (this.cityType == TYPE_FOREST) {
			suffix = "Forest";
			this.name = constructName(suffix, true, false);
		} else if (this.cityType == TYPE_VILLAGE) {
			suffix = "ville";
			this.name = constructName(suffix, false, true);
		} else if (this.cityType == TYPE_ROYAL) {
			suffix = "lot";
			this.name = constructName(suffix, false, true);
		}

	}

	public PonyCity(String name, PopulationType populationType) {

		// Determine the population
		if (populationType == PopulationType.VACANT_CITY) {
			this.population = 0;
			this.population_type = PopulationType.VACANT_CITY;
		} else if (populationType == PopulationType.LOW_POPULATION) {
			this.population = random(1, 50);
			this.population_type = PopulationType.LOW_POPULATION;
		} else if (populationType == PopulationType.MED_POPULATION) {
			this.population = random(51, 250);
			this.population_type = PopulationType.MED_POPULATION;
		} else if (populationType == PopulationType.MAX_POPULATION) {
			this.population = random(251, 500);
			this.population_type = PopulationType.MAX_POPULATION;
		}

		// Determine the name
		this.cityType = determineCityType(this.population);
		this.name = name;

	}

	public String determineCityType(long population) {
		if (population <= 500 && population > 10) {
			if ((Math.random() * 5) < 1) {
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
		List<String> st = Arrays.asList(
			"Name: " + this.name,
			"Population: " + this.population,
			"Population Type: " + stringifyPopulationType(population_type),
			"Type: " + this.cityType
		);

		String p = String.join("\n", st);
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
	
	public int random(int min, int max) {
		return (int) (Math.random() * (max - min + 1) + min);
	}

}