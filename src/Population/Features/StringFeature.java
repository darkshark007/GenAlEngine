package Population.Features;

public class StringFeature extends FeatureType {

	String[] range;
  	public String value;
	
	public StringFeature(String[] r) {
		range = r;
	}

	@Override
	public void init() {
		value = range[(int)(Feature.r.nextDouble()*range.length)];
	}
	
	@Override
	public String toString() {
		return value;
	}

	@Override
	public FeatureType clone() {
		StringFeature t = new StringFeature(range);
		t.value = value;
		return t;
	}
}
