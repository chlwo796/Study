import { useState, memo, useCallback } from "react";
import {Child1} from "./componentns3/Child1";
import {Child4} from "./componentns3/Child4";

const App12 = memo( ()=>{
  console.log("App 랜더링");
  const [ num, setNum ] = useState(0);
  const onClickButton = ()=> {
     setNum( num + 1 );
  } ;
  const onClickReset = useCallback(   ()=>{
      setNum(0);
  }, [] ); // 처음에 1번 만들고 재사용한다. 

  return(
    <>
      <button onClick={onClickButton}>버튼</button>
      <p>{num}</p>
      <Child1 onClickReset={onClickReset}></Child1>  {/*props 모습 */}
      <Child4></Child4>
    </>
  );
} );

export default App12;