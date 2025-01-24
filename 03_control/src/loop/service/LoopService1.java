package loop.service;

import java.util.Scanner;

/**
 * 반복문 기능 제공 클래스 1
 */
public class LoopService1 {
	// 필드
	Scanner sc = new Scanner(System.in);
	
	public void displayMenu() {
		System.out.println("1. for문을 이용해서 1~10까지 세로로 출력하기");
		System.out.println("2. for문을 이용해서 9~1까지 가로로 출력하기");
		System.out.println("3. 입력된 두 정수 사이의 모든 정수 출력 1");
		System.out.println("4. 입력된 두 정수 사이의 모든 정수 출력 2");
		System.out.println("5. 두 정수를 입력받아 작은 수부터 큰 수까지 1씩 증가하며 출력");
		System.out.println("6. 1~100 사이의 정수 중 입력받은 정수의 배수 갯수, 배수의 합 구하기");
		System.out.println("7. 입력받은 단 출력하기 (구구단)");
		System.out.println("8. 입력받은 두 정수 사이의 구구단을 모두 출력");
		
		System.out.print("실행할 메서드 번호 입력 >> ");
		int input = sc.nextInt();
		
		System.out.println("\n------------------------------------------\n");
		
		switch(input) {
		case 1 : method1(); break;
		case 2 : method2(); break;
		case 3 : method3(); break;
		case 4 : method4(); break;
		case 5 : method5(); break;
		case 6 : method6(); break;
		case 7 : method7(); break;
		case 8 : method8(); break;
		default : System.out.println("없는 번호 입력함");
		}
	}
	
	/**
	 * for문을 이용해서 1~10까지 세로로 출력하기
	 */
	public void method1() {
		for(int i=1; i<=10; i++) {
			// 초기식 : 대부분 for문 제어를 위한 변수를 선언
			// 조건식 : 결과가 true/false가 나오는 식
			// 증감식 : 초기식 변수를 증가/감소시켜 조건식의 결과가 변할 수 있게 제어
			System.out.println(i);
		}
	}
	
	/**
	 * for문을 이용해서 9~1까지 가로로 출력하기 
	 */
	public void method2() {
		for(int i=9; i>0; i--) {
			System.out.print(i + " ");
		}
		for(int i=0; i<9; i++) {
			System.out.printf("%d ", 9-i);
		}
	}
	
	/**
	 * 입력된 두 정수 사이의 모든 정수 출력
	 * (단, 첫번째 입력한 수가 작은 수)
	 * <pre>
	 * 첫 번째 정수 입력 : 5
	 * 두 번째 정수 입력 : 12
	 * 
	 * 5 6 7 8 9 10 11 12
	 * </pre>
	 */
	public void method3() {
		System.out.print("첫번째 정수 입력 : ");
		int num1 = sc.nextInt();
		System.out.print("두번째 정수 입력 : ");
		int num2 = sc.nextInt();
		
		if(num1 > num2) {
			System.out.println("첫번째 정수가 더 작아야합니다");
		}
		for(int i=num1; i<=num2; i++) {
			System.out.printf("%d ", i);
		}
	}
	
	/**
	 * 입력된 두 정수 사이의 모든 정수 출력
	 * <ul>
	 * 	<li>입력 1이 입력 2보다 작거나 같은 경우 : 1 2 3 ~ 증가하며 출력</li>
	 * 	<li>입력 1이 입력 2보다 큰 경우 : ~ 4 3 2 1 감소하며 출력</li>
	 * </ul>
	 */
	public void method4() {
		System.out.print("첫번째 정수 입력 : ");
		int num1 = sc.nextInt();
		System.out.print("두번째 정수 입력 : ");
		int num2 = sc.nextInt();
		
		if(num1 <= num2) {
			for(int i=num1; i<=num2; i++) {
				System.out.print(i + " ");
			}
		} else {
			for(int i=num1; i>=num2; i--) {
				System.out.printf("%d ", i);
			}
		}
	}
	
	/**
	 * 두 정수를 입력받아 작은 수부터 큰 수까지 1씩 증가하며 출력
	 * <pre>
	 * 입력 1 : 3
	 * 입력 2 : 6
	 * 3 4 5 6
	 * 
	 * 입력 1 : 7
	 * 입력 2 : 2
	 * 2 3 4 5 6 7
	 * </pre>
	 */
	public void method5() {
		System.out.print("첫번째 정수 입력 : ");
		int num1 = sc.nextInt();
		System.out.print("두번째 정수 입력 : ");
		int num2 = sc.nextInt();

		int start = num1;
		int end = num2;
		
		if(num1 > num2) {
			start = num2;
			end = num1;
		}
		for(int i=start; i<=end; i++) {
			System.out.print(i + " ");
		}
		
		System.out.println("\n------------------------------------------\n");
		
		// num1, num2를 바꾸기 (swap)
		if(num1 > num2) {
			int temp = num2;								// 임시 변수에 num2값 저장
			num2 = num1;										// num2에 num1값 대입
			num1 = temp;										// num1에 임시 변수에 저장한 값 대입
		}
		
		for(int i=num1; i<=num2; i++) {
			System.out.print(i + " ");
		}
	}
	
	/**
	 * 1~100 사이의 정수 중 입력받은 정수의 배수 갯수, 배수의 합 구하기
	 */
	public void method6() {
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		
		int sum = 0;										// 합계 저장용 변수
		int count = 0;									// 갯수 저장용 변수
		
		for(int i=1; i<=100; i++) {
			if(i % num == 0) {						// i가 num의 배수인 경우
				count++;
				sum += i;
			}
		}
		System.out.printf("개수 : %d / 합계 : %d", count, sum);
	}
	
	/**
	 * 입력받은 단 출력하기 (구구단)
	 */
	public void method7() {
		System.out.print("단 입력 : ");
		int dan = sc.nextInt();
		
		for(int i=1; i<=9; i++) {
			System.out.printf("%2d x %2d = %2d\n", dan, i, dan *i);
		}
	}
	
	/**
	 * 입력받은 두 정수 사이의 구구단을 모두 출력
	 * <pre>
	 * 시작 단 : 3
	 * 종료 단 : 5
	 * [3단]
	 * 3 x 1 = 3
	 * .........
	 * [4단]
	 * 4 x 1 = 4
	 * .........
	 * [5단]
	 * 5 x 1 = 5
	 * .........
	 * </pre>
	 */
	public void method8() {
		System.out.print("시작 단 : ");
		int start = sc.nextInt();
		System.out.print("종료 단 : ");
		int end = sc.nextInt();
		
		for(int dan=start; dan<=end; dan++) {
			System.out.printf("\n[%d단]\n", dan);
			for(int i=1; i<=9; i++) {
				System.out.printf("%2d x %2d = %2d\n", dan, i, dan * i);
			}
		}
	}
}