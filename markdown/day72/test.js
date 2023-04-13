function checkAll() {
  let male = document.getElementById("male");
  let female = document.getElementById("female");
  if (!checkLastName(form.lastName.value)) {
    return false;
  } else if (!checkFirstName(form.firstName.value)) {
    return false;
  } else if (!checkEmail(form.email.value)) {
    return false;
  } else if (!male.checked && !female.checked) {
    alert("성별을 입력해주세요.");
    form.gender.checked.focus();
    return false;
  }
  return alert("회원가입완료");
}
// 공백확인 함수
function checkExistData(value, dataName) {
  if (value == "") {
    alert(dataName + "입력해주세요!");
    return false;
  }
  return true;
}

function checkLastName(lastName) {
  //성이 입력되었는지 확인하기
  if (!checkExistData(lastName, "성을")) {
    return false;
  } else {
    return true;
  } //확인이 완료되었을 때
}
function checkFirstName(firstName) {
  //이름이 입력되었는지 확인하기
  if (!checkExistData(firstName, "이름을")) {
    return false;
  } else {
    return true; //확인이 완료되었을 때
  }
}
function checkEmail(email) {
  //email이 입력되었는지 확인하기
  if (!checkExistData(email, "이메일을")) return false;

  let emailRegExp = new RegExp("[a-z0-9]+@[a-z]+.[a-z]{2,3}");
  if (!emailRegExp.test(email)) {
    alert("이메일 형식이 올바르지 않습니다!");
    email = null;
    email.focus();
    return false;
  } else {
    return true; //확인이 완료되었을 때
  }
}
