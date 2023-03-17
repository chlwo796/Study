2023년 3월 15일 수요일

---

## day51

### 1. js

- 스프레드 구문 : `...`

  ```js
  // 2.6 스프레드구문

  // 1. 요소 전개

  const arr1 = [1, 2, 3];
  console.log(arr1);
  console.log(...arr1); // 내부요소를 순차적으로 전개할 수 있다.

  const obj1 = {
    name: "홍길동",
    age: 24,
  };
  console.log(obj1.name, obj1.age);

  const summaryFunc = (num1, num2) => console.log(num1 + num2);

  summaryFunc(arr1[0], arr1[1]);
  // 요소를 지정하여 나열하지 않고 모든 요소를 전달할 수 있다.
  summaryFunc(...arr1);

  const arr2 = ["홍길동", 24, 100];
  const func2 = (name, age, score) =>
    console.log(`${name}, ${age}살, ${score}점`);
  func2(...arr2);

  // 요소 모으기(새로운 배열을 생성)
  const arr3 = [1, 2, 3, 4, 5];
  // arr4에 요소들을 모아준다.
  const [num1, num2, ...arr4] = arr3;

  console.log(num1, num2, arr4);

  const arr5 = ["홍길동", 24, 100, 80, 90, 65];

  const [name, age, ...arr6] = arr5;
  const sum = (arr) => {
    let sum = 0;
    for (let i = 0; i < arr.length; i++) {
      sum += arr[i];
    }
    return sum;
  };

  const print = (name, age, arr6) =>
    console.log(`이름은 ${name}, 나이는 ${age}, 총점은 ${sum(arr6)}점입니다.`);
  print(name, age, arr6);

  // 요소 복사와 결합

  const arr7 = [10, 20];
  const arr8 = [30, 40];
  const arr9 = [...arr7];
  console.log(arr9);

  const arr10 = [...arr7, ...arr8];
  console.log(arr10);
  // 객체의 경우
  const obj2 = {
    val1: 10,
    val2: 20,
  };
  const obj3 = {
    val3: 30,
    val4: 40,
  };
  const obj4 = {
    ...obj2,
  };
  console.log(obj4);
  const obj5 = {
    ...obj2,
    ...obj3,
  };
  console.log(obj5);

  // = 를 써서 복사하지 않는 이유
  // 주소까지 복사가 되기 때문에 중간에 바꾸면 값이 같이 바뀐다.
  // 얕은복사 : 주소만 복사
  // 깊은복사 : 값까지 복사
  arr10[0] = 100;
  console.log(arr10);
  console.log(arr7);
  arr9[0] = 20;
  console.log(arr9);
  console.log(arr7);
  ```

- 쇼트핸드(shorthand) : 생략 표현, 객체의 속성명과 설정할 변수명이 같으면 생략할 수 있다.

  ```js
  // 2.7 객체 생략 표기법

  const name = "홍길동";
  const age = 24;

  // const 객체명 = {
  //     속성명(또는 필드명): 값
  // }

  const user = {
    // (name:)생략, (age:)생략
    name,
    age,
  };
  // (user.)생략
  console.log(name, age);
  ```

- map() : 배열을 순서대로 처리한 결과를 배열로 받을 수 있다.
- 완전한 map() 메소드 구문

  `arr.map(function(element, index, array){  }, this);`

  ```js
  // const 새로운배열 = 배열명.map()

  const nameArr1 = ["누시다", "사키오카", "고토"];
  const nameArr2 = nameArr1.map((n) => console.log(n));
  console.log(nameArr1);
  // console.log(nameArr2);

  const ageArr1 = [10, 20, 30, 40];
  ageArr1.map((n) => {
    if (n < 20) {
      console.log("미성년");
    } else {
      console.log("성년");
    }
  });
  // index를 이용
  ageArr2 = [10, 20, 30, 40];
  ageArr2.map((n, index) => {
    if (n < 20) {
      console.log(`${index + 1}번째는 미성년입니다.`);
    } else {
      console.log(`${index + 1}번째는 성년입니다.`);
    }
  });
  ```

- filter() : return 뒤에 조건식을 입력하여 일치하는 것만 반환

  ```js
  // filter
  const intArr1 = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];

  const newArr1 = intArr1.filter((n) => {
    return n % 2 === 0;
  });
  console.log(intArr1);
  console.log(newArr1);
  const evenArr2 = intArr1.filter((n) => n % 2 === 0);
  console.log(evenArr2);
  ```

- 삼항연산자 `(조건) ? (true) : (false)`

  ```js
  // 삼항연산자

  const val1 = 1 > 0 ? "참" : "거짓";
  console.log(val1);

  const printFormattedNum = (num) => {
    const formattedNum =
      typeof num === "number" ? num.toLocaleString() : "숫자를 입력하십시오";
    console.log(formattedNum);
  };
  printFormattedNum(123456700);
  printFormattedNum("홍길동");

  const checkSumOver100 = (num1, num2) => {
    return num1 + num2 > 100 ? "100을 넘었습니다" : "허용 범위입니다.";
  };

  console.log(checkSumOver100(50, 40));
  console.log(checkSumOver100(70, 80));

  const checkMiddle = (num1, num2, num3) => {
    return num1 > num2 && num2 > num3
      ? num2
      : num1 > num3 && num3 > num2
      ? num3
      : num1;
  };
  console.log(checkMiddle(19, 5, 3));
  ```

- 논리연산자 `&&` `||`

  ```js
  // || 연산은 처음에 조건인 true 이면 반환, 거짓이면 뒤로 가면서 true찾는다.
  // && 연산은 마지막까지 조건이 모두 true면 마지막 것을 반환
  const num2 = 100;
  const fee2 = num2 && 200 && null;
  console.log(fee2);

  const fee3 = null || 100 || 200;
  console.log(fee3);

  const fee4 = null || undefined || (null && undefined);
  console.log(fee4);
  ```

---

### 2. memo

- [자바스크립트 map() 함수](https://www.freecodecamp.org/korean/news/javascript-map-method/)
