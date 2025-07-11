package metadata;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class StringUsingInstanceOF {
	public static void main(String[] args) {
        Constructor<String> constructor = null;
		try {
			constructor = String.class.getDeclaredConstructor(char[].class);
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        constructor.setAccessible(true);
        
        String str = null;
		try {
			str = constructor.newInstance(new char[]{'H', 'e', 'l', 'l', 'o'});
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        System.out.println(str); 
	}
}
