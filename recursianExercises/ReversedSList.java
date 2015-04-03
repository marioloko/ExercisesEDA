package recursianExercises;

import edalib.list.singlelink.SList;

public class ReversedSList{
	
	private SList<Character> characterList;
	 
	/**Initialize the arrayList with the String enter as parameter
	 * 
	 * @param characters String to fill the single list
	 */
	public ReversedSList(String characters){
		if(characters==null || characters.length() == 0){
			System.out.println("ERROR: There is no String inside.");
			return;
		}

		characterList = new SList<Character>(); //Create a new character list
		for(int pos=0;pos<characters.length();pos++){ //Add each element of the array to the single list
			characterList.addLast(characters.charAt(pos));
		}
	}
	
	/**
	 * Print the SList
	 */
	public void printArray(){
		System.out.println("[ "+characterList.toString()+"]");
	}
	
	/**Initialize the reverse process
	 * 
	 * @return
	 */
	public void reverseSList(){
		 reverseSList(0, characterList.getSize()-1);
	}
	
	/**Reverse the single list, calling the function recursively
	 * 
	 * @param init: Initial position to change by the final position
	 * @param end: Final position to change by the initial position
	 * @return
	 */
	private void reverseSList(int init, int end){
		if(init < 0 || end < 0){
			System.out.println("ERROR: Index out of bounds");
			return;
		}
		
		if(init < end){ 
			
			//Store the initial and final variable in an auxiliar variables
			Character oldInit = new Character(characterList.getAt(init));
			Character oldEnd = new Character(characterList.getAt(end));
		
			characterList.removeAt(init); //Remove the initial variable and insert the old one in that position
			characterList.insertAt(init, oldEnd);		
		
			characterList.removeAt(end); //Remove the final position and insert the initial one at end
			characterList.insertAt(end, oldInit);

			reverseSList(init+1,end-1);
		}
	}
}