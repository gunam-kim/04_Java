package list.view;

import java.util.List;
import java.util.Scanner;

import list.dto.BookDTO;
import list.service.BookService;

/**
 * 도서 관리 프로그램 입/출력 담당 클래스 (UI)
 */
public class BookView {
	private Scanner sc = new Scanner(System.in);
	private BookService service = new BookService();
	
	/**
	 * 프로그램 메인 메뉴
	 */
	public void displayMenu() {
		int input = 0;												// 메뉴 번호를 저장할 변수
		
		do {
			System.out.println("\n***** 도서 관리 프로그램 *****\n");
			System.out.println("1. 전체 조회");
			System.out.println("2. index 번호로 조회");
			System.out.println("3. 책 추가하기");
			System.out.println("4. 책 가격 수정하기");
			System.out.println("5. 책 제거하기");
			
			// 추가
			System.out.println("6. 제목이 일치하는 책 조회하기");
			System.out.println("7. 제목이 일치하는 책 제거하기");
			System.out.println("8. 출판사가 일치하는 책 조회하기");
			System.out.println("9. 저자가 일치하는 책 조회하기");
			System.out.println("10. 검색어가 제목,저자에 포함된 모든 책 조회하기");
			
			System.out.println("11. bookList 제목 오름차순으로 정렬시키기");
			
			System.out.println("0. 종료");
			System.out.println();
			
			System.out.print("메뉴 번호 입력 >> ");
			input = sc.nextInt();
			sc.nextLine();											// 입력 버퍼에 남아있는 문자열 제거 (오류 방지)
			System.out.println("-------------------------------------------------------------");
			
			switch(input) {
			case 1 : selectAll(); break;
			case 2 : selectIndex(); break;
			case 3 : addBook(); break;
			case 4 : modifyBookPrice2(); break;
			case 5 : removeBook(); break;
			case 6 : selectTitle(); break;
			case 7 : removeBookTitle(); break;
			
			// 서비스 호출 시 반환된 결과가 List<BookDTO>
			case 8 : selectPublisherAll(); break;
			case 9 : selectAuthorAll(); break;
			case 10 : searchBook(); break;
			
			case 11 : bookListSorting(); break;
			
			case 0 : System.out.println("*** 프로그램이 종료되었습니다 ***");break;
			default : System.out.println("@@@ 메뉴 번호 잘못 입력하셨습니다 @@@");
			}
		} while(input != 0);
	}



	/**
	 * 1. 전체 조회
	 * - BookService의 필드 bookList를 얻어와 일반 for문을 이용해 모든 요소 정보 출력
	 * 단, bookList에 저장된 정보가 없으면 "저장된 책이 존재하지 않습니다" 출력
	 */
	private void selectAll() {
		System.out.println("\n### 전체 조회 ###\n");
		List<BookDTO> list = service.getBookList();
		
		// 전달받은 list에 데이터가 있는지 확인
		if(list.isEmpty()) {			// boolean isEmpty() : 저장된 객체가 없으면 true 반환
			System.out.println("저장된 책이 존재하지 않습니다");
			return;
		}
		
		// 모든 요소 정보 출력
		for(int i = 0; i < list.size(); i++) {
			System.out.println(i + ") " + list.get(i));
		}
	}
	
	/**
	 * 2. index 번호로 조회
	 * - 조회하려는 책의 index 번호를 입력 받아 책 정보 출력
	 * - BookService로부터 index번째 BookDTO 반환 받기
	 * 단, index 번호가 bookList의 범위를 초과하면 "해당 인덱스에 책이 존재하지 않습니다" 출력
	 */
	private void selectIndex() {
		System.out.println("\n### index 번호로 조회 ###\n");
		System.out.print("조회할 책의 index 번호 : ");
		int index = sc.nextInt();
		
		BookDTO book = service.selectIndex(index);
		
		if(book == null) {
			System.out.println("해당 인덱스에 책이 존재하지 않습니다");
			return;
		}
		
		System.out.println("제목 : " + book.getTitle());
		System.out.println("저자 : " + book.getAuthor());
		System.out.println("가격 : " + book.getPrice());
		System.out.println("출판사 : " + book.getPublisher());
	}
	
	/**
	 * 3. 책 추가하기
	 * - 책 정보(제목, 저자, 가격, 출판사)를 입력받아 BookService의 bookList에 마지막 요소로 추가
	 * 단, 모든 정보가 일치하는 책은 추가 X (중복 저장 X)
	 */
	private void addBook() {
		System.out.println("\n### 책 추가하기 ###\n");
		System.out.print("제목 : ");
		String title = sc.nextLine();
			// 엔터가 입력되기 전까지의 문자열 얻어오기 (띄어쓰기 가능)
		System.out.print("저자 : ");
		String author = sc.nextLine();
		System.out.print("가격 : ");
		int price = sc.nextInt();
		sc.nextLine();
			// sc.nextInt() 등을 수행 후 무조건 작성
		System.out.print("출판사 : ");
		String publisher = sc.nextLine();
		
		// 서비스 호출
		boolean result = service.addBook(new BookDTO(title, author, price, publisher));
		
		if(result) {								// 추가 성공
			System.out.println(title + " 책이 추가되었습니다");
		}else {											// 추가 실패
			System.out.println(title + " 책이 이미 존재합니다");
		}
	}
	
