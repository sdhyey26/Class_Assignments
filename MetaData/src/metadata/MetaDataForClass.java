package metadata;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class MetaDataForClass {
	public static void main(String[] args) throws ClassNotFoundException {

			Class stringClass = Class.forName("java.lang.String");

			Method methods[] = stringClass.getMethods();

			for(Method method: methods)
			{
				System.out.println(method.getName()+"\t"+method.getParameterCount());

				Parameter parameters[] = method.getParameters();

				for(Parameter parameter: parameters) {
					System.out.println(parameter.getName() +"\t"+ parameter.getType());
				}
				
				Constructor constructors[]= stringClass.getConstructors();
				
				for(Constructor constructor : constructors)
				{
					System.out.println(constructor.getName() +"\t"+constructor.getParameterCount());
					Parameter parameterss[] = constructor.getParameters();
					for(Parameter parameter : parameterss)
					{
						System.out.println(parameter.getName()+" \t"+parameter.getType());
					}
				}
			}
	}
}
