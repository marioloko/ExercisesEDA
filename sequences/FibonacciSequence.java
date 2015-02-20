package sequences;

public class FibonacciSequence extends Sequence{
	public long auxTerm;
	
	public FibonacciSequence(long first, long second){
		this.first = first;
		this.auxTerm = second;
		this.last += second;
	}
	
	public FibonacciSequence(){
		this(0, 1);
	}
	public long nextTerm(){
		long aux = this.last;
		this.last+= this.auxTerm;
		this.auxTerm = aux;
		return this.last;
	}
	
	public void printSequence(int n){
		System.out.println("Calculating Fibbonacci Sequence with terms: "+this.first+", "+this.last);
		super.printSequence(n);
	}
	
}