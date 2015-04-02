package Population.Features;

public class BooleanData extends FeatureData {
	
	public boolean value;

	@Override
	public void init() {
		if ( Feature.r.nextDouble() > 0.5 ) {
			value = true;
		}
		else {
			value = false;
		}
	}
	
	@Override
	public String toString() {
		return value+"";
	}
	
	@Override
	public FeatureData clone() {
		BooleanData t = new BooleanData();
		t.value = value;
		return t;
	}

}
