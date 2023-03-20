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
