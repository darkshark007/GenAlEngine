package Population.Features;

public class BooleanFeature extends FeatureType {
	
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
	public FeatureType clone() {
		BooleanFeature t = new BooleanFeature();
		t.value = value;
		return t;
	}

}
