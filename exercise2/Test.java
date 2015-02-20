package exercise2;

public class Test{
	public static void main(String[] args){
		Set<Character> cto1 = new Set<Character>(10);
		for(char character='a';character<='d';character++){
			cto1.addElement(character);
		}
		cto1.show();
		cto1.deleteElement('c');
		cto1.show();
		System.out.println(cto1.belongs('d'));
		System.out.println(cto1.isEmpty());
		Set<Character> cto2 = new Set<Character>(10);
		cto2.addElement('b');
		cto2.addElement('d');
		cto2.addElement('a');
		cto2.show();
		System.out.println(cto2.getCardinality());
		System.out.println(cto1.equals(cto2));
		for(char character='a';character<='g';character++){
			cto1.addElement(character);
		}
		cto2.addElement('m');
		cto1.show();
		cto2.show();
		Set<Character> cto3 = (Set<Character>)cto1.union(cto2);
		cto3.show();
		System.out.println(cto1.isSubset(cto3));
		System.out.println(cto3.isSuperset(cto2));
		Set<Character> cto4 = (Set<Character>)cto2.intersection(cto1);
		cto4.show();
		Set<Character> cto5 = (Set<Character>)cto1.difference(cto2);
		cto5.show();
	}
}