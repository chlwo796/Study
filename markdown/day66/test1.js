"use strict";

function loginFunc() {
  let userid = document.getElementById("id").value; // userid 의 값을 받아와 넣음.
  let userpw = document.getElementById("password").value; // userpw 의 값을 받아와 넣음.

  if (userid === "ezen" && userpw === "ezen1234") {
    let check = document.getElementById("check");
    check.value = "로그인 되었습니다.";
  }
}
