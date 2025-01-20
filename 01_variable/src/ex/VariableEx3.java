package ex;

public class VariableEx3 {
	public static void main(String[] args) {
		
		/* 강제 형 변환
		 * 1) 값의 범위가 큰 자료형 -> 작은 자료형으로 변환할 때
		 * (데이터 손실을 고려해야 한다)
		 * 2) 의도적으로 자료형을 변환할 때
		 * ex) (double)int -> double
		 * 
		 * [작성법]
		 * (자료형) 변수명/값;
		 */
		System.out.println("[강제 형 변환 예제 1 - 데이터 손실]");
		
		int num1 = 290;
		byte result1 = (byte)num1;
		System.out.println("num1 : " + num1);
		System.out.println("result1 : " + result1);
		
		System.out.println("-------------------------------------------------");
		System.out.println("[강제 형 변환 예제 2 - 데이터 손실]");
		
		// 실수 -> 정수로 강제 형 변환 (소수점 버림 처리)
		double num2 = 123.999;
		int result2 = (int)num2;
		System.out.println("num2 : " + num2);
		System.out.println("result2 : " + result2);
		
		System.out.println("-------------------------------------------------");
		System.out.println("[강제 형 변환 예제 3 - 데이터 손실 의도적 사용]");
		
		// 난수를 정수 형태로 반환 받기
			// JavaScript : Math.floor( Math.random() * 10 + 1 )	1~10 사이 정수형 난수
			// Java		  : (int)( Math.random() * 10 + 1 )			1~10 사이 정수형 난수
		// Math.random() : 0.0이상 1.0미만 double형 난수 반환
		for(int i=0; i<5; i++) {
			double randomNumber = (int)( Math.random() * 10 + 1 );
			System.out.println("randomNumber : " + randomNumber);
		}
		
		System.out.println("-------------------------------------------------");
		System.out.println("[의도적으로 자료형을 변환 1]");
		
		int a3 = 5;
		int b3 = 2;
		System.out.println( (double)a3 / (double)b3 );		// 강제 형 변환 적용
		System.out.println( (double)a3 / b3 );				// 자동 형 변환 적용
		
		System.out.println("-------------------------------------------------");
		System.out.println("[의도적으로 자료형을 변환 2]");
		System.out.println("문자(char) <=> 유니코드(int)");
		
		System.out.println("A의 유니코드 번호 : " + (int)'A');
		System.out.println("A 뒤에 10번째 문자 : " + (char)('A' + 10));
	}
}
