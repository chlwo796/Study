package javaHigh06.example03;

import java.util.Collection;
import java.util.Iterator;
import java.util.Properties;

public class GetPropertyExample {
	public static void main(String[] args) {
		String osName = System.getProperty("os.name");
		String userName = System.getProperty("user.name");
		String userHome = System.getProperty("user.home");
		String javaHome = System.getProperty("java.home");
		String userDir = System.getProperty("user.dir");
		String jsversion = System.getProperty("java.specification.version");
		
		System.out.println(osName + "\n" + userName + "\n" + userHome + "\n" + javaHome);
		System.out.println(userDir + "\n" + jsversion);
		
		Properties pp = System.getProperties();
		boolean isOsname = pp.containsKey("os.name");
		System.out.println(isOsname);
		
		int ppSize = pp.size();
		System.out.println(ppSize);
		
		Collection<Object> collection = pp.values();
		
		Iterator<Object> iterator = collection.iterator();
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}