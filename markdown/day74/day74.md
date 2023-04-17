2023년 4월 17일 월요일

## day 74

### 1. spring

- Model : 데이터 혹은 데이터를 처리하는 영역
  - VO : 컨트롤러, DAO 중간에서의 비즈니스 영역
  - DAO : 데이터베이스랑 관계
- View : 결과 화면을 만들어 내는 데 사용하는 자원
- Controller : 웹의 요청(request)를 처리하는 존재로 뷰와 모델 사이의 중간 통신 역할
- 모델 2 구조

  ![](./MVC_model2.png)

  - 모델 2에서 모든 요청은 기본적으로 컨트롤러를 호출
  - 각 컨트롤러는 자신을 호출하는 특정한 URI 경로를 가지고 있다.

- 장점
  - 개발자와 웹 퍼블리셔의 영역을 분리
  - 컨트롤러의 URI를 통하여 뷰를 제어하기 때문에, 뷰의 교체나 변경과 같은 유지보수에 유용하게 사용될 수 있다.

---

### 2. memo

- [Mysql | public key retrieval is not allowed 에러](https://deeplify.dev/database/troubleshoot/public-key-retrieval-is-not-allowed)
