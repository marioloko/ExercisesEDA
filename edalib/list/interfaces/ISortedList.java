package edalib.list.interfaces;

public interface ISortedList<E extends Comparable<E>> {

	public void add(E newElem);

	// public void addFirst(E newElem);
	//
	// public void addLast(E newElem);
	//
	// public void insertAt(int index, E newElem);

	public boolean isEmpty();

	public boolean contains(E elem);

	public int getSize();

	public int getIndexOf(E elem);

	public E getFirst();

	public E getLast();

	public E getAt(int index);

	public void removeFirst();

	public void removeLast();

	public void removeAll(E elem);

	public void removeAt(int index);

	// public IListIterator<E> createIterator();

}
