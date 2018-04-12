package GCCDemoCalculator;

public class IOhmValueCalculator implements IOhmValueCalculatorInterFace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	System.out.println(new IOhmValueCalculator().CalculateOhmValue("orange", "wHITE", "wHITE", "green"));	
		
	}

	@Override
	public String CalculateOhmValue(String bandAColor, String bandBColor, String bandCColor, String bandDColor) {
		// TODO Auto-generated method stub
		int aVal = BandColorUtil.getBandColorValue(bandAColor);
		int bVal = BandColorUtil.getBandColorValue(bandBColor);
		long Multiplier = BandColorUtil.getBandMultiplier(bandCColor);
		String tolerance = BandColorUtil.getBandTolerance(bandDColor);
		
		Long ohmValue = (aVal * 10 + bVal) * Multiplier;

		return BandColorUtil.formatNumber(ohmValue).toString() + " Ohms " + tolerance;
		
	}

}
