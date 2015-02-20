package sequences;

public class Test{
	public static void main(String[] args){
		AritmeticSequence first = new AritmeticSequence(5);
		AritmeticSequence second = new AritmeticSequence(3);
		AritmeticSequence third = new AritmeticSequence();
		GeometricSequence fourth = new GeometricSequence();
		GeometricSequence fifth = new GeometricSequence(3);
		FibonacciSequence sixth = new FibonacciSequence(4, 7);
		Sequence seventh = new Sequence();
		/*first.printSequence(10);
		second.printSequence(10);
		third.printSequence(10);
		fourth.printSequence(10);
		fifth.printSequence(10);
		sixth.printSequence(10);*/
		((AritmeticSequence)first).printSequence(10);
		seventh = first;
		((Sequence)seventh).printSequence(10);
	}
}