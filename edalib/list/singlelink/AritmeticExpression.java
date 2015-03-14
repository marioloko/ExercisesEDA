package edalib.list.singlelink;

public class AritmeticExpression extends Stack<Character>{
	private char[] charArr; //Char array where store the splitString
	
	public AritmeticExpression(String word){
		this.charArr = word.toCharArray(); //Fill the char array
	}
	
	/**Verify if the aritmetic expression enter as parameter in the constructor is valid
	 * or not, return true or false
	 * @return
	 */
	public boolean verify(){
		for(int pos=0;pos<this.charArr.length;pos++){ //Check for each element of the array if it is an opening sign or a close sign
			if(this.charArr[pos]=='[' || this.charArr[pos]=='{' || this.charArr[pos]=='('){ //If it is a opening sign then it add to the stack
				this.push(new Character(charArr[pos]));
			}else if(charArr[pos]==']'){//If is a close sign different to the first element of the stack then the expression is not correct
				if(this.isEmpty() || !this.pop().equals('[')){
					return false;
				}
			}else if(charArr[pos]==')'){
				if(this.isEmpty() || !this.pop().equals('(')){
					return false;
				}
			}else if(charArr[pos]=='}'){
				if(this.isEmpty() || !this.pop().equals('{')){
					return false;
				}
			}
		}
		return (this.isEmpty()); //If at the end of the array the stack is empty then the expression is correct
	}
}