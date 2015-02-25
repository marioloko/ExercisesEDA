package edalib.list.singlelink;

public class SListTail<E> extends SList<E> {
	protected SNode<E> tailNode = null;
	
	public SListTail(){
		this.tailNode = null;
	}
	
	public SNode<E> getTailNode(){
		return this.tailNode;
	}
	
	@Override
	public void addFirst(E newElem){
		SNode<E> newNode = new SNode<E>(newElem);
		if(this.isEmpty()){ //If the list was empty the new node is the first and the tail node
			this.tailNode = newNode;
			this.firstNode = newNode;
		}
		else{
			newNode.setNextNode(this.getFirstNode()); //The next node to the newNode is the previous first node
			this.firstNode = newNode; //The firstnode is now the first new node
		}
	}
	
	@Override
	public void addLast(E newElem){ 
		if(this.isEmpty()){ //If the list is empty then add the new element at first
			this.addFirst(newElem);
		}
		else{//If there is more than one node the nextNode of the last node is our new node, and our new tailNode is the newNode
			SNode<E> newNode = new SNode<E>(newElem);
			this.tailNode.setNextNode(newNode);
			this.tailNode = newNode;
		}
	}
	
	@Override
	public void removeLast(){
		if(!this.isEmpty()){ //If the list is not empty then create a lastNode variable where store the last node and store the first node of the list
			SNode<E> lastNode = this.getFirstNode();
			if(lastNode.getNextNode()==null){ //If there is only one element use the function remove first and the tail node will be now null
				this.removeFirst();
				this.tailNode = null;
			}
			else{
				while(lastNode.getNextNode().getNextNode()!=null){ //While the lastNode variable is not the node before the last, store the next node
					lastNode = lastNode.getNextNode();
				}
				lastNode.setNextNode(null); //Node remove the last node setting it to null
				this.tailNode = lastNode; //The last node is tail right now
			}
		}
	}
	
	@Override
	public void removeAll(E elem){
		if(!this.isEmpty()){
			SNode<E> lastNode = this.getFirstNode(); //If the list is not empty at first the last node is the first node
			while(!this.isEmpty() && elem.equals(lastNode.getElement())){ //If the element of the first node is equal to the elem and is not null
				this.removeFirst(); 
				lastNode = this.getFirstNode(); //Now the last element is the new first node
			}
			while(!this.isEmpty() && lastNode.getNextNode()!=null){ //If the list has not been got empty and it is not the last node check if the following node is equal to the element given
				if(elem.equals(lastNode.getNextNode().getElement())){ //If the next node has an element equal to the element given then remove the following node
					lastNode.setNextNode(lastNode.getNextNode().getNextNode());
				}
				else{
					lastNode = lastNode.getNextNode();
				}
			}
			this.tailNode = lastNode; //Set the tail node to the final last node(The node before the null)
		}
	}
	
	@Override
	public void removeAt(int index){
		if(!this.isEmpty()){ //If the list is not empty continue
			if(index==0){ //If the index given is 0 remove the first element
				this.removeFirst();
			}
			else{ //If not create a lastNode variable and store the first node of the list
				SNode<E> lastNode = this.getFirstNode();
				for(int pos=1;pos<index && lastNode!=null;pos++){ //Go until one node before the selected
					lastNode = lastNode.getNextNode();
				}
				if(lastNode==null || lastNode.getNextNode()==null || index<0){ //If the actual node or the following is null or the index is lower than zero then print an error
					System.out.println("ERROR: Index out of bounds.");
					return;
				}
				lastNode.setNextNode(lastNode.getNextNode().getNextNode());
				if(lastNode.getNextNode()==null){ //If the following node is zero then it is the last node
					this.tailNode = lastNode;
				}
			}
		}
	}
	
	@Override
	public void insertAt(int index, E elem){
		if(index==0){ //If the given index is zero add the element at first
			this.addFirst(elem);
		}
		else{
			SNode<E> newNode = new SNode<E>(elem); //Create a new node with the element given
			SNode<E> lastNode = this.getFirstNode(); //Create a node where store the last node and store the first node
			for(int pos=1;pos<index && lastNode!=null;pos++){ //Go to the position before the indicated index
				lastNode = lastNode.getNextNode();
			}
			if(lastNode==null || index<0){ //If the actual index or the following is null or the index is lower than zero print an error
				System.out.println("ERROR: Index out of bounds.");
				return;
			}
			newNode.setNextNode(lastNode.getNextNode()); //The new node next node will be the following to the actual node
			lastNode.setNextNode(newNode); //The following node to the actual node will be the new node
			if(newNode.getNextNode()==null){ //If the following node is null then the new node is the tail node
				this.tailNode = newNode;
			}
		}
		
	}
	
	
	@Override
	public E getLast(){
		E elem = null;
		if(!this.isEmpty()){ //If the list is not empty then return the element of the last node
			elem = this.getTailNode().getElement();
		}
		return elem;
	}
}
