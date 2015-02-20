package exercise3;

public class Test{
	public static void main(String[] args){
		Complex complex = new Complex(3, 4);
		Complex comp2 = new Complex(6,8);
		System.out.println(complex.getModule());
		Complex comp3 = (Complex)complex.sum(comp2);
		System.out.println(comp3.getReal());
		System.out.println(comp3.getImaginary());
		Complex comp4 = (Complex)complex.multiplication(comp2);
		System.out.println(comp4.getReal());
		System.out.println(comp4.getImaginary());
	}
}