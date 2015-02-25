package edalib.list.singlelink;

import edalib.list.interfaces.IList;

public class SList<E> implements IList<E> {

	protected SNode<E> firstNode = null; //Create a pointer to the first node
	
	
	public SList(){
		firstNode=null; //At the begining there is any node
	}
	
	/**
	 * Return the actual first node of the list
	 * @return
	 */
	public SNode<E> getFirstNode() {
		return firstNode;  //Return the first node of the list
	}

	@Override
	public void addFirst(E newElem) {
		SNode<E> newNode = new SNode<E>(newElem); //Create a new node with the element enetered as parameter
		newNode.nextNode = firstNode; //The new node next node will be the first node
		firstNode = newNode; //And the firstnode will be the new one
	}

	@Override
	public void addLast(E newElem) {
		
		if (isEmpty()) addFirst(newElem); //If the list is empty add a new node at the begining
		else { 
			SNode<E> node = new SNode<E>(newElem); //If the list is not empty create a new node with the element given as parameter
			SNode<E> last = firstNode; //Create a node where store the last node and store the first one
			while (last.nextNode!=null) { //While the last variable is not the last node go to the following node
				last = last.nextNode;
			}
			last.nextNode = node; //The last node next node will be the new node
		}
	}
	
	@Override
	public void removeFirst() {
		if (!isEmpty()) {//If the first node is not empty then the firstnode is replace by the second one
			firstNode = firstNode.nextNode;
		}
	}

	@Override
	public boolean isEmpty() {
		return (firstNode == null); //If there is not any firstnode then the list is empty
	}
	
	@Override
	public void insertAt(int index, E newElem) {
		if(index==0){ //If the index is equal to zero add at first position
			this.addFirst(newElem);
		}
		else{
			SNode<E> newNode = new SNode<E>(newElem); //Create a new node with the new element
			SNode<E> lastNode = this.getFirstNode(); //Set the actual node to the desired one
			for(int pos=1;pos<index && lastNode!=null;pos++){//We move to the desired index-1 of our node
				lastNode=lastNode.getNextNode();
			}
			if(lastNode==null || index<0){ //If the actual node is null print an error and stop insertion
				System.out.println("Error: Index out of bound.");
				return;
			}
			newNode.setNextNode(lastNode.getNextNode()); //Set the next position of our new node to the next node of our actual node
			lastNode.setNextNode(newNode); //Our actual node next node will be right now the new node
		}
	}

	

	@Override
	public boolean contains(E elem) {
		boolean contains = false;//By default the list does not contain a node with the given element
		if(!this.isEmpty()){//If the list is not empty continue checking
			SNode<E> actualNode = this.getFirstNode(); //Create an actual node where store the the node in which the list is at that moment
			while(actualNode!=null){ //Check for all the element's nodes of the list if are equal to the element enter as parameter 
				if(actualNode.getElement().equals(elem)){
					contains=true;
				}
				actualNode=actualNode.getNextNode(); 
			}
		}
		return contains; //Return if the list contain that element
	}

	

	@Override
	public void removeLast() {
		if(!this.isEmpty()){ //If the list is not empty then create an object where store the last node and store the firstnode
			SNode<E> lastNode = this.getFirstNode();
			if(lastNode.getNextNode()==null){ //If the first element is the last element too then use remove first
				this.removeFirst();
			}
			else{
				while(lastNode.getNextNode().getNextNode()!=null){//If the node stored in last is not the node before the last then store the next one
					lastNode = lastNode.getNextNode();
				}
				lastNode.setNextNode(null); //The before last node will point to null
			}
		}
	}

	@Override
	public void removeAll(E elem) {
		if(!this.isEmpty()){ //If the list is not empty create a node where store the last node and store the first one
			SNode<E> lastNode = this.getFirstNode();
			while(lastNode!=null && elem.equals(this.getFirstNode().getElement())){//If the element given as parameter is equal  to the element of the first node use the function remove first
				this.removeFirst();
				lastNode = this.getFirstNode(); //Now the lastnode is the new first node
			}
			while(lastNode!=null && lastNode.getNextNode()!=null){//Check for each node if the node of the following one is equal to the element given as parameter
				if(elem.equals(lastNode.getNextNode().getElement())){ 
					lastNode.setNextNode(lastNode.getNextNode().getNextNode());//If true then substitude the pointer of the actual element to the pointer of the next one
				}
				else{
					lastNode = lastNode.getNextNode(); //The last element is the following one
				}
			}
		}
	}

