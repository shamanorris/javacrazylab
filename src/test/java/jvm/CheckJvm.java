package jvm;

public class CheckJvm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(System.getProperty("os.arch"));
		try {
			Thread.sleep(13333333333333333L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
