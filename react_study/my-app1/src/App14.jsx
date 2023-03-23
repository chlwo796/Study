import React, { Component } from "react";
import { BrowserRouter, Routes, HashRouter, Route } from "react-router-dom";
import { Header } from "./component6/Header";
import { Main } from "./component6/Main";
import { Product } from "./component6/Product";
import { ProductDtl } from "./component6/ProductDtl";

export const App14 = () => {
  return (
    <div className="App">
      <BrowserRouter>
        {/* BrowserRouter = 서버로 주소를 보냄 */}
        <Header></Header>
        <Routes>
          <Route path="/" element={<Main></Main>}></Route>{" "}
          <Route path="/product" element={<Product></Product>}></Route>
          <Route path="/product3" element={<ProductDtl></ProductDtl>}></Route>
        </Routes>
      </BrowserRouter>
      <h3>해시라우팅</h3>
      <HashRouter>
        {/* HashRouter = 웹브라우저가 감지*/}
        <Header></Header>
        <Routes>
          <Route path="/" element={<Main></Main>}></Route>{" "}
          <Route path="/product" element={<Product></Product>}></Route>
          <Route path="/product3" element={<ProductDtl></ProductDtl>}></Route>
        </Routes>
      </HashRouter>
    </div>
  );
};
export default App14;
