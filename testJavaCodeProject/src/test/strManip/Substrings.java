package test.strManip;

public class Substrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filenameExt = "000447424_NdgDoc.pdf";
		subFilename(filenameExt);
		subLastNDigits(5, filenameExt); 
	}
	
	public static void subLastNDigits(int n, String value){
		value = value.substring(value.length() - n );
		System.out.println(value);
	}
	public static void subFilename(String filenameExt){
		filenameExt = filenameExt.substring(0, filenameExt.lastIndexOf("."));
		System.out.println(filenameExt);
	}
}
