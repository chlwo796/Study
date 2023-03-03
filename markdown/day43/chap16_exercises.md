2023년 3월 3일 금요일

---

## chap.16 exercises

### 1. 람다식

- 람다식은 함수형 인터페이스의 익명 구현 객체를 생성한다.
- 매개변수가 없을 경우() -> {~} 형태로 작성한다.
- (x,y) -> {return x+y;} 는 (x,y) -> x+y 로 바꿀 수 있다.
- @FunctionalInterface가 기술된 인터페이스만 람다식으로 표현이 가능하다. (x) -> 기술되어 있지 않아도 함수적 인터페이스(추상메소드 1개)라면 가능하다.

### 2. 메소드 참조와 생성자 참조

- 메소드 참조는 함수적 인터페이스의 익명 구현 객체를 생성한다.
- 인스턴스 메소드는 "참조변수::메소드"로 기술한다.
- 정적 메소드는 "클래스::메소드"로 기술한다.
- 생성자 참조인 "클래스::new"는 매개변수가 없는 디폴트 생성자만 호출한다. (x) -> 매개변수가 있는 명시적생성자도 호출할 수 있다.

### 3. 람다식오류

- a -> a+3
- a,b -> a\*b (x) -> 매개변수가 두개 이상이면 (소괄호)를 기술해야한다.
- x -> System.out.println(x/5)
- (x,y) -> Math.max(x,y)

### 4. 람다식 작성

    ```java
    package javaChap16.exercise04;

    public class Example {
        public static void main(String[] args) {
            Thread thread = new Thread(() -> {
                for (int i = 0; i < 3; i++) {
                    System.out.println("작업 스레드가 실행됩니다.");
                }
            });

            thread.start();
        }
    }
    ```

### 5. 람다식 작성

```java
package javaChap16.exercise05;

public class Button {
	@FunctionalInterface
	public static interface ClickListener {
		void onClick();
	}

	private ClickListener clickListener;

	public void setClickListener(ClickListener clickListener) {
		this.clickListener = clickListener;
	}

	public void click() {
		this.clickListener.onClick();
	}
}
```

```java
package javaChap16.exercise05;

public class Example {
	public static void main(String[] args) {
		Button btnOk = new Button();
		btnOk.setClickListener(() -> System.out.println("OK 버튼을 클릭했습니다."));
		btnOk.click();

		Button btnCancel = new Button();
		btnCancel.setClickListener(() -> System.out.println("Cancel 버튼을 클릭했습니다."));
		btnCancel.click();
	}
}
```

### 6. Function 함수형 인터페이스 작성

```java
package javaChap16.exercise06;

public class Example {
	public static double calc(Function fun) {
		double x = 10;
		double y = 4;
		return fun.apply(x, y);
	}

	public static void main(String[] args) {
		double result = calc((x, y) -> (x / y));
		System.out.println("result : " + result);
	}
}

@FunctionalInterface
interface Function {
	double apply(double x, double y);
}
```

### 7. maxOrMin() 메소드를 호출할 때 람다식 작성

    ```java
    package javaChap16.exercise07;

    @FunctionalInterface
    public interface Operator {
        public int apply(int x, int y);
    }
    ```

    ```java
    package javaChap16.exercise07;

    public class Example {
        private static int[] scores = { 10, 50, 3 };

        public static int maxOrMin(Operator operator) {
            int result = scores[0];
            for (int score : scores) {
                result = operator.apply(result, score);
            }
            return result;
        }

        public static void main(String[] args) {
            int max = maxOrMin((result, score) -> {
                if (result >= score) {
                    return result;
                } else {
                    return score;
                }
            });
            System.out.println(max);

            int min = maxOrMin((result, score) -> {
                if (result <= score) {
                    return result;
                } else {
                    return score;
                }
            });
            System.out.println(min);
        }
    }
    ```

### 8. avg()메소드 작성

    ```java
    package javaChap16.exercise08;

    @FunctionalInterface
    public interface Function<T> {
        public double apply(T t);
    }
    ```

    ```java
    package javaChap16.exercise08;

    public class Student {
        private String name;
        private int englishScore;
        private int mathScore;

        public Student(String name, int englishScore, int mathScore) {
            super();
            this.name = name;
            this.englishScore = englishScore;
            this.mathScore = mathScore;
        }

        public String getName() {
            return name;
        }

        public int getEnglishScore() {
            return englishScore;
        }

        public int getMathScore() {
            return mathScore;
        }
    }
    ```

    ```java
    package javaChap16.exercise08;

    public class Example {
        private static Student[] students = { new Student("홍길동", 90, 96), new Student("신용권", 95, 93) };

        public static double avg(Function<Student> function) {
            int sum = 0;
            for (int i = 0; i < students.length; i++) {
                sum += function.apply(students[i]);
            }
            double result = (double) sum / students.length;
            return result;
        }

        public static void main(String[] args) {
            double englishAvg = avg(s -> s.getEnglishScore());
            System.out.println("영어 평균 점수 : " + englishAvg);

            double mathAvg = avg(s -> s.getMathScore());
            System.out.println("수학 평균 점수 : " + mathAvg);
        }
    }
    ```

### 9. 메소드 참조

    ```java
    package javaChap16.exercise08;

    public class Example {
        private static Student[] students = { new Student("홍길동", 90, 96), new Student("신용권", 95, 93) };

        public static double avg(Function<Student> function) {
            int sum = 0;
            for (int i = 0; i < students.length; i++) {
                sum += function.apply(students[i]);
            }
            double result = (double) sum / students.length;
            return result;
        }

        public static void main(String[] args) {
            // 람다식이 매개값으로 변수를 전달만 하기 때문에 참조형으로 변경 가능
    //		double englishAvg = avg(s -> s.getEnglishScore());
            double englishAvg = avg(Student::getEnglishScore);
            System.out.println("영어 평균 점수 : " + englishAvg);

    //		double mathAvg = avg(s -> s.getMathScore());
            double mathAvg = avg(Student::getMathScore);
            System.out.println("수학 평균 점수 : " + mathAvg);
        }
    }
    ```
