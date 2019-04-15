package collections.hashmap;

import java.util.HashMap;
import java.util.Map;

public class HashMapSwitch {

	public static void main(String args[]){
		Map<String, String> formats = new HashMap<String, String>();
		formats.put("aa", "bb");
		String format = formats.get("aa");
		System.out.println(format);
	}
}
