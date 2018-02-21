package test.characters;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SpecialCharacters {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < '\uffff'; i++){
			char letra = (char) i;
			sb.append("letra #" + i + ": " +  letra + "\n");
		}	
		
		Path path = Paths.get("c:/ws/characterlist.txt");
		try {
			if(Files.exists(path)){
				Files.delete(path);
			}
			Files.write(path, sb.toString().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
