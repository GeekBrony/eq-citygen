package com.geekbrony.EQCityGen;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Tools {
	
	private static boolean LOGGER_ENABLED = false;

	public Tools() {
		
	}
	
	public static void loggerEnabled(boolean b) {
		if(!b) {
			log("Logger disabled.");
			LOGGER_ENABLED = b;
		} else {
			LOGGER_ENABLED = b;
			log("Logger enabled.");
		}
		
	}
	
	public static boolean isLoggerEnabled() {
		return LOGGER_ENABLED;
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
	
	public static void print(Object o) {
		System.out.println(o);
	}
	
	public static void log(Object o) {
		if(LOGGER_ENABLED)
			System.out.println("["+currentDate()+"] " + o);
	}
	
	public static String currentDate() {
		long d = new Date().getTime();
		return DateFormat.getTimeInstance(DateFormat.MEDIUM).format(d);
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
	
	public static boolean duplicates (List<String> interests) {
		Object[] x = interests.toArray();
	    Set<Object> set = new HashSet<Object>();
	    for ( int i = 0; i < x.length; ++i ) {
	        if (set.contains(x[i])) {
	            return true;
	        }
	        else {
	            set.add(x[i]);
	        }
	    }
	    return false;
	}
	
	public static String getVersion() {
		return new Version().VERSION;
	}

	public static int changeToInt(String string) {
		try {
		    return Integer.parseInt(string);
		} catch (NumberFormatException e) {
			return -1;
		}
	}

}
