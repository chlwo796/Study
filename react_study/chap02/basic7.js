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

// && 와 ||

const num = null;
const fee = num || "금액을 설정하지 않았습니다";
console.log(fee);

const num1 = 100;
const fee1 = num1 || "금액을 설정하지 않았습니다.";

console.log(fee1);

// || 연산은 처음에 조건인 true 이면 반환, 거짓이면 뒤로 가면서 true찾는다.
// && 연산은 마지막까지 조건이 모두 true면 마지막 것을 반환
const num2 = 100;
const fee2 = num2 && 200 && null;
console.log(fee2);

const fee3 = null || 100 || 200;
console.log(fee3);

const fee4 = null || undefined || (null && undefined);
console.log(fee4);
