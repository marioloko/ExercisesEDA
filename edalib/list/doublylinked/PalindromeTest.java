package edalib.list.doublylinked;
import java.util.Scanner;

public class PalindromeTest{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter a word.");
		sc.useDelimiter(System.getProperty("line.separator"));
		String word = sc.next();
		Palindrome palindrome = new Palindrome(word);
		palindrome.isPalindrome();
	}
}