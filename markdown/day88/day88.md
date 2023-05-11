2023년 5월 11일 목요일

## day88

### 1. memo

- si : system integration, 시스템 통합 => 처음부터 만드는 것

  - 레거시 => 리뉴얼 => 새로 만드는 것
  - 2~3년 정도는 경험해야 생태계를 잘 알 수 있을듯

- sm : system management, 시스템 유지보수 => 만든 시스템을 운영하는 것
- se : system engineer, 시스템 엔지니어 => 서버실 직접 운영(운영비용추가, 인력비)
- 클라우드시스템(AWS EC2, GF, NAVER)

- 입사가능 네임드회사 조건 : 학벌을 안볼것, 코테
- 경력직 코테 : 시스템구성 설계
- 코테준비 : 무작정 풀어보기, 프로그래머스
- 개념공부 : 인강추천x, 예전 개념책은 원념적이라 추천x
- 소프트웨어 버전관리 : 대부분 3단계(1.1.1)
- 회사거르기 : 최소 jdk 버전 1.8
- 로그인 시 post방식을 사용하는 이유(url 캐시가 남는다. url에 키밸류노출 방지)

### Servlet

- ip : 16진수, internet protocol

  - ip4 : 255.255.255.255

- DNS : domain name service
- [JSP vs Servlet](https://velog.io/@alicesykim95/JSP-Servlet-%EC%84%9C%EB%B8%94%EB%A0%9B)
- Controller
- Service
- Repository : db접근객체, myBatis
- vo : value object
- lombok : 컴파일 시(객체가 메모리에 올라갈 시)에 메소드 사용가능토록 함

### jsp 의 scope(생명주기)

- page : 제일 작은 범위
- request : 요청시에만 응답, 응답시 요청과 함께 소멸
- session : 서버와 브라우저의 연결, 로그아웃시에 소멸
- application : 제일 큰 범위.

- el태그 : `${}`, expression language
