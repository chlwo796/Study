2023년 2월 19일 일요일

---

## BufferedReader, BufferedWriter

### 1. BufferedReader

- BufferedReader : Scanner와 유사
- 많은 양의 데이터를 처리할 때 유리하다.(입력된 데이터가 바로 전달되지 않고 버퍼를 거쳐서 전달이 되므로 데이터 처리 효율성이 높다.)
- Enter만 경계로 인식하고 받은 데이터는 String으로 고정되기 때문에, 입력받은 데이터를 가공하는 작업이 필요한 경우가 많다.
- 사용법

  ```java
  import java.io.IOException;   // .readLine() 메소드의 예외처리를 위한 import
  import java.io.BufferedReader;
  import java.io.InputStreamReader;

  public static void main(String[] args) throws IOException{
  BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
  String str = bf.readLine();
  int i = Integer.parseInt(bf.readLine());
  }
  ```

- `String readLine()` : 리턴값이 String으로 고정되어 다른 타입으로 입력을 받고 싶다면 반드시 형변환을 거쳐야 하며, 반드시 예외처리를 해주어야 한다.
- `throws IOException` : readLine() 메소드의 예외처리 시, 대게 `try-catch` 보다 `throws IOException`을 사용한다.
- `readLine()`으로 입력받은 데이터는 line 단위로만 나눠지기에 공백 단위로 데이터를 가공하려면 따로 작업을 해주어야 한다.
  - `StringTokenizer nextToken()` : `readLine()`을 통해 입력받은 값을 공백 단위로 구분하여 순서대로 호출
  - `String.split()` 메소드를 활용하여 배열에 공백단위로 끊어서 데이터를 넣고 사용하는 방식
- 데이터처리

  ```java
  import java.util.StringTokenizer;

  public static void main(String[] args){
      StringTokenizer st = new stringTokenizer(s);    // readLine()의 데이터를 매개변수로 StringTokenizer st 선언
      int a = Integer.parseInt(st.nextToken());   // 공백으로 구분한 첫번째 데이터
      int b = Integer.parseInt(st.nextToken());   // 공백으로 구분한 두번째 데이터

      String[] array = s.split(" ");  // readLine()의 데이터를 "공백"으로 끊어서 배열에 저장
  }
  ```

### 2. BufferedWriter

- BufferedWriter : `System.out.println();` 과 유사
- 버퍼를 잡아 놓았기 때문에 반드시 `flush()` 혹은 `close()`를 호출해 주어야 한다.
- `.write`는 `System.out.println()`과 같이 자동개행기능이 없기 때문에 개행을 해주어야 할 경우 `\n`을 통해 따로 처리해주어야 한다.
- 사용법

  ```java
  import java.io.BufferedWriter;
  import java.io.OutputStreamWriter;

  public static void main(String[] args){
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      String s = "asdf";    // 출력할 문자열
      bw.write(s+"\n");     // 버퍼에 있는 값 전부 출력
      bw.flush();   // 남아 있는 데이터를 모두 출력
      bw.close();   // 스트림 닫기
  }
  ```

### 3. 활용예제

- backjoon.level03.no_15552

  ```java
  package no_15552;

  import java.io.BufferedReader;
  import java.io.BufferedWriter;
  import java.io.IOException;
  import java.io.InputStreamReader;
  import java.io.OutputStreamWriter;
  import java.util.StringTokenizer;

  public class Main {
      public static void main(String[] args) throws IOException {
          BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
          BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
          StringTokenizer str;
          int a = Integer.parseInt(bufferedReader.readLine());
          for (int i = 0; i < a; i++) {
              str = new StringTokenizer(bufferedReader.readLine());
              bufferedWriter.write((Integer.parseInt(str.nextToken()) + Integer.parseInt(str.nextToken())) + "\n");
          }
          bufferedWriter.close();
      }
  }
  ```

### 4. 정리

- BufferedReader, BufferedWriter를 통해 많은 양의 데이터입력을 한번에 받고 데이터 처리 및 가공을 통해 값을 전부 분리하여, 원하는 결과물을 출력할 수 있다.
