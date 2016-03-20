package com.geekbrony.EQCityGen;

public class Equestria {
	
	public final static int NUM_CITIES = 10;

	public static void main(String[] args) {
		int x = 0;
		PonyCity[] c = new PonyCity[NUM_CITIES];
		while (x < NUM_CITIES) {
			PonyCity city = new PonyCity();
			c[x] = city;
			x++;
		}
		System.out.println(cityArrayToString(c));
	}
	
	public static String cityArrayToString(PonyCity[] arr) {
		String start = "{", end = "\n}";
		String p = start+"";
		int x = 0;
		while (x < arr.length) {
			p += "\n"+(x + 1)+":\n"+arr[x];
			if(x < arr.length - 1) {
				p += "\n";
			}
			x++;
		}
		return p+end;
	}

}
