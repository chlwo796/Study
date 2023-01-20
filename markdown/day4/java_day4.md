2023년 1월 4일 수요일

---

### 자바 구조와 문장

- `class` : java programm의 단위. class이름은 대소문자를 구분하면 public인 경우 반드시 file name과 일치해야한다.
- `package` :  관련된 다양한 java class가 모여있는 folder
- java class의 구조
  - field : 소속 변수
  - method : code를 실행하는 기능의 단위

- 함수와 method의 차이점
  - 함수는 독립적으로 존재하고 method는 class에 종속적인 함수이다. 둘다 공통적으로 code를 실행하는 기능의 단위는 동일하다. 다만 class에 종속되어 있는가 아닌가의 여부로 불리는 형태가 다르다. method를 다른말로는 class 함수라고 부르기도 한다.

```java
public class Hello{

    String fd="k";  //필드

   pbulic static void main(String[] args) { //메소드
  }

}
```

### 키워드와 식별자


- keyword : 프로그래밍 언어에서 문법작으로 의미 있는 단어로 사용하기 위해 미리 정의해 놓은 단어
  - 기본타입 : boolean, true, false, byte, short, int, long, float, double, char
  - 제어문관련 : break, continue, case, default, do, else, switch, while, for, if
  - 접근 제한자 - private, protected, public, default
  - class, method, member : final, abstract, static
  - class 관련 : interface
  - 기타 - synchrnized, transient, volatile, native, strictfp
  - class 관련 : class, new, super, this, instanceof
  - 예외 관련 : try, catch, finally, throw, throws
  - method 관련 : return, void
  - debug 관련 : assert
  - 상속/구현 관련 : extends, implements
  - 패키지 관련 : package, import
  - 기타 : const, goto, enum
  
- identifier(식별자) : 프로그래머가 정의하여 사용하는 이름
  - class명, 변수명, method명, 배열명 등

- `camel style` : code를 작성할 때 여러 단어를 혼합하여 명명하는 경우, 낙타의 등처럼 대소문자가 섞여있도록 작성하는 스타일. java source file과 변수명을 작성할 때 관례적으로 사용.
  - class명은 대문자로 시작한다.
    - Week.java
    - MemberGrade.java
    - ProductKind.java
  - 변수명은 소문자로 시작한다.
    - score
    - mathScore
    - sprtsCar
  

