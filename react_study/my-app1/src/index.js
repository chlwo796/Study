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
