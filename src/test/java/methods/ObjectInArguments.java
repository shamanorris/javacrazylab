package methods;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ObjectInArguments {

	public static void main(String[] args) throws IOException {
		Caller caller = new Caller();
		byte[] myBytes = "ABCDEF".getBytes();
		caller.methodUsingBytes(myBytes);
		System.out.println(new String(myBytes));
		
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		os.write(myBytes);
		caller.methodUsingBytes(myBytes);
		System.out.println(os.toString());
		
		
	}

}

	class Caller{
	
		public void methodUsingBytes(byte[] bytes){
			bytes = "12345".getBytes();
			System.out.println(new String(bytes));
		}
		
		public void methodUsingOutputStream(OutputStream os) throws IOException{
			os.write("12345".getBytes());
			System.out.println(os.toString());
		}		
}


