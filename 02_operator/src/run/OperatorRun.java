package run;

// 다른 패키지의 클래스를 가져오기 위해선 import 구문 작성
import ex.OperatorEx;

/**
 * 연산자 예제 실행용 클래스
 */
public class OperatorRun {
	public static void main(String[] args) {
		OperatorEx ex = new OperatorEx();
			// 가져온 OperatorEx 클래스를 객체로 생성
		
		// OperatorEx 객체가 가지고있는 test1() 메서드를 호출
		ex.test1();
		
		ex.test2();
		
		ex.method1();
		
		ex.method2();
		
		ex.method3();
	}
}
