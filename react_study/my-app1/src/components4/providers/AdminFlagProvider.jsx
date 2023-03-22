import { useState, createContext } from "react";

export const AdminFlagContext = createContext({});

export const AdminFlagProvider = ( props )=>{
  const { children } = props;
  const [isAdmin, setIsAdmin] = useState(false);
  // const sampleObj = { sampleValue: "테스트" };
  return(
    <AdminFlagContext.Provider value={ { isAdmin, setIsAdmin } }>
        {children}
    </AdminFlagContext.Provider>
  );
}