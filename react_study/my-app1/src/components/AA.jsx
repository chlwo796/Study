import { AAA } from "./AAA";

export const AA = (props) => {
  const addScore = {
    score: 100,
  };
  return (
    <>
      <AAA name={props.name} age={props.age} score={addScore.score}></AAA>
    </>
  );
};
