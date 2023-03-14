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
// 분할대입, 매번 myProfile.변수명 으로 입력하기 번거로울때
const myProfile = {
  name11: "누시다",
  age11: 24,
};
// 객체 분할 대입하면, 해당 필드와 동일한 이름의 필드 값이 자동으로 바인딩
// 일부만 추출 가능하며, 순서는 관계없다.
const { name11, age11 } = myProfile;

console.log(`내이름은 ${name11}입니다. 나이는 ${age11}세 입니다.`);

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

const myProfile3 = ["홍길동", 24, 100];

const [name33, age33, score33] = myProfile3;

console.log(
  `이름은 ${name33}이고, 나이는 ${age33}이고 점수는 ${score33} 입니다.`
);

const sayHello = (name = "게스트") => console.log(name);
sayHello(1, "최재환");
sayHello("홍길동");
sayHello();
