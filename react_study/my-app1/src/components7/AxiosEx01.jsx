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
