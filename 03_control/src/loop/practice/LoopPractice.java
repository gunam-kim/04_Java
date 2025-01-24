package loop.practice;

import java.util.Scanner;

/**
 * 기능 제공용 클래스
 */
public class LoopPractice {
	Scanner sc = new Scanner(System.in);
	
	public void displayMenu() {
		System.out.println("실행할 메소드 번호 입력");
		System.out.println("1. ");
		System.out.println("2. ");
		System.out.println("3. ");
		System.out.println("4. ");
		System.out.println("5. ");
		System.out.println("6. ");
		System.out.println("7. ");
		System.out.println("8. ");
		System.out.println("9. ");
		System.out.println("10. ");
		System.out.println("11. ");
		System.out.println("12. ");
		System.out.println("13. ");
		System.out.println("14. ");
		System.out.println("15. ");
		System.out.println("16. ");
		System.out.print(">>");
		
		int input = sc.nextInt();
		
		switch(input) {
		case 1 : practice1(); break;
		case 2 : practice2(); break;
		case 3 : practice3(); break;
		case 4 : practice4(); break;
		case 5 : practice5(); break;
		case 6 : practice6(); break;
		case 7 : practice7(); break;
		case 8 : practice8(); break;
		case 9 : practice9(); break;
		case 10 : practice10(); break;
		case 11 : practice11(); break;
		case 12 : practice12(); break;
		case 16 : practice16(); break;
		default : System.out.println("잘못 입력했습니다");
		}
		
	}
	
	/**
	 * 사용자로부터 한개의 값을입력받아1부터그숫자까지의숫자들을모두출력하세요.
	 * 단, 입력한수는1보다크거나같아야합니다.
	 * 만일1 미만의숫자가입력됐다면“1 이상의숫자를입력해주세요“를출력하세요
	 */
	public void practice1() {
		System.out.print("숫자 입력 >> ");
		int num = sc.nextInt();
		
		if(num < 1) {
			System.out.println("1 이상의 숫자를 입력해주세요");
		} else {
			for(int i=1; i<=num; i++) {
				System.out.printf("%d ", i);
			}
		}
	}
	
	/**
	 * 사용자로부터한개의값을입력받아1부터그숫자까지의모든숫자를거꾸로출력하세요.
	 * 단, 입력한수는1보다크거나같아야합니다
	 */
	public void practice2() {
		System.out.print("숫자 입력 >> ");
		int num = sc.nextInt();
		
		if(num < 1) {
			System.out.println("1 이상의 숫자를 입력해주세요");
		} else {
			for(int i=num; i>=1; i--) {
				System.out.printf("%d ", i);
			}
		}
	}
	
	/**
	 * 1부터사용자에게입력받은수까지의정수들의합을for문을이용하여출력하세요
	 * ex) 정수 입력 : 8
	 * 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 = 36
	 */
	public void practice3() {
		System.out.print("숫자 입력 >> ");
		int num = sc.nextInt();
		int sum = 0;
		
		for(int i=1; i<=num-1; i++) {
			System.out.printf("%d + ", i);
			sum += i;
		}
		System.out.printf("%d = %d", num, num+sum);
	}
	
	/**
	 * 사용자로부터두개의값을입력받아그사이의숫자를모두출력하세요.
	 * 만일1 미만의숫자가입력됐다면“1 이상의숫자를입력해주세요“를출력하세요
	 */
	public void practice4() {
		System.out.print("첫번째 숫자 입력 >> ");
		int num1 = sc.nextInt();
		System.out.print("두번째 숫자 입력 >> ");
		int num2 = sc.nextInt();
		
		if(num1<1 || num2<1) {
			System.out.println("1 이상의 숫자를 입력해주세요");
			return;
		} 
		if(num1<=num2) {
			for(int i=num1; i<=num2; i++) {
				System.out.printf("%d ", i);
			}
		} else {
			for(int i=num2; i<=num1; i++) {
				System.out.printf("%d ", i);
			}
		}
	}
	
	/**
	 * 사용자로부터입력받은숫자의단을출력하세요
	 */
	public void practice5() {
		System.out.print("구구단 단 입력 >> ");
		int dan = sc.nextInt();
		
		System.out.printf("===== %d단 =====\n", dan);
		for(int i=1; i<=9; i++) {
			System.out.printf("%2d x %2d = %2d\n", dan, i, dan*i);
		}
	}
	
