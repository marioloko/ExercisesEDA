package recursianExercises;

public class CaesarCipherTest{
	public static void main(String[] args){
		CaesarCipher caesarCipher = new CaesarCipher();
		System.out.println(caesarCipher.iterativeCipher("Hola que ases?"));
		System.out.println(caesarCipher.recursiveCipher("Hola que ases y x z w?"));
	}
}