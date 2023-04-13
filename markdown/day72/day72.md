2023년 4월 13일 목요일

## day 72

### 1. ncs

- UI test
- 회원가입 및 유효성검사

  ```html
  <!DOCTYPE html>
  <html>
    <head>
      <meta charset="utf-8" />
      <meta http-equiv="X-UA-Compatible" content="IE=edge" />
      <title>Page Title</title>
      <meta name="viewport" content="width=device-width, initial-scale=1" />
      <link rel="stylesheet" type="text/css" media="screen" href="main.css" />
    </head>

    <body>
      <h3>회원가입</h3>
      <form method="post" name="form" action="">
        <p>성:</p>
        <input type="text" name="lastName" id="lastName" />
        <p>이름:</p>
        <input type="text" name="firstName" id="firstName" />
        <p>이메일:</p>
        <input type="text" name="email" id="email" /><br />
        <span>성별:</span
        ><input type="radio" name="gender" id="male" />남성<input
          type="radio"
          name="gender"
          id="female"
        />여성<br />
        <span>특기:</span><input type="checkbox" name="specialty" />HTML<input
          type="checkbox"
          name="specialty"
        />CSS<input type="checkbox" name="specialty" />JAVA<input
          type="checkbox"
          name="specialty"
        />MySQL<br />
        <span>전공:</span
        ><select name="majors" id="lang">
          <option value="Computer">Computer</option>
          <option value="AI">AI</option>
          <option value="Design">Design</option>
          <option value="Art">Art</option></select
        ><br />
        <span>생일:</span><input type="date" /><br />
        <p><textarea cols="30" rows="8" name="introduceMyself"></textarea></p>
        <input
          type="submit"
          name="join"
          value="가입하기"
          onclick="return checkAll()"
        />
        <input type="reset" name="cancle" value="취소하기" />
      </form>
    </body>
    <script src="test.js"></script>
  </html>
  ```

  ```js
  function checkAll() {
    let male = document.getElementById("male");
    let female = document.getElementById("female");
    if (!checkLastName(form.lastName.value)) {
      return false;
    } else if (!checkFirstName(form.firstName.value)) {
      return false;
    } else if (!checkEmail(form.email.value)) {
      return false;
    } else if (!male.checked && !female.checked) {
      alert("성별을 입력해주세요.");
      form.gender.checked.focus();
      return false;
    }
    return alert("회원가입완료");
  }
  // 공백확인 함수
  function checkExistData(value, dataName) {
    if (value == "") {
      alert(dataName + "입력해주세요!");
      return false;
    }
    return true;
  }

  function checkLastName(lastName) {
    //성이 입력되었는지 확인하기
    if (!checkExistData(lastName, "성을")) {
      return false;
    } else {
      return true;
    } //확인이 완료되었을 때
  }
  function checkFirstName(firstName) {
    //이름이 입력되었는지 확인하기
    if (!checkExistData(firstName, "이름을")) {
      return false;
    } else {
      return true; //확인이 완료되었을 때
    }
  }
  function checkEmail(email) {
    //email이 입력되었는지 확인하기
    if (!checkExistData(email, "이메일을")) return false;

    let emailRegExp = new RegExp("[a-z0-9]+@[a-z]+.[a-z]{2,3}");
    if (!emailRegExp.test(email)) {
      alert("이메일 형식이 올바르지 않습니다!");
      email = null;
      email.focus();
      return false;
    } else {
      return true; //확인이 완료되었을 때
    }
  }
  ```

---

### 2. spring

