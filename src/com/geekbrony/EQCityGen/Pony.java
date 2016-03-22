package com.geekbrony.EQCityGen;

import java.util.ArrayList;
import java.util.List;

public class Pony {
	
	public final String[] ponyNames = {
		"Pinkie Pie","Twilight Sparkle","Fluttershy","Rarity","Rainbow Dash","Applejack",
		"Sunset Shimmer","Starlight Glimmer","Derpy Hooves","Doctor Whooves","Scootaloo",
		"Apple Bloom","Sweetie Belle","Shining Armor","Bon Bon","Lyra Heartstrings",
		"Cheerilee","Tree Hugger","Big Macintosh","Maud Pie","Marble Pie","Cheese Slice",
		"Fluffy Glow","Sapphire Shadow","Amethyst Eyes","Obsidia","Dancing Star"
	};
	
	/* THE NAMES BELOW WERE GENERATED WITH
	 * :"THE PONY NAME GENERATOR" OVER AT:
	 *  http://pony.namegeneratorfun.com/ 
	 * ...there will be more added soon...
	 */
	
	public final String[] namePrefixes = {
		"Vanilla","Cuddle","Ember","Royal","Lily","Cloudy","Harvest","Firefly","Rosemary",
		"Velvet","Berry","Daisy","Serenity","Midnight","Meadow","Paradise","Aura","Magic",
		"Golden","Dainty","Happy","Apple","Monsoon","Perfect","Diamond","Silver","Ginger",
		"Lavender","Summer","Sweet","Lightning","Shadow","Winter","Cheery","Fizzy","Emerald",
		"Flurry","Cheese","Thunder","Frozen","Sapphire",""
	};
	
	public final String[] nameSuffixes = {
		"Sparkle","Shine","Rose","Stripes","Sunbeam","Blossom","Solstice","Cake","Eclipse",
		"Twinkle","Rain","Cookie","Flower","Dreams","Music","Flutter","Paradise","Crush",
		"Cinnamon","Melody","Scratch","Comet","Belle","Wishes","Muffin","Hooves","Snow",
		"Crown","Lollipop","Tiara","Spoon","Snap","Hazel","Dreamer","Lotus","Shimmer","Chaser",
		"Dash","Star","Hugger","Heart","Colt","Rock","Flash","Haze","Prize","Moon","Mane",
		"Light","Style","Pie","Harmony","Eyes"
	};
	
	public final String[] intCreative = {
		"Artist","Writer","Musician","Singer","Photographer","Scientist","Baker"
	};
	
	public final String[] intPhysical = {
		"Athlete","Farmer","Apple Bucking"
	};
	
	public final String[][] intList = {
		intCreative, intPhysical
	};
	
	// End name definitions, begin variables
	
	public String name;
	public List<String> interests = new ArrayList<String>();;

	public Pony() {
		
		int r = Tools.randomizeInclZero(3);
		String prefix = namePrefixes[Tools.randomize(namePrefixes.length-1)];
		String suffix = nameSuffixes[Tools.randomize(nameSuffixes.length-1)];
		
		if(r == 0) {
			//Pick random name from ponyNames[]
			this.name = ponyNames[Tools.randomize(ponyNames.length-1)];
		} else {
			this.name = prefix + " " + suffix;
		}
		
		generateInterests(Tools.randomizeInclZero(32768 / 4));
		
	}
	
	public void generateInterests(int seed) {
		int x = 0;
		while(x < 2) {
			int ra = Tools.randomizeInclZero(intList.length);
			interests.add(intList[ra][Tools.randomizeInclZero(intList[ra].length)]);
			
			x++;
		}
	}

	public String toString() {
		return "{\n"+"    Name: "+this.name+"\n    Interests: "+String.join(", ", interests)+"\n   }";
	}

}
