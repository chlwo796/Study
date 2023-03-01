package javaChap12.example10;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.METHOD })	// 메소드를 타겟으로
@Retention(RetentionPolicy.RUNTIME)	// 실행할 때 적용
public @interface PrintAnnotation {
	String value() default "-";	// value속성

	int number() default 15;	// number속성

}
