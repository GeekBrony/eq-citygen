package com.geekbrony.EQCityGen;

public class Pony {
	
	public final String[] ponyNames = {
		"Pinkie Pie","Twilight Sparkle","Fluttershy","Rarity","Rainbow Dash","Applejack",
		"Sunset Shimmer","Starlight Glimmer","Derpy Hooves","Doctor Whooves","Scootaloo",
		"Apple Bloom","Sweetie Belle","Shining Armor","Carrot Top","Bon Bon","Lyra Heartstrings",
		"Cheerilee","Tree Hugger","Big Macintosh","Maud Pie","Marble Pie"
	};
	
	/* THE NAMES BELOW WERE GENERATED WITH
	 * "THE PONY NAME GENERATOR" OVER AT:
	 * http://pony.namegeneratorfun.com/
	 * ...there will be more added soon...
	 */
	
	public final String[] namePrefixes = {
		"Vanilla","Cuddle","Ember","Royal","Lily","Cloudy","Harvest","Firefly","Rosemary",
		"Velvet","Berry","Daisy","Serenity","Midnight","Meadow","Paradise","Aura","Magic",
		"Golden","Dainty","Happy","Apple","Monsoon","Perfect","Diamond","Silver","Ginger",
		"Lavender","Summer","Sweet","Lightning","Shadow","Winter","Cheery","Fizzy","Emerald"
	};
	
	public final String[] nameSuffixes = {
		"Sparkle","Shine","Rose","Stripes","Sunbeam","Blossom","Solstice","Cake","Eclipse",
		"Twinkle","Rain","Cookie","Flower","Dreams","Music","Flutter","Paradise","Crush",
		"Cinnamon","Melody","Scratch","Comet","Belle","Wishes","Muffin","Hooves","Snow",
		"Crown","Lollipop","Tiara","Spoon","Snap","Hazel","Dreamer","Lotus","Shimmer"
	};
	
	// End name definitions, begin variables
	
	public String name;

	public Pony() {
		
		int r = Tools.randomizeInclZero(3);
		
		if(r == 0) {
			//Pick random name from ponyNames[]
			this.name = ponyNames[Tools.randomizeInclZero(ponyNames.length)];
		} else {
			String prefix = namePrefixes[Tools.randomizeInclZero(namePrefixes.length)];
			String suffix = nameSuffixes[Tools.randomizeInclZero(nameSuffixes.length)];
			this.name = prefix + " " + suffix;
		}
		
	}
	
	public String toString() {
		return "Pony Name: " + this.name;
	}

}
