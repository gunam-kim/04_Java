package section01;

/*
상속
: 부모의 코드(필드/메서드)를 자식이 자신의 것처럼 사용하는 기술

특징)
1. 재사용성 증가
- 한번 작성한 부모 코드를 자식들이 재사용
2. 유지 보수성 증가
- 부모 코드만 수정하면 자식은 그대로 있어도 됨
3. 공통적인 규약 정의
- 물려받은 자식들의 형태가 부모와 비슷함
- 부모 코드 수정/추가/제거 시 자식도 일괄 변경

상속 키워드 : extends (확장하다)
- 부모의 필드/메서드를 상속받은 자식의 크기가 커지기 때문에 "확장하다" 키워드 사용

주의사항)
1. 부모의 생성자는 상속 X
2. 부모의 private 필드/메서드는 상속받은 자식도 직접 접근이 불가능하다

상속 메모리 구조)
- 자식 객체 생성 시, 부모 객체가 같이 생성되어 자식 객체 내부에 배치됨
*/

/**
 * 부모 역할 클래스
 */
public class Parent {
	 private String lastName = "김";
	 
	 protected String firstName = "철수";
	 /*
			private : 현재 클래스/객체만 접근 가능
			protected : 같은 패키지 내 + 상속 관계 직접 접근 가능
	 */
	 
	 private String address = "서울시 중구 남대문로 120";
	 private int money = 10000;
	 
	 // 기본 생성자
	 public Parent() {
		 System.out.println("***** Parent 객체 생성됨 *****");
	 }

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	 
	// 부모만의 기능
	public String introduce() {
		return "저는 Parent 입니다";
	}
	
	public String toString() {
		return String.format(
				"성 : %s / 이름 : %s / 주소 : %s / 돈 : %d", lastName, firstName, address, money);
	}
}
