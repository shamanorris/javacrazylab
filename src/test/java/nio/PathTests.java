package nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class PathTests {

	public static void main (String args[]){
		try {
			Path path = Paths.get("C://ws//testpath.pdf");
			Files.write(path, "abcdefghijklmopqrstuvxzwy".getBytes(), StandardOpenOption.APPEND);
			
			System.out.println(path.getFileName().toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
