package Population.Features;

public class DoubleFeature extends FeatureType {

	double maxValue;
	double minValue;
  	public double value;
	
	public DoubleFeature(double min, double max) {
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
	public FeatureType clone() {
		DoubleFeature t = new DoubleFeature(minValue,maxValue);
		t.value = value;
		return t;
	}

}
