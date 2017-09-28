package tree;

public class BinaryTree {
	
	//nodes contain key (data)
	//nodes have only 2 children (left child, right child)
	
	Node root;
	
	public void add(int data){
		
		Node nodeToAdd = new Node(data);
		
		if (root == null)
			root = nodeToAdd;
		//if data < node, traverse left child, else traverse right child until we get to a node that we can't traverse
		//...insert new node
		
		traverseAndAddNode(root, nodeToAdd);
	}
	
	private int size (Node node){ // encapsulation
		if (node == null){
			return 0;
		}
		else{
			return size(node.leftChild) + 1 + size(node.rightChild);
		}
	}
	
	
	public int size(){
		System.out.println("Size of the tree: "+ (size(root)));
		return (size(root));
	}
	
	public boolean isEmpty(){
		if (root == null){
			System.out.println("Tree is empty.");
			return true;
		}
		else{
			System.out.println("Tree is not empty.");
			return false;
		}
	}
	
	public Node getRoot(){
		
		System.out.println("Root is: "+root.data);
		return root;
		
	}
	
	public boolean contains (Node node, Integer value){
		if (node.data == value){
			return true;
		}
		boolean contains = false;
		
		if (node.leftChild != null){
			contains = contains(node.leftChild, value);
		}
		if (!contains && node.rightChild != null){
			contains = contains(node.rightChild, value);
		}
		System.out.println("Contains: "+contains);
		return contains;
	}
	
	private void traverseAndAddNode(Node node, Node nodeToAdd){
		
		if (nodeToAdd.data < node.data){
			if (node.leftChild == null){
				nodeToAdd.parent = node; // adding the parent node
				node.leftChild = nodeToAdd;
			}
			else{
				traverseAndAddNode(node.leftChild, nodeToAdd);
			traverseAndAddNode(node.leftChild, nodeToAdd);
			}
			
		}
		else if (nodeToAdd.data > node.data){
			if (node.rightChild == null){
				nodeToAdd.parent = node; // adding the parent node
				node.rightChild = nodeToAdd;
			}
			else{
				traverseAndAddNode(node.rightChild, nodeToAdd);
			traverseAndAddNode(node.rightChild, nodeToAdd);
			}
			
		}
		
		
		
	}
	
	public void traverseIn(){ // FOR IN-ORDER TRAVERSAL
		
		if (root != null){
			Node nodeToTraverse = root;
			
			if (nodeToTraverse.leftChild == null && nodeToTraverse.rightChild == null){
				System.out.println(nodeToTraverse.data);
				
			}
			
			else{
				inOrderTraversal(nodeToTraverse);
			}
		}

	}
	
	public void inOrderTraversal(Node node){
		if (node.leftChild != null){
			inOrderTraversal(node.leftChild);
			}
		
		System.out.println(node.data);
		
		if (node.rightChild != null){
			inOrderTraversal(node.rightChild);
		}

	}
	
	public void traversePre(){ // FOR PRE-ORDER TRAVERSAL
		
		
		if (root != null){
			Node nodeToTraverse = root;
			
			if (nodeToTraverse.leftChild == null && nodeToTraverse.rightChild == null){
				
			}
			
			else{
				preOrderTraversal(nodeToTraverse);
			}
		}

	}
	
	public void preOrderTraversal(Node node){
		
		System.out.println(node.data);
		
		if (node.leftChild != null){
			preOrderTraversal(node.leftChild);
			}
		
		
		if (node.rightChild != null){
			preOrderTraversal(node.rightChild);
		}

	}
	
public void traversePost(){ // FOR POST-ORDER TRAVERSAL
		
		
		if (root != null){
			Node nodeToTraverse = root;
			
			if (nodeToTraverse.leftChild == null && nodeToTraverse.rightChild == null){
				
			}
			
			else{
				postOrderTraversal(nodeToTraverse);
			}
		}

	}
	
