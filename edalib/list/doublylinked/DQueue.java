package edalib.list.doublylinked;

import edalib.list.interfaces.IDQueue;

public class DQueue<E> implements IDQueue<E> {
	DNode<E> header;
	DNode<E> tailer;

	public DQueue() {
		header = new DNode<E>(null);
		tailer = new DNode<E>(null);
		header.nextNode = tailer;
		tailer.previousNode = header;
	}
	
	
	public boolean isEmpty() {
		return (header.nextNode == tailer);
	}

	
	public int size() {
		int size = 0;
		for (DNode<E> nodeIt = header.nextNode; nodeIt != tailer; nodeIt = nodeIt.nextNode) {
			++size;
		}
		return size;
	}

	
	public void addFirst(E elem) {
		DNode<E> newNode = new DNode<E>(elem);
		newNode.nextNode = header.nextNode;
		newNode.previousNode = header;
		header.nextNode.previousNode = newNode;
		header.nextNode = newNode;
	}

	public void addLast(E elem) {
		DNode<E> newNode = new DNode<E>(elem);
		newNode.nextNode = tailer;
		newNode.previousNode = tailer.previousNode;
		tailer.previousNode.nextNode = newNode;
		tailer.previousNode = newNode;
	}

	@Override
	public E removeFirst() {
		if (isEmpty()) {
			System.out.println("DQueue: Queue is empty");
			return null;
		}
		E e=getFirst();
		header.nextNode = header.nextNode.nextNode;
		header.nextNode.previousNode = header;
		return e;
	}

	@Override
	public E removeLast() {
		if (isEmpty()) {
			System.out.println("DQueue: Queue is empty");
			return null;
		}
		E e=getLast();
		tailer.previousNode = tailer.previousNode.previousNode;
		tailer.previousNode.nextNode = tailer;
		return e;
	}

	public E getFirst() {
		if (isEmpty()) {
			System.out.println("DQueue: Queue is empty");
			return null;
		}
		return header.nextNode.getElement();
	}

	public E getLast() {
		if (isEmpty()) {
			System.out.println("DQueue: Queue is empty");
			return null;
		}
		return tailer.previousNode.getElement();
	}
	
	public String toString(){
		String str = null;
		if(!this.isEmpty()){
			str = "[ ";
			for(DNode<E> nodeIt=this.header.getNextNode();nodeIt!=this.tailer;nodeIt=nodeIt.getNextNode()){
				str += nodeIt.getElement()+" ";
			}
			str += "]";
		}
		return (str == null) ? "It is empty" : str;
	}

}
