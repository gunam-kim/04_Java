package service;

import java.util.Random;
import dto.StudentDTO;

/* Service
 * : 프로그램의 실질적인 기능을 제공하는 클래스
*/

public class StudentService {
	
	// StudentDTO 객체 배열 선언
	private StudentDTO[] students = new StudentDTO[5];
		// new StudentDTO[5] : StudentDTO 참조형 변수 5칸짜리 배열 생성
		// 인덱스 : 0~4
		// 각 인덱스 요소의 초기값 : null (참조 객체 없음)
	
	/* 기본 생성자 */
	public StudentService() {
		System.out.println("[초기 학생 정보가 추가됨]\n");
		students[0] = new StudentDTO("20250001", "짱구", '남');
		students[1] = new StudentDTO("20250002", "유리", '여');
		students[2] = new StudentDTO("20250003", "훈이", '남');
		
		// Java 제공 난수 발생 객체
		Random random = new Random();
		
		for(StudentDTO std : students) {
			if(std == null) {
				continue;
			}
			std.setHtml( random.nextInt(101) );
				// random.nextInt(101) : 0 이상 101 미만의 정수형 난수 생성
			std.setCss( random.nextInt(101) );
			std.setJs( random.nextInt(101) );
			std.setJava( random.nextInt(101) );
		}
	}
	
	/**
	 * students 객체 배열을 반환하는 메서드
	 * (students에 저장된 주소가 복사되서 반환됨 == 얕은 복사)
	 * @return students
	 */
	public StudentDTO[] getStudents() {
		return students;
	}
	
	/**
	 * <pre>
	 * students 객체 배열 요소 중 비어있는(null) 인덱스를 찾아
	 * 전달받은 StudentDTO 객체를 추가 후 true 반환
	 * 단, 비어있는 인덱스가 없으면 false 반환
	 * </pre>
	 * @param student : 추가하려는 학생 객체 참조 주소
	 * @return 추가 성공 : true / 추가 실패 : false
	 */
	public boolean addStudent(StudentDTO student) {
		// students 객체 배열에서 null인 인덱스 찾기
		for(int i=0; i<students.length; i++) {
			if(students[i] == null) {
				// i번째 인덱스 요소가 참조하는게 없을 경우
				
				// 전달받은 StudentDTO 객체 추가 후 true 반환
				students[i] = student;
				return true;
			}
		}
		// students에 null이 존재하지 않을 경우 (꽉 참)
		return false;
	}
	
	/**
	 * index번째 학생 반환 service 메서드
	 * @param index
	 * @return index번째 학생 객체 참조 주소 || null
	 */
	public StudentDTO selectIndex(int index) {
		// index가 배열 인덱스 범위를 벗어난 경우
		if(index < 0 || index >= students.length) {
			return null;
		}
		return students[index];
	}
	
	
	/**
	 * targetName과 이름이 일치하는 학생 객체 반환 service 메서드
	 * @param targetName
	 * @return 이름이 일치하는 학생 객체 주소 || null
	 */
	public StudentDTO selectName(String targetName) {
		for(StudentDTO std : students) {
			// students 순차 접근 중 null을 만났을 때
			// == 학생이 없을 경우 -> 뒤에도 학생이 없다
			if(std == null) {
				return null;
			}
			// 학생이 있을 경우 -> 이름 비교
			if(std.getName().equals(targetName)) {
				// std.getName()과 targetName에 저장된 값이 같을 경우
				// -> 참조형은 주소를 저장하고 있다
				// 생성된 객체는 기본적으로 서로 다른 곳에 생성된다
				// -> 저장된 이름과 입력된 이름이 같아도 false가 발생할 수 있다
				/*
				 * boolean A.equals(B)
				 * : A가 참조하는 객체의 필드와 B가 참조하는 객체의 필드가 같은지 비교하여
				 *	 같으면 true, 다르면 false 반환 
				 *	 (객체가 가지고 있는 실제 값을 비교)
				*/
				return std;
			}
		}
		// if문이 하나도 실행되지 않은 경우
		return null;
	}
	
	
	/**
	 * 전달받은 index가 students 범위 내 index가 맞는지
	 * 맞다면 index번째에 참조하는 학생이 있는지 확인하는 메서드
	 * @param index
	 * @return 1:범위 초과 / 2:null / 3:참조하는 학생 있음
	 */
	public int checkIndex(int index) {
		if(index < 0 || index >= students.length) {				// 범위 초과
			return 1;
		}
		if(students[index] == null) {											// null
			return 2;
		}
		return 3;																					// 참조하는 학생 있음
	}
	
	
	/**
	 * index번째 학생의 점수 수정 service 메서드
	 * @param index
	 * @param html
	 * @param css
	 * @param js
	 * @param java
	 */
	public void updateScore(int index, int html, int css, int js, int java) {
		students[index].setHtml(html);
		students[index].setCss(css);
		students[index].setJs(js);
		students[index].setJava(java);
		return;
		
		// 원래 반환형 void 메서드도 return; 작성이 필수!
		// 작성이 안되면 컴파일러가 추가함
	}
	
	public String selectMaxMin() {
		double max = 0;
		String maxName = "";
		double min = 100;
		String minName = "";
		for(StudentDTO std : students) {
			if(std == null) {
				continue;
			}
			double avg = (std.getHtml() + std.getCss() + std.getJs() + std.getJava())/4.0;
			if(max < avg) {
				max = avg;
				maxName = std.getName();
			}
			if(min > avg) {
				min = avg;
				minName = std.getName();
			}
		}
		return String.format("최고점 : %s(%.1f)\n최저점 : %s(%.1f)", maxName, max, minName, min);
	}
	
	
	/**
	 * index번째 학생 삭제 후 요소 한칸씩 당기기
	 * @param index : 삭제할 index 번호
	 * @return 삭제된 학생 이름
	 */
	public String deleteStudent(int index) {
		// 삭제될 학생의 이름 (삭제 전 이름만 백업)
		String studentName = students[index].getName();
		
		// 1) students 배열에서 입력받은 index번째 요소를 null로 바꿈
		students[index] = null;
		
		// 2) 삭제된 index 뒤에 요소를 하나씩 당겨오기
		for(int i = index; i < students.length -1; i++) {
			students[i] = students[i+1];
		}
		
		// 마지막 index에 null 대입 (제일 끝을 비워둠)
		students[students.length - 1] = null;
		
		return studentName;
	}
}
