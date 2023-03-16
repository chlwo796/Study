console.log("test");
const title1 = document.getElementById("title");
console.log(title1);

const container1 = document.getElementsByClassName("container");
console.log(container1);

const title2 = document.querySelector("#title");
// 처음 클래스 .container만 선택해준다.
const container2 = document.querySelector(".container");
console.log(title2);
console.log(container2);

const h1Qs = document.querySelector("h1");
console.log(h1Qs);
// 첫 p태그
const pQs = document.querySelector("p");
console.log(pQs);

const container3 = document.querySelectorAll(".container");
// container[index]에 textContent 출력
console.log(container3[0].textContent);

console.log(container3[2].innerHTML);

// 태그 수정
container3[2].innerHTML = "<h3> 이걸로 수정해줘 </h3>";
console.log(container3[2].innerHTML);

// 태그 만들기 <h1> <p>

const divEl = document.createElement("div");
console.log(divEl);

const abcEl = document.createElement("abc");
console.log(abcEl);
const h3El3 = document.createElement("h3");

divEl.appendChild(h3El3);
console.log(divEl);

const bodyEl = document.querySelector("body");
bodyEl.appendChild(divEl);
console.log(bodyEl);
// 삭제하기
// bodyEl.removeChild(divEl); // 자식요소가 있어서 삭제불가

bodyEl3.removeChild(h3El3);
