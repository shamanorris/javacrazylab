package jvm;

public class CheckJvm {

	public static void main(String[] args) {
		System.out.println(System.getProperty("os.arch"));
		try {
			Thread.sleep(13333333333333333L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
