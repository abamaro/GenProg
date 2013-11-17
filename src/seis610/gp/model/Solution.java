package seis610.gp.model;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

import seis610.gp.model.Node;
import seis610.gp.util.Utilities;

public class Solution {
	
	Hashtable<String,String> config_settings;
	ArrayList<Double[]> training_set;  // [	0:x 	1:f(x)		2:f(target)		3:( f(x) - (target) )	 ]
	Node node;
	public Double confidence;
	
	public Solution(Hashtable<String,String> settings, ArrayList<Double[]> training_set){
		this.config_settings = settings;
		this.training_set = training_set;
	}
	public void initialize(){
		String[] terminals 	= config_settings.get("TerminalSets").split(",");
 		String[] functions 	= config_settings.get("FunctionalSets").split(",");
 		node = Utilities.buildSolutionTree(null,functions,terminals);
 	}
	public void evaluate(){
		confidence = 0.0;
		Iterator<Double[]> iter = this.training_set.iterator();
		while(iter.hasNext()){
			Double[] current_test_pair	= iter.next();
			current_test_pair[1] 		= compute(node,current_test_pair[0]);
			current_test_pair[3]		= current_test_pair[1] - current_test_pair[2];
			confidence 					= confidence + current_test_pair[3];
		}
	}
	public boolean isTerminate(){
		Double fitnest_measure	= Double.parseDouble(config_settings.get("TerminationCriteria"));
		return (this.confidence <= fitnest_measure) ;
	}
	private Double compute(Node node, Double x){
		String[] terminals 	= config_settings.get("TerminalSets").split(",");
		if(Utilities.exists(node,terminals))
 			return Double.parseDouble(String.valueOf(node.value));
		else{
			char function 		= node.value;
			Double operand1 	= compute(node.left,x);
			Double operand2 	= compute(node.right,x);
			return calculate(function,operand1,operand2);
		}
	}
	private Double calculate(char operator, Double operand1, Double operand2){
		if(operator == '+') return operand1 + operand2;
		if(operator == '-') return operand1 - operand2;
		if(operator == '*') return operand1 * operand2;
		if(operator == '/') return operand1 / operand2;
		return 0.0;	
	}
		
}
