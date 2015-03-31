package recursianExercises;

import edalib.list.doublylinked.DList;

public class ReversedDList{
	
	private DList<Character> characterList;
	
	/**Initialize the characterList with a String given as parameter
	 * 
	 * @param characters: String to initialize the characterList
	 */
	public ReversedDList(String characters){
		if((characters == null)||(characters.length() == 0)){ //If the length is 0 or there is no String then print an error
			System.out.println("ERROR: Wrong String!");
			return;
		}
		
		characterList = new DList<Character>();
		for(int pos=0; pos<characters.length(); pos++){ //Fill the characterList with each character of the String
			characterList.addLast(new Character(characters.charAt(pos)));
		}
	}
	
	/**
	 * Print the actual characterList
	 */
	public void printArray(){
		System.out.println("[ "+characterList.toString()+"]");
	}	
	
	/**
	 * Initialize the reverse process
	 */
	public void reverseDList(){
		reverseDList(0,characterList.getSize()-1);
	}
	
	/**Do the reverse process using recursive methods
	 * 
	 * @param init: The initial variable which will be change by the final one
	 * @param end: The final variable which will be change by the initial one
	 */
	private void reverseDList(int init, int end){
		if((init < 0)||(end < 0)){ //If the initial or final position are negative integers then print an error
			System.out.println("ERROR: Index out of bounds");
			return;
		}
		
		if(init<end){ //If init is greater or equeal than end then execute the base case
			
			//Store the init and end variables in auxiliar variables
			Character oldInit = characterList.getFirst();
			Character oldEnd = characterList.getLast();

			//Remove the first and the last element
			characterList.removeFirst();
			characterList.removeLast();
			
			//Call recursively this method until only one are there one or zero elements in the list
			reverseDList(init+1, end-1);
			
			//Add again each element in the oppose position
			characterList.addFirst(oldEnd);
			characterList.addLast(oldInit);
		}
	}
}