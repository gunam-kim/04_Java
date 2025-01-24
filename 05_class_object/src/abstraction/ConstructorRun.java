package abstraction;

public class ConstructorRun {
	public static void main(String[] args) {
		// Student 기본 생성자를 이용해 객체 생성
		Student std1 = new Student();
		System.out.println(std1.toString());
		
		// Student(String, String) 매개변수가 있는 생성자 이용
		Student std2 = new Student("20250004", "맹구");
		System.out.println(std2.toString());
		
		// Student 객체의 필드를 모두 초기화하는 생성자 이용
		Student std3 = new Student("20250005", "유리", 80, 90, 85, 90);
		System.out.println(std3.toString());
		Student std4 = new Student("20250006", "수지", 90, 90, 95, 90);
		System.out.println(std4.toString());
	}
}
