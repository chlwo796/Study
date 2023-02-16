package javaChap15.example04;

import java.io.IOException;
import java.util.Properties;

public class PropertiesExample {
	public static void main(String[] args) {
		Properties properties = new Properties();
		try {
			properties.load(PropertiesExample.class.getResourceAsStream("database.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(properties.getProperty("driver"));
		System.out.println(properties.getProperty("url"));
		System.out.println(properties.getProperty("username"));
		System.out.println(properties.getProperty("password"));
		System.out.println(properties.getProperty("admin"));
	}
}
