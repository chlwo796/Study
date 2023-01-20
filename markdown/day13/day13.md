2023년 1월 17일 화요일

---

- 클래스에 대한 개념을 이해한다.
- 응용문제 풀어 보기
- 문자열 처리하기
- `alt + ctrl + '위 arrow key'` : line copy, 매우 유용
- 배열값 출력하기
  - 직접 index 지정
```java
int[] a3 = { 1, 2, 3, 4, 5, 6 }; // 0~5열까지 생성된다.
System.out.println(a3[3]); // 3열
System.out.println(a3[5]); // 5열
```
  - 향상된 for를 활용
```java
int[] a3 = { 1, 2, 3, 4, 5, 6 };
		
for(int a : a3) {
System.out.print(a + " ");
}
System.out.println();
```

- 카페 영화예매프로그램