2023년 3월 7일 화요일

---

## day45

### 1. java

- 직렬화(serialization) : 객체의 필드값을 일렬로 늘어선 바이트로 변경(객체->스트림)
- 역직렬화(deserializaion) : 직렬화된 바이트를 객체의 필드값으로 복원
- Serializable : 직렬화할 클래스에 구현
- 메모장으로 열었을 때 읽을 수 없다

  - Access : 읽고 쓴다
  - 읽는다 : 불러온다
  - 쓴다 : 읽고, 수정, 삭제, 삽입한다.

- serialVersionUID : 직렬화할 때 사용된 클래스와 역직렬화할 때 사용된 클래스를 확인할 때 사용하는 필드
  - 각 클래스에 동일한 상수값 serialVersionUID 를 가지고 있다면 내용이 다르다 할지라도 직렬화 및 역직렬화를 할 수 있다.
- transferTo()
- 프론트엔드 목표 : 빠르게, 예쁘기, 편하게

### 2. memo

- [역직렬화필터링](https://countryxide.tistory.com/90)
