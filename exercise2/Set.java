package exercise2;

public class Set<E> implements ISet<E>{
	E[] elements;
	int nextToAdd;
	
	public Set(int size){
		if(size<=0){
			return;
		}
		this.elements = (E[])new Object[size];
		this.nextToAdd=0;
	}
	
	@Override
	public boolean isEmpty(){
		if(nextToAdd==0){
			return true;
		}
		return false;
	}
	
	@Override
	public boolean belongs(E element){
		if(this.isEmpty()){ //If the set is empty then the number does not belongs to the set
			return false;
		}
		for(int pos=0;pos<this.nextToAdd;pos++){ //Check any number of the set
			if(element.equals(this.elements[pos])){ //If the element is equal to any number of the set return true
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean addElement(E element){
		if(this.belongs(element) || this.nextToAdd==this.elements.length){ //If the elements does not belong to the set and the elements array is not fullfill then add the element
			return false;
		}
		this.elements[this.nextToAdd] = element;//Add the element in the next position
		this.nextToAdd++;//The next position is one position more
		return true;
	}
	
	@Override
	public boolean deleteElement(E element){
		if(!this.belongs(element)){
			return false;
		}
		boolean deleted=false; //By default the element is not deleted
		for(int posElem=0;posElem<this.nextToAdd && !deleted;posElem++){ //Search for the element to remove
			if(element.equals(this.elements[posElem])){
				for(int changePos=posElem;changePos<this.nextToAdd-1;changePos++){
					this.elements[changePos] = this.elements[changePos+1];//Delete the element and rotate each element a position before
				}
				deleted=true;
				this.nextToAdd--;
			}
		}
		return deleted; //Return if the element has been deleted
	}
	
	@Override
	public int getCardinality(){
		return this.nextToAdd;
	}
	
	@Override
	public boolean equals(ISet<E> otherSet){
		if(this.nextToAdd!=otherSet.getCardinality()){//If both set has not the same size then they are not equals
			return false;
		}
		for(int pos=0;pos<this.nextToAdd;pos++){
			if(!otherSet.belongs(this.elements[pos])){//If any number of this set does not belongs to the other set they are not equals
				return false;
			}
		}
		return true;
	}
	
	@Override
	public boolean isSubset(ISet<E> otherSet){
		for(int pos=0;pos<this.nextToAdd;pos++){
			if(!otherSet.belongs(this.elements[pos])){ //If any number of our set does not belong to the other set then is not a subset of that
				return false;
			}
		}
		return true;
	}
	
	@Override
	public boolean isSuperset(ISet<E> otherSet){
		return otherSet.isSubset(this); //If otherSet is a subset of this, then it is a superset of that
	}
	
	@Override
	public ISet<E> intersection(ISet<E> otherSet){
		Set<E> intersectionSet = new Set<E>(this.getCardinality()); //Create a new union set with the length of our set
		for(int pos=0; pos<this.nextToAdd;pos++){
			if(otherSet.belongs(this.elements[pos])){ //If an element belongs to both set add it to the intersection set
				intersectionSet.addElement(this.elements[pos]);
			}
		}
		return intersectionSet;
	}
	
	@Override
	public ISet<E> difference(ISet<E> otherSet){
		Set<E> differenceSet = new Set<E>(this.nextToAdd); //Create a new union set with the length of our set
		for(int pos=0; pos<this.nextToAdd;pos++){
			if(!otherSet.belongs(this.elements[pos])){//If a element of our set does not belong to the other set then add to the difference set
				differenceSet.addElement(this.elements[pos]);
			}
		}
		return differenceSet;
	}
	
	/**
	 * Store each element of the set in an array
	 * @return
	 */
	public E[] toArray(){
		E[] array = (E[])new Object[this.nextToAdd];
		for(int pos=0;pos<this.nextToAdd;pos++){
			array[pos] = this.elements[pos];
		}
		return array;
	}
	
	@Override
	public ISet<E> union(ISet<E> otherSet){
		Set<E> unionSet = new Set<E>(otherSet.getCardinality()+this.nextToAdd);
		Set<E> other = (Set<E>)otherSet;
		E[] otherSetArr = other.toArray();
		for(int pos=0; pos<this.nextToAdd;pos++){
			unionSet.addElement(this.elements[pos]);
		}
		for(int pos=0;pos<otherSetArr.length;pos++){
			unionSet.addElement(otherSetArr[pos]);
		}
		return unionSet;
	}
	
	/**
	 * Show the elements of the array
	 */
	public void show(){
		for(int pos=0;pos<this.nextToAdd;pos++){
			System.out.print(this.elements[pos]+" ");
		}
		System.out.println();
	}
	
}
