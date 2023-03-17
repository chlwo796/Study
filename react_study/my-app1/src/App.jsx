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
