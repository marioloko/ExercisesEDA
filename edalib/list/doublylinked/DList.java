package edalib.list.doublylinked;

import edalib.list.interfaces.IList;

/**
 * A double-linked list class with sentinel nodes
 */

public class DList<E> implements IList<E> {

	DNode<E> header;
	DNode<E> trailer;

	public DList() {
		header = new DNode<E>(null); 
		trailer = new DNode<E>(null);
		header.nextNode = trailer;
		trailer.previousNode = header;
	}

	@Override
	public void addFirst(E elem) {
		DNode<E> newNode = new DNode<E>(elem);
		newNode.nextNode = header.nextNode;
		newNode.previousNode = header;
		header.nextNode.previousNode = newNode;
		header.nextNode = newNode;
	}

	@Override
	public void addLast(E elem) {
		DNode<E> newNode = new DNode<E>(elem);
		newNode.nextNode = trailer;
		newNode.previousNode = trailer.previousNode;
		trailer.previousNode.nextNode = newNode;
		trailer.previousNode = newNode;
	}

	@Override
	public void insertAt(int index, E elem) {
		DNode<E> newNode = new DNode<E>(elem);
		int i = 0;
		for (DNode<E> nodeIt = header; nodeIt != trailer; nodeIt = nodeIt.nextNode) {
			if (i == index) {
				newNode.nextNode = nodeIt.nextNode;
				newNode.previousNode = nodeIt;
				nodeIt.nextNode.previousNode = newNode;
				nodeIt.nextNode = newNode;
				return;
			}
			++i;
		}
		System.out.println("DList: Insertion out of bounds");
	}

	@Override
	public boolean isEmpty() {
		return (header.nextNode == trailer);
	}

	@Override
	public boolean contains(E elem) {
		boolean contains = false; //By default the list does not contain the element
		if(!this.isEmpty()){
			DNode<E> actualNode = this.getFirstNode(); //The actual node is the first one
			while(actualNode!=this.getTrailer() && !contains){ //Check for each node if the element is equal to the given elem
				if(elem.equals(actualNode.getElement())){ 
					contains = true; //If the element is equal to the given elem then it is contained
				}
				actualNode = actualNode.getNextNode();
			}
		}
		return contains;
	}

	@Override
	public int getIndexOf(E elem) {
		int index = -1; //By default the element is not in the list
		if(this.isEmpty()){ //If the list is empty then it prints that it is empty
			System.out.println("ERROR: The list is empty.");
		}else{
			boolean find = false; //By default the boolean has not been find
			DNode<E> lastNode = this.getFirstNode();
			int counter = 0; //Count the position of the counter
			while(lastNode!=this.getTrailer()){//Check for each element if the element is given elem, if true leave the while and the index will be the actual position
				if(elem.equals(lastNode.getElement())){
					find = true;
					index = counter;
				}
				lastNode = lastNode.getNextNode();
				counter++;
			}
		}
		return index;
	}

	@Override
	public void removeFirst() {
		if (isEmpty()) {
			System.out.println("DList: List is empty");
			return;
		}
		header.nextNode = header.nextNode.nextNode;
		header.nextNode.previousNode = header;
	}

	@Override
	public void removeLast() {
		if (isEmpty()) {
			System.out.println("DList: List is empty");
			return;
		}
		trailer.previousNode = trailer.previousNode.previousNode;
		trailer.previousNode.nextNode = trailer;
	}

	@Override
	public void removeAll(E elem) {
		if(this.isEmpty()){ //If the list is empty print an error
			System.out.println("ERROR: The list is empty.");
		}else{
			DNode<E> actualNode = this.getFirstNode();
			while(actualNode!=this.getTrailer()){//Check for each element if it is equal to the elem
				if(elem.equals(actualNode.getElement())){
					actualNode.getPreviousNode().nextNode = actualNode.getNextNode(); //Connect the previous node with the following
					actualNode.getNextNode().previousNode = actualNode.getPreviousNode(); //And connect the following with the previous removing this node
				}
				actualNode = actualNode.getNextNode();
			}
		}
	}

	@Override
	public void removeAt(int index) {
		int i = 0;
		for (DNode<E> nodeIt = header.nextNode; nodeIt != trailer; nodeIt = nodeIt.nextNode) {
			if (i == index) {
				nodeIt.previousNode.nextNode = nodeIt.nextNode;
				nodeIt.nextNode.previousNode = nodeIt.previousNode;
				return;
			}
			++i;
		}
		System.out.println("DList: Deletion out of bounds");
	}

	@Override
	public int getSize() {
		int size = 0; //By default the list is not empty
		if(!this.isEmpty()){
			DNode<E> lastNode = this.getFirstNode();
			while(lastNode!=this.getTrailer()){ //Go until the trailer adding one unit to the size for each different node
				size++;
				lastNode = lastNode.getNextNode();
			}
		}
		return size;
	}

	@Override
	public E getFirst() {
		return this.getFirstNode().getElement(); //Return the element of the node after the header
	}

	@Override
	public E getLast() {
		return this.getLastNode().getElement(); //Return the element of the previous node of the trailer
	}

	@Override
	public E getAt(int index) {
		E elem = null; //By default the list is not empty
		if(!this.isEmpty()){
			DNode<E> lastNode = this.getFirstNode();
			int posIndex=0;
			for(; posIndex<index && lastNode.getNextNode()!=this.getTrailer();posIndex++){ //Go to the selected index and give up the loop if it reach the node before trailer
				lastNode = lastNode.getNextNode();
			}
			if(posIndex!=index){//If the actual index is not equal to the given index print an error and return null
				System.out.println("ERROR: Index out of bounds.");
				return null;
			}
			elem = lastNode.getElement(); //Store the element of the node at the given index
		}
		return elem;
	}

	@Override
	public String toString() {
		String str = null; 
		if(!this.isEmpty()){
			str = ""; //If there is at least one element initialize the String
			DNode<E> lastNode = this.getFirstNode();
			while(lastNode!=this.getTrailer()){ //Add each element to the string
				str += lastNode.getElement()+" ";
				lastNode = lastNode.getNextNode();
			}
		}
		return str;
	}

	public DNode<E> getFirstNode() {
		return header.nextNode;
	}

	public DNode<E> getLastNode() {
		return trailer.previousNode;
	}

	public DNode<E> getHeader() {
		return header;
	}

	public DNode<E> getTrailer() {
		return trailer;
	}

}
