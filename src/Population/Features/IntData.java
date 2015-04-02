package Population.Features;

public class IntData extends FeatureData {

	int maxValue;
	int minValue;
  	public int value;
	
	public IntData(int min, int max) {
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
	public FeatureData clone() {
		IntData t = new IntData(minValue,maxValue);
		t.value = value;
		return t;
	}
}
