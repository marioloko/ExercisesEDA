package recursianExercises;

public class TestReversedArray{
	public static void main(String[] args){
		System.out.println("Testing reversing array:");
		ReversedArray reversed = new ReversedArray("Hola Mundo");
		reversed.printArray();
		reversed.reverseArray();
		reversed.printArray();
		
		System.out.println("Testing reversing SList:");
		ReversedSList reversedSList = new ReversedSList("Hola Mundo");
		reversedSList.printArray();
		reversedSList.reverseSList();
		reversedSList.printArray();
		
		System.out.println("Testing reversing DList:");
		ReversedDList reversedDList = new ReversedDList("Hola Mundo");
		reversedDList.printArray();
		reversedDList.reverseDList();
		reversedDList.printArray();
	}
}