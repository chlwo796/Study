2023년 4월 12일 수요일

## day71

### 1. spring

- `Bean` : 스프링 컨테이너는 자바 객체의 생명 주기를 관리하며, 생성된 자바 객체들에게 추가적인 기능을 제공하는 역할을 합니다. 여기서 말하는 자바 객체를 스프링에서는 빈(Bean)이라고 부릅니다.
- `jsp` : html 코드안에 서버에서 받은 변수를 동적으로 변화시킬 수 있는 서버 프로그램

  - jsp문법 : jstl - jsp에서 화면을 표현하는 문법
  - `<fmt>` : jstl문법중에서 포맷에 관한 문법

- 책 입력, 상세페이지 구현
- BookService 인터페이스

  ```java
  package sample.spring.yse;

  import java.util.Map;

  public interface BookService {
      String create(Map<String, Object> map);	// 책 입력메소드
      Map<String, Object> detail(Map<String, Object> map); // 책 상세화면메소드
  }
  ```

- BookServiceImpl : BookService 구현클래스

  ```java
  package sample.spring.yse;

  import java.util.Map;

  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.stereotype.Service;

  @Service // 서비스 클래스(비즈니스클래스-진짜 동작시키는 클래스)
  public class BookServiceImpl implements BookService {

      @Autowired // BookDAO라는 객체를 자동으로 주입한다. BookDAO 클래스를 사용할 수 있다 new BookDAO();
      BookDAO bookDao;
      @Override
      public String create(Map<String, Object> map) {
          int affectRowCount = this.bookDao.insert(map);
          if (affectRowCount == 1) {
              return map.get("book_id").toString();
          }
          return null;
      }

      @Override
      public Map<String, Object> detail(Map<String, Object> map) {
          // bookDao의 selectDetail 메소드 구현
          return this.bookDao.selectDetail(map);
      }
  }
  ```

- BookDao : 데이터 접근객체

  ```java
  package sample.spring.yse;

  import java.util.Map;

  import org.mybatis.spring.SqlSessionTemplate;
  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.stereotype.Repository;

  @Repository // 스프링이 관리한다 저장소 용도로 사용하는 클래스이다 라고 지정함
  public class BookDAO {

      // 필드 선언
      @Autowired // 자동주입해라
      SqlSessionTemplate sqlSessionTemplate;

      // 메소드 삽입에 관련 역할을 하는 메소드 insert- username
      public int insert(Map<String, Object> map) {
          return this.sqlSessionTemplate.insert("book.insert", map);
      }

      public Map<String, Object> selectDetail(Map<String, Object> map) {
          // 데이터를 한 행만 가져올 경우 selectOne() 메소드 사용
          // 쿼리 결과 행수 = 0 일 경우 null return, 여러개면, TooManyResultsException 예외
          return this.sqlSessionTemplate.selectOne("book.select_detail", map);
      }
  }
  ```

- BookController : 컨트롤러클래스

  ```java
  package sample.spring.yse;

  import java.util.Map;

  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.stereotype.Controller;
  import org.springframework.web.bind.annotation.RequestMapping;
  import org.springframework.web.bind.annotation.RequestMethod;
  import org.springframework.web.bind.annotation.RequestParam;
  import org.springframework.web.servlet.ModelAndView;

  @Controller
  public class BookController {

      @Autowired
      BookService bookService;

      @RequestMapping(value = "/create", method = RequestMethod.GET)
      public ModelAndView create() {
          return new ModelAndView("book/create");
      }

      @RequestMapping(value = "/create", method = RequestMethod.POST)
      public ModelAndView createPost(@RequestParam Map<String, Object> map) {
          ModelAndView mav = new ModelAndView();

          String bookId = this.bookService.create(map);
          if (bookId == null) {
              mav.setViewName("redirect:/create");
          } else {
              mav.setViewName("redirect:/detail?bookId=" + bookId);
          }
          return mav;
      }

      @RequestMapping(value="/detail", method=RequestMethod.GET )
      public ModelAndView  detail( @RequestParam  Map<String, Object>  map ) {
          // 책상세화면
          Map<String, Object> detailMap = this.bookService.detail(map);
          ModelAndView mav = new ModelAndView();
          if(detailMap == null ) {
              mav.setViewName("/book/error");
          }
          else {
          mav.addObject("data", detailMap); //뷰로 detailMap의 값(데이터베이스에서 받은 ResultSet)을 data 속성에 담아서 보내라
          String bookId = map.get("bookId").toString();
          mav.addObject("bookId", bookId);
          mav.setViewName("/book/detail"); // src/main/webapp/web-inf/views/book/detail.jsp파일로 응답해라
          }
          return mav;
      }
  }
  ```

- `create.jsp` : 데이터생성

  ```jsp
  <%@ page language="java" contentType="text/html; charset=utf-8"
      pageEncoding="utf-8"%>
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="utf-8">
  <title>책 생성하기</title>
  </head>
  <body>
  <h1> 책생성하기 </h1>
  <form method="post">
      <p>제목 : <input type="text" name="title" /></p>
      <p>카테고리 : <input type="text" name="category" /></p>
      <p>가격 : <input type="text" name="price" /></p>
      <p><input type="submit" value="저장" />
  </form>
  </body>
  </html>
  ```

- `detail.jsp` : 상세페이지

  ```jsp
  <%@ page pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
  <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
  <html>
  <head>
  <title>책 상세</title>
  </head>
  <body>
      <h1>책 상세</h1>
      <p>제목 : ${ data.title }</p>
      <p>카테고리 : ${ data.category }</p>
      <p>
          가격 :
          <fmt:formatNumber type="number" maxFractionDigits="3"
              value="${data.price}" />
      </p>
      <fmt:setTimeZone value="Asia/Seoul" />
      <p>
          입력일 :
          <fmt:formatDate value="${data.insert_date}"
              pattern="yyyy.MM.dd HH:mm:ss" />
      </p>
      <p>
          <a href="/yse/update?bookId=${bookId}">수정</a>
      </p>
      <form method="POST" action="/yse/delete">
          <input type="hidden" name="bookId" value="${bookId}" /> <input
              type="submit" value="삭제" />
      </form>
      <p>
          <a href="/yse/list">목록으로</a>
      </p>
  </body>
  </html>
  ```

- `error.jsp` : db에 데이터 없을 시

  ```jsp
  <%@ page language="java" contentType="text/html; charset=utf-8"
      pageEncoding="utf-8"%>
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="utf-8">
  <title>책 검색하기</title>
  </head>
  <body>
      <h1>책 검색하기</h1>
      검색한 자료가 없습니다.
  </body>
  </html>
  ```

---

### 2. memo

- [spring | pom.xml 오류 해결법](https://pendine.tistory.com/15)
- [spring | 프로젝트 갑자기 404 오류](https://java119.tistory.com/17)
- [spring | dependency를 추가 했는데 오류가 뜬다? 제대로 설치가 안된다? 찾을수 없다면??](https://bbo-blog.tistory.com/52)
- [spring | Dynamic Web Module 4.0 requires java 1.8 or newer 에러](https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=yeajin0210&logNo=220956953890)
- [tomcat | tomcat 강제 종료](https://velog.io/@6441kjy/Server-tomcat-%EA%B0%95%EC%A0%9C-%EC%A2%85%EB%A3%8C)
