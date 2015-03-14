


package edalib.list.interfaces;

public interface IStack<E> {

	public boolean isEmpty();

	public void push(E elem);

	public E pop();

	public E top();
	
	public int getSize();

}