- 책 수정, 삭제, 목록, 검색 기능 추가
- BookController

  ```java
  package sample.spring.yse;

  import java.util.List;
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

      @RequestMapping(value = "/detail", method = RequestMethod.GET)
      public ModelAndView detail(@RequestParam Map<String, Object> map) {
          // 책상세화면
          Map<String, Object> detailMap = this.bookService.detail(map);
          ModelAndView mav = new ModelAndView();
          if (detailMap == null) {
              mav.setViewName("/book/error");
          } else {
              mav.addObject("data", detailMap); // 뷰로 detailMap의 값(데이터베이스에서 받은 ResultSet)을 data 속성에 담아서 보내라
              String bookId = map.get("bookId").toString();
              mav.addObject("bookId", bookId);
              mav.setViewName("/book/detail"); // src/main/webapp/web-inf/views/book/detail.jsp파일로 응답해라
          }
          return mav;
      }

      // 수정기능 컨트롤러 추가
      // 요청 -> 처리 = 서비스 객체 전달 -> 뷰객체 생성 -> 응답
      @RequestMapping(value = "/update", method = RequestMethod.GET)
      public ModelAndView update(@RequestParam Map<String, Object> map) {
          ModelAndView mav = new ModelAndView();
          Map<String, Object> detailMap = this.bookService.detail(map);
          mav.addObject("data", detailMap);
          mav.setViewName("/book/update"); // update.jsp로 응답
          return mav;
      }

      @RequestMapping(value = "/update", method = RequestMethod.POST)
      public ModelAndView updatePost(@RequestParam Map<String, Object> map) {
          ModelAndView mav = new ModelAndView();
          boolean isUpdateSuccess = this.bookService.edit(map);
          if (isUpdateSuccess) {
              // 정상실행 후 상세페이지화면으로 이동
              String bookId = map.get("bookId").toString();
              mav.setViewName("redirect:/detail?bookId=" + bookId);
          } else {
              // 정상실행이 아니면, 상세페이지 화면 이동
              mav = this.update(map);
          }
          return mav;
      }

      @RequestMapping(value = "/delete", method = RequestMethod.POST)
      public ModelAndView deletePost(@RequestParam Map<String, Object> map) {
          ModelAndView mav = new ModelAndView();
          boolean isDeleteSuccess = this.bookService.remove(map);
          if (isDeleteSuccess) {
              // 삭제 후 list.jsp 화면이동
              mav.setViewName("redirect:/list");
          } else {
              String bookId = map.get("bookId").toString();
              // 실패 후 상세페이지 이동
              mav.setViewName("redirect:/detail?bookId=" + bookId);
          }
          return mav;
      }
      @RequestMapping(value = "/list")
      public ModelAndView list(@RequestParam Map<String, Object> map) {
          ModelAndView mav = new ModelAndView();
          // 책 목록 db에서 가지고옴
          List<Map<String, Object>> list = this.bookService.list(map);
          // 데이터뷰에 전달
          mav.addObject("data", list);
          if(map.containsKey("keyword")) {
              mav.addObject("keyword", map.get("keyword"));
          }
          // /book/list 뷰 리턴, list.jsp
          mav.setViewName("/book/list");
          return mav;
      }
  }
  ```

- BookDAO

  ```java
  package sample.spring.yse;

  import java.util.List;
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

      public int update(Map<String, Object> map) {
          // insert()와 사용법 동일, 첫번째 파라미터 = 쿼리ID, 두번째 파라미터 = 쿼리파라미터
          // return = 영향받은 행 수
          return this.sqlSessionTemplate.update("book.update", map);
      }

      public int delete(Map<String, Object> map) {
          // 데이터 삭제 Dao 메소드, update()와 사용법 동일
          return this.sqlSessionTemplate.delete("book.delete", map);
      }
      // 책 목록 만드는 메소드
      public List<Map<String, Object>> selectList(Map<String, Object> map) {
          return this.sqlSessionTemplate.selectList("book.select_list", map);
      }
  }
  ```

- BookService

  ```java
  package sample.spring.yse;

  import java.util.List;
  import java.util.Map;

  public interface BookService {
      String create(Map<String, Object> map); // 책 입력메소드

      Map<String, Object> detail(Map<String, Object> map); // 책 상세화면메소드

      boolean edit(Map<String, Object> map);

      boolean remove(Map<String, Object> map);

      List<Map<String, Object>> list(Map<String, Object> map);	// 책목록 메소드

  }
  ```

