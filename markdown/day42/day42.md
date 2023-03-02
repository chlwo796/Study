2023년 3월 2일 목요일

---

## day42

### 1. java

- thread : 멀티프로그램(전화, 인터넷 사용 등)

```java
implements Runnable{
run(){
    // 전화걸기
}
}

extends Thread{
run(){

}
}
```

- Thread.sleep(milliseconds)
- t2.join() : 동시 실행중 t2스레드가 먼저 끝나고 join을 호출한 스레드 실행대기
- 스레드동기화
- 임계영역 : 스레드가 사용하고 있는 메소드를 다른 스레드가 사용하지 못하게 막아 주는 영역
- `synchronized`
  - `public synchronized returnType methodName(){}` : 메소드 전체를 임계영역으로 만들기
  - `synchronized(this){}` : 메소드의 일부분을 임계영역으로 만들기
- `notify()`, `wait()` : 충돌하지않고 교차실행
- 안전종료 스킵
- 데몬(daemon)스레드 : 주 스레드의 작업을 돕는 보조적인 역할을 수행하는 스레드, 주 스레드가 종료되면 같이 따라서 자동종료
- 실제로 스레드 코드는 run() 메소드 override하지 않고 스레드 풀을 이용한다.
- 스레드풀(thread pool) : 작업 처리에 사용되는 스레드를 제한된 개수만큼 정해놓고 작업 큐(queue)에 들어오는 작업들을 스레드가 하나씩 맡아 처리하는 방식
- 스레드풀 스킵
- chap.16 람다식
- 람다식은 코드를 간단하게 표현할 수 있는 방법
- `@FunctionalInterface` : 함수적 인터페이스, 하나의 추상메소드만 가지고 있는 인터페이스, 실제 붙이는 것은 선택사항
- 람다식은 함수적 인터페이스만 사용 가능
- return문 하나만 있을 경우에는 중괄호와 함께 생략 가능

---

### 2. memo

- [피보나치수열](https://memostack.tistory.com/92#article-2-3--3--%EC%9E%AC%EA%B7%80%EC%A0%81%EC%9C%BC%EB%A1%9C-%EB%B0%98%EB%B3%B5%ED%95%98%EC%97%AC-%ED%91%B8%EB%8A%94-%EB%B0%A9%EB%B2%95)
- [DAO, DTO, VO](https://melonicedlatte.com/2021/07/24/231500.html)
- [신선식품웹사이트 js실습](https://cafe.naver.com/thisiscoding)
