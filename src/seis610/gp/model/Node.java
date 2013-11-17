package seis610.gp.model;

public class Node {

	public char value;
	public Node left;
	public Node right;
	
	public Node(){}
	public Node(char value, Node left,Node right){
		this.value = value;
		this.left = left;
		this.right = right;
	}
	
	public void setRight(Node right){
		this.right = right;
	}
	public void setLeft(Node left){
		this.left = left;
	}
	
	
	
}
