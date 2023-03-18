package aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Aspect
@Order(1) // 지정 값에 따라 적용 순서 결정
public class ExeTimeAspect {

	@Pointcut("execution(public * chap07..*(..))") // execution 명시자는 Advice를 적용할 메소드를 지정할 때 사용
	// execution(수식어패턴? 리턴타입패턴 클래스이름패턴?메소드이름패턴(파라미터패턴)
	// 수식어패턴은 생략 가능하며 스프링 AOP에서는 public 메소드만 적용할 수 있다. * = 모든 값, .. = 0개 이상
	// chap07 패키지와 그 하위 패키지에 위치한 public 메소드를 Pointcut으로 설정
	// chap07 패키지나 그 하위 패키지에 속한 빈 객체의 public 메소드에 @Around가 붙은 measure() 메소드를 적용
	private void publicTarget() {

	}

//	public void publicTarget() {
// 다른 클래스에 위치한 @Around 어노테이션에서 publicTarget() 메소드의 Pointcut을 사용하고 싶은 경우, public으로 바꾼다.
//	}

	@Around("publicTarget()")
	// publicTarget() 메소드에 정의한 Pointcut에 공동 기능을 적용한다.
//	@Around("aspect.ExeTimeAspect.publicTarget()")
//	여러 Aspect에서 공통으로 사용하는 Pointcut 이 있는 경우 직접 설정을 통하여 재사용 할 수 있다.
	public Object measure(ProceedingJoinPoint joinPoint) throws Throwable {
		// ProceedingJoinPoint 타입 파라미터는 프록시 대상 객체의 메소드를 호출할 때 사용
		long start = System.nanoTime();
		try {
			Object result = joinPoint.proceed();
			// 대상 객체의 메소드 호출 후 리턴
			return result;
		} finally {
			long finish = System.nanoTime();
			Signature sig = joinPoint.getSignature();
			System.out.printf("%s.%s(%s) 실행 시간 : %d ns\n", joinPoint.getTarget().getClass().getSimpleName(),
					sig.getName(), Arrays.toString(joinPoint.getArgs()), (finish - start));
		}
	}
}
