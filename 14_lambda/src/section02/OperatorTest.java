package section02;

import java.util.function.IntBinaryOperator;
import java.util.function.UnaryOperator;

public class OperatorTest {
	public static void main(String[] args) {
		/* Operator 계열
			: 매개 변수와 반환 값의 타입이 같은 함수형 인터페이스
			: applyXXX() 메서드 제공
		*/
		
		/* UnaryOperator<T> : T를 전달받아 T를 반환 */
		UnaryOperator<String> addString
			= str -> "[" + str + "] 님 반갑습니다";
		System.out.println(addString.apply("맹구"));
		
		/* IntBinaryOperator : int 매개변수 2개를 전달받아 int 반환 */
		IntBinaryOperator square = (a, x) -> {
			int result = 1;
			for(int i=0; i<x; i++) {
				result *= a;
			}
			return result;
		};
		System.out.println("2^10 = " + square.applyAsInt(2, 10));
		System.out.println("2^16 = " + square.applyAsInt(2, 16));
	}
}
