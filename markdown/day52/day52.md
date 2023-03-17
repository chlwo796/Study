2023년 3월 16일 목요일

## day52

### 1. js

- chap.03 DOM
- DOM 작성, 추가, 삭제

  ```css
  .container {
    border: solid 1px #ccc;
    padding: 16px;
    margin: 8px;
  }
  ```

  ```html
  <!DOCTYPE html>
  <html>
    <head>
      <meta charset="utf-8" />
      <meta http-equiv="X-UA-Compatible" content="IE=edge" />
      <title>Page Title</title>
      <meta name="viewport" content="width=device-width, initial-scale=1" />
      <link
        rel="stylesheet"
        type="text/css"
        media="screen"
        href="src/style.css"
      />
    </head>
    <body>
      <h1 id="title">Hello World!!</h1>
      <div class="container">
        <p>영역 1입니다.</p>
        <h3>영역 h3입니다.</h3>
      </div>
      <div class="container">
        <p>영역 2입니다.</p>
      </div>
      <div class="container">
        <p>영역 3입니다.</p>
      </div>
      <script src="./src/index.js"></script>
    </body>
  </html>
  ```

  ```js
  // 콘솔창으로 js 연결여부 확인
  console.log("test");
  // id = "title" 요소
  const title1 = document.getElementById("title");
  console.log(title1);
  // container 클래스의 요소배열
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
  ```

- 메모어플리케이션

  ```html
  <!DOCTYPE html>
  <html>
  <head>
      <meta charset="utf-8" />
      <meta http-equiv="X-UA-Compatible" content="IE=edge" />
      <title>간단 메모 어플리케이션</title>
      <meta name="viewport" content="width=device-width, initial-scale=1" />
      <link
      rel="stylesheet"
      type="text/css"
      media="screen"
      href="./src/style1.css"
      />
  </head>
  <body>
      <h1 id="title">간단 메모 어플리케이션</h1>
      <input id="add-text" />
      <button id="add-button">추가</button>
      <div class="container">
      <p>메모 목록</p>
      <ul id="memo-list"></ul>
      </div>

      <script src="./src/index1.js"></script>
  </body>
  </html>
  </header>
  ```

  ```js
  document
    .getElementById("add-button")
    .addEventListener("click", () => onClickAdd());

  const onClickAdd = () => {
    const textEl = document.getElementById("add-text");

    const text = textEl.value;
    textEl.value = "";

    const li = document.createElement("li");
    const div = document.createElement("div");

    const p = document.createElement("p");
    p.textContent = text;

    const button = document.createElement("button");
    button.textContent = "삭제";

    button.addEventListener("click", () => {
      const deleteTarget = button.closest("li");

      document.getElementById("memo-list").removeChild(deleteTarget);
    });

    div.appendChild(p);
    div.appendChild(button);
    li.appendChild(div);

    document.getElementById("memo-list").appendChild(li);
  };
  ```

  ```css
  .container {
    border: solid 1px #ccc;
    padding: 16px;
    margin: 8px;
  }
  li > div {
    display: flex;
    align-items: center;
  }
  button {
    margin-left: 16px;
  }
  ```

---

### 2. memo
