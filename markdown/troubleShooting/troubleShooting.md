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
