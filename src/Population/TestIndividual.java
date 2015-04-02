package Population;

import Population.Features.*;

public class TestIndividual extends A_Individual {
	
	final String[] range = {
			"Test",
			"Test2"
	};

	public TestIndividual() {
		features = new Feature[4];
		
		features[0] = new Feature("Feature #1",new DoubleData(0,10));
		features[1] = new Feature("Feature #2",new DoubleData(0.5,100.5));
		features[2] = new Feature("Feature #3",new StringData(range));
		features[3] = new Feature("Feature #4",new IntData(0,10));
		
		Init();
	}
	
	@Override
	public double Evaluate() {
		
		if ( !evaluated ) {
			double f0 = ((DoubleData)features[0].data[0]).value;
			double f1 = ((DoubleData)features[1].data[0]).value;
			String f2 = ((StringData)features[2].data[0]).value;
			int f3 = ((IntData)features[3].data[0]).value;

			
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
