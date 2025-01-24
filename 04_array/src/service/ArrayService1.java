package service;

import java.util.Scanner;

public class ArrayService1 {
	/* 배열
	 * - 같은 자료형의 변수를 하나의 묶음으로 다루는 것
	 * - 생성 시 Heap 메모리 영역에 할당
	 * - 주소를 참조해서 배열 요소 접근 가능
	 */
	
	/**
	 * 배열 선언, 할당, 초기화
	 */
	public void method1() {
		
		/*
		 * int num;
		 * 		int 자료형을 저장하기 위한 공간(변수)을 메모리에 할당하고
		 * 		해당 공간의 이름을 "num"이라고 지정
		 * 		-> 실제 정수값을 저장 가능
		 * 		(실제 값을 저장할 수 있는 자료형은 기본 자료형밖에 없다)
		 */
		
		/* 배열 선언 */
		// : 배열을 참조할 변수 생성 
		int[] arr;
				// int[] 자료형을 저장하기 위한 공간(변수)을 메모리에 할당하고
				// 해당 공간의 이름을 "arr"이라고 지정
				// -> 배열이 존재하는 위치(주소) 저장 가능
				// (주소를 저장하는 변수를 "참조형 변수"라고 한다)
		
		/* 배열 할당 */
		arr = new int[4];
				// new : Heap 메모리 영역에 객체/배열을 생성하는 연산자
					// -> 생성 완료 후 생성된 객체/배열의 시작 주소를 반환
				// int[4] : int형 변수 4개 묶인 배열 할당
					// -> Heap 메모리 영역은 빈칸으로 존재할 수 없다
					// -> JVM이 자료형별 기본값(0)으로 초기화한다
				// arr = new int[4];
					// -> Heap 메모리 영역에 생성된 int 4칸짜리 배열의
					// 시작 주소를 arr 참조형 변수에 대입
		
		/* 배열 요소 접근 */
		// 1) JVM이 기본값으로 초기화했는지 확인
		System.out.println("arr[0] : " + arr[0]);
		System.out.println("arr[1] : " + arr[1]);
		System.out.println("arr[2] : " + arr[2]);
		System.out.println("arr[3] : " + arr[3]);
		
		/************************************************************/
		
		/* 배열 모든 요소에 값 대입 */
		// 1) 각각 접근
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		arr[3] = 40;
		
		System.out.println("--------------------");
		System.out.println("arr[0] : " + arr[0]);
		System.out.println("arr[1] : " + arr[1]);
		System.out.println("arr[2] : " + arr[2]);
		System.out.println("arr[3] : " + arr[3]);
		
		// 2) for문 이용
		for(int i=0; i<arr.length; i++) {
			arr[i] = (i+1) * 100;
		}
		System.out.println("--------------------");
		System.out.println("arr[0] : " + arr[0]);
		System.out.println("arr[1] : " + arr[1]);
		System.out.println("arr[2] : " + arr[2]);
		System.out.println("arr[3] : " + arr[3]);
		System.out.println("--------------------");
	}
	
	
	
	/**
	 * 배열 선언과 동시에 할당 + 초기화
	 */
	public void method2() {
		int[] arr = {10, 20, 30};								// Java에서는 {}를 사용한다
		
		// 향상된 for문
		for(int num : arr) {
			System.out.println(num);
		}
		System.out.println("--------------------");
	}
	
	
	
	/**
	 * 오늘의 점심 메뉴 뽑기
	 */
	public void method3() {
		String[] menus = {"순대국", "닭갈비", "마라탕", "햄버거", "짜장면",
											"짬뽕", "포케", "샐러드"};
		
		// 0~ 배열 길이 -1 사이의 난수 발생
		int randomNumber = (int)(Math.random() * menus.length);
		
		System.out.println("오늘의 점심 메뉴는!! : " + menus[randomNumber]);
		System.out.println("--------------------");
	}
	
	
	
	/**
	 * Java 배열 사용 시 주의할 점
	 */
	public void method4() {
		Scanner sc = new Scanner(System.in);
		System.out.println("[입력받은 정수를 각 배열 요소에 저장,출력]");
		
		long[] arr = new long[3];
		
		for(int i=0; i<arr.length; i++) {
			System.out.printf("arr[%d] 값 입력 : ", i);
			arr[i] = sc.nextLong();
		}
		for(long num : arr) {
			System.out.println(num);
		}
		
		/* 배열 길이 이상의 index에 접근하는 경우 */
			// arr이 참조하는 배열에 존재하는 index : 0, 1, 2
			// -> 존재하지 않는 3번 index에 값 대입할 경우
		// System.out.print("arr[3]에 대입할 값 : ");
		// long input = sc.nextLong();
		// arr[3] = input;
		
		// System.out.println("확인 : " + arr[3]);
			// (오류) ArrayIndexOutOfBoundsException (배열 인덱스 범위 초과 예외)
			// Java 배열은 존재하지 않는 인덱스에 접근 불가
			// 처음 배열이 할당될 때의 크기로 고정된다
		System.out.println("--------------------");
	}
	
	
	
	/**
	 * 인원 수를 입력받아 그 크기를 가지는 정수 배열을 선언,할당하고
	 * 각 배열 요소에 점수를 입력받아 저장
	 * 입력이 완료되면 합계,평균,최대값,최소값 출력하기
	 */
	public void method5() {
		Scanner sc = new Scanner(System.in);
		System.out.print("입력받을 인원 수 : ");
		int size = sc.nextInt();
		
		// 입력받은 정수만큼의 길이를 가지는 배열 선언, 할당
		int[] scoreArr = new int[size];
		
		int sum = 0;
		
		// 반복하면서 입력받기
		for(int i=0; i<scoreArr.length; i++) {
			System.out.printf("%d번째 index 점수 입력 : ", i);
			scoreArr[i] = sc.nextInt();
			
			// 합계 누적
			sum += scoreArr[i];
		}
		System.out.println("합계 : " + sum);
		System.out.println("평균 : " + (double)(sum / size));
		
		/* 최고,최저점이 기록된 인덱스 찾기 */
		int maxIndex = 0;
		int minIndex = 0;												// 첫번째 인덱스가 일단 최고/최저라고 기록
		
		for(int i=1; i<scoreArr.length; i++) {	// 0번은 비교할 필요가 없으니 1번부터 시작
			// 최대값 찾기
			if(scoreArr[i] > scoreArr[maxIndex]) {
				maxIndex = i;												// 현재 인덱스 i를 maxIndex에 대입
			}
			
			// 최소값 찾기
			if(scoreArr[i] < scoreArr[minIndex]) {
				minIndex = i;												// 현재 인덱스 i를 minIndex에 대입
			}
		}
		System.out.println("최대값 : " + scoreArr[maxIndex]);
		System.out.println("최소값 : " + scoreArr[minIndex]);
		System.out.println("--------------------");
	}
}
