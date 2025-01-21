package common;

public class PrintEx {
	public static void main(String[] args) {
		
		/* System.out : 지정된 출력용 화면 (Eclipse Console)
		 * 1) System.out.print(출력 내용);
		 * 출력 내용을 console에 출력
		 * 출력 완료 후 줄이 바뀌지 않음
		 * 
		 * 2) System.out.println(출력 내용);		(ln : line)
		 * 출력 완료 후 줄이 바뀜
		 * 
		 * 3) System.out.printf("문자열 템플릿(패턴)", 패턴에 대입될 값/변수);
		 * 정해진 형식(템플릿)에 맞는 문자열을 출력하는 구문
		 * 템플릿 중간에 "%"로 시작하는 패턴을 입력하여 원하는 값/변수를 대입할 수 있다
		 * (패턴 종류)
		 * %d : Decimal. 10진 정수 (byte, short, int, long)
		 		* 양의 정수 : 정수 크기만큼 칸 확보 + 오른쪽 정렬
		 		* ex) %4d, 3대입 : ㅁㅁㅁ3
		 		* 음의 정수 : 정수 크기만큼 칸 확보 + 왼쪽 정렬
		 		* ex) %-4d, 3대입 : 3ㅁㅁㅁ
		 * %c : Character. 문자 (char)
		 * %s : String. 문자열 (string)
		 * %b : Boolean. 논리형 (boolean)
		 * %f : Float. 실수 (float, double)
		 		* 소수점 : 소수점 아래 몇째자리까지 표시할지 지정
		 		* (지정된 자리 아래에서 반올림 처리)
		 		* ex) %.1f, 3.15 대입 : 3.2
		 */
		
		System.out.println("print() 확인");
		System.out.print("이름 : ");						// 줄바꿈 X
		System.out.print("홍길동");							// 줄바꿈 X
		System.out.println(", 나이 : 20세");		// 줄바꿈 O
		
		System.out.println("println() 확인");
		System.out.println(); 									// 출력 내용없이 줄만 바꿈
		
		System.out.println("printf() 확인");
		String name = "신짱구";									// 참조형 (값 저장 X, 값의 위치(주소) 저장)
		int age = 5;														// 정수 기본형 (4btye)
		double height = 80.5;										// 실수 기본형 (8btye)
		char gender = '남';											// 문자형 (2byte)
		boolean javaStudy = false;							// 논리형 (1byte)
		
		// println()
		System.out.println(name + "는 " + age + "세 "
		+ gender + "아로 " + "키는 " + height + "cm이며, "
		+ "자바 공부 여부 : " + javaStudy);
		
		// printf()
		System.out.printf("%s는 %d세 %c아로 키는 %.1fcm이며, 자바 공부 여부 : %b",
				name, age, gender, height, javaStudy);		
		System.out.println();
		
		// 왼쪽 정렬
		System.out.printf("%-6s/%-6d", name, age);		
		System.out.println();
		
		// 오른쪽 정렬
		System.out.printf("%6s/%6d", name, age);
		System.out.println();
		
		// (참고) 0 : 빈칸에 0 추가 (숫자만 가능)
		System.out.printf("%6s/%06d", name, age);
		System.out.println();
		
		System.out.println("-------------------------------------------------");
		
		/* Escape 문자
		 * 문자열 내에서 \로 시작하는 특수 문자
		 		* 줄바꿈 : \n, \r, \r\n
		 		* 탭 : \t
		 		* 유니코드 : \u0000
		 		* \ 출력 : \\
		 		* ', " 출력 : \', \"
		 */
		
		System.out.print("1\t2\t3\n");												// 1	2	3
		System.out.print("\"홍길동\"의 자료형은 String\r");		// "홍길동"의 자료형은 String
		System.out.print("\\o/\n");														// \o/
	}
}
