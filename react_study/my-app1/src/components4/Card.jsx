import { EditButton } from "./EditButton";

const style = {
    width: "300px",
    height: "200px",
    margin: "8px",
    borderRadius: "8px",
    display: "flex",
    flexDirection: "column",
    justifiyContent: "center",
    alignItems: "center"
};

export const Card = ()=>{
    return(
        <div style={style}>
            <p> 홍길동 </p>
            <EditButton></EditButton>
        </div>     
    );
}