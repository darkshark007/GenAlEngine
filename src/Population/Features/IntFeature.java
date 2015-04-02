package Population.Features;

public class IntFeature extends FeatureType {

	int maxValue;
	int minValue;
  	public int value;
	
	public IntFeature(int min, int max) {
		maxValue = max;
		minValue = min;
	}

	@Override
	public void init() {
		value = minValue+(int)((maxValue-minValue+1)*Feature.r.nextDouble());
	}
	
	@Override
	public String toString() {
		return value+"";
	}

	@Override
	public FeatureType clone() {
		IntFeature t = new IntFeature(minValue,maxValue);
		t.value = value;
		return t;
	}
}
