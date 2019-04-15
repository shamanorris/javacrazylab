package test;

public class VarArgsTests {

	public static void main(String[] args) {
		VarArgsTests test = new VarArgsTests();
		test.printArgs("A", "B", "C", "D");
		test.printArgs((String) null);
	}

	public void printArgs(String ... strings){
		System.out.println(strings[0] );
	}
	
}

class Animal<T>{
	
	
}