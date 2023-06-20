## Trouble Shooting

---

### 2023.06.05

- [Uncaught ReferenceError: jQuery is not defined](https://joonpyo-hong.tistory.com/entry/JS-jQuery-is-not-defined-is-not-defined-%EC%98%A4%EB%A5%98)
- [@PathVariable](https://byul91oh.tistory.com/435)
  - 컨트롤러에 `@PathVariable int biNum`를 매개변수로 하니 request URI에 /comment/list?biNum=1 로 자동으로 매핑되며 컨트롤러에 해당 URI를 응답받아 처리하는 메소드가 없어 404 에러가 발생했다.

---

### 2023.06.08

- Ajax 댓글 수정 기능 : Ajax로 댓글 수정하는 기능 구현 중 댓글 작성 중 ciNum에 대한 정보가 모두 0으로 초기화되는 현상으로 인해, 수정하기 버튼을 눌렀을 때 해당하는 ciNum의 정보가 없어, 마이바티스가 UPDATE 쿼리문을 실행하지 않는 현상
  - `CommentInfoMapper.xml`의 댓글목록에 대한 정보를 가져오는 SELECT문에서 CI_NUM 컬럼이 빠져있어 VO에 해당 정보가 담기지 않았다.

### 2023.06.13

- 카카오 API 연동 회원가입 및 로그인 구현 중 각 프로젝트 환경마다의 프로필업로드 경로 차이로 인한 프로필연동 안되는 현상

  - `System.getProperty("user.dir");` : 시스템프로퍼티로 각 프로젝트의 절대경로를 불러오도록 설정한 후 uploadFilePath에 프로젝트기준으로 저장하고자하는 폴더 경로를 합쳐준다.

  ```java
    private final String absolutePath = System.getProperty("user.dir"); // 시스템속성으로 프로젝트경로불러옴
    private final String uploadFilePath = absolutePath + "\\src\\main\\webapp\\resources\\upload";
  ```

### 2023.06.15

- 카카오 DB 분리 후 로그인 시 유저정보를 제대로 불러오지 않아 화면에 프로필 사진 등 연동이 되지 않는 현상.

- UserInfoMapper.xml : KUI_ID 로 찾아온 UI_NUM을 가지고 온 후 해당 UI_NUM 으로 UserInfoVO를 SELECT하는 쿼리문이 없어서 정보가 담기지 않았으며, 해당 쿼리문 추가

  ```xml
    <select id="selectUserInfoByKakao"
      resultType="com.ezen.mannamatna.vo.UserInfoVO">
      select * from user_info where ui_Num = #{uiNum}
    </select>
  ```

- UserInfoMapper.java : 해당 메소드 추가

  ```java
  UserInfoVO selectUserInfoByKakao(UserInfoVO userInfoVO);
  ```

- UserInfoService.java : kakaoLogin()에 selectKakaoUserInfo()를 실행한 후 얻어온 uiNum을 가진 UserInfoVO 객체를 다시 selectUserInfoByKakao(userInfoVO) 하여 해당하는 유저정보를 모두 가져오게 했다.

  ```java
    public boolean kakaoLogin(KakaoUserInfoVO kakaoUserInfoVO, HttpSession session) { //여기서 문제가 생기는듯 ㅇㅅ ㅇ?

      log.info("확인하려는 유저 =>{}",kakaoUserInfoVO);
      kakaoUserInfoVO = uiMapper.selectKakaoUserInfo(kakaoUserInfoVO);
      log.info("돌려받은 유저 =>{}",kakaoUserInfoVO); //카db에 제대로 안올라갔으니까 여기서 못찾아온거같음ㅇㅇ
      if (kakaoUserInfoVO != null) {
        UserInfoVO userInfoVO = new UserInfoVO();
        userInfoVO.setUiNum(kakaoUserInfoVO.getUiNum()); // 카카오 로그인 유저의 유저번호를 userInfoVO에 담기
        UserInfoVO newUserInfoVO = uiMapper.selectUserInfoByKakao(userInfoVO);
        // uiNum 정보만 가지고 있는 VO를 넣고 리턴은 다시 셀렉트문으로 찾은 모든 정보를 가지고 있는 uiVO 객체를 다시 돌려받는다.
        // uiVO와 kakaoVO가 연결되는것은 uiNum 인데 찾은 uiNum으로 uiVO를 셀렉트해서 찾는 쿼리문이 없었음
        // 매퍼에 해당 메소드 및 쿼리문 추가하여 kakaoLogin()에 추가함
        // 객체를 두개 생성하는게 비효율적이면 같은 userInfoVO에 계속 담아도 됨. 정상작동확인함
        log.info("카카오 로그인 서비스 =>{}",newUserInfoVO);
        session.setAttribute("user", newUserInfoVO);
        log.info("서비스에서 카카오 세션값확인={}", session.getAttribute("user"));
        return true;
      }
      return false;
    }
  ```

### 2023. 06. 20

- CommentInfoMapper.xml : 댓글작성한 시간(timestamp)로 저장된 mySQL의 CI_CREDAT, CI_CRETIM 데이터를 timestamp date_format(CI_CREDAT, '%Y. %m. %d'), date_format(CI_CRETIM, '%H시 %i분') 으로 가공하던 중 각 DATE_FORMAT()함수에 별칭으로 CI_CREDAT, CI_CRETIM 을 작성해주지 않아 계속 NULL값으로 출력되는 현상 해결하였다.

```xml
	<select id="selectCommentInfo" parameterType="int" resultType="com.ezen.mannamatna.vo.CommentInfoVO">
	SELECT CI_NUM, CI_CONTENT, date_format(CI_CREDAT, '%Y. %m. %d') CI_CREDAT,
	date_format(CI_CRETIM, '%H시 %i분') CI_CRETIM, UI_NUM, BI_NUM FROM COMMENT_INFO WHERE CI_NUM = #{ciNum}
	</select>
	<select id="selectCommentInfos" parameterType="int"
		resultType="com.ezen.mannamatna.vo.CommentInfoVO">
		SELECT u.UI_FILEPATH, u.UI_NICKNAME, c.CI_NUM, c.CI_CONTENT, date_format(c.CI_CREDAT, '%Y. %m. %d') CI_CREDAT,
		date_format(c.CI_CRETIM, '%H시 %i분') CI_CRETIM, c.BI_NUM, c.UI_NUM FROM COMMENT_INFO c
		JOIN USER_INFO u ON c.UI_NUM = u.UI_NUM WHERE c.BI_NUM = #{biNum}
	</select>
```
