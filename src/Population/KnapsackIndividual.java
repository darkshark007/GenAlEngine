package Population;

import Population.Features.*;

public class KnapsackIndividual extends A_Individual {
	
	int KnapsackSize = 125;
	int totalItems = 16;
	int[] KnapsackItemWeights = {
			5,
			10,
			25,
			5,
			10,
			20,
			50,
			20,
			45,
			13,
			27,
			38,
			90,
			110,
			20,
			42,
	};
	int[] KnapsackItemValues = {
			5,
			25,
			20,
			5,
			100,
			20,
			25,
			25,
			55,
			50,
			12,
			35,
			70,
			120,
			200,
			84,
	};
	
	public KnapsackIndividual() {
		features = new Feature[totalItems];
		
		for ( int i = 0; i < totalItems; i++ ) {
			features[i] = new Feature("Item #"+(i+1),new BooleanFeature());			
		}
		
		Init();
	}
	
	@Override
	public double Evaluate() {
		
		if ( !evaluated ) {
			evaluated = true;
			
			int totalWeight = 0;
			int totalValue = 0;
			boolean[] f = new boolean[totalItems];
			for ( int i = 0; i < totalItems; i++ ) {
				f[i] = ((BooleanFeature)features[i].type).value;
				if ( f[i] ) {
					totalWeight += KnapsackItemWeights[i];
					totalValue += KnapsackItemValues[i];
				}
			}
			
			if ( totalWeight <= KnapsackSize ) {
				value = totalValue;
			}
			else {
				value = 0;
			}
		}
		return value;
	}
}
