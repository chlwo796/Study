2023년 5월 18일 목요일

## day 93

---

### memo

- 자격증위주 수업진행(오라클, jsp, servlet, java 리마인드)

- 프로젝트 과정

  - 요구사항분석
  - 요구사항정의, 기능(mvp), 중요도
  - 간트차트(WBS)(일정)
  - 전체흐름도
  - ERD 까지 1주일 정도
  - 이후 코딩
  - 테스팅(단위테스트, 통합테스트)
  - 구글시트활용
  - 회의록
  - 트러블슈터(에러, 원인, 해결방법)
  - 동영상제작

- jsp/servlet 세팅

  - jdk : 11
  - eclipse
  - tomcat 9

- server : 톰캣, 제우스(국산)

- http 프로토콜과 요청방식
  - HTTP(HyperText Transfer Protocol) : web(world wide web) 서비스를 제공하기 위해 정의된 프로토콜(통신규약), 클라이언트(브라우저)와 서버(was)사이의 데이터 통신을 위한 규격
  - 웹의 경우 웹 브라우저가 클라이언트가 되고, 톰캣과 같은 WAS(Web application Server)가 설치된 컴퓨터는 서버가 된다.
- HTTP 특징
  - 비연결성 : 웹브라우저가 서버에 특정 문서를 요청하는 순간, 잠깐 서버에 연결됐다가 서버로부터 응답이 전송된 후에는 곧바로 끊어지는 것
  - 무상태(stateless) : 웹 서버가 웹 클라이언트의 상태 정보를 유지하지 않는 것을 의미, 클라이언트의 이전 상태 정보를 알 수 없다는 의미
    - 클라이언트가 앞에서 로그인을 성공하더라도 다음 페이지에서 로그인 여부를 확인할 수 없음을 의미, session과 cookie를 이용해 상태 정보를 유지시킴
- 서버에 요청, 연결요청에 따른 작업, 클라이언트에 응답, 연결 해제

- HTTP 요청방식

  - POST : CREATE
  - GET : READ
  - PUT : UPDATE
  - DELETE : DELETE

  - HEAD
  - OPTION
  - TRACE
  - CONNECT

- URI(Uniform Resource Identifier) : 인터넷상의 모든 자원을 표기하기 위한 규격 프로그램의 실행경로와 파라미터 등을 포함한 형태까지 포함
- URL(Uniform Resource Location) : 구체적인 파일자원에 대한 주소

  - https://www.ezen.co.kr:80/product/test.html : URL
    - 프로토콜// 호스트(도메인):포트/디렉토리/파일
  - https://www.ezen.co.kr:80/product/test?name=hong?id=1234 : URI

- 서블릿(Servlet) : 자바로 만들어진 프로그램, 서버에서 실행하기 위해 만들어진 프로그램, 특히 웹 서비스 개발에 특화되어 있으며 데이터베이스 연동, 외부서비스 연동을 통해 정적인 웹에 동적인 정보를 제공하기 위해 사용
  - HttpServlet 클래스를 상속받는 서블릿 클래스 작성
  - 컴파일 후 웹 어플리케이션으로 패키징
  - 서블릿 컨테이너에 배포
  - 클라이언트의 URL 요청
  - 어노테이션에 등록된 URL 매핑정보를 참고해 해당 서블릿 실행
  - 요청 메소드에 따라 서블릿의 doGet(), doPost() 등의 메소드 호출
  - 서블릿은 데이터베이스 연동 등 필요한 작업을 수행
  - 데이터를 포함한 HTML 형식의 데이터를 클라이언트에게 전달
