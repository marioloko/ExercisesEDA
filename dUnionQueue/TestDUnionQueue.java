package dUnionQueue;

import edalib.list.doublylinked.DQueue;

public class TestDUnionQueue{

	public static void main(String[] args){
		DQueue<Integer> queue1 = new DQueue<Integer>();
		DQueue<Integer> queue2 = new DQueue<Integer>();
		for(int pos=0;pos<10;pos++){
			queue1.addLast(pos);
		}
		for(int pos=0;pos<=10;pos=pos+2){
			queue2.addLast(pos);
		}
		DUnionQueue union = new DUnionQueue(queue1, queue2);
		System.out.println(union.unionOrderedQueue());
	}
}