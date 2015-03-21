package dUnionQueue;

import edalib.list.doublylinked.DQueue;

public class TestDUnionQueue{

	public static void main(String[] args){
		DQueue<Integer> queue1 = new DQueue<Integer>();
		DQueue<Integer> queue2 = new DQueue<Integer>();
		
		//Queue1 = [2,3,6,8,9]
		queue1.addLast(2);
		queue1.addLast(3);
		queue1.addLast(6);
		queue1.addLast(8);
		queue1.addLast(9);
		
		//Queue2 = [0,1,4,5,7]
		queue2.addLast(0);
		queue2.addLast(1);
		queue2.addLast(4);
		queue2.addLast(5);
		queue2.addLast(7);
		
		DUnionQueue union = new DUnionQueue(queue1, queue2);
		System.out.println(union.unionOrderedQueue());
	}
}