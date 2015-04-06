package recursianExercises;

public class CaesarCipher{
	
	/**Cipher an String using caesar cipher in an iterative form
	 * 
	 * @param stringToCipher: Is the string that will be cipher using the caesar cipher
	 * @return: The ciphered String
	 */
	public String iterativeCipher(String stringToCipher){
		String cipherString = null;
		
		if(stringToCipher!=null){
			cipherString = ""; 
			
			int low = 'A'; //The lower bound is the ascii code of the A(65)
			int sup = 'Z'+1; //The upper bound is the ascii code of the Z plus 1(91)
			
			char[] charArrayToCipher = stringToCipher.toUpperCase().toCharArray(); //Convert the String into an upper case char array
			
			for(int pos=0;pos<charArrayToCipher.length;pos++){
				char cipherChar = charArrayToCipher[pos];
				cipherChar = (char)((cipherChar - low + 3)%(sup-low)+low); //For each character of the string will calculate the following three position character
				cipherString += cipherChar;
			}
		}
		return cipherString;
	}
	
	/**Initialize the process of the recursive caesar cipher
	 * 
	 * @param stringToCipher: Is the String that will be cipher
	 * @return: Is the ciphered String
	 */
	public String recursiveCipher(String stringToCipher){
		if(stringToCipher!=null){
			stringToCipher = stringToCipher.toUpperCase(); 
			return recursiveCipher(stringToCipher,0); //Call itself recursively seting the String to cipher to upper case an the initial position to 0
		}
		return null;
	}
	
	/**Is the process of cipher recursively an String
	 * 
	 * @param stringToCipher: Is the string that will be cipher
	 * @param pos: Is the position of the next character to be cipher
	 * @return: The ciphered String
	 */
	private String recursiveCipher(String stringToCipher,int pos){
		String cipherString = "";
		int low = 'A'; //The character lower bound of the String is A upper case(65)
		int sup = 'Z'+1; //The character upper bound of the String is Z upper case plus 1
		if(pos<stringToCipher.length()){
			cipherString += (char)((stringToCipher.charAt(pos) - low +3)%(sup - low)+low); //Calculate the character that is three letters after the current character
			cipherString += recursiveCipher(stringToCipher, pos+1); //Call recursively this method until the String end is reached
		}
		return cipherString;
	}
}