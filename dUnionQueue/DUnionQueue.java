package dUnionQueue;

import edalib.list.doublylinked.DQueue;

public class DUnionQueue{
	DQueue<Integer> queue1; //First queue for creating an union
	DQueue<Integer> queue2; //Second queue for creating an union
	
	public DUnionQueue(DQueue<Integer> queue1, DQueue<Integer> queue2){
		if(queue1!=null && queue2!=null){ //If both entered queues are valid then create the object
			this.queue1 = queue1;
			this.queue2 = queue2;
		}else{ //If some queue is invalid print an error
			System.out.println("ERROR: Null Queue \n");
			return;
		}
	}
	
	public DQueue<Integer> unionOrderedQueue(){
		DQueue<Integer> unionOrderedQueue = new DQueue<Integer>(); //Create a new queue where store the union of the other queues
		while(!queue1.isEmpty() && !queue2.isEmpty()){//While both queue has at least one number add at last of the new queue the lower number of the queues
			if(queue1.getFirst().compareTo(queue2.getFirst()) < 0){ //If the first element of the queue1 is lower than the first element of the queue2 add the first element of queue1 and removeit
				unionOrderedQueue.addLast(queue1.removeFirst());
			}else{ //else add the first element of queue2 and removeit
				unionOrderedQueue.addLast(queue2.removeFirst());
			}
		}
		while(!queue1.isEmpty()){ //If queue2 is empty and queue1 has still any element add all the elements of queue1 at the end of the union queue
			unionOrderedQueue.addLast(queue1.removeFirst());
		}
		while(!queue2.isEmpty()){ //If queue1 is empty and queue2 has still any element add all the elements of queue2 at the end of the union queue
			unionOrderedQueue.addLast(queue2.removeFirst());
		}
		return unionOrderedQueue; //Return the union queue
	}
}