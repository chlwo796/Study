export const ColoredMessage = (props) => {
  const contentStyle = {
    color: props.color,
    fontSize: "20px",
  };
  const contentData = {
    name: props.name,
    age: props.age,
    message: props.message,
  };
  // 홍길동 안녕! 너 올해 24살이지??
  return (
    <p style={contentStyle}>
      {contentData.name} {props.message} {contentData.age}
    </p>
  );
};
