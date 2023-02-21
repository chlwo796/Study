2023년 2월 21일 화요일

---

### 1. remind

---

### 2. java

- chap.12 java.base module
- [API 도큐먼트](https://docs.oracle.com/en/java/javase/11/docs/api/)
- 자바에서 자동으로 처리되는 것
  - Object
  - Package java.lang
- `Object`: 자바 클래스의 최상위 스(모든 클래스의 부모)
- `System` : 윈도우 기능 이용할 때 사용하는 클래스
  - 키보드로부터 데이터를 입력받을 때
- 운영체제(operating system, os) : 하드웨어와 소프트웨어 사이에서 소프트웨어를 잘 실행할 수 있도록, 하드웨어를 컨트롤 해주는 일을 하는 소프트웨어
- `System.exit()` : 프로세스 종료 매우 중요(정상 종료 = 0, 비정상 종료 = 1 or -1 관례)
- `System.nanoTime()`
- `System.currentTimeMills()`클래
- `System.in.read()`
- `System.out.println()`
- `System.err.println()`
- `System.getProperty("user.home")`
- 문자처리 : UTF-8, 웹표준(3byte)
- EUC-KR : 2 Byte
- 인코딩 : 문자 -> 바이트(자바)
- 디코딩 : 바이트(자바) -> 문자
- StringBuilder : 메모리 낭비가 없지만, 데이터 양이 많아졌을 때 데이터 관리(index)에 시간이 더 소요될 수 있다.
- 포장클래스 Wrapper : 기본형을 클래스로 만들어둔 클래스를 총칭해서 부르는 말

---

### 3. memo

- project : ScoreMap만(TreeMap<Student, Score>) 이용해서 성적관리돌린다. 성적이없으면 추가해야한다.(size의 차이로 구분) 이걸로 오늘끝내기!!
- map.put(new Student(), new Score());
- [인코딩vs디코딩](https://codingpractices.tistory.com/entry/%EC%9D%B8%EC%BD%94%EB%94%A9-vs-%EB%94%94%EC%BD%94%EB%94%A9-%EC%A0%95%ED%99%95%ED%95%98%EA%B2%8C-%EC%9D%B4%ED%95%B4%ED%95%98%EA%B8%B0)
- [openInBrowser](https://shoney.tistory.com/entry/VS-Code-Open-in-browser-%EC%84%A4%EC%B9%98-%EB%B0%8F-%ED%81%AC%EB%A1%AC%EC%9C%BC%EB%A1%9C-%EC%8B%A4%ED%96%89)
