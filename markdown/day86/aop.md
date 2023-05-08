## AOP

**AOP의 등장배경**

- PP(Procedural Programming) : 절차지향언어, 대표적으로 c언어가 있다.

  - 절차지향언어는 개체를 순차적으로 처리하여 프로그램 전체가 유기적으로 연결되어야 한다.
  - 절차지향언어의 구조는 컴퓨터의 처리구조와 유사하며, 실행 속도가 빠르다는 것이 장점이다.

- 절차지향언어의 단점

  - 유지보수의 어려움
  - 엄격하게 순서가 정해져 있어 비효율적

- OOP(Object Oriented Programming) : 객체지향언어, 대표적으로 java, c++, python 등

  - 객체지향언어는 프로그램을 다수의 객체로 만들고, 이들끼리 서로 상호작용하도록 만드는 프로그래밍 언어이다.
  - 재사용성, 생산성 증가(유지보수용이), 자연스러운 모델링의 장점이 있다.

- 객체지향언어의 단점
  - 느린 개발 속도 : 모든 객체의 역할과 기능을 이해해야 하기 때문에, 프로그래밍에 많은 시간이 소요
  - 느린 실행 속도 : 객체지향언어의 처리속도는 절차지향언어보다 느리다.

처음 프로그래밍 언어가 생겨나고 프로그램이 생기기 시작

- OOP의 모듈성의 단위는 class, AOP의 모듈성의 단위는 aspect
- Aspect는 여러 유형과 개체를 가로지르는 트랜잭션 관리와 같은 문제의 모듈화를 가능하게 한다.

  - 어플리케이션 내 여러 군데에 흩어져 있는 코드/기능이며, 실제 비지니스 로직과는 다르다(ex. 트랜잭션 관리)
  - 각 Aspect는 고유한 Cross-Cutting 기능에 초점을 맞추고 있으며, 여러 객체에 공통적으로 적용되는 관심 사항이다.

- JoinPoint : 프로그램이 실행중일 때 발생하는 메소드실행, 생성자 호출, 필드값 변경 등과 같은 특수한 지점을 의미한다.(AOP에서 말하는 Aspect는 어디에서(PointCut) 무엇을 할 것인지(Advice)를 합쳐놓은 개념)
- Advice : 특정 Joinpoint의 Aspect에 의한 동작을 의미
- PointCut : JoinPoint의 정규표현식, JoinPoint가 PointCut에 일치할 때마다 해당 PointCut에 관련된 Advice가 실행된다.
- Weaving : Aspect를 대상 객체에 연결시켜 관점지향 객체로 만드는 과정을 의미한다.(Advice를 비즈니스 로직 코드에 삽입하는 것을 의미)
- Cross-Cutting-Concern : 횡단 관심사항. 로깅, 트랜잭션, 보안과 같이 다수의 비지니스 로직에서 반복적으로 발생하는 부분을 의미하며, 이러한 반복적으로 발생하는 코드/기능을 한데로 모아 공통적인 기능을 만들게 된다.
- Spring 의 주요 구성 요소 중 하나는 AOP프레임워크이다.

- 스프링 AOP 프레임워크는 제한된 타입의 AspectJ 포인트컷만 지원하며 IoC 컨테이너에 선언한 빈에 한하여 Aspect를 적용할 수 있다.
- 따라서 포인트컷 타입을 추가하거나, IoC 컨테이너 외부 객체에 어스펙트를 적용하려면 스프링 어플리케이션에서 AspectJ 프레임워크를 직접 끌어쓰는 수밖에 없다.
- Weaving(엮어넣기)는 Aspect를 대상 객체에 적용하는 과정이며, 스프링 AOP는 런타임에 동적 프록시를 활용해 Weaving을 하는 반면, AspectJ 프레임워크는 compile-time(컴파일 시점에 하는) Weaving, load-time(로드하는 시점에 하는) Weaving 모두 지원한다.
- AspectJ LTW(Load Time Weaving)은 JVM이 클래스로더를 이용해 대상 클래스를 로드하는 시점에 일어난다.

### memo

- pojo(Plain Old Java Object) : 다른 클래스나 인터페이스를 상속/implements 받아 메서드가 추가된 클래스가 아닌 일반적으로 getter, setter와 같이 기본적인 기능만 가진 자바 객체

  - 객체 지향적인 원리에 충실하면서, 환경과 기술에 종속되지 않고 필요에 따라 재활용될 수 있는 방식으로 설계된 오브젝트

- [참고](https://3months.tistory.com/74)
- [spring aop 공식설명](https://docs.spring.io/spring-framework/docs/2.5.5/reference/aop.html)
- [스프링 기초와 원리, 코드로 설명](https://velog.io/@shlee327/%EC%8A%A4%ED%94%84%EB%A7%81-%EA%B8%B0%EC%B4%88%EC%99%80-%EC%9B%90%EB%A6%AC%EB%A5%BC-%EC%95%8C%EC%95%84%EB%B3%B4%EC%9E%90)
- [DispatcherServlet](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/servlet/DispatcherServlet.html)
- [AOP](https://www.linkedin.com/pulse/aspect-oriented-programming-spring-aop-ahmed-marey)
- [Understanding AOP Proxies](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#aop-proxying)
- [AOP Guide](https://www.springframework.net/doc/reference/html/aop-quickstart.html)
