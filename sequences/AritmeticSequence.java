package sequences;

public class AritmeticSequence extends Sequence{
	public long incrementRatio;
	
	public AritmeticSequence(long incrementRatio){
		this.incrementRatio = incrementRatio;
	}
	
	public AritmeticSequence(){
		this(1);
	}
	
	public long nextTerm(){
		last += incrementRatio;
		return last;
	}
	
	public void printSequence(int n){
		System.out.println("Calculating Aritmetic Sequence with increment ratio: "+incrementRatio);
		super.printSequence(n);
	}
}