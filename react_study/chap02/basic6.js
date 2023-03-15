// filter
const intArr1 = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];

const newArr1 = intArr1.filter((n) => {
  return n % 2 === 0;
});
console.log(intArr1);
console.log(newArr1);
const evenArr2 = intArr1.filter((n) => n % 2 === 0);
console.log(evenArr2);

const personName = ["홍길동", "이순신", "최수연"];
const gender = [true, true, false];
const age = [10, 24, 34];

// 남자, 나이20살 이상 신검대상
// 이름 = 신검대상자
const newArray = [personName, age, gender];
console.log(newArray);
const pickArray = newArray.map((arr, i) => {
  if (gender[i] && age[i] >= 20) {
    console.log(`${personName[i]} 신검대상자`);
    return personName[i];
  }
});
console.log(
  pickArray.filter((n) => {
    if (n != undefined) {
      return pickArray;
    }
  })
);

// const findIndexFunc = (n) => {
//   //인덱스를 찾아줌
//   let findIndex;
//   for (i = 0; i < personName.length; i++) {
//     if (n == personName[i]) findIndex = i;
//   }
//   return findIndex;
// };

// const mappingGender = (n) => gender[n]; //젠더배열에 받아온 인덱스를 넣은 값을 리턴함
// const mappingAge = (n) => age[n]; //나이배열에 받아온 인덱스를 넣은 값을 리턴함
// const findMember = personName
//   .filter((n) => mappingGender(findIndexFunc(n)))
//   .filter((n) => mappingAge(findIndexFunc(n)) > 20);
// console.log(findMember);
