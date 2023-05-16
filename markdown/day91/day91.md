2023년 5월 16일 화요일

## day 91

---

### memo

- jsp를 사용하면 언어느 자바가 필수이므로 응집도가 매우 높다.
- json 형태로 백엔드 작업 후 프론트에서 자바스크립트로 화면을 그리는 방식이 현재많이 사용하는 방식이다.(백엔드와 프론트엔드를 분리)
- 스프링 필수 암기, 공통사항 : 메모리 생성과 관련

- Url 매핑설정
  - `@Controller`
  - `@RestController` : Model 로 jsp에 전달하는 방식 사용불가, ResponseBody 형태
- 설정

  - `@Configuration` : 제일 먼저 메모리 생성

- 메모리설정 말고 구동의 큰 역할은 없다.

  - `@Service`
  - `@Repository`
  - `@Component` : 컨트롤러, 설정, 서비스, 리파지토리도 아니지만 메모리 생성이 필요한 경우

- `@Bean`

- TDD : Test Driven Development, 테스트주도 개발

  - 개발시간은 오래걸리지만, 완성도는 높다.
  - MOC데이터

- 둘중 하나만 필요
  - bootstrap.bundle.js : 읽기 쉬운 파일
  - bootstrap.bundle.min.js : 한줄소스(컴프레스버전), 이너파일
