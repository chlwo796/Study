package chap07;

public class ExeTimeCalculator implements Calculator {
	private Calculator delegate;

	public ExeTimeCalculator(Calculator delegate) {
		this.delegate = delegate;
	}
	
	@Override
	public long factorial(long num) {
		long start = System.nanoTime();
		// 핵심 기능의 실행은 다른 객체에 위임하고 부가적인 기능을 제공하는 객체를 프록시(proxy)라고 부른다.
		// 실제 핵심 기능을 실행하는 객체는 대상 객체라고 부른다.
		// ExeTimeCalculator = proxy, ImpeCalculator = 프록시의 대상객체
		long result = delegate.factorial(num);
		long end = System.nanoTime();
		System.out.printf("%s.factorial(%d) 실행 시간 = %d\n", delegate.getClass().getSimpleName(), num, (end - start));
		return result;
	}
}
