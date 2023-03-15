// 디폴트값

const myProfile = {
  age: 24,
};
// 객체에 속성이 존재하지 않는 경우 디폴트값 설정함
const { name = "최재환", age } = myProfile;
const message = `${name}님, 안녕하세요! ${age}살입니다.`;
console.log(message);

myProfile.name = "최수연";
const message1 = `${myProfile.name}님, 안녕하세요! ${age}살입니다.`;
console.log(message1);
// 배열에 속성 추가 가능
const arr1 = [1, 2, 3];
const [kor, eng, mat, sci = 100] = arr1;
console.log(kor, eng, mat, sci);
