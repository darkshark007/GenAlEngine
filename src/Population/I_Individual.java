package Population;

import java.util.PriorityQueue;

import Config.Config;

public interface I_Individual {

	public I_Individual Cross(A_Individual in);
	public double Evaluate();
	//public static PriorityQueue<A_Individual> Evaluate(A_Individual[] pop);
	public void Mutate(double chance, double features);
	public void Init();
	public static Config getConfig() {
		throw(new UnsupportedOperationException("Not Implemented"));
	}
}
