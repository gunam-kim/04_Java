package run;

import view.StudentView;

/* Run
 * : Java 프로그램 실행용 클래스
*/

/* 생성자
 * : 객체가 생성될 때 수행할 명령어를 작성한 특수한 메서드
 * : 객체 생성 시 1회만 수행
 * : 모든 클래스에는 생성자가 최소 1개 이상 존재
 * (단, 하나도 작성되지 않으면 컴파일러가 기본 생성자 추가)
*/

public class StudentRun {
	public static void main(String[] args) {
		
		// 객체를 1회용으로 사용하는 방법
		new StudentView().mainMenu();
		// 새로운 StudentView 객체가 생성되자마자 mainMenu() 메서드를 호출
		// mainMenu()가 종료되면 new StudentView() 로 만들어진 객체가 사라짐
		// (참조하는 변수가 없어서 GC가 없애버림)
	}
}
