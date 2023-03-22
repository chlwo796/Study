import { createContext, useState } from "react";

export const AdminFlagContext5 = createContext({});
// createContext({}) 글로벌 state를 담을 변수를 생성한다.

export const AdminFlagProvider = (props) => {
  const { children } = props; //객체 분할 대입
  const [isAdmin, setIsAdmin] = useState(false);
  const [name, setName] = useState("");
  //   const sampleObj = { sampleValue: "테스트" };
  return (
    <AdminFlagContext5.Provider value={{ isAdmin, setIsAdmin, name, setName }}>
      {children}
    </AdminFlagContext5.Provider>
  );
};
