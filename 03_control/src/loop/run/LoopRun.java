package loop.run;

import loop.service.LoopService1;
import loop.service.LoopService2;

public class LoopRun {
	public static void main(String[] args) {
		// LoopService1 객체 생성
		// LoopService1 service1 = new LoopService1();
		
		// 메뉴 제공 메서드 호출
		// service1.displayMenu();
		
		// LoopService1 객체 생성
		LoopService2 service2 = new LoopService2();
			
		// 메뉴 제공 메서드 호출
		service2.displayMenu();
	}
}
