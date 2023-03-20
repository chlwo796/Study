// Shop.jsx는 Login.jsx에서 import, props 속성값 id, pw, shopid
import { ShopDtl } from "./ShopDtl";
export const Shop = (props) => {
  const contentProps = {
    id: props.id,
    pw: props.pw,
  };
  const { id, pw } = contentProps;
  return (
    <>
      {console.log(id, pw)}
      <ShopDtl id={props.id} pw={props.pw} shopId="t-100"></ShopDtl>
    </>
  );
};
