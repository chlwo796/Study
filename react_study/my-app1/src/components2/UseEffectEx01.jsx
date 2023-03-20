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
