package com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.Data;

@Controller // HelloController 클래스가 컨트롤러의 기능을 수행
public class HelloController {
	@GetMapping("/hello") // 9000/hello url 요청이 발생하면 hello 메소드가 실행
	@ResponseBody // hello 메소드의 응답 결과가 문자열 그 자체임을 나타냄
	public Student hello() {
		Student student = new Student();
		student.setAge(100);
		student.setName("홍길동");
		student.setAge(200);
		student.setName("최재환");
		return student;
	}
}
@Data
class Student {
	String name;
	int age;
}