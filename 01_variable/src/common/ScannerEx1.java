package common;

import java.util.Scanner;
			// import : 가져오다. 다른 패키지에 존재하는 클래스를 가져오는 구문

public class ScannerEx1 {
	public static void main(String[] args) {
		/* Scanner 클래스
		 * 사용자로부터 입력을 받기 위해 Java에서 제공하는 클래스
		 * java.util 패키지에 존재
		 * 사용 시 import java.util.Scanner 구문을 가져와야함
		 */
		
		// Scanner 생성 구문
		Scanner sc = new Scanner(System.in);
		// 키보드 입력을 읽어올 객체 Scanner를 생성 후 변수 sc에 저장
			// new : Heap 메모리 영역에 새 객체 생성
			// new Scanner() : Heap 메모리 영역에 Scanner 객체를 생성
			// System.in : 지정된 입력 장치 (Eclipse에서 기본값 : 키보드)
		
		System.out.print("정수 입력 : ");
		int num1 = sc.nextInt();
			// 입력 버퍼에서 다음 정수 읽어오기
			// 정수가 아닌 다른 값이 입력되어 읽어져오면 오류가 발생한다 (InputMistmatchException)
		
		System.out.println("입력받은 num1 : " + num1);
		
		System.out.print("두번째 정수 입력 : ");
		int num2 = sc.nextInt();
		System.out.println("입력받은 num2 : " + num2);
		System.out.println("num1 + num2 = " + (num1 + num2));
	}
}
