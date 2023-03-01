package javaChap12.example10;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.METHOD })	// �޼ҵ带 Ÿ������
@Retention(RetentionPolicy.RUNTIME)	// ������ �� ����
public @interface PrintAnnotation {
	String value() default "-";	// value�Ӽ�

	int number() default 15;	// number�Ӽ�

}
