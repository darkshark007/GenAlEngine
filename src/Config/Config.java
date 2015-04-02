package Config;

public class Config {

	public int SEED;
	public int POPULATION_BASE; // This setting must be set by the caller
	public double MUTATION_BASE_CHANCE; // This setting must be set by the caller
	public double MUTATION_BASE_AMOUNT; // This setting must be set by the caller
	public int GENERATIONS_MAX;
	
	public Config() {
		
		SEED = (int)(Math.random()*Integer.MAX_VALUE);
		GENERATIONS_MAX = Integer.MAX_VALUE;
				
	}
	
}
