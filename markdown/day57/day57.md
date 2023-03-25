2023년 3월 23일 목요일

## day57

### 1. react

- AJAX(Asynchronous Javascript And Xml) : 브라우저가 가지고 있는 XMLHttpRequest 객체를 이용하여, 페이지 일부만을 위한 데이터를 로드하는 기법으로, **JavaScript를 사용한 비동기 통신, 서버와 클라이언트 간에 XML 데이터를 주고받는 기술**
- Axios : 리액트에서 많이 쓰이는 HTTPClient 라이브러리의 하나이며, Axios는 Promise 기반이고, async/await 코드를 쉽게 구현할 수 있게 해준다.

  - 오래된 브라우저에서도 지원한다.
  - 요청을 중단할 수 있다.
  - response timeout을 쉽게 지정할 수 있다.
  - CSRF 보호 기능이 내장되어 있다.
  - Promise(ES6) API를 사용한다.
  - HTTP 요청 취소 혹은 요청과 응답을 JSON 형태로 자동 변경해준다.

- REST : 어떤 자원에 대해 CRUD(Create, Read, Update, Delete) 연산을 수행하기 위해 URI로 요청을 보내는 것으로 Get, Post 방식의 method를 사용하여 요청을 보내며, 요청을 위한 자원은 특정한 형태(ex. JSON)로 표현된다.
- REST API : REST 기반의 API를 웹으로 구현한것

  - GET : 데이터 조회
  - POST : 데이터 등록 및 전송
  - PUT: 데이터 수정
  - DELETE: 데이터 삭제

- `npm install axios`, `yarn add axios`

  ```jsx
  // ./components7/AxiosEx01.jsx
  import axios from "axios";
  import { useState } from "react";

  export const AxiosEx01 = () => {
    const [userList, setUserList] = useState([]);
    const [isLoading, setIsLoading] = useState(false);
    const [isError, setIsError] = useState(false);
    const onClickFetchUser = () => {
      // axios 기본 형식
      // axios
      //   .get() // url주소
      //   .then() // 주소가 웹페이지 들어오면 이부분을 처리
      //   .catch() // 에러가 발생할 때 처리할 내용
      //   .finally(); // 정상, 에러 상관없이 처리할 내용
      setIsLoading(true);
      setIsError(false);
      axios
        .get("https://jsonplaceholder.typicode.com/posts")
        .then((result) => {
          const users = result.data.map((user) => ({
            userId: user.userId,
            id: user.id,
            title: user.title,
            body: user.body,
          }));
          setUserList(users);
        }) // end then
        .catch(() => setIsError(true)) // end catch
        .finally(() => setIsLoading(false)); // end finally
      return <></>;
    };
    const [userList1, setUserList1] = useState([]);
    const onClickFetchUser1 = () => {
      axios
        .get("https://jsonplaceholder.typicode.com/comments")
        .then((result) => {
          const users1 = result.data.map((user) => ({
            postId: user.postId,
            id: user.id,
            name: user.name,
            email: user.email,
            body: user.body,
          }));
          setUserList1(users1);
        });
    };

    const [userList2, setUserList2] = useState([]);
    const onClickFetchUser2 = () => {
      axios.get("https://jsonplaceholder.typicode.com/users").then((result) => {
        const users2 = result.data.map((user) => ({
          id: user.id,
          name: user.name,
          username: user.username,
          email: user.email,
          street: user.address.street,
          suite: user.address.suite,
          city: user.address.city,
          zipcode: user.address.zipcode,
          lat: user.address.geo.lat,
          lng: user.address.geo.lng,
        }));
        setUserList2(users2);
      });
    };
    return (
      <>
        <button onClick={onClickFetchUser}>사용자 정보 얻기</button>
        {/* (조건문) ? (참) : (거짓) */}
        {/* useState 참고 */}
        {isError && <p style={{ color: "red" }}> 에러가 발생했습니다. </p>}
        {isLoading ? (
          <p>데이터가져오기</p>
        ) : (
          userList.map((user) => (
            <p>
              {user.userId} {user.id} {user.title} {user.body}
            </p>
          ))
        )}
        <button onClick={onClickFetchUser1}>두번째</button>
        {userList1.map((n) => (
          <p>
            postId : {n.postId}
            <br></br>
            id : {n.id}
            <br></br>
            name : {n.name}
            <br></br>
            email : {n.email}
            <br></br>
            body : {n.body}
            <br></br>
          </p>
        ))}
        <button onClick={onClickFetchUser2}>users</button>
        {userList2.map((m) => (
          <p>
            id : {m.id}
            <br></br>
            name : {m.name}
            <br></br>
            username : {m.username}
            <br></br>
            email : {m.email}
            <br></br>
            street : {m.street}
            <br></br>
            suite : {m.suite}
            <br></br>
            city : {m.city}
            <br></br>
            zipcode : {m.zipcode}
            <br></br>
            lat : {m.lat}
            <br></br>
            lng : {m.lng}
            <br></br>
          </p>
        ))}
      </>
    );
  };
  ```

  ```jsx
  // App.jsx
  import { AxiosEx01 } from "./components7/AxiosEx01";

  export const App = () => {
    return (
      <>
        <AxiosEx01></AxiosEx01>
      </>
    );
  };

  export default App;
  ```

