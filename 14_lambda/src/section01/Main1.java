package section01;

public class Main1 {
	public static void main(String[] args) {
		/* Calculator 구현체를 만들어서 메서드 수행하기 */
		
		/* 1. 인터페이스를 상속받은 클래스 이용 */
		Calculator calc1 = new CalculatorImpl();					// 구현체 객체 이용
		System.out.println("calc1.sumTwoNumber(3,6) : " + calc1.sumTwoNumber(3,6));
		
		/* 2. 익명 내부 클래스 이용 */
		Calculator calc2 = new Calculator() {			
			@Override
			public int sumTwoNumber(int a, int b) {
				return a + b;
			}
		};
		System.out.println("calc2.sumTwoNumber(10,89) : " + calc2.sumTwoNumber(10,89));
		
		/* 3. 람다식을 이용 */
		Calculator calc3 = (a, b) -> { return a + b; };
			// 추상 메서드 int sumTwoNumber(int a, int b)를 오버라이딩
		// 람다식은 컴파일 시 익명 내부 클래스로 변환된다
		
		System.out.println("calc3.sumTwoNumber(100, 899) : " + calc3.sumTwoNumber(100, 899));
		
		Calculator calc4 = (a, b) -> 2 * (a + b);
			// {} 내부 코드가 한 줄이면 {}, return 생략 가능하다
		
		System.out.println("calc4.sumTwoNumber(3, 4) : " + calc4.sumTwoNumber(3, 4));
		
		Calculator calc5 = (a, b) -> (a * a) + (b * b * b);
		
		System.out.println("calc5.sumTwoNumber(3, 2) : " + calc5.sumTwoNumber(3, 2));
	}
}
