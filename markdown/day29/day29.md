2023년 2월 10일 금요일

---

## day29

### 1. remind

- 자료구조 : 컴퓨터가 데이터를 효율적으로 다룰 수 있게 도와주는 데이터 보관 방법과 데이터에 관한 연산의 총체

  1. 단순구조 : 정수, 실수, 문자 문자열
  2. 선형구조 : 자료를 구성하는 원소들을 하나씩 순차적으로 나열시킨 형태
     - 순차리스트
     - 연결리스트
     - 스택
     - 큐
     - 데크
  3. 비선형구조 : 하나의 자료 뒤에 여러개의 자료가 존재할 수 있는 형태
     - 트리
     - 그래프
  4. 파일구조
     - 순차파일(Sequantial Access File, SAM) : 순서대로 자료를 읽음, SAM
     - 색인순차파일(Index SAM, ISAM) : 색인으로 정리가 되어 자료를 찾는 속도가 빠름
     - 직접파일(Direct Access File, DAM) : 원하는 자료를 한번만으로 검색할 수 있는 것, 적은 용량으로 검색 속도를 높이는 용도

- 요구사항에 따른 자료구조를 고려하여 프로젝트를 진행한다.
- 실무에서 MAP을 많이 사용한다.

---

### 2. class

- generic : `<E>` 데이터의 타입을 일반화하는 것을 의미하며, 클래스나 메소드에서 사용할 내부 데이터 타입을 컴파일 시에 미리 지정하는 방법
  `ArrayList<E> list1 = new ArrayList<E>();`
  `List<Board> boardList1 = new ArrayList<Board>();`

- ArrayList Example 01

  - `list.add(value);` or `list.add(index, value)` : 리스트에 데이터를 인덱스 순서대로 추가하거나 지정된 인덱스위치에 데이터를 추가한다.(인덱스를 지정하면 기존 데이터는 인덱스가 하나씩 뒤로 밀려서 저장)
  - `list.size();` : 리스트의 데이터의 수를 출력
  - `list.contain(value);` : 리스트에 value 값이 있다면 true or false
  - `list.remove(value);` or `list.remove(Object o);` : 리스트에 데이터를 삭제한다.
  - `list.clear();` : 리스트 전체삭제
  - `list.isEmpty();` : 리스트가 비어있다면 true or false
  - `list.get(index)` : 리스트의 해당 인덱스의 데이터를 가져온다.
  - source

    ```java
    package javaHigh02.example01;

    import java.util.ArrayList;

    public class ArrayListExample {

        public static void main(String[] args) {
            ArrayList<String> list1 = new ArrayList<String>();
            list1.add("홍길동");
            list1.add("이순신");
            list1.add("김유신");
            list1.add(1, "최영");

            for (int i = 0; i < list1.size(); i++) {
                System.out.print(list1.get(i) + " ");
            }
            System.out.println();

            System.out.println(list1.contains("홍길동"));
            if (list1.contains("홍길동")) {
                System.out.println("있습니다.");
            } else
                System.out.println("없습니다.");

            list1.remove("최영");
            for (int i = 0; i < list1.size(); i++) {
                System.out.print(list1.get(i) + " ");

            }
            System.out.println();
            list1.remove("김유신");
            for (int i = 0; i < list1.size(); i++) {
                System.out.print(list1.get(i) + " ");
            }
            System.out.println();

            list1.clear();
            for (int i = 0; i < list1.size(); i++) {
                System.out.print(list1.get(i) + " ");
            }
            System.out.println();

            System.out.println(list1.isEmpty());
        }
    }
    ```

- ArrayList Example02

  - 정수타입은 <int> 가 아닌 Object클래스로 <Integer>로 분류한다.
  - 반복적인 규칙이 있다면 반복문으로 데이터를 일괄적으로 처리할 수 있다.
  - `list.set(index, value);` : index 위치에 데이터를 value로 교체한다. 이전 데이터는 사라진다.
  - source

    ```java
    package javaHigh02.example02;

    import java.util.ArrayList;

    public class ArrayListExample {
        public static void main(String[] args) {
            ArrayList<Integer> list1 = new ArrayList<Integer>();
            for (int i = 1; i <= 10; i++) {
                list1.add(i);
            }
            for(int i = 0; i<list1.size();i++) {
                System.out.print(list1.get(i) + " ");
            }
            System.out.println();

            list1.set(5, 50);
            for(int i = 0; i<list1.size();i++) {
                System.out.print(list1.get(i) + " ");
            }
            System.out.println();
        }
    }
    ```

