package seis610.gp.control;

import java.util.ArrayList;

import seis610.gp.main.exception.SoulutionFoundException;
import seis610.gp.model.Solution;

public class Generator {

	Configuration configuration;
	ArrayList<Solution> solutions;
	
	
	public Generator(Configuration configuration) {
		this.configuration 	= configuration;
		this.solutions 		= new ArrayList<Solution>();
	}

	public void generateSolutions() throws SoulutionFoundException {
		int max_population 		= Integer.parseInt(configuration.settings.get("MaximumPopulationSize"));
		for(int i = 0; i < max_population; i++){
			Solution solution = new Solution(configuration.settings, configuration.training_set);
			solution.initialize();
			solution.evaluate();
			if(solution.isTerminate()) 
				throw new SoulutionFoundException(solution);
			solutions.add(solution);
		}
	}
	
	
	
	
	
}
