2023년 3월 21일 화요일

## day55

### 1. react

- UseEffect(콜백함수, []) : 재랜더링되는 것을 방지
- memo() : 상위컴포넌트가 랜더링이되면 하위컴포넌트도 자동으로 랜더링 되는 것을 막아준다.

```jsx
// ./componentns3/Child1.jsx
import { memo } from "react";
import { Child2 } from "./Child2";
import { Child3 } from "./Child3";

const style = {
  height: "200px",
  backgroundColor: "lightblue",
  padding: "8px",
};

export const Child1 = memo((props) => {
  console.log("Child1 랜더링");
  const { onClickReset } = props;
  return (
    <div style={style}>
      <p> Child1 </p>
      <button onClick={onClickReset}>리셋</button>
      <Child2></Child2>
      <Child3></Child3>
    </div>
  );
});
```

```jsx
// ./componentns3/Child2.jsx
import { memo } from "react";

const style = {
  height: "50px",
  backgroundColor: "lightgray",
};

export const Child2 = memo(() => {
  console.log("Child2 랜더링");
  return (
    <div style={style}>
      <p> Child2 </p>
    </div>
  );
});
```

```jsx
// ./componentns3/Child3.jsx
import { memo } from "react";
const style = {
  height: "50px",
  backgroundColor: "lightgray",
};

export const Child3 = memo(() => {
  console.log("Child3 랜더링");
  return (
    <div style={style}>
      <p> Child3 </p>
    </div>
  );
});
```

```jsx
// ./componentns3/Child4.jsx
import { memo } from "react";

const style = {
  height: "200px",
  backgroundColor: "wheat",
  padding: "8px",
};

export const Child4 = memo(() => {
  console.log("Child4 랜더링");
  return (
    <div style={style}>
      <p> Child4 </p>
    </div>
  );
});
```

```jsx
// App12.jsx
import { useState, memo, useCallback } from "react";
import { Child1 } from "./componentns3/Child1";
import { Child4 } from "./componentns3/Child4";

const App12 = memo(() => {
  console.log("App 랜더링");
  const [num, setNum] = useState(0);
  const onClickButton = () => {
    setNum(num + 1);
  };
  const onClickReset = useCallback(() => {
    setNum(0);
  }, []); // 처음에 1번 만들고 재사용한다.

  return (
    <>
      <button onClick={onClickButton}>버튼</button>
      <p>{num}</p>
      <Child1 onClickReset={onClickReset}></Child1> {/*props 모습 */}
      <Child4></Child4>
    </>
  );
});

export default App12;
```

- useCallback() : props 전달받은 하위컴포넌트는 상위컴포넌트가 랜더링되면 하위컴포넌트가 변형되지 않아도 자동으로 랜더링되는 것을 방지 ex) 버튼, 리셋버튼
- 공통 글로벌값 state : 모든 컴포넌트가 사용할 수 있는 State를 만듬(권장x)

---

### 2. memo