- ArrayList<객체> : 객체의 데이터배열을 리스트로 관리한다.

  - 해당 클래스의 데이터를 일괄적으로 관리한다.
  - 리스트에 추가할 데이터타입과 동일한 매개변수의 생성자를 생성한 후 각 매개변수들의 getter(), setter() 메소드를 생성한다.
  - `list.add(new Object(value));`
  - `list.get(index).getter()` or `list.get(index).setter()` : 객체의 데이터의 getter, setter 메소드로 값을 출력하거나 입력한다.
  - for문에서의 조건에 따라 인덱스변수에 i를 저장한 후 해당 인덱스변수를 다른메소드를 호출할 때 사용할 수 있다.

    ```java
    int index = 0;
    for(){
        if(){
            index = i;
        }
    }   // for문 종료 후 index 값으로 다른 메소드 호출
    System.out.println(list.get(index).getter() + list.get(index).getter());
    ```

  - source

    ```java
    package javaHigh02.example04;

    import java.util.ArrayList;
    import java.util.List;
    import java.util.Scanner;

    public class ArrayListExample {

        public static void main(String[] args) {
            List<Data> arrayList1 = new ArrayList<Data>();

            arrayList1.add(new Data("4월3일", "BC103", "강남구", 230, 276000, "3470-1234"));
            arrayList1.add(new Data("4월5일", "BL203", "서초구", 150, 180000, "3470-2200"));
            arrayList1.add(new Data("4월8일", "AC205", "송파구", 270, 324000, "3470-3300"));

            System.out.println("매출일자\t거래처코드\t매출지역\t판매량\t매출금액\t연락처");
            for (int i = 0; i < arrayList1.size(); i++) {
                System.out.print(arrayList1.get(i).getDate() + "\t");
                System.out.print(arrayList1.get(i).getCode() + "\t");
                System.out.print(arrayList1.get(i).getArea() + "\t");
                System.out.print(arrayList1.get(i).getSaleAmmount() + "\t");
                System.out.print(arrayList1.get(i).getSalePrice() + "\t");
                System.out.print(arrayList1.get(i).getPhoneNumber() + "\n");
            }
            Scanner sc = new Scanner(System.in);
            System.out.print("거래처 코드는?");
            String searchCode = sc.nextLine();
            boolean search = true;
            for (int i = 0; i < arrayList1.size(); i++) {
                if (arrayList1.get(i).getCode().equals(searchCode)) {
                    System.out
                            .print("매출지역은 " + arrayList1.get(i).getArea() + "\n연락처는 " + arrayList1.get(i).getPhoneNumber());
                    search = false;
                }
            }
            if (search) {
                System.out.println("자료가 없습니다.");
            }
            int max = 0;
            int indexMax = 0;
            for (int i = 0; i < arrayList1.size(); i++) {
                if (max < arrayList1.get(i).getSalePrice()) {
                    max = arrayList1.get(i).getSalePrice();
                    indexMax = i;
                }
            }
            System.out.println("매출액이 가장 높은 거래처코드는 : " + arrayList1.get(indexMax).getArea() + ", 최대매출은 : " + arrayList1.get(indexMax).getSalePrice());

            int min = Integer.MAX_VALUE;
            int indexMin = 0;
            System.out.println(min);
            for (int i = 0; i < arrayList1.size(); i++) {
                if (min > arrayList1.get(i).getSaleAmmount()) {
                    min = arrayList1.get(i).getSaleAmmount();
                    indexMin = i;
                }
            }
            System.out.println("인덱스 : " + indexMin + ", 최소판매량은 : " + arrayList1.get(indexMin).getSaleAmmount());
        }
    }
    ```

- 스레드(thread) : 프로세스 내에서 실제로 작업을 수행하는 주체이며, 모든 프로세스는 한개 이상의 스레드가 존재하여 작업을 수행한다.
- Vector : ArrayList와 동일한 내부구조를 가지고 있지만, 동기화된 메소드로 구성되어 있어서 멀티스레드가 동시에 Vector()메소드를 실행할 수 없다.

  - 스레드(멀티처리)에서 ArrayList 대신 사용
  - `vlist.iterator();` : 반복자, 재사용할 수 없다.
  - `.hasNext();` : 해당 변수에 어떤 주소를 가지고 있으면 true or false
  - `.next()` : 해당 변수에 제일 앞에 있는 주소를 가져온다.
  - source

    ```java
    package javaHigh02.example05;

    import java.util.Iterator;
    import java.util.Vector;

    public class StudentMain {
        public static void main(String[] args) {
            Vector<Student> vlist = new Vector<Student>();

            vlist.add(new Student("홍길동", 30));
            vlist.add(new Student("홍길동1", 60));
            vlist.add(new Student("홍길동2", 70));
            vlist.add(new Student("홍길동3", 80));
            Iterator<Student> it = vlist.iterator();
            while(it.hasNext()) {
                Student st = it.next();
                System.out.println(st);
            }
            System.out.println("--------------");
            vlist.remove(2);
            it = vlist.iterator();
            while(it.hasNext()) {
                Student st = it.next();
                System.out.println(st);
            }
        }
    }
    ```

- ArrayList : 배열을 대신하는 것

  - 빈 데이터 없이 순차적으로 저장한다. 메모리 사용이 효율적이다.
  - 삽입과 삭제가 LinkedList보다 비효율적이다.
  - 자료구조 : 선형구조
  - 저장용, 백업용, 검색용, SAM

- LinkedList : 따로따로 저장
  - 데이터 양이 많아졌을 때 삽입과 삭제가 ArrayList보다 효율적이다.
  - 링크(주소)를 담는 곳이 더 필요해서 메모리 낭비가 있다.
  - 수정이 빈번히 일어나는 프로그램의 경우 LinkedList가 효율적이다.

---

### 3. memo

- [반복자 보충설명](https://onlyfor-me-blog.tistory.com/319)
- 2월 13일 월요일 ncs 과정평가시험
