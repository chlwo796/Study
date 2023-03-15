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
