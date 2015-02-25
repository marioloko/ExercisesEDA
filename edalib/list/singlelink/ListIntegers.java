package edalib.list.singlelink;

public class ListIntegers extends SList<Integer>{
	/**
	 * Add all the integers of the list
	 * @return
	 */
	public int addition(){
		int sum=0; //At first the sum is zero
		SNode<Integer> lastNode = this.getFirstNode(); //At first the last node is the first one
		while(lastNode!=null){ //Sum all the element different from null
			sum += lastNode.getElement();
			lastNode = lastNode.getNextNode();
		}
		return sum; //Return the sum of all the nodes elements
	}
	
	/**
	 * Return an array with all the even numbers of the list
	 * @return
	 */
	public int[] even(){
		SNode<Integer> lastNode = this.getFirstNode(); //At first the last node is the first one
		int size = 0; 
		while(lastNode!=null){ //Calculate how many even numbers are there in the list
			if(lastNode.getElement()%2==0){
				size++;
			}
			lastNode = lastNode.getNextNode();
		}
		int[] arrayEven = new int[size]; 
		lastNode = this.getFirstNode();//Restart the lastNode variable to the first node
		int pos=0;
		while(lastNode!=null){ //Add each even number of the list in a different array position
			if(lastNode.getElement()%2==0){
				arrayEven[pos] = lastNode.getElement();
				pos++;
			}
			lastNode = lastNode.getNextNode();
		}
		return arrayEven; //Return an array with all the even numbers of the list
	}
}