package edalib.list.array;

import edalib.list.interfaces.IQueue;

public class ArrayQueue<E> implements IQueue<E> {
	E queue[];
	int top; //Position of the next element that will leave the queue (Relative position for the array)
	int tail; //Next position of the element that will be inserted in the queue (Relative position for the array)
	
	int absoluteTop; //Position of the next element that will leave the queue (Absolute position, independent from the array)
	int absoluteTail; //Next position of the element that will be inserted in the queue (Absolute position, independent from the array)
	public ArrayQueue(int N) {
		queue =(E[]) new Object[N];A
		top=0;
		tail=0;
		this.absoluteTop = top; //We initialize the absoluteTop as the same way as the relative top
		this.absoluteTail = tail; //We initialize the absoluteTail as the same way as the relative tail
	}
	
	public boolean isEmpty() {
		return (this.absoluteTop==this.absoluteTail); //If the absoluteTop and the absoluteTail are the same then the array is empty
	}
	
	public int getSize() {
		int size=this.absoluteTail - this.absoluteTop; //The size is the difference between the absolute tail and the absolute top
		return size;
	}
	
	public void enqueue(E elem) {
		if (getSize()==queue.length) {
			System.out.println("Queue is full");
			return;
		}
		
		queue[tail]=elem;
		this.absoluteTail=(this.absoluteTail+1); //We increase the absolute tail by one
		this.tail = this.absoluteTail % queue.length; //The calculate the relative tail, it will be the real position in the array
	}

	public E dequeue() { 
		if (isEmpty()) {
			System.out.println("Queue is empty");
			return null;
		}
		E front= queue[top];
		queue[top]=null;
		this.absoluteTop=(this.absoluteTop+1); //The absolute top is one more to remove the element in the actual top
		this.top = this.absoluteTop % queue.length; //We calculate the relative tail, it will be the real position in the array
		return front;
	}

	
	public E front() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
			return null;
		}
		return queue[top];
	}
	
	
	
}
