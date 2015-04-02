package Population.Features;

import java.util.Random;

public class Feature {

	static Random r;

	String name;
	public FeatureData type;
	
	public Feature(String n, FeatureData t) {
		name = n;
		type = t;
	}
	
	@Override
	public Feature clone() {
		Feature f = new Feature(name,type.clone());
		return f;
	}
	
	public void init() {
		type.init();
	}
	
	@Override
	public String toString() {
		return name+" "+type.toString();
	}
	
	public static void setRNG(Random in) {
		r = in;
	}
}
