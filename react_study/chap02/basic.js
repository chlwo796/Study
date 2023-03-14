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