	/**
	 * 사용자로부터입력받은숫자의단부터9단까지출력하세요.
	 * 단, 2~9를사이가아닌수를입력하면“2~9 사이숫자만입력해주세요”를출력하세요
	 */
	public void practice6() {
		System.out.print("구구단 단 입력 >> ");
		int num = sc.nextInt();
		
		if(num<2 || num>9) {
			System.out.println("2~9 사이 숫자만 입력해주세요");
			return;
		}
		for(int dan=num; dan<=9; dan++) {
			System.out.printf("===== %d단 =====\n", dan);
			for(int i=1; i<=9; i++) {
				System.out.printf("%2d x %2d = %2d\n", dan, i, dan*i);
			}
		}
	}
	
	/**
	 * 정수입력: 4
	 *  *
	 *  **
	 *  ***
	 *  ****
	 */
	public void practice7() {
		System.out.print("숫자 입력 >> ");
		int num = sc.nextInt();
		
		for(int i=1; i<=num; i++) {
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}			
			System.out.print("\n");
		}
	}
	
	public void practice8() {
		System.out.print("숫자 입력 >> ");
		int num = sc.nextInt();
		
		for(int i=num; i>=1; i--) {
			for(int j=i; j>=1; j--) {
				System.out.printf("*");
			}
			System.out.print("\n");
		}
	}
	
	/**
	 * 정수입력: 4
	 * 		*
	 * 	 **
	 *  ***
	 * ****
	 */
	public void practice9() {
		System.out.print("숫자 입력 >> ");
		int num = sc.nextInt();
		
		for(int i=1; i<=num; i++) {
			for(int j=1; j<=num-i; j++) {
				System.out.print(" ");
			}
			for(int k=1; k<=i; k++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
	}
	
	/**
	 * 정수입력: 3
	 * *
	 * **
	 * ***
	 * **
	 * *
	 */
	public void practice10() {
		System.out.print("숫자 입력 >> ");
		int num = sc.nextInt();
		
		for(int i=1; i<=num; i++) {
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i=1; i<=num-1; i++) {
			for(int j=num-1; j>=i; j--) {
				System.out.print("*");
			}
			System.out.println();
		}		
	}
	
	/**
	 * 정수입력: 4
	 * 		*
	 * 	 ***
	 * 	*****
	 * *******
	 */
	public void practice11() {
		System.out.print("숫자 입력 >> ");
		int num = sc.nextInt();
		
		for(int i=1; i<=num; i++) {
			for(int j=num-1; j>=i; j--) {
				System.out.print(" ");
			}
			for(int k=1; k<=2*i-1; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	/**
	 * 정수입력: 5
	 * *****
	 * *   *
	 * *   *
	 * *   *
	 * *****
	 */
	public void practice12() {
		System.out.print("숫자 입력 >> ");
		int num = sc.nextInt();
		
		for(int row=1; row<=num; row++) {
			for(int col=1; col<=num; col++) {
				if(row==1 || row==num || col==1 || col==num) {
					System.out.print("*");					
				}else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	
	public void practice13() {}
	public void practice14() {}
	public void practice15() {}
	
	public void practice16() {
		System.out.print("숫자 입력 >> ");
		int num = sc.nextInt();
		
		int count = 0;										// 소수 갯수를 세기 위한 변수
		
		// 2부터 입력받은 수까지 1개씩 접근하는 for문
		for(int i=2; i<=num; i++) {
			boolean flag = true;						// 신호 용도
																			// true인 경우 : 소수 O
																			// false인 경우 : 소수 X
			
			// 1과 자기 자신을 뺀 정수를 한개씩 접근(x)
			for(int x=2; x<i; x++) {
				if(i%x == 0) {								// 1, 자기 자신 빼고 나누어 떨어지는 수 존재
					flag = false;
					break;
				}
			}
			
			if(flag) {											// 소수라고 판별된 경우 수행
				System.out.print(i + " ");
				count++;
			}
		}
		System.out.printf("\n2부터 %d까지 소수의 개수는 %d개입니다\n", num, count);
	}
}