- BookServiceImpl

  ```java
  package sample.spring.yse;

  import java.util.List;
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

      // 수정기능메소드 구현
      @Override
      public boolean edit(Map<String, Object> map) {
          int affectRowCount = this.bookDao.update(map);
          // 수정의 경우 입력과는 다르게 PK를 가져오거나 하는 절차 필요 없음
          // 1개의 행만이 영향받았는지만 체크
          return affectRowCount == 1;
      }

      // 책 삭제기능 메소드 구현
      @Override
      public boolean remove(Map<String, Object> map) {
          int affectRowCount = this.bookDao.delete(map);
          // 수정의 경우 입력과는 다르게 PK를 가져오거나 하는 절차 필요 없음
          // 1개의 행만이 영향받았는지만 체크
          return affectRowCount == 1;
      }
      // 책 목록 출력메소드
      @Override
      public List<Map<String, Object>> list(Map<String, Object> map) {
          return this.bookDao.selectList(map);
      }
  }
  ```

- `book_SQL.xml` : BookDAO 에서 db와 데이터 교환

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <!DOCTYPE  mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
  <mapper namespace="book">
      <insert id="insert" parameterType="hashMap"
          useGeneratedKeys="true" keyProperty="book_id">
      <![CDATA[
      insert into book ( title, category, price) values(#{title}, #{category}, #{price});
      ]]>
      </insert>
      <select id="select_detail" parameterType="hashMap"
          resultType="hashMap">
      <![CDATA[select book_id, title, category, price, insert_date from book where book_id = #{bookId}]]>
      </select>
      <update id="update" parameterType="hashMap">
  <![CDATA[update book set title = #{title}, category = #{category}, price = #{price} where book_id = #{bookId}]]>
      </update>
      <delete id="delete" parameterType="hashMap">
  <![CDATA[delete from book where book_id = #{bookId}]]>
      </delete>
      <select id="select_list" parameterType="hashMap"
          resultType="hashMap">
  <![CDATA[select book_id, title, category, price, insert_date from book where 1 = 1]]>
          <if test="keyword != null and keyword != ''"> and (title like CONCAT('%', #{keyword}, '%') or category
              like
              CONCAT('%', #{keyword}, '%'))</if>
          order by insert_date desc
      </select>
  </mapper>
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

- `list.jsp` : db 목록 출력

  ```jsp
  <%@ page pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
  <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <html>
  <head>
  <title>책 목록</title>
  </head>
  <body>
      <h1>책 목록</h1>
      <p>
      <form>
          <input type="text" placeholder="검색" name="keyword" value="${keyword}" />
          <input type="submit" value="검색" />
      </form>
      </p>
      <table>
          <thead>
              <tr>
                  <td>제목</td>
                  <td>카테고리</td>
                  <td>가격</td>
              </tr>
          </thead>
          <tbody>
              <c:forEach var="row" items="${data}">
                  <tr>
                      <td><a href="detail?bookId=${row.book_id}"> ${row.title} </a></td>
                      <td>${row.category}</td>
                      <td><fmt:formatNumber type="number" maxFractionDigits="3"
                              value="${row.price}" /></td>
                  </tr>
              </c:forEach>
          </tbody>
      </table>
      <p>
          <a href="/yse/create">생성</a>
      </p>
  </body>
  </html>
  ```

- `update.jsp` : 데이터 수정

  ```jsp
  <%@ page language="java" contentType="text/html; charset=utf-8"
      pageEncoding="utf-8"%>
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="utf-8">
  <title>책 수정하기</title>
  </head>
  <body>
      <h1>수정하기</h1>
      <form method="post">
          <p>
              제목 : <input type="text" name="title" />
          </p>
          <p>
              카테고리 : <input type="text" name="category" />
          </p>
          <p>
              가격 : <input type="text" name="price" />
          </p>
          <p>
              <input type="submit" value="수정" />
      </form>
  </body>
  </html>
  ```

---

### 3. memo

- [spring | timeZone 설정](https://velog.io/@taelee/mysql%EC%97%90%EC%84%9C-9%EC%8B%9C%EA%B0%84-%EC%B0%A8%EC%9D%B4%EB%82%A0%EB%95%8CGCP)
- [javaScript | from 태그의 element 접근방법](http://www.mungchung.com/xe/lecture/4197)
- [절대경로 vs 상대경로](https://www.inflearn.com/blogs/1284)
- [spring | @Controller](https://pjc91.tistory.com/68)
- [spring | springMVC](https://ky-dev.tistory.com/m/54)
