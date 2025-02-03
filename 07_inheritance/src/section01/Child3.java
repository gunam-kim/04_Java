package section01;

public class Child3 extends Parent {
	private double bitCoin;
	
	public Child3() {
		System.out.println("*** Child3 객체 생성됨 ***");
		setFirstName("가람");
		firstName = "가람가람";
		setAddress("충북 청주시");
		setMoney(9000);
		bitCoin = 0.1;
	}

	public double getBitCoin() {
		return bitCoin;
	}

	public void setBitCoin(double bitCoin) {
		this.bitCoin = bitCoin;
	}
	
	
}
