package exercise2;

public interface ISet<E>{
	/**
	 * Check if the Set is empty
	 * @return true if the set is empty
	 */
	boolean isEmpty();
	
	/**
	 * Add a new element to the Set if it has not been added before
	 * @param element, is the element to add to the set
	 * @return true if the operation has been successfully
	 */
	boolean addElement(E element);
	
	/**
	 * Delete the indicated element of the Set
	 * @param element, is the element to be remove from the Set
	 * @return true if the operation has been successfully
	 */
	boolean deleteElement(E element);
	
	/**
	 * Return the actual size of the Set
	 * @return
	 */
	int getCardinality();
	
	/**
	 * Check if a number belongs to the Set
	 * @param element, is the element to check if belongs to the set
	 * @return true if the element belongs to the set
	 */
	boolean belongs(E element);
	
	/**
	 * Check if two Sets are equal
	 * @param otherSet, other set to compare if is equal to our set
	 * @return true if both sets are equal
	 */
	boolean equals(ISet<E> otherSet);
	
	/**
	 * Check if our set is a subset of  otherSet
	 * @param otherSet
	 * @return true if our set is subset of the other set
	 */
	boolean isSubset(ISet<E> otherSet);
	
	/**
	 * Check if our set is a superset of otherSet
	 * @param otherSet
	 * @return true if our set is superset of otherSet
	 */
	boolean isSuperset(ISet<E> otherSet);
	
	/**
	 * Return the union between our set and other set
	 * @param otherSet
	 * @return
	 */
	ISet<E> union(ISet<E> otherSet);
	
	/**
	 * Return the intersection between our set and other set
	 * @param otherSet
	 * @return
	 */
	ISet<E> intersection(ISet<E> otherSet);
	
	/**
	 * Return the difference between our set and other set
	 * @param otherSet
	 * @return
	 */
	ISet<E> difference(ISet<E> otherSet);
}