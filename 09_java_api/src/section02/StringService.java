package section02;

// import java.lang.*;						컴파일러가 자동 추가

public class StringService {
	/* String
			java.lang 패키지에서 제공
			문자열을 저장하고 관련된 기능을 제공하는 클래스
	*/
	
	/* String의 불변성 (immutable)
			String은 문자열을 저장하는 필드가 final로 선언되어 있다
			(한번만 값 대입 가능)
			저장된 문자열 수정이 불가하기 때문에 수정을 원할 경우
			새로운 String 객체를 생성해서 참조한다
				ex)
				String s1 = "hello";								참조 주소 : 0x100
				s1 += "world";											참조 주소 : 0x300
	*/
	
	/**
	 * String 불변성 확인
	 */
	public void test1() {
		/* int System.identityHashCode(Object obj)
				객체를 구분하는 해시코드 반환
				(주소를 이용해서 만들었기 때문에 모든 객체가 다른 값을 지닌다)
		*/
		String s1 = "hello";
		System.out.println("s1 : " + s1);
		System.out.println(System.identityHashCode(s1));
		System.out.println("---------------------------------------------");
		
		s1 += "world";
		System.out.println("s1 : " + s1);
		System.out.println(System.identityHashCode(s1));
		System.out.println("---------------------------------------------");
	}
	
	/* String 객체 생성 방법
			1) String 리터럴("")을 이용하여 생성
				: Heap 메모리 영역에 존재하는 String Constant Pool에 String 객체 생성
				ex) String s1 = "hello";
			2) new 연산자를 이용하여 생성
				: Heap 메모리 영역에 독립된 String 객체 생성
				ex) String s2 = new String("hello");
	*/
	
	/* String Constant Pool
			: String 리터럴("")을 이용해 생성된 String 객체가 저장되는 Heap 내부 영역
			: String 리터럴을 이용해서 '동일한 값'의 String 객체를 생성하는 경우
				새로운 객체가 생성되지 않고 기존에 같은 값을 지닌 객체의 주소가 반환된다
				(메모리 효율을 높여줌)
			ex)
				String s1 = "hello";					참조 주소 : 0x100
				String s2 = "hello";					참조 주소 : 0x100
	*/
	public void test2() {
		// String 리터럴을 이용해 객체 생성
		String s1 = "hello";
		System.out.println("s1 : " + System.identityHashCode(s1));	// 468121027
		
		// 같은 값을 지닌 String 객체를 리터럴을 이용해 생성
		String s2 = "hello";
		System.out.println("s2 : " + System.identityHashCode(s2));	// 468121027
		
		// 같은 값을 지니지만 new 연산자로 String 객체를 생성
		String s3 = new String("hello");
		System.out.println("s3 : " + System.identityHashCode(s3));	// 471910020
			// Heap 영역에 별도로 생성되어 주소가 다르다
		
		System.out.println("---------------------------------------------");
		
		System.out.println("[참조 주소 비교]s1 == s2 : " + (s1 == s2));		// true
		System.out.println("[참조 주소 비교]s1 == s3 : " + (s1 == s3));		// false
		System.out.println("[필드 값 비교]s1.equals(s2) : " + s1.equals(s2));			// true
		System.out.println("[필드 값 비교]s1.equals(s3) : " + s1.equals(s3));			// true
		
		System.out.println("---------------------------------------------");
	}
	
	/* StringBuilder / StringBuffer
			: String의 불변성 문제를 해결한 클래스
			: 가변성 (mutable)
			: 기본 16글자를 저장할 수 있는 크기로 생성
			: 저장되는 문자열의 길이에 따라서 자동으로 크기가 증가/감소함
			: 문자열의 추가/수정/삭제가 발생해도 별도의 String 객체 생성이 없어서
				메모리 효율이 좋다
				
			StringBuilder
				: Thread Safe 미지원 (비동기, 빠름)
			StringBuffer
				: Thread Safe 지원 (동기, 느림)
	*/
	public void test3() {
		// StringBuilder 객체 생성
		StringBuilder sb = new StringBuilder();
		System.out.println("sb 크기 : " + sb.capacity());
		System.out.println("sb 주소 : " + System.identityHashCode(sb));
		
		/* append(String s) : 제일 뒤에 문자열 s 추가 */
		sb.append("abcde");
		sb.append("fghij");
		sb.append("klmno");
		sb.append("/");
		System.out.println("---------------------------------------------");
		
		/* toString() : StringBuilder 객체에 저장된 값을 String 형태로 반환 */
		System.out.println("sb.toString() : " + sb.toString());
		System.out.println("sb 크기 : " + sb.capacity());
		System.out.println("sb 주소 : " + System.identityHashCode(sb));
			// 주소가 변하지 않음 (가변성 확인)
		System.out.println("---------------------------------------------");
		
		/* insert(int offset, String s) : offset 위치에 s 삽입 */
		sb.insert(0, "가나다라");
		System.out.println("sb.toString() : " + sb.toString());
		System.out.println("sb 크기 : " + sb.capacity());
		System.out.println("sb 주소 : " + System.identityHashCode(sb));
			// 크기 증가, 주소는 변하지 않음
		System.out.println("---------------------------------------------");
		
		/* delete(int start, int end) : start 이상 ~ end 미만 사이 삭제 */
		sb.delete(4, 9);
		System.out.println("sb.toString() : " + sb.toString());
		System.out.println("sb 크기 : " + sb.capacity());
		System.out.println("sb 주소 : " + System.identityHashCode(sb));
			// 한번 증가한 크기는 줄어들지 않는다
		System.out.println("---------------------------------------------");
		
		/* trimToSize() : 버퍼 크기를 문자열 길이에 맞춤 */
		sb.trimToSize();
		System.out.println("sb.toString() : " + sb.toString());
		System.out.println("sb 크기 : " + sb.capacity());
		System.out.println("sb 주소 : " + System.identityHashCode(sb));
	}
}
