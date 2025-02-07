package list.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import generics.Child;
import generics.Parent;

/* Collection Framework
		: Java에서 제공하는 자료구조 모음
		: java.util 패키지에 존재
		
		특징)
		(1) 크기 제한 X
		(2) 추가/수정/삭제/정렬 등의 기능 제공
		(3) 객체만 저장 가능
			- 기본 자료형은 Wrapper Class를 이용해서 저장
			- 기본적으로 타입 제한은 없지만 개발의 편의성을 위해 한가지 타입으로 제한 (Generics 이용)
*/

public class ListService {
	/* List
		: 데이터를 순차적으로 나열한 자료구조 (배열과 비슷하다)
	
		특징)
		- 각 데이터를 index를 이용해 구분한다 (순서가 있다)
		- index로 데이터가 구분되기 때문에 중복 값 저장이 가능하다
	*/
	
	public void test1() {
		/* 
			List는 인터페이스라 직접 객체 생성이 불가하다
			상속받아 구현한 자식 클래스를 이용한다
		*/
		
		// 제네릭을 이용한 타입 제한 X
		ArrayList list = new ArrayList();
		
		// boolean add(E e) : 리스트 객체에 요소 E 추가 후 true 반환
		list.add(new Object());
		list.add("hello world");
		list.add(12345);
		
		// E get(int index) : 리스트에서 index번째 요소 E 반환
		list.get(0);																						// Object 타입 반환
		Object obj = list.get(1);
		if(obj instanceof String) {															// 타입 검증
			System.out.println( ((String)obj).length() );					// 다운 캐스팅
		}
		System.out.println("-----------------------------------------------");
		
		/* 불편하게 타입 검증, 다운 캐스팅을 하는 이유
			여러 타입을 저장할 수 있다는 컬렉션의 특징이 오히려 독이 됨
			(제네릭스를 이용해 타입을 제한)
			(한 타입만 있을테니까 검증,다운캐스팅 X)
		*/
	}
		
	// 제네릭스를 적용하여 타입 제한
	public void test2() {
		ArrayList<String> menuList = new ArrayList<String>();
		
		// add() 확인
		menuList.add("김치찌개");
		menuList.add("족발");
		menuList.add("보쌈");
		menuList.add("치킨");
		menuList.add("피자");
		menuList.add("떡볶이");
		menuList.add("마라탕");
		
		for(int i = 0; i < menuList.size(); i++) {
			String menu = menuList.get(i);						// i번째 index값 얻어오기
			// 타입 검증 X, 다운 캐스팅 X
			System.out.println(menu);
		}
		System.out.println("-----------------------------------------------");
		
		for(String menu : menuList) {
			System.out.println(menu);
		}
		System.out.println("-----------------------------------------------");
		
		// void add(int index, E e) : index번째에 e 추가 (중간 삽입)
		menuList.add(1, "갈비탕");
		
		// String toString() : 리스트에 저장된 값을 하나의 문자열로 반환
		System.out.println(menuList.toString());
		System.out.println("-----------------------------------------------");
		
		// E set(int index, E e) : index번째 요소에 전달받은 e를 세팅
		// 결과로 이전에 존재하던 요소(E)를 반환
		String before = menuList.set(2, "불족발");
		System.out.println(before + " 이/가 수정되었습니다");
		System.out.println(menuList);
		System.out.println("-----------------------------------------------");
		
		// boolean contains(E e) : 같은 객체가 있는지 확인
		// 비교하려는 객체가 equals()를 오버라이딩 해야한다
		System.out.println("보쌈 : " + menuList.contains("보쌈"));
		System.out.println("막국수 : " + menuList.contains("막국수"));
		System.out.println("-----------------------------------------------");
		
		// int indexOf(E e) : 같은 객체가 있는 index 번호를 반환
		// 없으면 -1 반환
		System.out.println("치킨 인덱스 : " + menuList.indexOf("치킨"));
		System.out.println("햄버거 인덱스 : " + menuList.indexOf("햄버거"));
		System.out.println("-----------------------------------------------");
		
		// E remove(int index) : index번째 요소 삭제
		// 삭제된 요소 E 반환
		// 중간 요소가 삭제되면 알아서 앞으로 당겨 빈 공간을 채움
		System.out.println(menuList.remove(1) + " 제거");
		System.out.println(menuList);
		System.out.println("-----------------------------------------------");
	}
	
	/* 컬렉션 객체의 참조 변수는 부모 타입(List 인터페이스)으로 설정하면 좋은 이유
		: 프로그래밍 과정에서 미처 생각하지 못한 비효율적인 요소를 쉽게 개선하기 위해서
		
		1) ArrayList
			: 배열처럼 요소가 붙어서 존재한다
			: 중간에 추가/수정/삭제가 비효율적이다
			: 검색 속도가 빠르다
		2) LinkedList
			: 요소를 서로 참조하는 형식으로 연결되어있다
			: 중간에 추가/수정/삭제가 효율적이다
			: 검색 속도가 느리다
	*/
	public void test3() {
		List<Integer> list = new LinkedList<Integer>();
		
		Random random = new Random();
		
		// System.currentTimeMillis()
			// 1970년 1월 1일 09:00:00.000 (대한민국 기준) 기준으로
			// 현재 얼마만큼 시간이 지났는지 ms(1/1000초) 단위로 계산해서 반환
		long start = System.currentTimeMillis();
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		list.add(random.nextInt(Integer.MAX_VALUE));
		list.add(random.nextInt(Integer.MAX_VALUE));
		for(int i = 0; i < 1000000; i++) {
			list.add(1, random.nextInt(Integer.MAX_VALUE));
		}
		long end = System.currentTimeMillis();
		System.out.println("걸린 시간 : " + (end - start) + "ms");
	}
	
	public void test4() {
		// 부모 타입만 저장할 수 있는 List 생성
		List<Parent> list1 = new ArrayList<Parent>();
		list1.add(new Parent());
		
		// 자식 타입만 저장할 수 있는 List 생성
		List<Child> list2 = new ArrayList<Child>();
		list2.add(new Child(1));
		list2.add(new Child(2));
		list2.add(new Child(3));
		
		// list1, list2 하나로 합치기
		List<Parent> list3 = new ArrayList<Parent>();
		/* boolean addAll(Collection<? extends E> c)
					E : 현재 List에 재한된 타입 == Parent
					? : Parent 또는 Child
			: Collection 상속 객체(List, Set)를 현재 List의 제일 뒤에 추가
		*/
		list3.addAll(list1);				// List<Parent>
		list3.addAll(list2);				// List<Child>
		
		// List<String> temp = new ArrayList<String>();
		// list3.addAll(temp);					// String은 Parent 상속 관계가 아니라 오류
		
		for(Parent p : list3) {
			System.out.println(p);				// p.toString();
		}
	}
}
