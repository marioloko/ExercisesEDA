package edalib.list.singlelink;

public class SNode<E> {

	E elem;
	public SNode<E> nextNode = null;
	
	public SNode(E e) {
		elem = e;
	}
	public SNode(E elem, SNode<E> nextNode) {
		this.elem = elem;
		this.nextNode = nextNode;
	}
	public E getElement() {
		return elem;
	}

	public SNode<E> getNextNode() {
		return nextNode;
	}
	public void setElement(E e) {
		this.elem = e;
	}
	public void setNextNode(SNode<E> nextNode) {
		this.nextNode=nextNode;
	}
}
