2023년 2월 6일 월요일

---

- 클래스관계

  - 상속관계 : is a ~은 ~이다.
  - 사용관계 : has a ~은 ~을 가지고있다.

- 중첩클래스

```java
class A1{
    classB1{
        // 밖의 클래스멤버 객체생성 없이 바로 사용
        // 단점 : static은 사용할 수 없다.
    }
}
class A2{
    static classB2{
        // 클래스 속의 static class
        // 단점 : 인스턴스멤버는 사용할 수 없다.
        // static class field는 final로 간주한다.
    }
}
class A3{
    void methodB(){
        class B3{
            // method 속 class = 메소드독점, 정보은닉
            // methodB()가 호출되어야만 사용가능
            // B3를 사용하려면 객체생성 후 B3의 method를 호출까지 한 후 종료되어야 한다.
        }
    }
}
```

- 컴파일단계 -> 빌드단계 -> 실행
- 클래스로더단계에서 static 붙어있는 것은 메소드 영역에 올라간다.
- 빌드단계에서 `new` 하면 static 안 붙어 있는 것들이 힙메모리영역에 올라간다.
- p.413 익명객체 매우 중요.
- 인터페이스 선언 후 사용하려면 반드시 구현클래스 implements하고 구현클래스를 `new` 사용한다.
- 익명객체 : 구현클래스 이름을 익명으로 하는 것
- 조건 : `extends` 혹은 `implements`
- 상속할때 자식의 이름을 익명으로, implements할 때 구현클래스를 익명으로 한다.
- html : 로그인 화면 구현