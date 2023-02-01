2023년 2월 1일 수요일

---

- `.equalsIgnoreCase(" ")` : 대소문자 구분없는 `eqauls()` method
- 이클립스와 깃 바로 연동하기(https://cafe.naver.com/thisiscoding)
- 객체지향프로그램 핵심가치
  - 단순하게
  - 중복하지 말자
  - 역할별로 메소드명 동일하게 하자
- 상속연습문제, 성적 프로그램
- import -> temp folder 생성후 거기에 압축을 푼다.(패키지 이름이 같으면 안열린다. 이름이 안바껴서)
- general에 맞는 옵션에따라 import해야한다.(이미 있는프로젝트, 새로운 프로젝트, 파일 타입 등..)
- 1331 다형성 문제설계
  1. 기본설계
  1. 메인 메소드가 있는 클래스
  1. 역할 : 메뉴나오게, 비즈니스클래스 객체생성해서 필요한 메소드호출, 배열로 만들어서
  1. 비지니스클래스
  1. 매출현황구하기
  1. 입력하기(제품명, 판매량)
  1. 출력하기
  1. 부모클래스
  1. 지사명, 제품명, 제품가격, 판매량, 매출현황(공통사항)
  1. 자식클래스
  1. `toString() overriding` : 참조변수를 출력하면 지사명이 나오게
  1. 상세설계
     1. SaleMain.java
        - while사용해서 메뉴
     2. SaleBusiness.java
        1. saleStatus()
        2. input()
        3. output()
     3. Jisa.java
        1. JisaName, proName, proPrice, saleAmount, saleStatus
     4. SeoulJisa, kyeonginJisa, KangwonJisa, JejuJisa.java
        1. toString overriding

### Interface

- 인터페이스 : 역할 명시, 추상메소드의 집합
- 구현클래스 : 실제구현
- 객체생성은 구현클래스만 가능하다.(interface x)
- 인터페이스는 추상메소드만 다 모아 놓은 객체들의 용도, 역할을 지정한다.
- 인터페이스에 넣을 수 있는 것들
  1. 주로 넣는 것은 추상메소드
  2. 상수
  3. default
  4. static
  5. private 등 ... 많지만 외울필요x

### html

- 화면구현 수업 시작.
- 인터넷에 tutorial site 참조
