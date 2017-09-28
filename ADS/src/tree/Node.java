package tree;

class Node { //removing "public" to restricting access to this class within package 
	
	int data;
	Node leftChild;
	Node rightChild;
	Node parent;
	
	public Node(){
		
	}
	
	public Node (int data){
		
		this.data = data; //populating data in the instantiated node
	}

}