	public void postOrderTraversal(Node node){
		
		if (node.leftChild != null){
			postOrderTraversal(node.leftChild);
			}
		
		
		if (node.rightChild != null){
			postOrderTraversal(node.rightChild);
		}
		
		System.out.println(node.data);

	}
	
	public boolean delete (int val){
		// case 1: node has no children
		// case 2: node has one child
		// case 3: node has two children
		
		Node nodeToBeDeleted = find(val);
		
		if (nodeToBeDeleted != null){
			if (nodeToBeDeleted.leftChild == null && nodeToBeDeleted.rightChild == null){
				// case 1
				deleteCase1(nodeToBeDeleted);
				}
			else if (nodeToBeDeleted.leftChild != null && nodeToBeDeleted.rightChild != null){
				// case 2.1, where left child should be deleted
				deleteCase3(nodeToBeDeleted);
			}
			else if (nodeToBeDeleted.rightChild != null){
				// case 2.2, where right child should be deleted
				deleteCase2(nodeToBeDeleted);
			}
			else if (nodeToBeDeleted.rightChild != null){
				// case 3 node has both children populated
				deleteCase2 (nodeToBeDeleted);
			}
			
		}
		return false;
	}
	
	private void deleteCase2(Node nodeToBeDeleted) {
		
		if (nodeToBeDeleted.parent.leftChild == nodeToBeDeleted){
			if (nodeToBeDeleted.leftChild != null){
			nodeToBeDeleted.parent.leftChild = nodeToBeDeleted.leftChild;
			}
			else if (nodeToBeDeleted.rightChild != null){
				nodeToBeDeleted.parent.leftChild = nodeToBeDeleted.rightChild;
			}
			
		}
		
		else if (nodeToBeDeleted.parent.rightChild == nodeToBeDeleted){
			if (nodeToBeDeleted.leftChild != null){
				nodeToBeDeleted.parent.rightChild = nodeToBeDeleted.leftChild;
				}
				else if (nodeToBeDeleted.rightChild != null){
					nodeToBeDeleted.parent.rightChild = nodeToBeDeleted.rightChild;
				}
			
		}
		
	}
	
	private void deleteCase3 (Node nodeToBeDeleted){
		Node minNode = minLeftTraversal(nodeToBeDeleted.rightChild);
		deleteCase2(minNode);
		
		minNode.parent = nodeToBeDeleted.parent;
		minNode.leftChild = nodeToBeDeleted.leftChild;
		minNode.rightChild = nodeToBeDeleted.rightChild;
		
		if (nodeToBeDeleted.parent == null){
			root = minNode;
		}
		
		else{
		if (nodeToBeDeleted.parent.leftChild == nodeToBeDeleted){
			
			nodeToBeDeleted.parent.leftChild = minNode;
			
		}
		else if (nodeToBeDeleted.parent.rightChild == nodeToBeDeleted){
			
			nodeToBeDeleted.parent.rightChild = minNode;
			
		}
		}
		
		
		
	}
	
	private Node minLeftTraversal(Node node){ // algorithm to traverse the tree for case 3 (to the right and then all the way to the left)
		if (node.leftChild == null){
			return node;
		}
		return minLeftTraversal(node.leftChild);
		
	}

	private void deleteCase1 (Node nodeToBeDeleted){
		// check if the node to be deleted is the left of right CHILD of the PARENT of the node
		
			if (nodeToBeDeleted.parent.leftChild == nodeToBeDeleted){
				nodeToBeDeleted.parent.leftChild = null;
				
			}
			else if (nodeToBeDeleted.parent.rightChild == nodeToBeDeleted){
				nodeToBeDeleted.parent.rightChild = null;
				
			}
		}
		
	
	public Node find (int val){
		if (root != null){
			return findNode (root, new Node(val));
		}
		return null;
	}
	
	private Node findNode (Node search, Node node){
		if (search == null){
			return null;
		}
		
		if (search.data == node.data){
			return search;
		}
		else{
			Node returnNode = findNode (search.leftChild, node);
			
			if (returnNode == null){
				returnNode = findNode (search.rightChild, node);
			}
			return returnNode;
		}
	}


}
