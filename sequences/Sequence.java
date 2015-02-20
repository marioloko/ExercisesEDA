package sequences;

public class Sequence{
	protected long first;
	protected long last;
	//The protected attributes can only be accesse from the class and from the subclass
	
	public Sequence(){
		this.first = 0;
		this.last = 0;
	}
	
	public long initialize(){
		last=first;
		return last;
	}
	
	protected long nextTerm(){
		last++;
		return last;
	}
	
	public void printSequence(int n){
		System.out.print(initialize() + " ");
		for (int sequence=1; sequence < n; sequence++){
			System.out.print(nextTerm() + " ");
		}
		System.out.println();
		System.out.println();
	}
}