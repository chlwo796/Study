2023년 2월 20일 월요일

---

## day35

### 1. remind

- TreeSet, TreeMap
- Comparable, Comparator
- 트리구조, 동등비교(Set)

---

### 2. java

- LIFO(List In First Out) : 후입선출, stack구조(함수처리), 사칙연산에서 복잡한 것을 처리할 때 사용

  ```java
  main(){
      a1();
  }
  a1(){
      a2(); // a2를 호출하기 위해 a1을 호출을 하며, a2->a1순서로 실행
  }
  ```

- FIFO(First In First Out) : 선입선출, queue구조
- Queue구조 : 후입선출, 순차처리, i/o에서 데이터 순서 기억해주는 메모리- 채널
- 버퍼메모리 :
- 캐쉬메모리 :
- 데큐(Ddouble-ended Queue) : 큐와 스택의 장점을 합쳐놓은 자료구조
- `String substring(index)` : 문자열을 index기준으로 분리
- `String indexOf()` : 찾고자하는 문자의 index를 리턴
- chap.15 확인문제

---

### 3. memo

- [Stack, Queue, Double-endedQueue](https://velog.io/@sdh7700/%EC%8A%A4%ED%83%9DStack-%ED%81%90Queue-%EB%8D%B0%ED%81%90Double-ended-Queue)
- [문자열분리](https://codechacha.com/ko/java-substring-or-split/#2-stringsubstring%EC%9C%BC%EB%A1%9C-%EB%AC%B8%EC%9E%90%EC%97%B4-%EC%9E%90%EB%A5%B4%EA%B8%B0)
- ncs 실습문제1 : 100 이하의 양의 정수만 입력받아서 1~입력받은 정수까지의 합 구하기
- ncs 실습문제2 : 국어, 영어, 수학, 과학점수를 입력받아서 배열리스트 저장하고 총점, 평균 구하기
