package section01;

public class Child2 extends Parent {
	// Child2만의 필드
	private String car;
	
	public Child2() {
		System.out.println("*** Child2 객체 생성됨 ***");
		// 부모의 firstName 필드를 상속받았으나
		// 접근 제어자가 private이라서 직접 접근 불가능 (간접 접근 이용)
		setFirstName("바다");
		setAddress("경기도 용인시");
		setMoney(7000);
		car = "아반테";
	}

/* getter/setter 자동완성
 : alt + shift + s -> r
*/
	public String getCar() {
		return car;
	}

	public void setCar(String car) {
		this.car = car;
	}
	
}
