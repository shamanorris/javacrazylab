package test.lists;

import java.util.ArrayList;
import java.util.List;

public class ListMethods {

	public static void main(String args[]){
		List<String> list = new ArrayList<String>();
		list.add("bruno");
		list.add("bruna");
		list.clear();
		System.out.println(list);
	}
}
