package recursianExercises;

public class ReversedArray{
	
	private char[] charArray;

	/**Store each char of the String in a position of the char Array
	 * 
	 * @param characters: String that will be split into the field char array
	 */
	public ReversedArray(String characters){
		charArray = characters.toCharArray(); //Split the String into a char array
	}
	
	/**
	 * Print the charArray
	 */
	public void printArray(){
		System.out.print("[ ");
		for(int pos=0;pos<charArray.length;pos++){
			System.out.print(charArray[pos]+" ");
		}
		System.out.println("]");
	}
	
	/**Initialize the reversed array proccess 
	 *  
	 * @param array, is the array to be reversed
	 * @return the reverse array
	 */
	public void reverseArray(){
		reverseArray(0,charArray.length-1);
	}
	
	/**Reverse the array recursively changing each position with
	 * the correspondant position at the end of the array
	 * 
	 * @param array Array to be reversed
	 * @param init Position of the array that will be changed by the end position
	 * @param end Position of the array that will be changed by the init position
	 * @return The array reversed
	 */
	private void reverseArray(int init, int end){
		if(init < 0 || end < 0){//If the index are negatives print an error
			System.out.println("ERROR: The index must be positive numbers");
			return;
		}
		
		if(init<end){ //When the init position is larger or equal than the end position return the array without changing(base case)

			//Changes the init position by the end position using an auxiliar variable
			char aux = charArray[init]; 
			charArray[init] = charArray[end];
			charArray[end] = aux;
			reverseArray(init+1, end-1); //Call recursively this method until the base case is reached
		}
	}
}