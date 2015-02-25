package edalib.list.singlelink;

public class Test{
	public static void main(String[] args){
		SList<Integer> list = new SList<Integer>();
		for(int elem=0;elem<10;elem++){
			list.addLast(elem);
		}
		list.insertAt(0, 5);
		list.printList();
		System.out.println(list.contains(11));
		list.removeLast();
		list.removeLast();
		list.printList();
		list.removeAll(5);
		list.removeAll(7);
		list.printList();
		list.removeAt(0);
		list.printList();
		list.removeAt(5);
		list.printList();
		System.out.println(list.getSize());
		System.out.println(list.getIndexOf(6));
		System.out.println(list.getFirst());
		System.out.println(list.getLast());
		System.out.println(list.getAt(3));
		list.removeLast();
		list.removeLast();
		list.removeLast();
		list.removeLast();
		list.removeLast();
		System.out.println(list);
		SListTail<Integer> tailList = new SListTail<Integer>();
		for(int pos=0;pos<10;pos++){
			tailList.addLast(pos);
		}
		tailList.printList();
		System.out.println(tailList.getLast());
		for(int pos=0;pos<10;pos++){
			tailList.removeLast();
		}
		System.out.println(tailList.getLast());
		System.out.println(tailList);
		for(int pos=0;pos<10;pos++){
			tailList.addFirst(pos);
		}
		System.out.println(tailList.getLast());
		tailList.removeAll(0);
		tailList.printList();
		System.out.println(tailList.getLast());
		tailList.removeLast();
		tailList.removeLast();
		tailList.printList();
		System.out.println(tailList.getLast());
		tailList.removeAt(0);
		tailList.printList();
		tailList.removeAt(5);
		tailList.printList();
		System.out.println(tailList.getLast());
		tailList.insertAt(0, 11);
		tailList.printList();
		tailList.insertAt(6,11);
		tailList.printList();
		System.out.println(tailList.getLast());
		ListIntegers listIntegers = new ListIntegers();
		for(int pos=0;pos<10;pos++){
			listIntegers.addLast(pos);
		}
		System.out.println(listIntegers.addition());
		for(int pos=0;pos<listIntegers.even().length;pos++){
			System.out.println(listIntegers.even()[pos]);
		}
	}
}