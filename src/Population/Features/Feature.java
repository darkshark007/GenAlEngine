package Population.Features;

import java.util.Random;

public class Feature {

	static Random r;

	String name;
	public FeatureData[] data;
	
	public Feature(String n, FeatureData t) {
		name = n;
		data = new FeatureData[1];
		data[0] = t;
	}

	public Feature(String n, FeatureData[] t) {
		name = n;
		data = t;
	}

	@Override
	public Feature clone() {
		FeatureData[] features = new FeatureData[data.length];
		for ( int i = 0; i < data.length; i++)
			if ( data[i] != null ) features[i] = data[i].clone();
		
		Feature f = new Feature(name,features);
		return f;
	}
	
	public void init() {
		for ( int i = 0; i < data.length; i++)
			if ( data[i] != null ) data[i].init();
	}
	
	@Override
	public String toString() {
		String ret = name;
		
		String dataString = "";
		for ( int i = 0; i < data.length; i++) {
			if ( data[i] != null ) {
				if ( dataString.equals("") ) {
					dataString += ", ";
				}
				dataString += data[i].toString();
			}
		}
		
		ret += dataString;
		return ret;
	}
	
	public static void setRNG(Random in) {
		r = in;
	}
}
