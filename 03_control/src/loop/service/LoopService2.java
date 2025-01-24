package loop.service;

import java.util.Scanner;

public class LoopService2 {
	Scanner sc = new Scanner(System.in);
	public void displayMenu() {
		System.out.println("LoopService2");
		System.out.println("1. 모양 출력하기");
		System.out.println("2. 1~20 중 입력된 수까지 출력");
		System.out.println("3. 1~20 중 입력된 수의 배수 제외하고 출력");
		System.out.println("4. 0이 입력될 때까지 입력된 모든 숫자 합계 구하기");
		System.out.println("5. ");
		
		System.out.print("번호 입력 >> ");
		int input = sc.nextInt();
		
		switch(input) {
		case 1 : method1(); break;
		case 2 : method2(); break;
		case 3 : method3(); break;
		case 4 : method4(); break;
		case 5 : method5(); break;
		default : System.out.println("잘못 입력하셨습니다");
		}
	}
	
	/**
	 * 다음 모양 출력하기
	 * <pre>
	 * (0, 0) (0, 1) (0, 2)
	 * (1, 0) (1, 1) (1, 2)
	 * (2, 0) (2, 1) (2, 2)
	 * (3, 0) (3, 1) (3, 2)
	 * </pre>
	 */
	public void method1() {
		for(int row=0; row<4; row++) {
			for(int col=0; col<3; col++) {
				System.out.printf("(%d, %d) ", row, col);
			}
			System.out.println();
		}
	}
	
	/* 분기문
	 * - break : 현재 반복 종료
	 * - continue : 다음 반복으로 넘어감
	 */
	
	/**
	 * 1~20까지 출력
	 * 단, 입력받은 수에서 반복 멈춤
	 */
	public void method2() {
		System.out.print("Stop Number : ");
		int stop = sc.nextInt();
		
		for(int i=1; i<=20; i++) {
			System.out.print(i + " ");
			if(i == stop) {
				break;
			}
		}
	}
	
	/**
	 * 1~20까지 출력
	 * 단, 입력받은 수의 배수는 출력 X
	 */
	public void method3() {
		System.out.print("Continue Number : ");
		int con = sc.nextInt();
		
		for(int i=1; i<=20; i++) {
			if(i % con == 0) {
				continue;
			}
			System.out.print(i + " ");
		}
	}
	
	/**
	 * 0이 입력될 때까지 입력된 모든 숫자 합계 구하기 1
	 */
	public void method4() {
		int sum = 0;
		int input = -1;
		
		while(input != 0) {				// 0이 아닐때 반복
			System.out.print("정수 입력 : ");
			input = sc.nextInt();
			
			sum += input;
		}
		System.out.println("합계 : " + sum);
	}
	
	/* do~while문
	 * - while문의 조건식이 시작이 아닌 마지막 부분으로 이동한 반복문
	 * - 최소 1회 이상의 반복 보장
	 * [작성법]
	 * do{
	 * 
	 * } while(조건식);
	 */
	
	/**
	 * 0이 입력될 때까지 입력된 모든 숫자 합계 구하기 2
	 */
	public void method5() {
		int sum = 0;
		int input = 0;

		do {
			System.out.print("정수 입력 : ");
			input = sc.nextInt();
			
			sum += input;
		} while(input != 0);
		System.out.println("합계 : " + sum);
	}
}
