2023년 3월 5일 일요일

---

## chap.18 data input_output

### 1. 입출력 스트림

- 데이터 입력 : 데이터는 키보드를 통해 입력될 수도 있고, 파일 또는 프로그램으로부터 입력될 수도 있다.
- 데이터 출력 : 반대로 데이터는 모니터로 출력될 수도 있고, 파일에 저장되거나 다른 프로그램으로 전송될 수 있다.
- 자바는 입력 스트림과 출력 스트림을 통해 데이터를 입출력한다.
- 스트림(stream) : 단방향으로 데이터가 흐르는 것을 말한다.
  ![](https://velog.velcdn.com/images/dev-taewon-kim/post/7983a8d7-f354-4bdb-8eb5-a8ae1d672716/image.png)
- 프로그램을 기준으로 데이터가 들어오면 입력 스트림, 데이터가 나가면 출력스트림이 되며, 프로그램이 다른 프로그램과 데이터를 교환하려면 양쪽 모두 입력 스트림과 출력 스트림이 필요하다.

  ![](https://velog.velcdn.com/images/dev-taewon-kim/post/49e0d77d-753a-4e37-9118-b6d0cab912b7/image.png)

- 어떤 데이터를 입출력 하느냐에 따라 스트림은 다음 두 종류로 구분할 수 있다.
  - **바이트 스트림** : 그림, 멀티미디어, 문자 등 모든 종류의 데이터를 입출력할 때 사용
  - **문자 스트림** : 문자만 입출력할 때 사용
- 자바는 데이터 입출력과 관련된 라이브러리를 java.io 패키지에서 제공하고 있으며, java.io 패키지는 바이트 스트림과 문자 스트림을 다음과 같이 이름으로 구분해서 제공한다.
  ![](https://velog.velcdn.com/images/dev-taewon-kim/post/11265954-cf76-4901-9f03-1c2b21fb275d/image.png)
- 바이트 입출력 스트림의 최상위 클래스는 InputStream과 OutputStream이고, 이 클래스를 상속받는 자식클래스에는 접미사로 InputStream 또는 OutputStream이 붙는다.
- 문자 입출력 스트림의 최상위 클래스는 Reader과 Writer이고, 이 클래스를 상속받는 자식클래스에는 접미사로 Reader 또는 Writer가 붙는다.
  ![](https://velog.velcdn.com/images/dev-taewon-kim/post/3f14b605-9f03-4078-bd4a-ffc4069e094f/image.png)

---

### 2. 바이트 출력 스트림

- OutputStream은 바이트 출력 스트림의 최상위 클래스로 추상 클래스이다.

  ![](https://velog.velcdn.com/images/dev-taewon-kim/post/9c3e5f2a-d832-448c-aa47-ebabe6919ffc/image.png)

- OutputStream 클래스에는 모든 바이트 출력 스트림이 기본적으로 가져야 할 메소드가 정의되어 있다.

  ![](https://velog.velcdn.com/images/dev-taewon-kim/post/2eefb4b3-ee91-4e0c-bf98-5ce97d52cf21/image.png)

1. 1바이트 출력

- write(int b) 메소드는 매개값 int(4byte)에서 끝 1byte만 출력한다.
- WriteExample 예제

  ```java
  package javaChap18.example01;

  import java.io.FileOutputStream;
  import java.io.IOException;
  import java.io.OutputStream;

  public class WriteExample {
      public static void main(String[] args) {
          try {
              OutputStream os = new FileOutputStream("C:/JHC/test1.db");
              byte a = 10;
              byte b = 20;
              byte c = 30;
              os.write(a);
              os.write(b);
              os.write(c);
              os.flush();
              os.close();
          } catch (IOException e) {
          }
          // 디렉토리에 파일생성 확인
      }
  }
  ```

- FileOutputStream 생성자는 주어진 파일을 생성할 수 없으면 IOException을 발생시키며, write(), flush(), close() 메소드도 IOException이 발생할 수 있으므로 예외 처리를 해야 한다.
- OutputStream은 내부에 작은 버퍼(buffer)를 가지고 있다.
- write() 메소드가 호출되면 버퍼에 바이트를 우선 저장하고, 버퍼가 차면 순서대로 바이트를 출력한다.
- flush() 메소드는 내부 버퍼에 잔류하는 모든 바이트를 출력하고 버퍼를 비우는 역할을 한다.
- 내부 버퍼를 사용하는 이유는 출력 성능을 향상하기 위해서이다.
- 출력 스트림을 더이상 사용하지 않을 때에는 close() 메소드를 호출해서 출력 스트림이 사용했던 메모리를 해제하는 것이 좋다.

2. 바이트 배열 출력

- 일반적으로 1바이트를 출력하는 경우는 드물고, 보통 바이트 배열을 통째로 출력하는 경우가 많다.
- write(byte[] b) 메소드는 매개값으로 주어진 배열의 모든 바이트를 출력한다.

  ![](https://velog.velcdn.com/images/dev-taewon-kim/post/5fb95695-869a-40ed-88e6-14898416fe3e/image.png)

- ByteArrayWriteExample 예제

  ```java
  package javaChap18.example01;

  import java.io.FileOutputStream;
  import java.io.IOException;
  import java.io.OutputStream;

  public class ByteArrayWriteExample {
      public static void main(String[] args) {
          try {
              OutputStream os = new FileOutputStream("C:/JHC/test2.db");

              byte[] array = { 10, 30, 50 };
              os.write(array);
              os.flush();
              os.close();
          } catch (IOException e) {

          }
      }
  }
  ```

- 만약 배열의 일부분을 출력하고 싶다면 write(byte[], int off, int len) 메소드를 사용하면 된다.
  ![](https://velog.velcdn.com/images/dev-taewon-kim/post/3dffa06a-77ea-4b5a-8cf8-d9526e80b0dd/image.png)
- ByteArrayIndexWriteExample 예제

  ```java
  package javaChap18.example01;

  import java.io.FileOutputStream;
  import java.io.IOException;
  import java.io.OutputStream;

  public class ByteArrayIndexWriteExample {
      public static void main(String[] args) throws IOException {
          OutputStream os = new FileOutputStream("C:/JHC/test3.db");
          byte[] array = { 10, 40, 20, 50, 60 };
          // 2바이트 크기의 파일 생성
          os.write(array, 1, 2);
          os.flush();
          os.close();

      }
  }
  ```

---

### 3. 바이트 입력 스트림

- InputStream은 바이트 입력 스트림의 최상위 클래스로, 추상 클래스이다.
  ![](https://velog.velcdn.com/images/dev-taewon-kim/post/8d700e94-0405-4c94-bd95-56a44ba59864/image.png)
- InputStream 클래스에는 바이트 입력 스트림이 기본적으로 가져야 할 메소드가 정의되어 있다.
  ![](https://velog.velcdn.com/images/dev-taewon-kim/post/4217a5d3-11d6-4a6a-b14f-5fb95f877f61/image.png)

1. 1바이트 읽기

- read() 메소드는 입력 스트림으로부터 1byte를 읽고 int(4byte) 타입으로 리턴하며, 리턴된 4byte 중 끝 1byte에만 데이터가 들어가 있다.
  ![](https://velog.velcdn.com/images/dev-taewon-kim/post/5eb3002f-0d7f-43a2-8764-4311b8b9592d/image.png)
- 더 이상 입력 스트림으로부터 바이트를 읽을 수 없다면 read() 메소드는 -1을 리턴하는데, 이것을 이용하여 마지막 바이트까지 반복해서 한 바이트씩 읽을 수 있다.

  ```java
  InputStream is = ...;
  while(true){
      int data = is.read();   // 1바이트씩 read()
      if(data ==-1){  // while 종료
          break;
      }
  }
  ```

- ReadExample 예제

  ```java
  package javaChap18.example02;

  import java.io.FileInputStream;
  import java.io.IOException;
  import java.io.InputStream;

  public class ReadExample {
      public static void main(String[] args) throws IOException {
          InputStream is = new FileInputStream("C:/JHC/test1.db");
          while (true) {
              int data = is.read();
              if (data == -1) {
                  break;
              }
              System.out.println(data);
          }
          is.close();
      }
  }
  ```

- FileInputStream 생성자는 주어진 파일이 존재하지 않을 경우 FileNotFoundException을 발생시키며, read(), clase() 메소드에서 IOException이 발생할 수 있으므로 두 가지 예외를 모두 처리해야 한다.

2. 바이트 배열로 읽기

- read(byte[] b) 메소드는 입력 스트림으로부터 주어진 배열의 길이만큼 바이트를 읽고 배열에 저장한 다음 읽은 바이트 수를 리턴한다.

  ![](https://velog.velcdn.com/images/dev-taewon-kim/post/1a54646d-f444-407b-9f70-829162e103cc/image.png)

  ```java
  InputStream is = ...;
  byte[] data = new byte[100];
  while(true){
      // 한번에 최대 100byte를 읽고, 읽은 바이트는 배열 data에 저장, 읽은 수 리턴
      int num = is.read(data);
      if(num == -1){
          break;
      }
  }
  ```

- 많은 양의 바이트를 읽을 때는 read(byte[] b) 메소드를 사용하는 것이 좋다. 한번 읽을 때 byte[] b의 길이만큼 읽기 때문에 읽는 횟수가 read() 메소드보다 현저히 줄어든다.

  ```java
  package javaChap18.example02;

  import java.io.FileInputStream;
  import java.io.IOException;
  import java.io.InputStream;

  public class ByteArrayReadExample {
      public static void main(String[] args) throws IOException {
          InputStream is = new FileInputStream("C:/JHC/test2.db");

          byte[] data = new byte[100];
          while (true) {
              int num = is.read(data);
              if (num == -1) {
                  break;
              }
              for (int i = 0; i < num; i++) {
                  System.out.println(data[i]);
              }
          }
          is.close();

      }
  }
  ```

- CopyExample 예제

  ```java
  package javaChap18.example02;

  import java.io.FileInputStream;
  import java.io.FileOutputStream;
  import java.io.IOException;
  import java.io.InputStream;
  import java.io.OutputStream;

  public class CopyExample {
      public static void main(String[] args) throws IOException {
          String originalFileName = "C:/JHC/test.png";
          String targetFileName = "C:/JHC/test2.png";

          InputStream is = new FileInputStream(originalFileName);
          OutputStream os = new FileOutputStream(targetFileName);

          byte[] data = new byte[1024];

          while (true) {
              int num = is.read(data);
              if (num == -1) {
                  break;
              }
              os.write(data, 0, num);
          }
          os.flush();
          os.close();
          is.close();
      }
  }
  ```

---

### 4. 문자 입출력 스트림

- 바이트 입출력 스트림인 InputStream과 OutputStream에 대응하는 문자 입출력 스트림으로 Reader와 Writer가 있다.

1. 문자 출력

- Writer는 문자 출력 스트림의 최상위 클래스로, 추상클래스이다.

  ![](https://velog.velcdn.com/images/dev-taewon-kim/post/4a64ebfc-a748-4f9c-9372-67ef4b381beb/image.png)

- Writer 클래스는 모든 문자 출력 스트림이 기본적으로 가져야 할 메소드가 정의되어 있다.
  ![](https://velog.velcdn.com/images/dev-taewon-kim/post/ff89f03a-dccf-47ad-a4dc-2a290ac66929/image.png)
  ![](https://velog.velcdn.com/images/dev-taewon-kim/post/69091e00-972c-44be-a095-84f31bdf6867/image.png)
- Wirte는 OutputStream과 사용 방법은 동일하지만, 출력 단위가 문자(char)이며, 문자열을 출력하는 write(String str) 메소드를 추가로 제공한다.
- WriteExample 예제

  ```java
  package javaChap18.example03;

  import java.io.FileWriter;
  import java.io.IOException;
  import java.io.Writer;

  public class WriteExample {
      public static void main(String[] args) throws IOException {
          Writer writer = new FileWriter("C:/JHC/test1.txt");

          char a = 'a';
          writer.write(a);
          char b = 'b';
          writer.write(b);

          char[] array = { 'c', 'd', 'e' };
          writer.write(array);

          writer.write("ghjy");
          writer.flush();
          writer.close();
      }
  }

  ```

2. 문자 읽기

- Reader는 문자 입력 스트림의 최상위 클래스로, 추상클래스이다.
  ![](https://velog.velcdn.com/images/dev-taewon-kim/post/b10e34c4-8180-4fb7-b104-411998d2699b/image.png)
- Reader 클래스에는 문자 입력 스트림이 기본적으로 가져야 할 메소드가 정의되어 있다.
  ![](https://velog.velcdn.com/images/dev-taewon-kim/post/72c1e6e5-1eb4-4b66-8d14-7ec0ea36e120/image.png)
- Reader는 InputStream과 사용 방법은 동일하지만, 출력 단위가 문자(char)이다.
- ReadExample 예제

  ```java
  package javaChap18.example03;

  import java.io.FileReader;
  import java.io.IOException;
  import java.io.Reader;

  public class ReadExample {
      public static void main(String[] args) throws IOException {
          Reader reader = new FileReader("C:/JHC/test1.txt");

          while (true) {
              int data = reader.read();
              if (data == -1) {
                  break;
              }
              System.out.print((char) data);

          }
          reader.close();

          reader = new FileReader("C:/JHC/test1.txt");
          char[] data = new char[100];
          while (true) {
              int num = reader.read(data);
              if (num == -1) {
                  break;
              }
              for (int i = 0; i < num; i++) {
                  System.out.println(data[i]);
              }
          }
          reader.close();
      }
  }

  ```

---

### 5. 보조 스트림

- 보조스트림이란 다른 스트림과 연결되어 여러가지 편리한 기능을 제공해주는 스트림을 말하며, 자체적으로 입출력을 수행할 수 없기 때문에 입출력 소스로부터 직접 생성된 입출력 스트림에 연결해서 사용해야 한다.

  ![](https://velog.velcdn.com/images/dev-taewon-kim/post/5606943a-44e2-4e20-b962-32ee5de9a123/image.png)

- 입출력 스트림에 보조 스트림을 연결하려면 보조 스트림을 생성할 때 생성자 매개값으로 입출력 스트림을 제공하면 된다.

  ```java
  InputStream is = new FileInputStream("..");
  // 보조스트림 변수 = new 보조스트림(입출력스트림);
  InputStreamReader reader = new InputStreamReader(is);
  ```

- 보조 스트림은 또 다른 보조 스트림과 연결되어 스트림 체인으로 구성할 수 있다.
  ![](https://velog.velcdn.com/images/dev-taewon-kim/post/b3db0bda-5a49-4fef-9019-62dde6ad28b6/image.png)

```java
InputStream is = new FileInputStream("..");
InputStreamReader reader = new InputStreamReader(is);
// 보조스트림2 변수 = new 보조스트림2(보조스트림1);
BufferedReader br = new BufferedReader(reader);
```

- 자주 사용되는 보조 스트림
  ![](https://velog.velcdn.com/images/dev-taewon-kim/post/4ac6ed23-f8e7-43dd-b272-ad5ef6ad6564/image.png)

---

### 6. 문자 변환 스트림

- 바이트 스트림(InputStream, OutputStream)에서 입출력할 데이터가 문자라면 문자 스트림(Reader와 Writer)로 변환해서 사용하는 것이 좋다.
- 문자로 바로 입출력하는 편리함이 있으며, 문자셋의 종류를 지정할 수 있다.

1. InputStream을 Reader로 변환

- InputStream을 Reader로 변환하려면 InputStreamReader 보조 스트림을 연결하면 된다.

  ![](https://velog.velcdn.com/images/dev-taewon-kim/post/ccfdce50-f347-4e12-99d3-7ba1f5473216/image.png)

  ```java
  // InputStream을 Reader로 변환
  InputStream is = new FileInputStream("..");
  Reader reader = new InputStreamReader(is);
  ```

- FileReader의 원리
  - FileInputStream에 InputStreamReader를 연결하지 않고 직접 FileReader를 생성할 수 있다. FileReader는 InputStreamReader의 자식 클래스이며, FileReader가 내부적으로 FileInputStream에 InputStreamReader 보조 스트림을 연결한 것이다.

2. OutputStream을 Writer로 변환

- OutputStream을 Writer로 변환하려면 OutputStreamWriter 보조 스트림을 연결하면 된다.

  ![](https://velog.velcdn.com/images/dev-taewon-kim/post/aefc050e-0d47-4776-b204-3cc30a7b2fd7/image.png)

  ```java
  // OutputStream을 Writer로 변환
  OutputStream os = new FileOutputStream("..");
  Writer writer = new OutputStreamWriter(os);
  ```

- FileWriter의 원리

  - FileOutputStream에 OutputStreamReader를 연결하지 않고 직접 FileWriter를 생성할 수 있다. FileWriter는 OutputStreamWriter의 자식 클래스이며, FileWriter가 내부적으로 FileOutputStream에 OutputStreamWriter 보조 스트림을 연결한 것이다.

- CharacterConvertStreamExample 예제

---

### 7. 성능 향상 스트림

- CPU와 메모리가 아무리 뛰어나도 하드 디스크의 입출력이 늦어지면 프로그램의 실행 성능은 하드디스크의 처리 속도에 맞춰진다.
- 이 문제에 대한 완전한 해결책은 될 수 없지만, 프로그램이 입출력 소스와 직접 작업하지 않고, 중간에 메모리 버퍼(buffer)와 작업함으로서 실행 성능을 향상시킬 수 있다.
- 출력 스트림의 경우 직접 하드 디스크에 데이터를 보내지 않고, 메모리 버퍼에 데이터를 보냄으로서 출력 속도를 향상시킬 수 있으며, 버퍼는 데이터가 쌓이기를 기다렸다가 꽉 차게 되면 데이터를 한꺼번에 하드 디스크로 보냄으로서 출력 횟수를 줄여준다.
  ![](https://velog.velcdn.com/images/dev-taewon-kim/post/fee0cf1d-c597-40bc-bf7a-4704d61493bb/image.png)
- 입력 스트림에서도 버퍼를 사용하면 읽기 성능이 좋아진다.
  ![](https://velog.velcdn.com/images/dev-taewon-kim/post/b676f851-26b0-49e3-9d0f-3d69f31801b5/image.png)

  ```java
  // 메모리 버퍼를 제공하여 프로그램의 실행 성능을 향상시키는 보조 스트림
  BufferedInputStream bis = new BufferedInputStream(바이트 입력 스트림);
  BufferedOutputStream bos = new BufferedOutputStream(바이트 출력 스트림);

  BufferedReader br = new BufferedReader(문자 입력 스트림);
  BufferedWriter bw = new BufferedWriter(문자 출력 스트림);
  ```

- BufferExample 예제

  ```java
  package javaChap18.example05;

  import java.io.BufferedInputStream;
  import java.io.BufferedOutputStream;
  import java.io.FileInputStream;
  import java.io.FileOutputStream;
  import java.io.IOException;
  import java.io.InputStream;
  import java.io.OutputStream;

  public class BufferExample {
      public static void main(String[] args) throws IOException {
          String originalFilePath1 = BufferExample.class.getResource("test1.png").getPath();

          String targetFilePath1 = "C:/JHC/targetFile1.png";

          FileInputStream fis1 = new FileInputStream(originalFilePath1);
          FileOutputStream fos1 = new FileOutputStream(targetFilePath1);

          String originalFilePath2 = BufferExample.class.getResource("test2.png").getPath();

          String targetFilePath2 = "C:/JHC/targetFile2.png";

          FileInputStream fis2 = new FileInputStream(originalFilePath2);
          FileOutputStream fos2 = new FileOutputStream(targetFilePath2);

          BufferedInputStream bis = new BufferedInputStream(fis2);
          BufferedOutputStream bos = new BufferedOutputStream(fos2);
          long nonBufferTime = copy(fis1, fos1);
          System.out.println("버퍼 미사용 : " + nonBufferTime + "ns");
          long bufferTime = copy(bis, bos);
          System.out.println("버퍼 사용 : " + bufferTime + "ns");

      }

      public static long copy(InputStream is, OutputStream os) throws IOException {
          long startTime = System.nanoTime();
          while (true) {
              int data = is.read();
              if (data == -1) {
                  break;
              }
              os.write(data);
          }
          is.close();
          os.flush();
          os.close();
          long endTime = System.nanoTime();

          return endTime - startTime;
      }
  }
  ```

- 문자 입력 스트림 Reader에 BufferedReader를 연결하면 성능 향상 뿐만 아니라 좋은 점이 한가지 더 있는데, 행 단위로 문자열을 읽는 매우 편리한 readLine() 메소드를 제공한다.

  ```java
  BufferedReader br = new BufferedReader(new FileReader(".."));
  while(true){
      String str = br.readLine();
      if(str==null){
          // 더 이상 읽을 행이 없는 경우
          break;
      }
  }
  ```

- ReadLineExample 예제

  ```java
  package javaChap18.example05;

  import java.io.BufferedReader;
  import java.io.FileReader;
  import java.io.IOException;

  public class ReadLineExample {
      public static void main(String[] args) throws IOException {
          BufferedReader br = new BufferedReader(new FileReader("src/javaChap18/example05/ReadLineExample.java"));
          int lineNo = 1;
          while (true) {
              String str = br.readLine();
              if (str == null) {
                  break;
              }
              System.out.println(lineNo + "\t" + str);
              lineNo++;
          }
          br.close();
      }
  }
  ```

---

### 8. 기본 타입 스트림

- 바이트 스트림에 DataInputStream과 DataOutputStream 보조 스트림을 연결하면 기본타입인 boolean, char, short, int, long, float, double 값을 입출력 할 수 있다.

  ![](https://velog.velcdn.com/images/dev-taewon-kim/post/0ae07312-499f-415a-a106-7096527a4cdf/image.png)

  ```java
  // DataInputStream과 DataOutputStream 보조 스트림을 연결
  DataInputStream dis = new DataInputStream(바이트 입력 스트림);
  DataOutputStream dos = new DataOutputStream(바이트 출력 스트림);
  ```

- DataInputStream과 DataOutputStream이 제공하는 메소드

  ![](https://velog.velcdn.com/images/dev-taewon-kim/post/f1fc9816-1938-4db9-9233-bfce7c1853b8/image.png)

- 데이터 타입의 크기가 모두 다르므로 DataOutputStream으로 출력한 데이터를 다시 DataInputStream으로 읽어 올 때는 출력한 순서와 동일한 순서로 읽어야 한다.
- DataInputOutputStreamExample 예제

  ```java
  package javaChap18.example06;

  import java.io.DataInputStream;
  import java.io.DataOutputStream;
  import java.io.FileInputStream;
  import java.io.FileOutputStream;
  import java.io.IOException;

  public class DataInputOutputStreamExample {
      public static void main(String[] args) throws IOException {
          FileOutputStream fos = new FileOutputStream("C:/JHC/primitive.db");
          DataOutputStream dos = new DataOutputStream(fos);

          dos.writeUTF("홍길동");
          dos.writeDouble(95.5);
          dos.writeInt(1);

          dos.writeUTF("김자바");
          dos.writeDouble(90.3);
          dos.writeInt(2);

          dos.flush();
          dos.close();
          fos.close();

          FileInputStream fis = new FileInputStream("C:/JHC/primitive.db");
          DataInputStream dis = new DataInputStream(fis);

          for (int i = 0; i < 2; i++) {
              String name = dis.readUTF();
              double score = dis.readDouble();
              int order = dis.readInt();
              System.out.println(name + " " + score + " " + order);
          }
          dis.close();
          fis.close();
      }
  }
  ```

---

### 9. 프린트 스트림

- PrintStream과 PrintWriter는 프린터와 유사하게 출력하는 print(), println(), printf() 메소드를 가지고 있는 보조 스트림이다.

  ![](https://velog.velcdn.com/images/dev-taewon-kim/post/269cb965-931c-4dbd-94c0-d141866f8592/image.png)

  ```java
  // PrintStream은 바이트 출력 스트림과 연결되고, PrintWriter는 문자 출력 스트림과 연결된다.
  PrintStream ps = new PrintStream(바이트 출력 스트림);
  PrintWriter pw = new PrintWriter(문자 출력 스트림);
  ```

- PrintStream과 PrintWriter는 거의 같은 메소드를 가지고 있다.

  ![](https://velog.velcdn.com/images/dev-taewon-kim/post/2f16ae9a-efd9-4a07-939f-21710847732a/image.png)

- PrintStreamExample 예제

  ```java
  package javaChap18.example07;

  import java.io.FileOutputStream;
  import java.io.IOException;
  import java.io.PrintStream;

  public class PrintStreamExample {
      public static void main(String[] args) throws IOException {
          FileOutputStream fos = new FileOutputStream("C:/JHC/printstream.txt");
          PrintStream ps = new PrintStream(fos);

          ps.print("마치");
          ps.println("프린터가 출력하는 것처럼");
          ps.println("데이터를 출력합니다.");

          ps.printf("|%6d | %-10s | %10s | \n", 1, "홍길동", "자바");
          ps.printf("|%6d | %-10s | %10s | \n", 2, "김길동", "학생");

          ps.flush();
          ps.close();
      }
  }
  ```

---

### 10. 객체 스트림

- 자바는 메모리에 생성된 객체를 파일 또는 네트워크로 출력할 수 있으며, 객체를 출력하려면 필드값을 일렬로 늘어선 바이트로 변경해야 하는데, 이것을 직렬화(serialization)라고 한다.(반대로 직렬화된 바이트를 객체의 필드값으로 복원하는 것을 역직렬화(deserialization)라고 한다.)
- ObjectInputStream과 ObjectOutputStream은 객체를 입출력할 수 있는 보조 스트림이며, ObjectOutputStream은 바이트 출력 스트림과 연결되어 객체를 직렬화하고, ObjectInputStream은 바이트 입력 스트림과 연결되어 객체로 복원하는 역직렬화를 한다.
  ![](https://velog.velcdn.com/images/dev-taewon-kim/post/71e8f47f-8ffa-4934-b917-ee7f6318c4cf/image.png)

  ```java
  // ObjectInputStream과 ObjectOutputStream 보조 스트림을 연결
  ObjectInputStream ois = new ObjectInputStream(바이트 입력 스트림);
  ObjectOutputStream oos = new ObjectOutputStream(바이트 출력 스트림);

  // ObjectOutputStream으로 객체를 직렬화 하기 위해 writeObject() 메소드 사용
  oos.writeObject(ClassName);
  // ObjectInputStream의 readObject() 메소드는 읽은 바이트를 역직렬화 하여 객체로 생성한다.
  // readObject() 메소드의 리턴타입은 Object이므로 구체적인 타입으로 강제 타입 변환해야한다.
  ClassName className = (ClassName)ois.readObject();

  ```

- ObjectInputOutputStreamExample 예제

  ```java
  package javaChap18.example08;

  import java.io.Serializable;

  public class Member implements Serializable {
      private static final long serialVersionUID = -622284561026719240L;
      private String id;
      private String name;

      public Member(String id, String name) {
          super();
          this.id = id;
          this.name = name;
      }

      @Override
      public String toString() {
          return id + ": " + name;
      }
  }
  ```

  ```java
  package javaChap18.example08;

  import java.io.Serializable;

  public class Product implements Serializable {
      private static final long serialVersionUID = -621812868470078544L;
      private String name;
      private int price;

      public Product(String name, int price) {
          super();
          this.name = name;
          this.price = price;
      }

      @Override
      public String toString() {
          return name + ": " + price;
      }

  }
  ```

  ```java
  package javaChap18.example08;

  import java.io.FileInputStream;
  import java.io.FileOutputStream;
  import java.io.IOException;
  import java.io.ObjectInputStream;
  import java.io.ObjectOutputStream;
  import java.util.Arrays;

  public class ObjectInputOutputStreamExample {
      public static void main(String[] args) throws IOException, ClassNotFoundException {
          FileOutputStream fos = new FileOutputStream("C:/JHC/object.dat");
          ObjectOutputStream oos = new ObjectOutputStream(fos);

          Member member1 = new Member("fail", "단풍이");
          Product product1 = new Product("노트북", 1500000);
          int[] intArray1 = { 1, 2, 3 };

          oos.writeObject(member1);
          oos.writeObject(product1);
          oos.writeObject(intArray1);
          oos.flush();
          oos.close();
          fos.close();

          FileInputStream fis = new FileInputStream("C:/JHC/object.dat");
          ObjectInputStream ois = new ObjectInputStream(fis);

          Member member2 = (Member) ois.readObject();
          Product product2 = (Product) ois.readObject();
          int[] intArray2 = (int[]) ois.readObject();

          ois.close();
          fis.close();

          System.out.println(member2);
          System.out.println(product2);
          System.out.println(Arrays.toString(intArray2));

      }
  }
  ```

2. Serializable 인터페이스

- 이전 예제를 보면 Member와 Product는 Serializable 인터페이스를 구현하고 있는데, 자바는 Serializable 인터페이스를 구현한 클래스만 직렬화할 수 있도록 제한한다.
- Serializable 인터페이스는 멤버가 없는 빈 인터페이스지만, 객체를 직렬화할 수 있다고 표시하는 역할을 한다.
- 객체가 직렬화될 때 인스턴스 필드값은 직렬화 대상이지만, 정적 필드값과 transient로 선언된 필드값은 직렬화에서 제외되므로 출력되지 않는다.

  ```java
  public class ClassName implements Serializable{
      public int field1;
      protected int field2;
      int field3;
      private int field4;
      public static int field5;   // 정적 필드는 직렬화에서 제외
      transient int field6;   // transient 선언된 필드로 직렬화에서 제외
  }
  ```

3. serialVersionUID 필드

- 직렬화할 때 사용된 클래스와 역직렬화할 때 사용된 클래스는 기본적으로 동일한 클래스여야 하며, 만약 클래스의 이름이 같더라도 클래스의 내용이 다르면 역직렬화에 실패한다.

  ![](https://velog.velcdn.com/images/dev-taewon-kim/post/01fa8e23-4d8a-426e-89af-4c6bde032b17/image.png)

- 클래스 내용이 다르다 할지라도 직렬화된 필드를 공통으로 포함하고 있다면 역직렬화할 수 있는 방법이 있는데, 두 클래스가 동일한 serialVersionUID 상수값을 가지고 있으면 된다.

  ![](https://velog.velcdn.com/images/dev-taewon-kim/post/7fda0e58-f2b8-4877-aac9-002ce618e75d/image.png)

- serialVersionUID의 값은 개발자가 임의로 줄 수 있지만, 가능하다면 클래스마다 다른 유일한 값을 갖도록 하는 것이 좋다.
- 이클립스는 serialVersionUID 필드를 자동 생성하는 기능을 제공한다.

---

### 11. File과 Files 클래스

- java.io 패키지와 java.nio.file 패키지는 파일과 디렉토리 정보를 가지고 있는 File과 Files 클래스를 제공하며, Files 클래스는 File 클래스를 개선한 클래스로, 좀 더 많은 기능을 가지고 있다.

1. File 클래스

- File 클래스로부터 File 객체를 생성하는 방법

```java
File file = new File("경로");
// 경로 구분자는 운영체제마다 조금씩 다르다. 윈도우 = \\또는 /, 맥OS 및 리눅스 = /

// 윈도우의 두가지 File 객체생성 방법
File file = new File("C:/Temp/file.txt");
File file = new File("C:\\Temp\\file.txt");

// File 객체를 생성했다고 해서 파일이나 디렉토리가 생성되는 것은 아니며, 경로에 실제 파일이나 디렉토리가 없더라도 예외가 발생하지 않는다.
// 파일이나 디렉토리가 실제 있는지 확인
boolean isExist = file.exists();    // 파일이나 폴더가 존재한다면 true를 리턴
```

- exists() 메소드가 false를 리턴할 경우, 다음 메소드로 파일 또는 폴더를 생성할 수 있다.

  ![](https://velog.velcdn.com/images/dev-taewon-kim/post/070d3bf5-ae43-4781-8842-67441097961c/image.png)

- exists() 메소드의 리턴값이 true라면 사용할 수 있는 메소드

  ![](https://velog.velcdn.com/images/dev-taewon-kim/post/423d72dc-1fa9-48af-97e8-413162681f6f/image.png)
  ![](https://velog.velcdn.com/images/dev-taewon-kim/post/9990f087-6c7f-4039-8a85-5c1e6b4daae0/image.png)

- FileExample 예제

  ```java
  package javaChap18.example09;

  import java.io.File;
  import java.io.IOException;
  import java.text.SimpleDateFormat;
  import java.util.Date;

  public class FileExample {
      public static void main(String[] args) throws IOException {
          File dir = new File("C:/JHC/images");
          File file1 = new File("C:/JHC/file1.txt");
          File file2 = new File("C:/JHC/file1.txt");
          File file3 = new File("C:/JHC/file1.txt");

          if (dir.exists() == false) {
              dir.mkdir();
          }
          if (file1.exists() == false) {
              file1.createNewFile();
          }
          if (file2.exists() == false) {
              file2.createNewFile();
          }
          if (file3.exists() == false) {
              file3.createNewFile();
          }
          File jhc = new File("C:/JHC");
          File[] content = jhc.listFiles();
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH:mm");
          for (File file : content) {
              System.out.printf("%-25s", sdf.format(new Date(file.lastModified())));
              if (file.isDirectory()) {
                  System.out.printf("%-10s%-20s\n", "<DIR>", file.getName());
              }else {
                  System.out.printf("%-10s%-20s\n", file.length(), file.getName());
              }
          }
          System.out.println();
      }
  }
  ```

2. Files 클래스

- Files 클래스는 정적 메소드로 구성되어 있기 때문에 File 클래스처럼 객체로 만들 필요가 없으며, Files 클래스의 정적 메소드는 운영 체제의 파일 시스템에게 파일 작업을 수행하도록 위임한다.
  ![](https://velog.velcdn.com/images/dev-taewon-kim/post/90a2f0de-b28b-4de4-9890-200f3a9c1583/image.png)
- 이 메소드들은 매개값으로 Path 객체를 받는데, Path 객체는 파일이나 디렉토리를 찾기 위한 경로 정보를 가지고 있고, 정적 메소드인 get() 메소드로 얻어올 수 있다.

```java
// String -> Path
Path path = Paths.get(String first, String..more);

// 절대경로
Path path = Paths.get("C:/Temp/dir/file.txt");
// 상위 디렉토리와 하위 디렉토리를 나열해서 지정
Path path = Paths.get("C:/Temp/dir", "file.txt");
Path path = Paths.get("C:", "Temp", "dir", "file.txt");

// 현재 위치 "C:/Temp" 일 경우, 상대경로
Path path = Paths.get("dir/file.txt");
Path path = Paths.get("./dir/file.txt");
// 현재 위치 "C:/Temp/dir1" 일 경우, 상대 경로
Path path = Paths.get("../dir2/file.txt");
```

- FilesExample 예제

  ```java
  package javaChap18.example09;

  import java.io.IOException;
  import java.nio.charset.Charset;
  import java.nio.file.Files;
  import java.nio.file.Path;
  import java.nio.file.Paths;

  public class FilesExample {
      public static void main(String[] args) throws IOException {
          String data = "" + "id: winter\n" + "email: winter@mycompany.com\n" + "tel: 010-123-1234";

          Path path = Paths.get("C:/JHC/user.txt");

          Files.writeString(path, data, Charset.forName("UTF-8"));

          System.out.println("파일 유형 : " + Files.probeContentType(path));
          System.out.println("파일 크기 : " + Files.size(path) + "bytes");

          String content = Files.readString(path, Charset.forName("UTF-8"));
          System.out.println(content);
      }
  }
  ```

- probeContentType() 메소드는 파일 확장명에 따른 파일 유형을 리턴한다.
- Files는 입출력 스트림을 사용하지 않아도 파일의 데이터를 쉽게 읽고 쓸 수 있으며(운영체제의 파일시스템에게 파일 작업을 수행하도록 위임), writeString() 메소드는 문자열을 파일에 저장하고, readString() 메소드는 텍스트 파일의 내용을 전부 읽고 String으로 리턴한다.
