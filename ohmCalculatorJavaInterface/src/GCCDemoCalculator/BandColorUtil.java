package GCCDemoCalculator;

public class BandColorUtil {
	static int getBandColorValue(String color) {
		int value;
		switch(color.toLowerCase()){
			case "black" : value = 0;
			break;
			case "brown" : value = 1;
			break;
			case "red" : value = 2;
			break;
			case "orange" : value = 3;
			break;
			case "yellow" : value = 4;
			break;
			case "green" : value = 5;
			break;
			case "blue" : value = 6;
			break;
			case "violet" : value = 7;
			break;
			case "gray" : value = 8;
			break;
			case "white" : value = 9;
			break;
			default: value = -1;
            break;
		}
		return value;
	}
	
	static long getBandMultiplier(String color) {
		long value;
		switch(color.toLowerCase()){
			case "black" : value = 1;
			break;
			case "brown" : value = 10;
			break;
			case "red" : value = 100;
			break;
			case "orange" : value = 1000;
			break;
			case "yellow" : value = 10000;
			break;
			case "green" : value = 100000;
			break;
			case "blue" : value = 1000000;
			break;
			case "violet" : value = 10000000;
			break;
			case "gray" : value = 100000000;
			break;
			case "white" : value = 1000000000L;
			break;
			default: value = -1;
            break;
		}
		return value;
	}
	
	static String getBandTolerance(String color) {
		String value;
		switch(color.toLowerCase()){
			case "brown" : value = "1%";
			break;
			case "red" : value = "2%";
			break;
			case "green" : value = ".5%";
			break;
			case "blue" : value = ".25%";
			break;
			case "violet" : value = ".1%";
			break;
			case "gray" : value = ".05%";
			break;
			case "gold" : value = "5%";
			break;
			case "silver" : value = "10%";
			break;
			default: value = null;
            break;
		}
		return value;
	}

	static String formatNumber(long value) {
		if(value < 1000) {
			return Long.toString(value);
		}
		else if(value >= 1000 && value < 1000000) {
			return (double)value/1000 + "K";
		}
		else if(value >= 1000000 && value < 1000000000) {
			return (double)value/1000000 + "M";
		}
		else {
			return (double)value/1000000000 + "G";
		}
		
	}
}
