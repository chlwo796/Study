2023년 3월 17일 금요일

---

### 1. react

- 리액트 기본 구조는 index.html ("root")-> index.js -> App.js
- `render(`)` : 렌더링(웹페이지 표시)
- App.jsx

  ```jsx
  // default 처리하지 않은 컴포넌트 import
  import { Header } from "./components/Header";
  import { Footer } from "./components/Footer";
  import { Content } from "./components/Content";
  import { News } from "./components/News";
  import { Advertisement } from "./components/Advertisement";
  const App = () => {
    const onClickButton = () => {
      console.log("버튼이 눌려짐");
      alert("버튼을 누름");
    };
    const onClickButton2 = () => {
      const ok = window.confirm("리액트 좀 할만 하시나요?");
    };
    const onClickButton3 = () => {
      // 버튼을 누르면 prompt로 이름을 입력받는다.
      // 출력결과 = <p> 잘지내시죠 <div> 홍길동 </div> </p>

      const name = prompt("이름을 입력하세요"); // 이름입력받기
      const divEl = document.createElement("div"); // <div>태그 만들기
      const pEl = document.querySelector("p"); // <p> 태그를 선택하기
      divEl.textContent = name;
      pEl.appendChild(divEl);
      // return (
      //   <>
      //     <p>
      //       안녕하세요
      //       <div>{name}</div>
      //     </p>
      //   </>
      // );
    };

    const onClickButton4 = () => {
      const del = document.querySelector("p");
      const divList = del.querySelectorAll("div");
      console.log("삭제");
      console.log(divList);
      if (divList.length > 1) {
        del.removeChild(divList[divList.length - 1]);
      }
    };

    const contentStyle = {
      // 속성객체를 따로 만들어서 나열
      color: "blue",
      fontSize: "20px",
    };

    const button2Style = {
      fontSize: "30px",
      color: "white",
      backgroundColor: "black",
    };
    const button3Style = {
      fontSize: "40px",
    };
    const button4Style = {
      color: "black",
      backgroundColor: "white",
    };
    return (
      <>
        {/* { 자바스크립트 함수 호출 가능} */}
        {console.log("test")}
        {/* 직접객체(컴포넌트) 삽입 {{ 다소 번거로움 }} */}
        <h3 style={{ color: "red" }}>안녕하세요</h3>
        <p style={contentStyle}>잘지내셨죠?</p>
        <Header></Header>
        <button onClick={onClickButton} style={{ backgroundColor: "red" }}>
          버튼
        </button>
        <br></br>
        <button onClick={onClickButton2} style={button2Style}>
          버튼2
        </button>
        <br></br>
        <button onClick={onClickButton3} style={button3Style}>
          버튼3
        </button>
        <br></br>
        <button onClick={onClickButton4} style={button4Style}>
          삭제버튼
        </button>
        {/* conClickButton4() 작동x */}
        {/* 함수컴포넌트를 호출할 때 () 매개변수를 쓰지 않는다. react는 jsx 라는 다소 다른 문법 */}
        <Footer></Footer>
        <Content></Content>
        <News></News>
        <Advertisement></Advertisement>
      </>
    );
  };
  export default App; // import App from "./App";
  ```

- index.js

  ```js
  // 리액트의 명령어를 가지고 있는 패키지(라이브러리)
  import ReactDOM from "react-dom";
  import App from "./App";
  // import { } from "패키지명/파일명"
  // { } : 보내는 파일에서 export
  // default 설정하면 { } 없이 import 가능
  // 여러 개일 경우 { }에 나열한다.

  // // 컴포넌트
  // const App = () => {
  //   // return()은 <>태그 하나만 있어야 한다.
  //   return (
  //     <header>
  //       <h1>안녕하세요!</h1>
  //       <p>잘지내시죠</p>
  //     </header>
  //   );
  // };

  const App1 = () => {
    const name = "홍길동";
    const age = 24;
    return (
      <>
        <h3>{name}</h3>
        <p>{age}</p>
      </>
    );
  };
  ReactDOM.render(<App />, document.getElementById("root"));
  ReactDOM.render(<App1 />, document.getElementById("root1"));
  ```

- index.html

  ```html
  <!DOCTYPE html>
  <html lang="en">
    <head>
      <meta charset="utf-8" />
      <link rel="icon" href="%PUBLIC_URL%/favicon.ico" />
      <meta name="viewport" content="width=device-width, initial-scale=1" />
      <meta name="theme-color" content="#000000" />
      <meta
        name="description"
        content="Web site created using create-react-app"
      />
      <link rel="apple-touch-icon" href="%PUBLIC_URL%/logo192.png" />
      <link rel="manifest" href="%PUBLIC_URL%/manifest.json" />
      <title>React App</title>
    </head>
    <body>
      <noscript>You need to enable JavaScript to run this app.</noscript>
      <div id="root"></div>
      <div id="root1"></div>
    </body>
  </html>
  ```

---

### 2. memo
