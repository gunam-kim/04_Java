package section03;

import java.io.EOFException;
import java.io.IOException;

public class Child extends Parent {
	// 오버라이딩 : 자식 클래스에서 상속받은 부모 메서드 재정의
		// 성립조건 1) 반환형,메서드명,매개변수 모두 일치
		// 성립조건 2) 접근 제어자는 같거나 넓은 범위
		// 성립조건 3) 예외 처리 구문(throws)의 예외 타입은 같거나 좁은 범위 + 예외 제거
	/* 부모 타입의 예외 -> 자식 타입(좁은 범위)으로 변경 가능 확인 */
	@Override
	public void method1() throws EOFException{}
	
	/* 부모 타입의 예외 -> 상위 타입으로 변경 가능 확인 */
	// @Override
	// public void method2() throws Exception{}
		// Exception Exception is not compatible with throws clause in Parent.method2()
		// 컴파일 에러 발생
	
	/* 예외 처리 구문 제거 */
	@Override
	public void method3(){}
	// 재정의 시 예외 발생 가능성이 있는 코드가 제거될 수 있어서
}
