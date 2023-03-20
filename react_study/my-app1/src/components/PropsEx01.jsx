export const PropsEx01 = (props) => {
  const contentStyle = {
    color: props.color,
    fontSize: "25px",
  };
  return <p style={contentStyle}>{props.word}</p>;
};
