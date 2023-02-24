package javaHigh06.example10;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PrintAnnotationExample {
	public static void main(String[] args)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method[] declaredMethods = Service.class.getDeclaredMethods();

		for (Method method : declaredMethods) {
			
			PrintAnnotation printAnnotation = method.getAnnotation(PrintAnnotation.class);
			System.out.println(printAnnotation);
			printLine(printAnnotation);

			method.invoke(new Service());

			printLine(printAnnotation);
		}
	}

	public static void printLine(PrintAnnotation printAnnotation) {
		if (printAnnotation != null) {
			int number = printAnnotation.number();
			for (int i = 0; i < number; i++) {
				String value = printAnnotation.value();
				System.out.print(value);
			}
		}
		System.out.println();
	}
}
