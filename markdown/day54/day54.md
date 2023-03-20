2023년 3월 20일 월요일

---

## day54

### 1. react

- Props : 컴포넌트에 전달하는 인수와 같은 것으로, 컴포넌트는 전달받은 Props에 따라 표시하는 스타일과 내용을 변경한다.

  ```jsx
  import { AA } from "./AA";

  export const A = (props) => {
    const addAge = {
      age: 24,
    };
    return (
      <>
        <AA name={props.name} age={addAge.age}></AA>{" "}
      </>
    );
  };
  ```

  ```jsx
  import { AAA } from "./AAA";

  export const AA = (props) => {
    const addScore = {
      score: 100,
    };
    return (
      <>
        <AAA name={props.name} age={props.age} score={addScore.score}></AAA>
      </>
    );
  };
  ```

  ```jsx
  export const AAA = (props) => {
    return (
      <>
        <p>
          {props.name} {props.age} {props.score}
        </p>
      </>
    );
  };
  ```

  ```jsx
  // App.jsx
  import { PropsEx03 } from "./components/PropsEx03";
  const App = () => {
    return (
      <>
        <PropsEx03></PropsEx03>
      </>
    );
  };
  export default App;
  ```

- State : 컴포넌트의 상태를 나타내는 값
- useStatus : 리액트 내부에서 제공되며 import하여 사용한다.
- 재렌더링 : 변경을 감지하고 컴포넌트를 다시 처리하는 것
- useEffect : 어떤 값이 변했을 때에 한해서만 어떤 처리를 실행하는 것

```jsx
// UseStateEx01.jsx
// const [ 변수명, 변수를 바꿀함수명 ] = useState(초기값); //배열분할대입
import { useState } from "react";

export const UseStateEx01 = () => {
  // useState
  const [num, setNum] = useState(0);
  const [name, setName] = useState("");
  const [age, setAge] = useState();
  const [score, setScore] = useState();
  const onClickButton = () => {
    setNum(num + 1);
  };
  const onClickButton2 = () => {
    setNum(num - 1);
  };
  //이름을 담아줄 변수 필요, 이름을 변경할 함수가 필요하다.

  const onChangeName = (event) => {
    setName(event.target.value);
  };
  const onChangeAge = (event) => {
    setAge(event.target.value);
  };
  const onChangeScore = (event) => {
    setScore(event.target.value);
  };

  return (
    <>
      <p> {num} </p>
      <button onClick={onClickButton}> useState연습버튼+1 </button>
      <button onClick={onClickButton2}> useState연습버튼-1 </button>
      <br></br>
      <input value={name} onChange={onChangeName} />
      <p> {name} </p>
      <input value={age} onChange={onChangeAge}></input>
      <p>{age}</p>
      <input value={score} onChange={onChangeScore}></input>
      <p>{score}</p>
    </>
  );
};
```

```jsx
// UseEffectEx01.jsx
import { useState, useEffect } from "react";
export const UseEffectEx01 = () => {
  const [count, setCount] = useState(100);
  const [name, setName] = useState("");

  const onChangeName = (event) => {
    console.log("이름 수정시 랜더링");
    setName(event.target.value);
  };
  const onClickButton = (event) => {
    console.log("점수 수정시 랜더링");
    setCount((event) => count + 1);
  };
  useEffect(() => {
    // 해당 배열의 값이 변할 때 실행하고자 할 내용
    console.log("useEffect 실행됨");
  }, [count]);
  return (
    <>
      <p>안녕하세요 {name} 입니다.</p>
      <input onChange={onChangeName}></input>
      <p>{count}번 클릭했어요</p>
      <button onClick={onClickButton}>UseEffect버튼</button>
    </>
  );
};
```

```jsx
// App.jsx
import { UseStateEx01 } from "./components2/UseStateEx01";
import { UseEffectEx01 } from "./components2/UseEffectEx01";
import { CssModules } from "./components2/CssModules";
const App = () => {
  // const [ 변수명, 변수를 바꿀 함수명 ] = useState(초기값); //배열분할대입
  return (
    <>
      <div>
        <UseStateEx01></UseStateEx01>
        <UseEffectEx01></UseEffectEx01>
      </div>
    </>
  );
};
export default App;
```

---

### 2. memo

- [nodejs18 - (node-sass) version](https://www.npmjs.com/package/node-sass?activeTab=versions)