	@Override
	public void removeAt(int index) {
		if(!this.isEmpty()){//If the lis is not empty then continue
			if(index==0){ //If the entered index is 0 remove the first element
				this.removeFirst();
			}
			else{ //Else create a variable where store the last node and store the first node
				SNode<E> lastNode = this.getFirstNode();
				for(int pos=1;pos<index && lastNode!=null;pos++){ ///Go until the index position desired
					lastNode = lastNode.getNextNode(); //The last node is the next one
				}
				if(lastNode==null || lastNode.getNextNode()==null || index<0){ //If the actual node is null or lower than zero prints an error and leave the
					System.out.println("ERROR: Index out of bounds.");
					return;
				}
				lastNode.setNextNode(lastNode.getNextNode().getNextNode()); //Substitude the following node for the nextNode of the following one
			}
		}
	}

	@Override
	public int getSize() {
		int i=0;
		if(!this.isEmpty()){//If the list is not empty create a last node variable where store the last node, and store the first node
			SNode<E> lastNode = this.getFirstNode();
			while(lastNode!=null){//If the actual lastNode is not the last node then the lastNode variable will be the next node and the size counter "i" will increase by one
				lastNode = lastNode.getNextNode();
				i++;
			}
			
		}
		return i; //Return the size counter
	}

	@Override
	public int getIndexOf(E elem) {
		int index = -1;
		if(!this.isEmpty()){//If the list is not empty then create a lastNode variable where store the last node and store the first node variable
			SNode<E> lastNode = this.getFirstNode();
			int counter = 0; //Count the index of the element
			boolean find = false; //By default the element has not been find
			while(lastNode!=null && !find){ //If the actual node is not null and the element has not been found check for each node if has the element given as parameter
				if(elem.equals(lastNode.getElement())){ //If the element is equal to the given as parameter then the index is equal the counter, and has find the element so will leave the loop
					index = counter;
					find = true;
				}
				lastNode=lastNode.getNextNode(); //Now the last node is the following node
				counter++; //The counter is increased by one
			}
		}
		return index;
	}

	@Override
	public E getFirst() {
		E elem=null;
		if(!this.isEmpty()){//If the list is not empty return the element of the first node
			elem=this.getFirstNode().getElement();
		}
		return elem;
	}

	@Override
	public E getLast() {
		E elem=null;
		if(!this.isEmpty()){ //If the list is not empty create a variable lastNode where store the last node and store the first element inside
			SNode<E> lastNode = this.getFirstNode();
			while(lastNode.getNextNode()!=null){//If the next element is not null then is not the last element, so store in the lastNode variable the following one
				lastNode = lastNode.getNextNode();
			}
			elem = lastNode.getElement(); //Store the element of the last node
		}
		return elem;//Return the element of the last node
	}

	@Override
	public E getAt(int index) {
		E elem=null;
		if(!this.isEmpty()){ //If the list is not empty create a variable lastNode where store the last element
			SNode<E> lastNode = this.getFirstNode();
			for(int pos=1;pos<=index && lastNode!=null;pos++){ //Go to the index position
				lastNode = lastNode.getNextNode();
			}
			if(lastNode==null || index<0){ //If the last node is null or the index is lower than 0 return error
				System.out.println("ERROR: Index out of bounds.");
				return null;
			}
			elem = lastNode.getElement(); //Store the element in the index position
		}
		return elem; //Return the index position
	}

	@Override
	public String toString() {
		String str=null; //By default there is nothing in the list
		if(!this.isEmpty()){ //If the list is not empty then create a new node where store the last element
			str="";
			SNode<E> lastNode = this.getFirstNode(); //By default the lastnode is the firstnode
			str += lastNode.getElement()+" "; //Store the element of the firstnode in the returning string
			while(lastNode.getNextNode()!=null){//While the last node is not the last node, store the next node in the last node variable 
				lastNode = lastNode.getNextNode();
				str += lastNode.getElement()+" ";//Finally add the element of the lastNode variable to the returning variable
			}
		}
		return str;
	}
	
	/**
	 * Print all the elements in the nodes of the SList
	 */
	public void printList(){
		if(!this.isEmpty()){//If the list is not empty then print the nodes
			SNode<E> node = this.getFirstNode(); //Create a new node and store the first element
			while(node!=null){ //While the element is not null print it 
				System.out.print(node.getElement()+" ");
				node = node.getNextNode(); //Now the node is the following node
			}
			System.out.println();
		}
	}
}
