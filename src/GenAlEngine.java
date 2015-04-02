import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.PriorityQueue;
import java.util.Random;

import Population.*;
import Population.Features.Feature;


public class GenAlEngine {

	static Random r;
	
	public static void main(String[] args) {
		
		// .===========================================.
		// |     Define the input type, Individual     |
		// '==========================================='
		String type = "KnapsackIndividual";
		//String type = "TestIndividual";
		Constructor<?> ctor = null;
		try {
			ctor = Class.forName("Population."+type).getConstructor();
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}

		
		// .===============================================.
		// |     Set up the random number generator(s)     |
		// '==============================================='
		r = new Random(50);
		Feature.setRNG(r);
		A_Individual.setRNG(r);
		

		// .================================.
		// |     Parse the Config setup     |
		// '================================'

		
		// .====================================.
		// |     Create the base population     |
		// '===================================='
		System.out.println("Original Generation:");
		A_Individual[] Pop = new A_Individual[50];
		PriorityQueue<A_Individual> q = new PriorityQueue<A_Individual>();
		for ( int i = 0; i < Pop.length; i++ ) {

			// Create the base generation
			try {
				Pop[i] = (A_Individual)ctor.newInstance();
			} catch (InstantiationException | IllegalAccessException
					| IllegalArgumentException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return;
			}
			q.add(Pop[i]);
			System.out.println(Pop[i]);			
		}
		
		
		for ( int numGens = 0; numGens < 2000; numGens++ ) {

			System.out.println("Generation "+numGens);
			A_Individual[] Pop2 = new A_Individual[Pop.length];
			PriorityQueue<A_Individual> q2 = new PriorityQueue<A_Individual>();

			for ( int i = 0; i < Pop.length; i += 2) {
				
				Pop2[i] = q.remove();
				//System.out.println("Top: "+Pop2[i]);
				Pop2[i+1] = Pop[(int)(GenAlEngine.r.nextDouble()*Pop.length)];
				//System.out.println("Crossed: "+Pop2[i+1]);
				Pop2[i+1] = Pop2[i].Cross(Pop2[i+1]);
				
				Pop2[i].Mutate(0.4, 0.25);
				Pop2[i+1].Mutate(0.4, 0.25);
				
				q2.add(Pop2[i]);
				System.out.println(Pop2[i]);						
				q2.add(Pop2[i+1]);
				System.out.println(Pop2[i+1]);						
			}
			
			Pop = Pop2;
			q = q2;
		}
		
		
		
	}
	
}
