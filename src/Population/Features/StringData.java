package Population.Features;

public class StringData extends FeatureData {

	String[] range;
  	public String value;
	
	public StringData(String[] r) {
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
	public FeatureData clone() {
		StringData t = new StringData(range);
		t.value = value;
		return t;
	}
}
