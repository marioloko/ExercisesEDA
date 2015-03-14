package dUnionQueue;

import edalib.list.doublylinked.DQueue;

public class DUnionQueue{
	DQueue<Integer> queue1;
	DQueue<Integer> queue2;
	
	public DUnionQueue(DQueue<Integer> queue1, DQueue<Integer> queue2){
		if(queue1!=null && queue2!=null){
			this.queue1 = queue1;
			this.queue2 = queue2;
		}else{
			System.out.println("ERROR: Null Queue");
			return;
		}
	}
	
	public DQueue<Integer> unionOrderedQueue(){
		DQueue<Integer> unionOrderedQueue = new DQueue<Integer>();
		while(!queue1.isEmpty() && !queue2.isEmpty()){
			if(queue1.getFirst().compareTo(queue2.getFirst()) < 0){
				unionOrderedQueue.addLast(queue1.removeFirst());
			}else{
				unionOrderedQueue.addLast(queue2.removeFirst());
			}
		}
		while(!queue1.isEmpty()){
			unionOrderedQueue.addLast(queue1.removeFirst());
		}
		while(!queue2.isEmpty()){
			unionOrderedQueue.addLast(queue2.removeFirst());
		}
		return unionOrderedQueue;
	}
}