	/**
	 * 4. 책 가격 수정하기
	 * - 인덱스 번호를 입력받아
	 * 해당 인덱스에 책이 없다면 "해당 인덱스에 책이 존재하지 않습니다" 출력
	 * 해당 인덱스에 책이 있다면 "수정할 가격 : " 출력
	 * 														스캐너로 가격 입력받기
	 * 														입력받은 index번째 요소의 가격 수정
	 * 														"[책제목] 가격이 [이전가격]->[수정된가격]으로 수정되었습니다" 출력
	 */
	private void modifyBookPrice() {
		System.out.println("\n### 책 가격 수정하기 ###\n");
		System.out.print("인덱스 번호 입력 : ");
		int index = sc.nextInt();
		
		BookDTO book = service.selectIndex(index);
		
		if(book == null) {
			System.out.println("해당 인덱스에 책이 존재하지 않습니다");
			return;
		}
		
		System.out.print("수정할 가격 : ");
		int newPrice = sc.nextInt();
		
		int previousPrice = book.getPrice();
		book.setPrice(newPrice);
		System.out.printf("'%s'의 가격이 %d원 -> %d원 으로 수정되었습니다", book.getTitle(), previousPrice, newPrice);
	}
	
	// 객체 지향에 맞는 풀이 방법
	private void modifyBookPrice2() {
		System.out.println("\n### 책 가격 수정하기 ###\n");
		System.out.print("인덱스 번호 입력 : ");
		int index = sc.nextInt();
		
		// index 범위 초과 시
		if(service.checkIndex(index) == false) {
			System.out.println("해당 인덱스에 책이 존재하지 않습니다");
			return;
		}
		
		System.out.print("수정할 가격 : ");
		int newPrice = sc.nextInt();
		
		// 서비스 호출
		System.out.println(service.modifyBookPrice2(index, newPrice));
	}
	
	/**
	 * 5. 책 제거하기
	 * index 번호를 입력받아 책 제거
	 * 단, 해당 index에 책이 없으면 "해당 인덱스에 책이 존재하지 않습니다" 출력
	 * 있으면 "[책제목]이 제거되었습니다" 출력 
	 */
	private void removeBook() {
		System.out.println("\n### 책 제거하기 ###\n");
		System.out.print("제거할 책 인덱스 번호 : ");
		int index = sc.nextInt();
		
		// 서비스 호출
		BookDTO remove = service.removeBook(index);
		if(remove == null) {
			System.out.println("해당 인덱스에 책이 존재하지 않습니다");
		} else {
			System.out.printf("'%s' 책이 제거되었습니다\n", remove.getTitle());
		}
	}
	
	/**
	 * 6. 제목이 일치하는 책 조회하기
	 * 일치하는 책이 없다면 "검색 결과 없음" 출력
	 */
	private void selectTitle() {
		System.out.print("책 제목 조회 : ");
		String title = sc.nextLine();
		
		// 서비스 호출
		BookDTO book = service.selectTitle(title);
		if(book == null) {
			System.out.println("검색 결과 없음");
		} else {
			System.out.println("제목 : " + book.getTitle());
			System.out.println("저자 : " + book.getAuthor());
			System.out.println("가격 : " + book.getPrice());
			System.out.println("출판사 : " + book.getPublisher());
		}
	}
	
	/**
	 * 7. 제목이 일치하는 책 제거하기
	 */
	private void removeBookTitle() {
		System.out.print("제거할 책 제목 조회 : ");
		String title = sc.nextLine();
		
		boolean result = service.removeBookTitle(title);
		if(!result) {
			System.out.printf("'%s' 책이 존재하지 않습니다\n", title);
			return;
		} else {
			System.out.printf("'%s' 책이 제거되었습니다", title);			
		}
	}
	
	/**
	 * 8. 출판사가 일치하는 책 조회하기
	 */
	private void selectPublisherAll() {
		System.out.print("출판사 입력 : ");
		String publisher = sc.nextLine();
		
		List<BookDTO> searchList = service.selectPublisherAll(publisher);
		
		if(searchList.isEmpty()) {					// 조회 결과가 없을 경우
			System.out.println("검색 결과 없음");
			return;
		}
		
		for(BookDTO book : searchList) {
			System.out.println(book);
		}
	}
	
	/**
	 * 9. 저자가 일치하는 책 조회하기
	 */
	private void selectAuthorAll() {
		System.out.print("저자 입력 : ");
		String author = sc.nextLine();
		
		List<BookDTO> searchList = service.selectAuthorAll(author);
		
		if(searchList.isEmpty()) {					// 조회 결과가 없을 경우
			System.out.println("검색 결과 없음");
			return;
		}
		
		for(BookDTO book : searchList) {
			System.out.println(book);
		}
	}
	
	/**
	 * 10. 검색어가 제목,저자에 포함된 모든 책 조회하기
	 */
	private void searchBook() {
		System.out.print("검색어 입력 : ");
		String keyword = sc.nextLine();
		
		List<BookDTO> searchList = service.searchBook(keyword);
		
		if(searchList.isEmpty()) {					// 조회 결과가 없을 경우
			System.out.println("검색 결과 없음");
			return;
		}
		
		for(BookDTO book : searchList) {
			System.out.println(book);
		}
	}
	
	/**
	 * 11. bookList 제목 오름차순으로 정렬시키기
	 */
	private void bookListSorting() {
		System.out.println("\n### 제목 오름차순 정렬시키기 ###\n");
		service.bookListSorting();
		System.out.println("정렬되었습니다");
	}
}
