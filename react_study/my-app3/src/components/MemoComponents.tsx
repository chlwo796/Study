import { ChangeEvent, useState, FC, useCallback } from "react";
import styled from "styled-components";
import { useMemoList } from "../hooks/useMemoList";
import { MemoList } from "./MemoList";
export const MemoComponents: FC = () => {
  const { memos, addTodo, deleteTodo } = useMemoList(); // 사용자 정의 훅
  const [text, setText] = useState<string>("");
  // const [memos, setMemos] = useState<string[]>([]); // 사용자 정의 훅에 넣기 위해 삭제

  const onChangeText = (e: ChangeEvent<HTMLInputElement>) =>
    setText(e.target.value);
  const onClickAdd = () => {
    // const newMemos = [...memos];
    // newMemos.push(text);
    // setMemos(newMemos);
    addTodo(text); // 사용자 정의 훅에 있는 코드를 호출
    setText("");
  };
  const onClickDelete = useCallback(
    (index: number) => {
      //   const newMemos = [...memos];
      //   newMemos.splice(index, 1);
      //   setMemos(newMemos);
      deleteTodo(index);
    },
    [deleteTodo]
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
// const SContainer = styled.div`
//   border: solid 1px #ccc;
//   padding: 16px;
//   margin: 8px;
// `;
// const SMemoWrapper = styled.div`
//   display: flex;
//   align-items: center;
// `;
