package Population;

import Config.Config;
import Population.Features.*;

public class KnapsackIndividual extends A_Individual {
	
	int KnapsackSize = 125;
	int totalItems = 21;
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
			10,
			50,
			1,
			2,
			5,
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
			30,
			250,
			5,
			2,
			1,
	};
	
	public KnapsackIndividual() {
		features = new Feature[totalItems];
		
		for ( int i = 0; i < totalItems; i++ ) {
			features[i] = new Feature("Item #"+(i+1),new BooleanData());			
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
				f[i] = ((BooleanData)features[i].data[0]).value;
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

	
	public static Config getConfig() {
		Config ret = new Config();
		
		ret.GENERATIONS_MAX = 2000;
		ret.MUTATION_BASE_CHANCE = 0.40;
		ret.MUTATION_BASE_AMOUNT = 0.10;
		ret.POPULATION_BASE = 100;
		
		return ret;
	}
}
