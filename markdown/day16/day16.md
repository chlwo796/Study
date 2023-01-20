2023년 1월 20일 금요일

---

### NCS day2

- 논리 : 개념 
- 물리 : 실제물건
- TCP/IP(Transmission Control Protocol/Internet Protocol)
- p.5 <표 1-2> TCP/IP 프로토콜 스택 구성
- 라우팅(Routing) : 데이터가 송신지에서 수신지까지 이동하는 경로를 형성하는것
  - 정적라우팅(Static Routing) : 네트워크 관리자가 직접 라우팅 테이블에 경로를 입력하여 관리하는 방법
  - 동적라우팅(Dynamic Routing) : 네트워크 관리자가 직접 개입하지 않고 라우터 간에 정보를 교환하면서 경로를 관리하는 방법
- `nslookup(name server lookup) domain name(주소)` : IP 주소 확인
- `ipconfig /all` : 로컬네트워크 IP 정보 확인
- `tracert ip주소` : 라우터 경로 추적, 확인
- `ping domain name` : 접속 여부 확인(신호전송) 
- 미들웨어 : 운영체제와 응요소프트웨어 사이에서 다양한 기능을 지원하는 소프트웨어
  - 운영체제(윈도우, 리눅스, 맥)
  - 응용프로그램(Application) - msoffice, 한글 등
- 웹 어플리케이션 서버(WAS)
  - Web Application Server
  - web system에서 전달된 Request를 처리하기 위해 transaction 관리, session 유지, 부하분산 등의 역할을 하는 서버의 소프트웨어
- p.33 [그림 2-4] 웹 어플리케이션 서버 처리 흐름 예시
- 데이터베이스 관리 시스템(DBMS : Database Management System) : 다수의 응용소프트웨어 및 사용자가 데이터베이스에 접근하여 원활하게 사용할 수 있도록 중간에서 관리해주는 시스템

---

- 프로토콜 : 통신 규약
  - 웹페이지 html주고 받기 - HTTP
- 인트라넷 : 사내망, 학교망 등 한정된 사용자가 사용할 수 있는 전산망
- FTP프로토콜 : 파일 송수신용 프로토콜
- (연결지향형 / 비연결지향형), (동기화 / 비동기화)
  - 연결지향형(동기화) - 두 A와 B네트워크가 연결된 상태에서 자료를 주고 받는 것(전화 등)
    - 바로 확인 가능함, 정보보안 강점, 송신측에서는 연결될 때까지 기다려야함
  - 비연결지향형(비동기화) - 두 A네트워크와 B네트워크가 연결과 상관없이에서 자료를 주고 받는 것(이메일, 카톡 등)
    - 송신측에서는 연결될 때까지 안 기다려도됨
- TCP :  연결지향형이다
- 관계형 데이터베이스 : 정형화된 데이터의 관계성 표현한 데이터베이스
- MongoDB : NoSQL문(자료를 키와 값을 구분 "name" :  "정현희")
- `create table 테이블명` : 테이블 만들기 
- `alter table 테이블명` : 테이블 수정하기 
- `drop table 테이블명` : 테이블 삭제하기 
- SQL - 데이터베이스를 제어하는데 사용하는 명령어
- PL/SQL - SQL문을 프로그램처럼 만든 것 확장SQL문
- CRUD
  - Create : 만들다(테이블만들기, 자료 삽입(insert))
  - Read : 읽는다. select 
  - Update : 수정한다(테이블 고친다 - alter, 자료고치는 것 - update)
  - Delete : 지운다(테이블 - drop, 자료 지운다 - delete)