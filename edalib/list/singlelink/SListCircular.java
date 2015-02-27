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
				do{
					if(elem.equals(lastNode.getNextNode().getElement())){
						contains = true;
					}
					lastNode = lastNode.getNextNode();
				}while(lastNode.getNextNode()!=this.getFirstNode() && !contains);
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
	
	@Override
	public void removeAt(int index){
		if(!this.isEmpty()){ //If the list is not empty then remove the node at that position
			if(index==0){ //If the index is 0 then remove the first element
				this.removeFirst();
			}
			else{ //If the index is different from zero then go to the previous node to the desired index and remove the following element
				SNode<E> lastNode = this.getFirstNode();
				int indexPos = 1;
				for(;indexPos<index && lastNode.getNextNode().getNextNode()!=this.getFirstNode();indexPos++){
					lastNode = lastNode.getNextNode();
				}
				if(indexPos!=index){
					System.out.println("ERROR: Index out of bounds.");
					return;
				}
				lastNode.setNextNode(lastNode.getNextNode().getNextNode()); //Link the previous node of the given index with the following node to the given index
			}
		}
	}
	
	@Override
	public int getSize(){
		int size = 0; //By default there is no element in the list
		if(!this.isEmpty()){ //If the list is not empty then at lest there is an element inside
			SNode<E> lastNode = this.getFirstNode();
			size = 1;
			while(lastNode.getNextNode()!=this.getFirstNode()){ //While the node is not the last go to the last counting the size
				lastNode = lastNode.getNextNode();
				size++; 
			}
		}
		return size;//Return the number of node of the list
	}
	
	@Override
	public int getIndexOf(E elem){
		int index = -1; //By default the element is not in the list
		if(!this.isEmpty()){ //If the list is not empty check for all the elements
			SNode<E> lastNode = this.getFirstNode();
			if(elem.equals(lastNode.getElement())){ //If the firstNode is equal to the eleme the index will be 0
				index = 0;
			}
			else{
				int position = 1; 
				while(lastNode.getNextNode()!=this.getFirstNode()){//Check if every element if the node is equal to the given element
					if(elem.equals(lastNode.getNextNode().getElement())){ //If the following element is equal to the elem then the position is equal to the index of the next position
						index = position;
					}
					position++; //Increset the actual position
					lastNode = lastNode.getNextNode(); //Now the lastNode is the following node
				}
			}
		}
		return index; //Return the index of that index
	}
	
	@Override
	public E getLast(){
		E elem = null; 
		if(!this.isEmpty()){//If the list is no null go to the last element
			SNode<E> lastNode = this.getFirstNode();
			while(lastNode.getNextNode()!=this.getFirstNode()){
				lastNode = lastNode.getNextNode();
			}
			elem = lastNode.getElement(); //Store the element of the lastNode
		}
		return elem; //Return the last node element
	}
	
	@Override
	public E getAt(int index){
		E elem = null;
		if(index<0){ //If the index is lower than zero return an error
			System.out.println("ERROR:Index out of bounds.");
			return elem;
		}
		else if(!this.isEmpty()){ //If there is no error and the list is not empty search the element of the given index
			if(index==0){ //If the index is 0 return the element at the first position
				elem = this.getFirstNode().getElement();
			}
			else{ //Else go to the previous position to the given index
				SNode<E> lastNode = this.getFirstNode();
				for(int pos=1; pos<index;pos++){
					lastNode = lastNode.getNextNode(); 
				}
				elem = lastNode.getNextNode().getElement(); //Store the position of the element at that index
			}
		}
		return elem; //Return the element at that index
	}
	
	@Override
	public String toString(){
		String str = null; //By default does not return anything
		if(!this.isEmpty()){ //If the list is not empty add each node element separated with an space to the returning string
			SNode<E> lastNode = this.getFirstNode();
			str = lastNode.getElement()+" ";
			do{
				str += lastNode.getNextNode().getElement()+" ";
				lastNode = lastNode.getNextNode();
			}while(lastNode.getNextNode()!=this.getFirstNode());
			str += "-> cyclic";
		}
		return str; //Return the string with all the elements
	}
	
	@Override
	public void printList(){
		if(!this.isEmpty()){ //If the list is not empty print all the values separated by spaces
			SNode<E> lastNode = this.getFirstNode();
			System.out.print(lastNode.getElement()+" ");
			while(lastNode.getNextNode()!=this.getFirstNode()){
				System.out.print(lastNode.getNextNode().getElement()+" ");
				lastNode = lastNode.getNextNode();
			}
			System.out.println("-> cyclic");
		}
	}
	
	/**
	 * Print all the elements until it reach the given element
	 * @param index
	 */
	public void printUntil(int index){
		if(!this.isEmpty()){
			SNode<E> lastNode = this.getFirstNode();
			System.out.print(lastNode.getElement()+" ");
			for(int indexPos=1;indexPos<=index;indexPos++){//While the actual position is lower than the given index print all his elements
				lastNode = lastNode.getNextNode();
				System.out.print(lastNode.getElement()+ " ");
			}
			System.out.println();
		}
	}
}
