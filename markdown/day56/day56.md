2023년 3월 22일 수요일

## day56

### 1. react

- createContext() : 컴포넌트 사이에서 Props를 전달하지 않고 값을 공유할 수 있다.
- Context에서 글로벌 State를 사용하는 기본적인 방법

  - React.createContext로 Context의 프로바이더를 작성
  - 작성한 Context의 Provider로 글로벌 State를 다루고자 하는 컴포넌트를 감싼다.
  - State를 참조할 컴포넌트에서 React.useContext를 사용한다.

    ```jsx
    // ./components5/providers/AdminFlagProvider.jsx
    import { useState, createContext } from "react";

    export const AdminFlagContext = createContext({});

    export const AdminFlagProvider = (props) => {
      const { children } = props;
      const [isAdmin, setIsAdmin] = useState(false);
      // const sampleObj = { sampleValue: "테스트" };
      return (
        <AdminFlagContext.Provider value={{ isAdmin, setIsAdmin }}>
          {children}
        </AdminFlagContext.Provider>
      );
    };
    ```

    ```jsx
    import React from "react";
    import * as ReactDOM from "react-dom/client";
    import App from "./App";
    import reportWebVitals from "./reportWebVitals";
    import { AdminFlagProvider } from "./components5/providers/AdminFlagProvider";
    const root = ReactDOM.createRoot(document.getElementById("root"));
    root.render(
      // App 컴포넌트를 감싸준다.
      <AdminFlagProvider>
        <App />
      </AdminFlagProvider>
    );
    reportWebVitals();
    ```

    ```jsx
    // ./components/Card.jsx
    // 참조할 컴포넌트에서 useContext를 사용한다.
    import { useContext } from "react";
    import { EditButton } from "./EditButton";
    import { AdminFlagContext5 } from "./providers/AdminFlagProvider";

    const style = {
      width: "300px",
      height: "200px",
      margin: "8px",
      borderRadius: "8px",
      display: "flex",
      flexDirection: "column",
      justifiyContent: "center",
      alignItems: "center",
    };

    export const Card = () => {
      //   const { isAdmin, name } = props;
      const { name, isAdmin } = useContext(AdminFlagContext5);
      return (
        <div style={style}>
          <p>
            여기는 Card 컴포넌트
            {name} {isAdmin}
          </p>
          <EditButton />
        </div>
      );
    };
    ```

    ```jsx
    // ./components/EditButton.jsx
    // 참조할 컴포넌트에서 useContext를 사용한다.
    import { useContext } from "react";
    import { AdminFlagContext5 } from "./providers/AdminFlagProvider";
    const style = {
      width: "100px",
      padding: "6px",
      borderRadius: "8px",
    };

    export const EditButton = () => {
      //   const { isAdmin, name } = props;
      const modifyButton = () => {
        alert("수정버튼을 눌렀습니다.");
      };
      //   const contextValue = useContext(AdminFlagContext5);
      const { isAdmin, name } = useContext(AdminFlagContext5);
      //   console.log(contextValue);
      console.log(isAdmin, name);
      return (
        <>
          <button style={style} disabled={!isAdmin} onClick={modifyButton}>
            수정
          </button>
          {isAdmin ? (
            <span>관리자모드 {name} </span>
          ) : (
            <span> 일반인모드 {name}</span>
          )}
        </>
      );
    };
    ```

- 라우터 <a href = ""> : 사용자가 요청한 URL에 따라 해당 URL에 맞는 페이지를 보여주는 것
- 리액트 라우터(React Router) : 사용자가 입력한 주소를 감지하는 역할을 하며, 여러 환경에서 동작할 수 있도록 여러 종류의 라우터 컴포넌트를 제공한다.
- BrowserRouter : HTML5를 지원하는 브라우저의 주소 감지
- HashRouter : 해시 주소(http://goddaehee.tistory.com/#test)를 감지 한다
- `npm install react-router-dom`, `yarn add react-router-do`
- 타입스크립트 : 문자열 String, 숫자 number, <제네릭>
- `npx create-react-app [프로젝트명] --template typescript`
- `.tsx` : 마이크로소프트사의 open 스크립트

  ```tsx
  // ./components1/TypeEx01.tsx
  export const TypeEx01 = () => {
    const ex = () => {
      let str: string = "A";
      str = "B";
      //  str = 100;
      let num: number = 0;
      num = 100;
      let bool: boolean = false;
      bool = true;
      bool = false;
      // bool = "B";
      const arr1: Array<Number> = [0, 1, 2];
      let n: null = null;
      n = null;
      // n은 null만 할당가능
      // n = 10;
      let u: undefined = undefined;
      u = undefined;
      // u는 undefined만 할당가능
      // u = null;
      // a는 모든 타입 할당가능, 가급적 지양한다.
      let a: any;
      a = undefined;
      a = null;
      a = 10;
      a = "아무거나";
    };
    // (인수: 인수 타입명): 리턴타입명 => {}
    const funcA = (num: number): void => {
      console.log(num);
    };
    funcA(10);
    // funcA("10"); // 인수타입 불일치
    // funcA();  // 인수가 없어도 에러

    const obj: { str: string; num: number } = {
      str: "a",
      num: 100,
    };
    // intersection(교차) 타입
    const obj1: { str: string } & { num: number } = {
      // 선언된타입 모두 값을 할당하여야한다.
      str: "A",
      num: 100,
    };
    obj1.str = "20";
    //   obj1.num = "10";
    // union(병합, 공용체) 타입
    let obj2: string | number;

    obj2 = "A";
    obj2 = 100;
    return <>{ex}</>;
  };
  ```

  ```tsx
  // App.tsx
  import { TypeEx01 } from "./components1/TypeEx01";

  const App = () => {
    return (
      <>
        <TypeEx01></TypeEx01>
      </>
    );
  };
  export default App;
  ```

- 표준 형식 `.xml`, `.json` : 네트워크망에서 데이터를 주고 받는다(`.json`으로 바뀌는 추세)
- axios

---

### 2. memo

- [라우터교안](https://cafe.naver.com/thisiscoding)
- [라우터](https://reactrouter.com/en/main/router-components/hash-router)
- [JSON으로 작업하기](https://developer.mozilla.org/ko/docs/Learn/JavaScript/Objects/JSON)
