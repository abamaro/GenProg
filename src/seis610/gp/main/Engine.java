package seis610.gp.main;

import java.io.File;
import seis610.gp.control.Configuration;
import seis610.gp.control.Generator;
import seis610.gp.main.exception.SoulutionFoundException;
import seis610.gp.model.Solution;

public class Engine {

	
	Generator solution_generator;
	
	public static void main(String [] args){
		File config_file 	= new File("init.txt");
		File training_file	= new File("init.txt");
		new Engine().run(new File[]{config_file,training_file});
	}
	

	private void run(File[] file) {

		//generate solutions
		try{ new Generator(new Configuration(file)).generateSolutions(); }
		catch(SoulutionFoundException sfe){dump(sfe.getSolution());}
		
		//analyze solutions
		
		
		
		
		
	}
	
	private void dump(Solution solution){
		
	}
	
	

	
}
