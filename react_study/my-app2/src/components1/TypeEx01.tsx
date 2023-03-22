export const TypeEx01 = () => {
  const ex = () => {
    let str: string = "A";
    str = "B";
    //  str = 100;
    let num: number = 0;
    num = 100;
    let bool: boolean = false;
    bool = true;
    bool = false;
    // bool = "B";
    const arr1: Array<Number> = [0, 1, 2];
    let n: null = null;
    n = null;
    // n은 null만 할당가능
    // n = 10;
    let u: undefined = undefined;
    u = undefined;
    // u는 undefined만 할당가능
    // u = null;
    // a는 모든 타입 할당가능, 가급적 지양한다.
    let a: any;
    a = undefined;
    a = null;
    a = 10;
    a = "아무거나";
  };
  // (인수: 인수 타입명): 리턴타입명 => {}
  const funcA = (num: number): void => {
    console.log(num);
  };
  funcA(10);
  // funcA("10"); // 인수타입 불일치
  // funcA();  // 인수가 없어도 에러

  const obj: { str: string; num: number } = {
    str: "a",
    num: 100,
  };
  // intersection(교차) 타입
  const obj1: { str: string } & { num: number } = {
    // 선언된타입 모두 값을 할당하여야한다.
    str: "A",
    num: 100,
  };
  obj1.str = "20";
  //   obj1.num = "10";
  // union(병합, 공용체) 타입
  let obj2: string | number;

  obj2 = "A";
  obj2 = 100;
  return <>{ex}</>;
};
