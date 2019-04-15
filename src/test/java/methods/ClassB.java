package methods;

import java.util.HashSet;
import java.util.Set;

public class ClassB<T extends DataType> {

	public Set<T> findBy(String index, Object... keys){
		System.out.println("hi");
		return new HashSet<T>();
	}
}
