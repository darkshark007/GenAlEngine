package Population;

import java.lang.UnsupportedOperationException;
import java.lang.reflect.InvocationTargetException;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

import Population.Features.Feature;


public class A_Individual implements I_Individual, Comparable<A_Individual> {

	static Random r;
	
	Feature[] features;
	double value;
	boolean evaluated = false;
	
	@Override
	public A_Individual Cross(A_Individual in) {
		
		A_Individual newInd = null;
		try {
			newInd = (A_Individual)in.getClass().getConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		newInd.features = new Feature[this.features.length];

		for ( int i = 0; i < newInd.features.length; i++ ) {
			if ( A_Individual.r.nextDouble() > 0.5 ) {
				newInd.features[i] = this.features[i].clone();				
			}
			else {
				newInd.features[i] = in.features[i].clone();
			}
		}

		return newInd;
	}

	@Override
	public double Evaluate() {
		throw(new UnsupportedOperationException("Not Implemented"));
	}
	
	public static PriorityQueue<A_Individual> Evaluate(A_Individual[] pop) {
		throw(new UnsupportedOperationException("Not Implemented"));
	}

	@Override
	public void Mutate(double chance, double fToMutate) {
		if ( A_Individual.r.nextDouble() < chance ) {
			evaluated = false;
			int numFeat = (int)(fToMutate*features.length);
			while ( numFeat > 0 ) {
				features[(int)(A_Individual.r.nextDouble()*features.length)].init();
				numFeat--;
			}
		}
	}

	@Override
	public void Init() {
		for ( int i = 0; i < features.length; i++ ) {
			features[i].init();
		}
	}
	
	public double ReEvaluate() {
		evaluated = false;
		return Evaluate();
	}
	
	public String toString() {
		String ret = "Value: {"+Evaluate()+"}\t";
		for ( int i = 0; i < features.length; i++ ) {
			ret += features[i].toString()+",\t";
		}
		
		return ret;
	}

	public int compareTo(A_Individual o) {
		
		if ( Evaluate() > o.Evaluate() ) return -1;
		if ( Evaluate() == o.Evaluate() ) return 0;
		return 1;
	}

	public static void setRNG(Random in) {
		r = in;
	}
}
