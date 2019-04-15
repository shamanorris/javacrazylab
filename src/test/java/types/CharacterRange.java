package types;

public class CharacterRange {

	public static void main(String args[]){
		int total = 0;
		total += printCaracteres(45,45);
		total += printCaracteres(97,122);
		total += printCaracteres(65,90);
		total += printCaracteres(95,95);
		total += printCaracteres(48,57);
		System.out.println("total " + total);
	}
	
	public static int printCaracteres(int rangeMin, int rangeMax){
		int amount = rangeMax - rangeMin + 1;		
		for (int caractere = rangeMin; caractere <= rangeMax; caractere++){
			char character = (char) caractere;
			System.out.println("caractere numero " + caractere + " = '" + character + "'");
		}
		return amount;
	}
}