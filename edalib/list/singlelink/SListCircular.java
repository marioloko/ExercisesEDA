package edalib.list.singlelink;

public class SListCircular<E> extends SList<E> {
	
	protected int size;
		
	@Override
	public void addFirst(E newElem){
		SNode<E> newNode = new SNode<E>(newElem);//Create a node with the new element
		if(this.isEmpty()){ //If the list is empty the new element is the first element and the next element is itself
			this.firstNode = newNode;
			newNode.setNextNode(newNode);
		}
		else{ //If not is emty the last element will point to the new node that will be the first element
			SNode<E> lastNode = this.getFirstNode();
			while(lastNode.getNextNode()!=this.getFirstNode()){ //Go until the last node
				lastNode = lastNode.getNextNode();
			}
			lastNode.setNextNode(newNode);//The last node point to the new one
			newNode.setNextNode(this.getFirstNode()); //The new node point to the previous one
			this.firstNode = newNode; //The first node will be the new node right now 
		}
	}
	
	@Override
	public void addLast(E newElem){
		if(this.isEmpty()){ //If the list is empty use the function addFirst
			this.addFirst(newElem);
		}
		else{//If the list is not empty link the newNode to the firstNode and the lastNode to the newNode
			SNode<E> newNode = new SNode<E>(newElem);
			newNode.setNextNode(this.getFirstNode()); //Link the new node to the last one
			SNode<E> lastNode = this.getFirstNode();
			while(lastNode.getNextNode()!=this.getFirstNode()){ //Go until the lastNode
				lastNode = lastNode.getNextNode();
			}
			lastNode.setNextNode(newNode); //Link the last node to the new node
		}
	}
	
	@Override
	public void removeFirst(){
		if(!this.isEmpty()){ //If the list is not empty remove the first node
			SNode<E> lastNode = this.getFirstNode();
			if(lastNode.getNextNode()==lastNode){ //If there is only one node the first node will be null
				this.firstNode = null;
			}
			else{ 
				while(lastNode.getNextNode()!=this.getFirstNode()){ //If there are more than one node go to the last node
					lastNode = lastNode.getNextNode();
				}
				lastNode.setNextNode(this.getFirstNode().getNextNode()); //The last node will link the second node
				this.firstNode = this.getFirstNode().getNextNode(); //The first node will be now the second element
			}
		}
	}
	
	@Override
	public void insertAt(int index, E elem){
		if(index==0){ //If we want to insert a node at first we simply add at first
			addFirst(elem);
		}
		else{ //If we want to add a node in a different position we create the new node
			SNode<E> newNode = new SNode<E>(elem);
			SNode<E> lastNode = this.getFirstNode();
			int posIndex = 1;
			for(;posIndex<index && lastNode.getNextNode()!=this.getFirstNode();posIndex++){ //We go until the index entered as parameter, this index cannot be greater than the index of the last node
				lastNode = lastNode.getNextNode();
			}
			if(posIndex!=index || index<0){ //If the index is lower than 0 or is greater than the last element return an error
				System.out.println("ERROR:Index out of bounds.");
				return;
			}
			newNode.setNextNode(lastNode.getNextNode()); //The new node will point to the following element to the index node
			lastNode.setNextNode(newNode); //The last node will point to the new node
		}
	}
	
	@Override
	public boolean contains(E elem){
		boolean contains = false; //By default the list does not contains the element
		if(!this.isEmpty()){ //If the list is not empty then check if the element is contained
			SNode<E> lastNode = this.getFirstNode();
			if(elem.equals(lastNode.getElement())){ //If the first node element is equal to te given element then it contain the element
				contains = true;
			}
			else{ //If the first element is not equal to the given element check for the other elements
				while(lastNode.getNextNode()!=this.getFirstNode() && !contains){
					if(elem.equals(lastNode.getElement())){
						contains = true;
					}
					lastNode = lastNode.getNextNode();
				}
				if(elem.equals(lastNode.getElement())){ //If the last node element is equal to te given element then it contain the element
					contains = true;
				}

			}
		}
		return contains; //Return if the list contain an element
	}
	
	@Override
	public void removeLast(){
		if(!this.isEmpty()){ //If the list is not empty then remove the last element
			SNode<E> lastNode = this.getFirstNode();
			if(lastNode.getNextNode()==this.getFirstNode()){ //If there is only one element then remove first
				this.removeFirst();
			}
			else{ //If there is more than one element then go to the node before the last node and link it to the first
				while(lastNode.getNextNode().getNextNode()!=this.getFirstNode()){
					lastNode = lastNode.getNextNode();
				}
				lastNode.setNextNode(this.getFirstNode());
			}
		}
	}
	
	@Override
	public void removeAll(E elem){
		if(!this.isEmpty()){ //If the list is not empty remove all the entered elements
			SNode<E> lastNode = this.getFirstNode();
			while(elem.equals(lastNode.getElement())){ //While the first element is equal to the given remove first
				this.removeFirst();
				lastNode = this.getFirstNode();
			}
			do{
				if(elem.equals(lastNode.getNextNode().getElement())){ //Check for each node if the next node element is equal to the element given as parameter and if true delete
					lastNode.setNextNode(lastNode.getNextNode().getNextNode());
				}
				lastNode = lastNode.getNextNode();
			}while(lastNode!=null && lastNode.getNextNode()!=this.getFirstNode());
		}
	}
}
