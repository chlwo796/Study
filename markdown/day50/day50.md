2023년 3월 14일 화요일

## day50

### 1. react

- react : 프론트엔드 프레임워크
- path : `node --version`
- cmd : 명령프롬프트, cd 작업폴더
- react : `npx create-react-app my-app1`
- 목록보기 : `dir`
- 해당 폴더로 이동 : `cd my-app1`롯한 모던 자바스크립트 웹 시스템이 작성되는 방식, html 파일은 하나만 사용
- 리액트 실행하기 : `npm start`
- SPA(single page application) : 리액트를 비용하고 자바스크립트를 이용해 화면을 전환함으로서 화면이동 등의 동작을 표현
- 리액트 구조
  - `index.js` : 시작점

---

### 2. js

- 변수 선언

  - `var` : 변수를 덮어 쓸 수 있고, 다시 선언(재선언)할 수 있다.(단점)
  - `let` : 변수를 덮어쓸 수는 있지만, 재선언 불가
  - `const` : 덮어쓰기 불가, 재선언 불가(상수)

  ```js
  var val1 = "var 변수";
  console.log(val1);

  val1 = "var 변수 덮어쓰기";
  console.log(val1);

  var val1 = "다시선언";
  console.log(val1);

  let val2 = 100;
  console.log(val2);

  val2 += 300;
  console.log(val2);
  // let val2 = 300;  // let는 블록단위에서 재선언 불가
  const val3 = 2.5;
  console.log(val3 + 3);

  // val3 *= 2.7; // const는 재선언, 덮어쓰기 모두 불가능한 변수
  // 인터프리터 언어(한줄씩 해석)
  // primitive type 종류의 데이터는 const로 덮어쓸 수 없다.
  // 객체나 배열 등 오브젝트타입의 데이터는 const로 값 변경 가능
  console.log(val3);
  // 객체타입 const 선언
  const obj1 = {};
  // 배열타입 const 선언
  const arr1 = [];
  // 함수타입 const 선언
  const function1 = () => {};
  // , 로 데이터를 구분
  const obj2 = {
    name: "홍길동",
    age: 24,
    adress: "서울시",
    fun2: () => {
      console.log(this.name);
    },
    fun3: () => {
      this.age = this.age + 5;
    },
  };
  console.log(obj2.name, obj2.age);
  obj2.fun2();
  obj2.fun3();

  obj2.name = "이순신";
  obj2.age = obj2.age + 5;
  console.log(obj2.name, obj2.age);

  obj2.adress = "경기도 하남시";
  console.log(obj2.name, obj2.age, obj2.adress);

  let obj3 = {
    phone: "01012341234",
    email: "aa@naver.com",
    p_phone: () => {
      console.log(this.phone);
    },
    m_email: () => {
      email = "bb@naver.com";
    },
  };
  console.log(obj3.p_phone, obj3.email);
  obj3.p_phone();
  obj3.m_email();

  const arr2 = ["dog", "cat"];
  arr2.push(1000);

  console.log(arr2);
  ```

- 템플릿 문자열 : `\``(역따옴표 또는 백쿼트)로 문자열을 감싼다. 함수나 계산식을 넣을 수도 있다.

  ```js
  const name = "누시다";
  const age = 24;
  const message = "내이름은" + name + "나이는" + age + "입니다.";

  console.log(message);

  const message2 = `내 이름은 ${name}입니다. 나이는 ${age}세 입니다.`;
  console.log(message2);

  const name1 = "정현희";
  const birth1 = "2005년 10월 10일";
  const age1 = 24;
  const calAge = () => {
    age1 + 1;
  };
  const message1 = `내이름은 ${name}입니다. 생일은 ${birth1}이야 나이는 ${age1}이고, 내년에 ${calAge()}살이 되 `;
  console.log(message1);
  // function 함수명(인수 또는 매개변수){처리할내용}
  function func1(value) {
    return value;
  }
  console.log(func1("홍길동"));
  console.log(func1(100));
  function func2(value1, value2) {
    return value1 + value2;
  }
  const result = func2("최재환", 30);
  console.log(result);

  const aa = func2("이순신", 40);
  console.log(aa);

  // 함수명 생략하고 선언
  const func3 = function (name) {
    return name;
  };

  func3("홍길동");
  ```

- 화살표 함수 `()=>{}`

  ```js
  // 화살표 함수 선언
  const func4 = (value) => {
    return value;
  };
  console.log(func4("화살표함수"));
  // 소괄호 생략 가능, 인수가 하나일 경우만
  const func5 = (value) => {
    return value;
  };
  // 실행문이 한개면 ({}, return) 생략, {}과 return 세트로 생략해야한다.
  const func6 = (num1, num2) => num1 + num2;

  console.log(func6(3, 6));

  const func7 = (v1, v2, v3) => ({
    name: v1,
    age: v2,
    phone: v3,
  });

  console.log(func7("최재환", 30, "01041160586"));
  let result7 = func7("최재환", 30, "01041160586");
  console.log(result7.age);

  const func8 = (v1, v2) => ({
    gender: v1,
    point: v2,
  });
  // 객체를 바로 출력
  console.log(func8(true, 100));

  let result8 = func8(true, 100);
  console.log(result8.gender + " " + result8.point);
  // 형식출력
  console.log(`${result8.gender}이고 ${result8.point}`);
  ```

- 분할 대입 : 개체 속성 수가 많아지거나, 객체 변수명이 더 길어지면 매우 번거롭다. 이런 경우, 객체나 배열로부터 값을 추출하기 위한 방법
- 객체 분할 대입

  ```js
  const myProfile2 = {
    name22: "홍길동",
    email: "aa@naver.com",
    phone: "0101231234",
  };
  // 이메일 출력
  console.log(`${myProfile2.email}`);

  // 객체분할

  const { phone, name22 } = myProfile2;

  console.log(`${name22}`);
  console.log(`${phone}`);

  const { phone: cellPhone, name22: newName } = myProfile2;

  console.log(`${cellPhone}`);
  console.log(`${cellPhone}, ${newName}`);
  console.log(`${phone}`);
  ```

- 배열 분할 대입

  ```js
  const myProfile3 = ["홍길동", 24, 100];

  const [name33, age33, score33] = myProfile3;

  console.log(
    `이름은 ${name33}이고, 나이는 ${age33}이고 점수는 ${score33} 입니다.`
  );

  const sayHello = (name = "게스트") => console.log(name);
  sayHello(1, "최재환");
  sayHello("홍길동");
  sayHello();
  ```

- 객체 분할 대입의 디폴트값

  ```js
  // 디폴트값

  const myProfile = {
    age: 24,
  };
  // 객체에 속성이 존재하지 않는 경우 디폴트값 설정함
  const { name = "최재환", age } = myProfile;
  const message = `${name}님, 안녕하세요! ${age}살입니다.`;
  console.log(message);

  myProfile.name = "최수연";
  const message1 = `${myProfile.name}님, 안녕하세요! ${age}살입니다.`;
  console.log(message1);
  // 배열에 속성 추가 가능
  const arr1 = [1, 2, 3];
  const [kor, eng, mat, sci = 100] = arr1;
  console.log(kor, eng, mat, sci);
  ```

---

### 3. memo

- [git HEAD](https://kotlinworld.com/272)
- [git add, commit, push 취소](https://gmlwjd9405.github.io/2018/05/25/git-add-cancle.html)
- [.gitignore](https://adjh54.tistory.com/16)
