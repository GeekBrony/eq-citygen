package com.geekbrony.EQCityGen;

public class Tools {

	public Tools() {
		
	}
	
	public static int makeInt(double d) {
		return (int) Math.floor(d);
	}
	
	public static int makeInt(long d) {
		return (int) Math.floor(d);
	}
	
	public static int random(int min, int max) {
		return makeInt(Math.random() * (max - min + 1) + min);
	}
	
	public static int randomize(int rangeWithoutZero) {
		return makeInt(Math.random() * (rangeWithoutZero - 1));
	}
	
	public static int randomizeInclZero(int range) {
		return makeInt(Math.random() * (range));
	}
	
	public static String ponyArrayToString(Pony[] arr) {
		String start = "{", end = "\n  }";
		String p = start+"";
		int x = 0;
		while (x < arr.length) {
			p += "\n   Pony "+(x + 1)+": "+arr[x];
			if(x < arr.length - 1) {
				p += "";
			}
			x++;
		}
		return p+end;
	}
	
	public static String cityArrayToString(PonyCity[] arr) {
		String start = "{", end = "\n}";
		String p = start+"";
		int x = 0;
		while (x < arr.length) {
			p += "\n "+(x + 1)+" ("+arr[x].name+"): {\n  "+arr[x];
			if(x < arr.length - 1) {
				p += "\n }";
			}
			x++;
		}
		return p+end;
	}

}
