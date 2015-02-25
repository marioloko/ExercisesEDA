package edalib.list.interfaces;

public interface IList<E> {
	/**
	 * Add a new node at the begining of the list with the desired element
	 * @param newElem
	 */
	public void addFirst(E newElem);

	/**
	 * Add a new node at the end of the list with the desired element
	 * @param newElem
	 */
	public void addLast(E newElem);

	/**
	 * Insert a node in the index position desired with the element given as parameter
	 * @param index
	 * @param newElem
	 */
	public void insertAt(int index, E newElem);

	/**
	 * Check if the list is empty 
	 * @return
	 */
	public boolean isEmpty();

	/**
	 * Check if the list contain a node with the element enter as parameter
	 * @param elem
	 * @return
	 */
	public boolean contains(E elem);

	/**
	 * Return the number of nodes of the array
	 * @return
	 */
	public int getSize();

	/**
	 * Return the index of node with the elements equal to the enter as parameter
	 * @param elem
	 * @return
	 */
	public int getIndexOf(E elem);

	/**
	 * Return the element of the first node of the list
	 * @return
	 */
	public E getFirst();

	/**
	 * Return the element of the last node of the list
	 * @return
	 */
	public E getLast();

	/**
	 * Return the element of the node enter as paramater
	 * @param index
	 * @return
	 */
	public E getAt(int index);

	/**
	 * Remove the first node of the list
	 */
	public void removeFirst();

	/**
	 * Remove the last node of the list
	 */
	public void removeLast();

	/**
	 * Remove all the nodes of the list with the elements equals as the entered as parameter
	 * @param elem
	 */
	public void removeAll(E elem);

	/**
	 * Remove the node at the position entered as parameter
	 * @param index
	 */
	public void removeAt(int index);

}
