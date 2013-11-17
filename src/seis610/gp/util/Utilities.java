package seis610.gp.util;

import java.util.Random;
import seis610.gp.model.Node;


public class Utilities {
	
	public static void $(String log){
		System.out.println(log);
	}
	
	private static Node getRandomIndex(String[] array){
		return new Node(array[Math.abs(new Random().nextInt() % array.length)].trim().charAt(0),null,null);
	}
	private static Node getRandomNode(String[] array1, String[] array2){
		if( new Random().nextInt() % 2 == 0) 
 			return getRandomIndex(array1);
 		return getRandomIndex(array2);
	}
	
	public static boolean exists(Node node, String[] array){
		if(node != null){
			for(int i = 0; i < array.length; i++){
				char c = array[i].charAt(0);
				if(node.value == c) return true;
			}
		}
		return false;			
	}

	public static Node buildSolutionTree(Node nodes, String[] functions, String[] terminals) {
		Node root 	= nodes == null ? getRandomIndex(functions) : nodes;
		Node left	= getRandomNode(functions,terminals);
		Node right	= getRandomNode(functions,terminals);
		if(exists(left,terminals)) root.setLeft(left); 
		else root.setLeft(buildSolutionTree(left,functions,terminals));
		if(exists(right,terminals)) root.setRight(right);
		else root.setRight(buildSolutionTree(right,functions,terminals));
		return root;
	}
	
	
	


}
