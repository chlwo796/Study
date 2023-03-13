2023년 3월 13일 월요일

## chap.17 exercises

### 1. 스트림

- 스트림은 내부 반복자를 사용하기 때문에 코드가 간결해진다.
- 스트림은 요소를 분리해서 병렬 처리시킬 수 있다.
- 스트림은 람다식을 사용해서 요소 처리 내용을 기술한다.
- 스트림은 요소를 모두 처리하고 나서 처음부터 요소를 다시 반복시킬 수 있다. (x) -> 모두 처리하면 새로운 스트림을 만들어야한다.

---

### 2. 스트림을 얻을 수 있는 소스

- 컬렉션(List)
- int, long, double 범위
- 디렉토리 (x)
- 배열

---

### 3. 스트림 파이프라인

- 스트림을 연결해서 중간 처리와 최종 처리를 할 수 있다.
- 중간 처리 단계에서는 필터링, 매핑, 정렬, 그룹핑을 한다.
- 최종 처리 단계에서는 합계, 평균, 카운팅, 최대값, 최소값 등을 얻을 수 있다.
- 최종 처리가 없더라도 중간 처리를 할 수 있다. (x) -> 중간처리는 최종 처리가 되지 않으면 처리되지 않는다.

---

### 4. 스트림 병렬 처리

- 전체 요소를 분할해서 처리한다.
- 내부적으로 포크조인 프레임워크를 이용한다.
- 병렬 처리는 순차적 처리보다 항상 빠른 처리를 한다. (x) -> 시스템의 성능(CPU), 컬렉션의 요소 수, 스트림 소스의 종류에 따라 다르다.
- 내부적으로 스레드풀을 이용해서 스레드를 관리한다.

---

### 5. 대소문자 상관없이 "java" 포함 단어 필터링하여 출력

```java
package javaHigh11.exercise05;

import java.util.Arrays;
import java.util.List;

public class Example {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("This is a java book", "Lambda Expressions",
				"Java8 supports lambda expressions");
		list.stream().filter(s -> s.toLowerCase().contains("java")).forEach(s -> System.out.println(s));
	}
}
```

### 6. List에 저장되어있는 Member의 평균 나이

```java
package javaHigh11.exercise06;

public class Member {
	private String name;
	private int age;

	public Member(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
}
```

```java
package javaHigh11.exercise06;

import java.util.Arrays;
import java.util.List;

public class Example {
	public static void main(String[] args) {
		List<Member> list = Arrays.asList(new Member("홍길동", 30), new Member("김자바", 40));
		double avg = list.stream().mapToDouble(m -> m.getAge()).average().getAsDouble();
		System.out.println("평균나이 : " + avg);
	}
}
```

---

### 7. List에 저장되어 있는 Member 중에서 직업이 "개발자"인 사람만 별도에 List에 수집

```java
package javaHigh11.exercise07;

public class Member {
	private String name;
	private String job;

	public String getName() {
		return name;
	}

	public String getJob() {
		return job;
	}

	public Member(String name, String job) {
		super();
		this.name = name;
		this.job = job;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "{name:" + name + ", job:" + job + "}";
	}
}
```

```java
package javaHigh11.exercise08;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javaHigh11.exercise07.Member;

public class Example {
	public static void main(String[] args) {
		List<Member> list = Arrays.asList(new Member("홍길동", "개발자"), new Member("김나리", "디자이너"),
				new Member("신용권", "개발자"));

		Map<String, List<Member>> groupingMap = list.stream().collect(Collectors.groupingBy(m -> m.getJob()));

		Set<String> job = groupingMap.keySet();

		List<Member> devList = groupingMap.get("개발자");
		devList.stream().forEach(d -> System.out.println(d));
		System.out.println();
		List<Member> degList = groupingMap.get("디자이너");
		degList.stream().forEach(d -> System.out.println(d));
	}
}
```
