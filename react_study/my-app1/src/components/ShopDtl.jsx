export const ShopDtl = (props) => {
  const propsData = {
    id: props.id,
    pw: props.pw,
    shopId: props.shopId,
  };
  return (
    <>
      <p>
        {props.id}, {props.pw}, {props.shopId}
      </p>
      <p>
        {propsData.id}, {propsData.pw}, {propsData.shopId}
      </p>
    </>
  );
};
