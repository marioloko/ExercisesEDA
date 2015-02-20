package sequences;

public class GeometricSequence extends Sequence{
	public long ratio;
	
	public GeometricSequence(long ratio){
		this.first = 1;
		this.ratio=ratio;
	}
	
	public GeometricSequence(){
		this(2);
	}
	
	public long nextTerm(){
		this.last*=this.ratio;
		return this.last;
	}
	
	public void printSequence(int n){
		System.out.println("Calculating Geometric Sequence with ratio: "+ratio);
		super.printSequence(n);
	}
	
}