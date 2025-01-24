package staticmember;

public class StaticMemberRun {
	
	public static void main(String[] args) {
		System.out.println("Korean.nationalCode : " + Korean.nationalCode);
		/* 
		 * 아래 있는 코드가 수행되기 전
		 * 이미 static이 붙은 멤버가 static 영역에
		 * 클래스명.필드명 / 클래스명.메서드명() 형태로 할당되어 있음
		*/
		// Korean 객체 생성
		Korean k1 = new Korean("윤석열", "601218-1122334");
		Korean k2 = new Korean("김건희", "601218-2244668");
		
		System.out.println(k1.toString());
		System.out.println(k2.toString());
		
		System.out.println("========================================================");
		
		// 만약 이미 생성된 모든 Korean 객체의 nationalCode를
		// 수정해야 되는 경우
			// k1.setNationalCode(1);
			// k2.setNationalCode(1);
			// 생성된 모든 Korean 객체에 하나하나 접근해서 값 수정해야한다
			// => static을 이용해 문제 해결!
		
		// static 변수 값을 변경
			// 모든 Korean 객체의 nationalCode가 일괄 변경
		Korean.nationalCode = 100;
		
		System.out.println(k1.toString());
		System.out.println(k2.toString());
		
		System.out.println("========================================================");
		
		System.out.println("[초기화 블럭 확인]");
		
		Korean k3 = new Korean();
		Korean k4 = new Korean();
		System.out.println(k3.toString());
		System.out.println(k4.toString());
	}
}
