package list.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import list.dto.BookDTO;

/**
 * 도서 관리 프로그램 기능 제공 클래스
 */
public class BookService {
	private List<BookDTO> bookList = new ArrayList<BookDTO>();
	
	// 기본 생성자
	public BookService() {
		// 샘플 데이터 추가
		bookList.add(new BookDTO("소년이 온다", "한강", 15000, "창비"));
		bookList.add(new BookDTO("초역 부처의 말", "코이케 류노스케", 17800, "포레스트북스"));
		bookList.add(new BookDTO("채식주의자", "한강", 15000, "창비"));
		bookList.add(new BookDTO("작별하지 않는다", "한강", 16800, "문학동네"));
		bookList.add(new BookDTO("모순", "양귀자", 13000, "쓰다"));
	}

	// getter
	public List<BookDTO> getBookList() {
		return bookList;
	}
	
	/**
	 * 전달 받은 index번째 bookList 요소 반환
	 * 단, 범위 초과 시 null 반환
	 * @param index
	 * @return BookDTO 참조 주소 또는 null
	 */
	public BookDTO selectIndex(int index) {
		// 범위 초과 검사 -> 초과 시
		if(checkIndex(index) == false) return null;
		
		return bookList.get(index);
	}
	
	/**
	 * 전달받은 index가 정상 범위인지 확인
	 * @param index
	 * @return 정상 true, 아니면 false
	 */
	public boolean checkIndex(int index) {
		if(index < 0 || index >= bookList.size()) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * 전달받은 book을 bookList에 추가
	 * 단, 책 정보가 모두 일치하는 책이 있다면 추가 X
	 * @param book
	 * @return 추가 O : true, 추가 X : false
	 */
	public boolean addBook(BookDTO book) {
		// 책 정보 비교 방법 1) 필드 값 하나씩 꺼내서 비교
		// 책 정보 비교 방법 2) equals() 오버라이딩 후 이용
		
		//		for(BookDTO b : bookList) {
		//			if(b.equals(book)) return false;
		//		}
		if(bookList.contains(book)) return false;				// 위 3줄 대신 사용
			// BookDTO의 equals()를 오버라이딩 했기 때문에 List가 제공하는 contains() 사용 가능 
		
		return bookList.add(book);		// 컬렉션은 크기 제한이 없어서 무조건 추가 성공 (true 반환)
	}
	
	/**
	 * 전달받은 index번째 요소의 가격을 newPrice로 수정
	 * @param index
	 * @param newPrice
	 * @return "[책제목] 가격이 [이전가격]->[수정된가격]으로 수정되었습니다"
	 */
	public String modifyBookPrice2(int index, int newPrice) {
		 BookDTO target = bookList.get(index);
		 int oldPrice = target.getPrice();
		 target.setPrice(newPrice);
		 
		 return String.format("[%s] 가격이 %d -> %d 으로 수정되었습니다", target.getTitle(), oldPrice, newPrice);
	}
	
	/**
	 * index번째 BookDTO 제거
	 * 단, 없으면 null 반환
	 * 제거 성공하면 제거된 BookDTO 반환
	 * @param index
	 */
	public BookDTO removeBook(int index) {
		if(checkIndex(index) == false) return null;
		
		return bookList.remove(index);
		// bookList에서 index번째 요소 제거
		// == index번째 요소를 뽑아냄
	}
	
	/**
	 * 제목이 일치하는 책 반환
	 * @param title : 찾으려는 책 제목
	 */
	public BookDTO selectTitle(String title) {
		for(BookDTO book : bookList) {					// bookList에서 하나씩 꺼냄
			if(book.getTitle().equals(title)) {
				return book;
			}
		}
		return null;
	}
	
	public boolean removeBookTitle(String title) {
		for(BookDTO book : bookList) {					// bookList에서 하나씩 꺼냄
			if(book.getTitle().equals(title)) {
				bookList.remove(book);
					// bookList에 저장된 객체(BookDTO)가 equals() 오버라이딩되어 있어야 사용 가능
				return true;
			}
		}
		return false;
	}
	
	public List<BookDTO> selectPublisherAll(String publisher) {
		// 출판사명이 일치하는 책만 저장해둘 List 생성
		List<BookDTO> searchList = new ArrayList<BookDTO>();
		
		// 같은 출판사인 책 찾기
		for(BookDTO book : bookList) {
			if(book.getPublisher().equals(publisher)) {			// 출판사 일치하면
				searchList.add(book);													// searchList에 찾은 책 추가
			}
		}
		return searchList;																// List에 저장된 요소의 개수 : 0 ~ n
	}
	
	public List<BookDTO> selectAuthorAll(String author) {
		// 저자가 일치하는 책만 저장해둘 List 생성
		List<BookDTO> searchList = new ArrayList<BookDTO>();
		
		// 같은 저자인 책 찾기
		for(BookDTO book : bookList) {
			if(book.getAuthor().equals(author)) {						// 저자 일치하면
				searchList.add(book);													// searchList에 찾은 책 추가
			}
		}
		return searchList;																// List에 저장된 요소의 개수 : 0 ~ n
	}
	
	public List<BookDTO> searchBook(String keyword) {
		List<BookDTO> searchList = new ArrayList<BookDTO>();
		
		for(BookDTO book : bookList) {
			// book의 제목이 저자에 keyword가 포함된 경우
			if(book.getTitle().contains(keyword) || book.getAuthor().contains(keyword)) {
				searchList.add(book);
			}
		}
		return searchList;
	}
	
	/**
	 * 제목 오름차순 정렬
	 */
	public void bookListSorting() {
		Collections.sort(bookList);
		// 원본 리스트가 정렬된 형태로 변경됨
	}
}
