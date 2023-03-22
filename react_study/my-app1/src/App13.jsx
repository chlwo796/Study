import { useContext } from "react";
import { Card } from "./components5/Card";
import { AdminFlagContext5 } from "./components5/providers/AdminFlagProvider";

const App13 = () => {
  // const [isAdmin, setIsAdmin] = useState(false);
  // const [name, setName] = useState("");

  const { isAdmin, setIsAdmin, name, setName } = useContext(AdminFlagContext5);
  const onClickName = () => {
    const inputName = prompt("이름은?");
    setName(inputName);
  };
  const onClickSwitch = () => {
    setIsAdmin(!isAdmin);
  };
  return (
    <>
      <button onClick={onClickName}>이름 입력</button>
      {isAdmin ? (
        <span> {name} 관리자입니다</span>
      ) : (
        <span> {name} 일반인</span>
      )}
      <button onClick={onClickSwitch}>전환</button>
      <Card isAdmin={isAdmin} name={name}></Card>
    </>
  );
};

export default App13;
