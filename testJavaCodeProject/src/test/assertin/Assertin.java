package test.assertin;

/**
 * Assertions should be used for public methods where you don't want to validate invalid input and throw an exception instead.
 * To enable it, use the VM argument <strong>-ea</strong> or <strong>-enableassertions</strong>
 * @author BOCA
 *
 */
public class Assertin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		assert 1 == 3;
			System.out.println("1 is equal 3");
		
	}

}
