package edalib.list.doublylinked;

/**
 * 
 * @author Adrián Gallego Castellanos
 *
 */
public class Palindrome extends DList<Character>{

	public Palindrome(String word){
		word = word.toLowerCase();//We change all characters to lower case to avoid errors
		for(int pos=0;pos<word.length();pos++){
			char character = word.charAt(pos);
			if(character!=' '){//If the character is not a space add it to the last position of the list
				this.addLast(word.charAt(pos));
			}
		}
	}
	
	/**
	 * Check if the word stored in the list is a palindrome or not
	 */
	public void isPalindrome(){
		String wordRight = ""; //Create an string to store the word writen from left to right
		for(DNode<Character> nodeIt=this.getFirstNode();
				nodeIt!=this.getTrailer();nodeIt=nodeIt.getNextNode()){
			wordRight += nodeIt.getElement(); //Store each element in the String like an only word
		}
		
		String wordLeft = ""; //Create an string to store the word written from right to left
		for(DNode<Character> nodeIt=this.getLastNode();
				nodeIt!=this.getHeader();nodeIt=nodeIt.getPreviousNode()){
			wordLeft += nodeIt.getElement(); //Store each element in the String reversed, like an only word
		}
		if(wordRight.equals(wordLeft)){ //If the word is the same written from left to right than from right to left then it is a palindrome
			System.out.println("It is a palindrome!!!");
		}else{ //Else it is not
			System.out.println("It is not a palindrome...");
		}
	}
}