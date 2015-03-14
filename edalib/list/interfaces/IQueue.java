package edalib.list.interfaces;

public interface IQueue<E> {

	public boolean isEmpty();

	public void enqueue(E elem);

	public E dequeue();

	public E front();
	
	public int getSize();

}
