package edalib.list.doublylinked;

import edalib.list.interfaces.IList;

public class Test {

	public static void main(String[] args) {
		// incomplete test
		IList<String> list = new DList<String>();
		System.out.println(list);
		list.addLast("1");
		System.out.println(list);
		list.addFirst("2");
		System.out.println(list);
		list.addFirst("3");
		System.out.println(list);
		list.addLast("4");
		System.out.println(list);
		list.removeLast();
		System.out.println(list);
		list.removeFirst();
		System.out.println(list);
		list.removeFirst();
		System.out.println(list);
		list.removeLast();
		System.out.println(list);
		
		//Contains
		list.addFirst("2");
		System.out.println(list.contains("2"));
		System.out.println(list.contains("1"));
		
		//Get index
		list.addFirst("3");
		list.addLast("0");
		list.addFirst("3");
		list.addFirst("3");
		list.addLast("3");
		list.addLast("1");
		list.addLast("3");
		list.addLast("3");
		list.addLast("3");
		System.out.println(list.getIndexOf("3"));
		System.out.println(list.getIndexOf("2"));
		System.out.println(list.getIndexOf("0"));
		System.out.println(list.getIndexOf("1"));
		System.out.println(list);
		System.out.println(list.getSize());
		list.removeAll("3");
		System.out.println(list);
		
		//Get Size
		System.out.println(list.getSize());
		
		//Get Last
		System.out.println(list.getLast());
		
		//Get First
		System.out.println(list.getFirst());
		
		//Get At
		System.out.println(list.getAt(1));
		System.out.println(list.getAt(3));
	}
}
