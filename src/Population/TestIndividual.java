package Population;

import Population.Features.*;

public class TestIndividual extends A_Individual {
	
	final String[] range = {
			"Test",
			"Test2"
	};

	public TestIndividual() {
		features = new Feature[4];
		
		features[0] = new Feature("Feature #1",new DoubleFeature(0,10));
		features[1] = new Feature("Feature #2",new DoubleFeature(0.5,100.5));
		features[2] = new Feature("Feature #3",new StringFeature(range));
		features[3] = new Feature("Feature #4",new IntFeature(0,10));
		
		Init();
	}
	
	@Override
	public double Evaluate() {
		
		if ( !evaluated ) {
			double f0 = ((DoubleFeature)features[0].type).value;
			double f1 = ((DoubleFeature)features[1].type).value;
			String f2 = ((StringFeature)features[2].type).value;
			int f3 = ((IntFeature)features[3].type).value;

			
			int temp = ((f3+3) % 10);
			//System.out.println("("+f3+"+3) % 10 == "+temp);
			
			value = ((temp)*f0)-f1;
			if ( f2.equals(range[1]) ) {
				value += 35;
			}
		}
		return value;
	}
}
