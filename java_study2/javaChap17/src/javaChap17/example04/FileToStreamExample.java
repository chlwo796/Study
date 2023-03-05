package javaChap17.example04;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileToStreamExample {
	public static void main(String[] args) throws URISyntaxException, IOException {
		Path path = Paths.get(FileToStreamExample.class.getResource("data.txt").toURI());
		Stream<String> stream = Files.lines(path);
		stream.forEach(line -> System.out.println(line));
		stream.close();
		// 리소스 보호
	}
}