import { useContext } from "react";
import { AdminFlagContext  } from "./providers/AdminFlagProvider";

const style={
    width: "100px",
    padding: "6px",
    borderRadius: "8px"
};

export const EditButton = ()=>{
  const { isAdmin }  = useContext(AdminFlagContext); 
  const onClickButton = () =>{
    alert("수정 버튼을 눌렀습니다");
  }
  const contextValue = useContext(AdminFlagContext);
  console.log(contextValue);

  return(
    <div>
        {/* disabled = true이면 비활성 disabled=false 활성
            isAdmin이 false이면 비활성 
        */}
        <button style={style} disabled={ !isAdmin } onClick={ onClickButton }> 수정 </button>
    </div>
  );
}