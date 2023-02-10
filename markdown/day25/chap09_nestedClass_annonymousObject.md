2023�� 2�� 6�� ������

---

## chap.09 nestedClass & annonymousObject

### 1. ��ø Ŭ������ ��ø �������̽�

- Ư�� Ŭ������ ���踦 ���� ��쿡�� ���� Ŭ������ ���ο� �����ϴ� ���� ����.
- ��øŬ����(nested class)�� Ŭ���� ���ο� ������ Ŭ������ ���ϴ� �� ��ø Ŭ������ ����ϸ� �� Ŭ������ ������� ���� ���� ������ �� �ִٴ� ������ ������ �ִ�.
- �ܺο��� ���ʿ��� ���� Ŭ������ �������μ� �ڵ��� ���⼺�� ���� �� �ִ�.

1. ��øŬ���� ����

   ```java
   public class A {
       class B{

       }
   }
   ```

2. ��ø �������̽� ����

   ```java
   public class B {
       interface C{

       }
   }
   ```

3. �̿�Ǵ� ��

- UI ���α׷��ֿ��� �̺�Ʈ�� ó���� �������� ���

4. ��ø Ŭ������ ����

- ����Ŭ�������� �ܺ�Ŭ������ ������� ���� ������ �� �ִ�.
- �ڵ��� ���⼺�� ���� �� �ִ�.(ĸ��ȭ)

5. ����Ŭ������ �ٸ� Ŭ�������� �� ������� �ʰ� �ܺ�Ŭ���������� �ַ� ����ϹǷ� ����Ŭ������ ���� ���̴�.

   ```java
   public class A { // �ܺ�Ŭ����
       class B{ // ����Ŭ����

       }
   }
   ```

### 2. ��ø(����) Ŭ������ ������ Ư¡

1. �ν��Ͻ� Ŭ����(instance class)

- �ܺ� Ŭ������ ��� ���� ���� ��ġ�� �����ϸ�, �ܺ� Ŭ������ �ν��Ͻ�ó�� �ٷ������.
- �ַ� �ܺ�Ŭ������ �ν��Ͻ� ������ ���õ� �۾��� ���� �������� ����ȴ�.

  1.  ����

      ```java
      public class A {
              class B{ // �ν��Ͻ� Ŭ����
              // A��ü�� �����ؾ߸� B ��øŬ������ ����� �� �ִ�.
              }
          }
      ```

  2.  �����

  - AŬ���� �ܺο��� �ν��Ͻ� ���Ŭ���� B�� ��ü�� �����Ϸ���, ���� A��ü�� �����ϰ� B�� ��ü�� �����Ѵ�.

    ```java
    public class A {
        int fieldA;

        class B {
            int fieldB;

            void methodB() {
                fieldA = fieldA + 3; // ����Ŭ�������� �ܺ�Ŭ���� �ν��Ͻ����� ���ٰ���
                System.out.println("fieldA : " + fieldA);
                System.out.println("fieldB : " + fieldB);
            }
        }

        void methodA() {

        }
    }
    public class Main {
        public static void main(String[] args) {
            A a = new A();
            A.B b = a.new B();  // A��ü ���� �� B��ü ����
            b.fieldB = 5;   // B��ü�� �ν��Ͻ����� ����
            b.methodB();    // B��ü�� �ν��Ͻ��޼ҵ� ����
        }
    }
    ```

2. ����ƽ Ŭ����(static class)

- �ܺ� Ŭ������ ��� ���� ���� ��ġ�� �����ϸ�, �ܺ� Ŭ������ static���ó�� �ٷ������.
- �ַ� �ܺ� Ŭ������ static ���, Ư�� static �޼ҵ忡 ���� �������� ����ȴ�.

  1. ����

     ```java
     public class A {
            static class C{ // ����ƽ Ŭ����

             }
         }
     ```

  2. ������

     ```java
     public class C {
         static class D{
             int d;
             static int sd;
             void methodD() {

             }
             static void smethodD() {

             }
         }
     }
     public class Main {
         public static void main(String[] args) {

             C.D cd = new C.D();
             cd.methodD();
             cd.d = 3;
             C.D.sd = 2;
             C.D.smethodD();

         }
     }
     ```

3. ���� Ŭ����(local class)

- �ܺ� Ŭ������ �޼ҵ峪 �ʱ�ȭ �� �ȿ� �����ϸ�, ����� ���� ���ο����� ���� �� �ִ�.
- �޼ҵ� ȣ�� �ÿ��� ���� �� �ֱ� ������, �޼ҵ带 �����ϸ� �������п� �����ϴ�.

  1. ���� �� ����

     ```java
     public class A {
         private int fieldA;

         void methodA() {
             class B {
                 int fieldB;

                 void methodB() {
                     fieldA = +1;
                     fieldA = fieldA + fieldB;
                     System.out.println(fieldA);
                 }

             }
             B b = new B();
             b.fieldB = +3;
             b.methodB();

         }
     }
     public class Main {
         public static void main(String[] args) {

             A a = new A();
             a.methodA();
         }
     }
     ```

4. �͸� Ŭ����(anonymous class)

- Ŭ������ ����� ��ü�� ������ ���ÿ� �ϴ� �̸����� Ŭ����(��ȸ��)

### 3. �͸�Ŭ����(anonymous clas)

1. �͸�Ŭ������ �̸��� ���� Ŭ�����̴�.
   - Ŭ������ ����� ��ü�� ������ ���ÿ� �ϱ� ������ �� �ѹ��� ���� �� �ְ� ���� �ϳ��� ��ü���� ������ �� �ִ� ��ȸ�� Ŭ�����̴�.
2. ����(`Type name = new Type(){};`)

   ```java
   package tempMemo;

   public class A {
       void methodA() {
       }
   }
   package tempMemo;

   public interface C {
       void methodC();
   }
   package tempMemo;

   public class B {
       A a = new A() {
           void methodA() {
               System.out.println("class A�� �͸� �ڽİ�ü");
           };
       };
       C c = new C() {
           @Override
           public void methodC() {
               System.out.println("interface C�� �͸� ������ü");
           }
       };
   }
   ```

3. Ư¡

- �̸��� ���� ������ �����ڸ� ���� �� ����.
- ����Ŭ������ �̸��̳� �����ϰ��� �ϴ� �������̽��� �̸��� ����ؼ� �����ϱ� ������ �ϳ��� Ŭ������ ��ӹ޴� ���ÿ� �������̽��� �����ϰų� �� �̻��� �������̽��� ������ �� ����.
- ������ �� �ϳ��� Ŭ������ ��ӹްų� �� �ϳ��� �������̽����� ������ �� �ִ�.

4. ���� �� �����Ǵ� ����

`�ܺ�Ŭ������$number.class`