- 함수컴포넌트 자체 타입 정의(리액트 18버전은 둘다 포함 x)
  - FC : 타입 정의에 암묵적으로 children 포함
  - VFC : 타입 정의에 암묵적으로 children 포함x
- 컴포넌트화 : 기존의 코드가 복잡한 경우 역할별로 코드를 나누어 주는 것
- `useCallback(콜백함수,[])`
- 컴포넌트화 후 메모 어플리케이션

  ```tsx
  // ./components/MemoComponents.tsx
  import { ChangeEvent, useState, FC, useCallback } from "react";
  import styled from "styled-components";
  import { MemoList } from "./MemoList";
  export const MemoComponents: FC = () => {
    const [text, setText] = useState<string>("");
    const [memos, setMemos] = useState<string[]>([]);

    const onChangeText = (e: ChangeEvent<HTMLInputElement>) =>
      setText(e.target.value);
    const onClickAdd = () => {
      const newMemos = [...memos];
      newMemos.push(text);
      setMemos(newMemos);
      setText("");
    };
    const onClickDelete = useCallback(
      (index: number) => {
        const newMemos = [...memos];
        newMemos.splice(index, 1);
        setMemos(newMemos);
      },
      [memos]
    ); // memos라는 변수가 변할 때에만 useCallback안의 함수 실행

    return (
      <>
        <h1> 메모장 </h1>
        <input type="text" value={text} onChange={onChangeText} />
        <SButton onClick={onClickAdd}>추가</SButton>
        <MemoList memos={memos} onClickDelete={onClickDelete}></MemoList>
      </>
    );
  };

  const SButton = styled.button`
    margin-left: 16px;
  `;
  ```

  ```tsx
  // ./components/MemoList.tsx
  import { type } from "os";
  import { ChangeEvent, useState, FC, useCallback } from "react";
  import styled from "styled-components";
  type Props = {
    memos: string[];
    onClickDelete: (index: number) => void;
  };
  export const MemoList: FC<Props> = (props) => {
    const { memos, onClickDelete } = props;
    return (
      <>
        <SContainer>
          <p>메모 목록</p>
          <ul>
            {memos.map((memo, index) => (
              <li key={memo}>
                <SMemoWrapper>
                  <p>{memo}</p>
                  <SButton onClick={() => onClickDelete(index)}>삭제</SButton>
                </SMemoWrapper>
              </li>
            ))}
          </ul>
        </SContainer>
      </>
    );
  };
  const SButton = styled.button`
    margin-left: 16px;
  `;
  const SContainer = styled.div`
    border: solid 1px #ccc;
    padding: 16px;
    margin: 8px;
  `;
  const SMemoWrapper = styled.div`
    display: flex;
    align-items: center;
  `;
  ```

  ```tsx
  // App.tsx
  import { MemoComponents } from "./components/MemoComponents";
  export const App = () => {
    return (
      <>
        <MemoComponents></MemoComponents>
      </>
    );
  };

  export default App;
  ```

---

### 2. memo

- [자바스크립트 블럭요소이동](https://stonefree.tistory.com/365)
  ![](./정보처리기사시험일정.png)
