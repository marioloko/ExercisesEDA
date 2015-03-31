package recursianExercises;

public class RussianMethod{
	
	/**Calculate the multiplication of two numbers using recursivity
	 * 
	 * @param multiplierOne is the first term for doing the russian multiplication
	 * @param multiplierTwo is the second term for doing the russian multiplication
	 * @return the product between the number entered as parameter
	 */
	public int russianMultiplication(int multiplierOne, int multiplierTwo){
		if(multiplierOne == 1){ //When the multiplier is one it has reach the limit, and start returning values
			int product = multiplierOne * multiplierTwo;
			return product;
		}
		int product = ((multiplierOne%2)*multiplierTwo) + russianMultiplication(multiplierOne/2, multiplierTwo*2); //If the multiplier is odd then multiply it by two and add to it the recursive methods
		return product;
	}
}

