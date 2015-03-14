package edalib.list.interfaces;

public interface IDQueue<E> {
	public boolean isEmpty();
	public int size();

	public void addFirst(E elem);
	public void addLast(E elem);

	public E removeFirst();
	public E removeLast();
	
	
	public E getFirst();
	public E getLast();
	
}
