import { AA } from "./AA";

export const A = (props) => {
  const addAge = {
    age: 24,
  };
  return (
    <>
      <AA name={props.name} age={addAge.age}></AA>{" "}
    </>
  );
};
