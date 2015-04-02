package Population.Features;

public class DoubleData extends FeatureData {

	double maxValue;
	double minValue;
  	public double value;
	
	public DoubleData(double min, double max) {
		maxValue = max;
		minValue = min;
	}
	
	@Override
	public void init() {
		value = minValue+((maxValue-minValue)*Feature.r.nextDouble());
	}
	
	@Override
	public String toString() {
		return value+"";
	}
	
	@Override
	public FeatureData clone() {
		DoubleData t = new DoubleData(minValue,maxValue);
		t.value = value;
		return t;
	}

}
