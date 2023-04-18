2023년 4월 18일 화요일

## day 75

### 1. spring boot

- 개발환경

  - STS-4.18.0.RELEASE
  - Spring Boot 2.7.11-SNAPSHOT
  - jdk 11

- `build.gradle`

```java
plugins {
	id 'java'
	id 'org.springframework.boot' version '2.7.11-SNAPSHOT'
	id 'io.spring.dependency-management' version '1.0.15.RELEASE'
}

group = 'com.mysite'
version = '0.0.1-SNAPSHOT'
sourceCompatibility = '11'

repositories {
	mavenCentral()
	maven { url 'https://repo.spring.io/milestone' }
	maven { url 'https://repo.spring.io/snapshot' }
}

dependencies {
	implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
	implementation 'org.springframework.boot:spring-boot-starter-thymeleaf'
	implementation 'org.springframework.boot:spring-boot-starter-web'
	developmentOnly 'org.springframework.boot:spring-boot-devtools'
	runtimeOnly 'com.mysql:mysql-connector-j'
	testImplementation 'org.springframework.boot:spring-boot-starter-test'
    implementation 'com.h2database:h2'
}

tasks.named('test') {
	useJUnitPlatform()
}
```

- `developmentOnly` : 개발환경에만 적용되는 설정

**자바파일 작성해야 하는 역할**

- controller : 요청--> 처리--> 응답
- DTO (Data Transaction Object) : VO(View Object) : 그릇, setter/getter 롬복을 이용 @Data
- DAO (Data Access Object) : 데이터베이스와 연결하는 역할
- Service : 비즈니스 역할(실제 실행), `interface  Member`, `class MemberImpl`

- SQL문 : 데이터베이스에 SQL문을 전달해 주고 결과 받고

  - `book_SQL.xml` : 마이바티스 방식, 스프링 프레임워크
  - `book_SQL.java` : JPA방식, 스프링 부트

- `View` 화면 부분 : `book.jsp`, `book.html`

**스프링부트 프로젝트의 구조**

- `src/main/resources`

  - src/main/resources 디렉터리는 자바 파일을 제외한 HTML, CSS, Javascript, 환경파일 등을 작성하는 공간이다.

- `templates`

  - src/main/resources 디렉터리의 하위 디렉터리인 templates 디렉터리에는 템플릿 파일을 저장한다. 템플릿 파일은 HTML 파일 형태로 자바 객체와 연동되는 파일이다. templates 디렉터리에는 SBB의 질문 목록, 질문 상세 등의 HTML 파일을 저장한다.

- `static`

  - static 디렉터리는 SBB 프로젝트의 스타일시트(.css), 자바스크립트(.js) 그리고 이미지 파일(.jpg, .png) 등을 저장하는 공간이다.

- `application.properties`

  - application.properties 파일은 SBB 프로젝트의 환경을 설정한다. SBB 프로젝트의 환경, 데이터베이스 등의 설정을 이 파일에 저장한다.

- `src/test/java`

  - src/test/java 디렉터리는 SBB 프로젝트에서 작성한 파일을 테스트하기 위한 테스트 코드를 작성하는 공간이다. JUnit과 스프링부트의 테스팅 도구를 사용하여 서버를 실행하지 않은 상태에서 src/main/java 디렉터리에 작성한 코드를 테스트할 수 있다.

- `build.gradle`
  - 그레이들(Gradle)이 사용하는 환경 파일이다. 그레이들은 그루비(Groovy)를 기반으로 한 빌드 도구로 Ant, Maven과 같은 이전 세대 빌드 도구의 단점을 보완하고 장점을 취합하여 만든 빌드 도구이다. build.gradle 파일에는 프로젝트를 위해 필요한 플러그인과 라이브러리 등을 기술한다.

**컨트롤러**

```java
package com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller	// 스프링부트의 컨트롤러
public class MainController {
	// 서버에 요청이 발생하면 스프링부트는 요청 페이지와 매핑되는 메소드를 컨트롤러를 대상으로 찾는다.
	// http://localhost:9000/sbb 요청이 발생하면
	// /sbb url과 매핑되는 index메소드를 MainController 클래스에서 찾아서 실행한다.
	@GetMapping("/sbb")	// 요청된 url과의 매핑 담당
	@ResponseBody
	public String index() {
		return "sbb에 오신것을 환영합니다.";
	}
}
```

**JPA**

- ORM(Object-Relational Mapping)의 장점
  - ORM을 이용하면 데이터베이스 종류에 상관 없이 일관된 코드를 유지할 수 있어서 프로그램을 유지·보수하기가 편리하다. 또한 내부에서 안전한 SQL 쿼리를 자동으로 생성해 주므로 개발자가 달라도 통일된 쿼리를 작성할 수 있고 오류 발생률도 줄일 수 있다.
- JPA(Java Persistence API) : 자바 진영에서 ORM의 기술 표전으로 사용하는 인터페이스의 모음

  - JPA를 구현한 대표적인 실제 클래스에는 하이버네이트(Hibernate)가 있다. SBB도 JPA + 하이버네이트 조합을 사용한다.

- H2 데이터베이스
  - 주로 개발용이나 소규모 프로젝트에서 사용되는 파일 기반의 경량 데이터베이스이다. 개발시에는 H2를 사용하여 빠르게 개발하고 실제 운영시스템은 좀 더 규모있는 DB를 사용하는 것이 일반적인 개발 패턴이다.
- `implementation`

  - build.gradle 파일의 implementation은 해당 라이브러리 설치를 위해 일반적으로 사용하는 설정이다. implementation은 해당 라이브러리가 변경되더라도 이 라이브러리와 연관된 모든 모듈들을 컴파일하지 않고 직접 관련이 있는 모듈들만 컴파일하기 때문에 rebuild 속도가 빠르다.

- `application.properties` JPA 설정 추가
  - spring.jpa.properties.hibernate.dialect : 데이터베이스 엔진 종류를 설정한다.
  - spring.jpa.hibernate.ddl-auto : 엔티티를 기준으로 테이블을 생성하는 규칙을 정의한다.
- `spring.jpa.hibernate.ddl-auto=update` : 개발 환경에서는 보통 update 모드를 사용하고, 운영환경에서는 none 또는 validate 모드를 사용
  - `none` : 엔티티가 변경되더라도 데이터베이스를 변경하지 않는다.
  - `update` : 엔티티의 변경된 부분만 적용
  - `validate` : 변경사항이 있는지 검사만 한다.
  - `create` : 스프링부트 서버가 시작될 때 모두 drop하고 다시 생성
  - `create-drop` : `create`와 동일하지만, 종료시에도 모두 drop

**엔티티**

- 엔티티 : 데이터베이스 테이블과 매핑되는 자바 클래스, 모델 또는 도메인 모델이라고 부르기도 한다.

---

### 2. memo

- 5.1 근로자의 날
- 5.2 ~ 5.17 현업대표 스프링 특강
- 5.8,9 과정형 평가
- 5.18 ~ 6.30 새로운 강사
- [springBoot | Failed to determine a suitable driver class](https://www.appletong.com/entry/Spring-boot-Failed-to-determine-a-suitable-driver-class?category=1071413)
- [springBoot | 서버 포트 변경](https://computer-science-student.tistory.com/527)
