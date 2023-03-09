package javaHigh11.example02;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileStreamEx04 {
	public static void main(String[] args) throws URISyntaxException, IOException {
		Path path = Paths.get(FileStreamEx04.class.getResource("data.txt").toURI());
		System.out.println(path);

//		Stream<String> stream = Files.lines(path, Charset.forName("UTF-8"));
//		stream.forEach(line -> System.out.println(line));

		Files.lines(path, Charset.forName("UTF-8")).forEach(line -> System.out.println(line));
	}
}