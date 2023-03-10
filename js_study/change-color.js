let text = document.getElementById("text");
text.onclick = function () {
  text.style.fontSize = "20px";
  text.style.backgroundColor = "red";
  // 변수 입력
  let number = 100;
  // 알림
  alert(number + "클릭을 하셨습니다.~~");

  console.log(number + "콘솔창에 출력하기");
};
// var은 자료타입이 계속 바뀐다.
// '' "" 특별히 구분하지 않는다.

let text1 = document.getElementById("text1");

text1.onclick = function () {
  let name = "홍길동";
  // 확인 취소 선택
  let result = confirm(name + "자바");
  // 확인 = true, 취소 = false
  if (result) {
    alert(name);

    for (let i = 0; i < 10; i++) {
      console.log(name + i);
    }
  } else {
    alert("다른사람입니다.");
  }
};

let text2 = document.querySelector("#text2");
text2.onclick = function () {
  let name = prompt("이름을 입력해 주세요", "홍길동");
  // 국어점수
  alert(name);

  let score1 = prompt("국어점수 입력");
  let score2 = prompt("수학점수 입력");
  result1 = parseInt(score1, 10);
  result2 = parseInt(score2, 10);
  // let total = Number(score1) + Number(score2);
  // let avg = total / 2;
  sum = result1 + result2;
  average = sum / 2;
  alert(
    "이름 : " +
      name +
      "국어 : " +
      score1 +
      "수학 : " +
      score2 +
      "합계 : " +
      sum +
      "평균 : " +
      average
  );
  // 결과를 웹브라우저에 출력하기
  // document.write("<p> 내용 </p>")
  document.write(
    "<p> 이름 : " +
      name +
      "국어 : " +
      score1 +
      "수학 : " +
      score2 +
      "합계 : " +
      sum +
      "평균 : " +
      average +
      "</p>"
  );
};

let gugudan = document.getElementById("gugudan");

gugudan.onclick = function () {
  let number = prompt("알고 싶은 구구단은?");
  let n = prompt("한번더");
  for (let j = number; j <= n; j++) {
    document.write(j + "단<br>");
    for (let i = 1; i <= 9; i++) {
      document.write(j + " * " + i + " = " + i * Number(j) + "<br>");
    }
  }
};
