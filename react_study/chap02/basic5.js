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

// 2.8 map, filter
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

const nameArr3 = ["홍길동", "이순신", "최수연"];
const ageArr3 = [24, 14, 15];
const newArr = ageArr3.map((n) => {
  if (n > 20) {
    return "성년";
  } else {
    return "미성년";
  }
});

ageArr3.map((n, index) => {
  if (n < 20) {
    console.log(`${nameArr3[index]}은 ${ageArr3[index]}살 미성년입니다.`);
  } else {
    console.log(`${nameArr3[index]}은 ${ageArr3[index]}살 성년입니다.`);
  }
});

const result = (n) => {
  if (n < 20) return "미성년";
  else return "성년";
};
ageArr3.map((n, i) =>
  console.log(`${nameArr3[i]}은 ${n}살 ${result(n)}입니다.`)
);
