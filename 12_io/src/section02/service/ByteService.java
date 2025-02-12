package section02.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/* Stream
: 데이터가 이동하는 통로 역할의 객체
: 데이터의 흐름은 기본적으로 단방향
*/

public class ByteService {
	/* Byte 기반 Stream
		: 1byte 단위로 데이터를 입/출력하는 Stream
		
		최상위 클래스 : InputStream, OutputStream
		
		입/출력 가능 데이터 : 문자열, 파일(이미지,영상,오디오 등)
			(단, 2byte 범위 문자열이 깨질 수 있고
			좁은 통로를 이용하다보니 속도가 상대적으로 느리다)
		
		[!] Stream 객체는 Java 프로그램이 종료되어도 외부 장치/파일/프로그램과의 연결이 유지되기 때문에
		자동으로 사라지지 않는다
			-> 프로그램 종료 전 Stream 객체의 메모리를 반환하는 close() 구문 필수! 
	*/
	
	/**
	 * 지정된 경로에 파일 생성 + 내용 출력 (파일 기반 Byte Stream)
	 */
	public void fileByteOutput() {
		FileOutputStream fos = null;							// 참조 객체가 없음
		try {
			// 폴더 경로, 파일명 지정
			String folderPath = "io_test/byte";			// 프로젝트폴더/io_test/byte
			String fileName = "바이트기반테스트.txt";
			
			// 폴더가 없으면 생성
			File folder = new File(folderPath);
			if(!folder.exists()) {
				folder.mkdirs();
			}
			
			// 출력할 파일과 연결된 출력용 Stream 객체를 생성
			// 이 때, 해당 파일이 없으면 자동으로 생성된다
			fos = new FileOutputStream(folderPath + "/" + fileName, true);	// true : 이어쓰기 옵션
				// io_test/byte/바이트기반테스트.txt
			
			// 만들어진 txt파일에 출력할 내용 작성
			/* StringBuilder : String의 불변성 문제를 해결하기 위한 객체 */
			StringBuilder builder = new StringBuilder();
			builder.append("Hello World!\n");
			builder.append("123456789\n");
			builder.append("!@#$%^&*()\n");
			builder.append("가나다라마바사\n");
			
			// StringBuilder에 저장된 내용을 String으로 변경
			String content = builder.toString();
			
			// 연결된 외부 txt파일로 content의 내용을 출력
			// 방법 1) 1byte씩 끊어서 출력
//			for(int i=0; i<content.length(); i++) {
//				char ch = content.charAt(i);					// i번째 문자 1개 반환 (문자에 매칭되는 번호 저장)
//				// 1byte 범위만 출력 가능
//				// (0~255 바이트 범위 사이 글자는 정상 출력)
//				// (나머지 글자는 모두 깨져서 출력)
//				fos.write(ch);												// IOException 발생 가능성 있음
//			}
//			System.out.println("!!! 출력 완료 !!!");
			
			// 방법 2) String을 Byte로 먼저 변환한 후 손실되는 데이터 없이 출력하기
			byte[] bytes = content.getBytes();				// String -> byte[] 형태로 얻어오기
			
			fos.write(bytes);													// 손실되는 데이터 없이 모든 문자열(byte) 출력
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fos != null) {											// NullPointerException 방지					
					fos.close();												// IOException 발생 가능성 있음
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * 보조 Stream 중 BufferedOutputStream을 이용해서 출력 속도 향상시키기
	 */
	public void bufferedFileByteOutput() {
		/* Buffer
			: 데이터가 모아져있는 메모리상의 임시 공간
		*/
		
		/* Stream 객체 참조 변수 선언 */
		FileOutputStream fos = null;									// 기반 Stream (단독 사용 O)
		BufferedOutputStream bos = null;							// 보조 Stream (단독 사용 X)
			// 보조 Stream은 꼭 기반 Stream에 붙여서 사용
		
		try {
			/* 기반 Stream 생성 */
			fos = new FileOutputStream("io_test/byte/버퍼_바이트.txt");
																									// 파일이 없으면 생성됨
			/* 보조 Stream 생성 */
			// 보조 Stream 생성 시 기반 Stream과 연결
			bos = new BufferedOutputStream(fos);
			
			// """ """ : 내부에 작성된 모양 그대로의 문자열 생성
			String content = """
Ooh
I
I just woke up from a dream
Where you and I had to say goodbye
And I don't know what it all means
But since I survived, I realized
Wherever you go, that's where I'll follow
Nobody's promised tomorrow
So I'ma love you every night like it's the last night
Like it's the last night
If the world was ending, I'd wanna be next to you
If the party was over and our time on Earth was through
I'd wanna hold you just for a while
And die with a smile
If the world was ending, I'd wanna be next to you
Woo-ooh
Ooh, lost
Lost in the words that we scream
I don't even wanna do this anymore
'Cause you already know what you mean to me
And our love is the only war worth fighting for
Wherever you go, that's where I'll follow
Nobody's promised tomorrow
So I'ma love you every night like it's the last night
Like it's the last night
If the world was ending, I'd wanna be next to you
If the party was over and our time on Earth was through
I'd wanna hold you just for a while
And die with a smile
If the world was ending, I'd wanna be next to you
Right next to you
Next to you
Right next to you
Oh-oh-oh
If the world was ending, I'd wanna be next to you
If the party was over and our time on Earth was through
I'd wanna hold you just for a while
And die with a smile
If the world was ending, I'd wanna be next to you
If the world was ending, I'd wanna be next to you
Ooh, ooh
I'd wanna be next to you
					""";
			
			// 보조 Stream을 이용해서 출력
			// -> 내용 출력시 Buffer를 이용해서 한번에 출력
			bos.write(content.getBytes());
			
			System.out.println("--- 출력 완료 ---");
		}catch(Exception e) {													// 다형성 이용해서 모든 예외 처리
			e.printStackTrace();
		}finally {
			// 사용 완료된 Stream 객체 메모리 반환
			try {
				if(bos != null) bos.close();
				// 보조 Stream만 close하면 연결된 기반 Stream도 같이 close된다
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * 바이트 기반 파일 입력 (파일 읽어오기) 1
	 */
	public void fileByteInput() {
		FileInputStream fis = null;
		
		try {
			// 파일 입력용 바이트 기반 Stream 생성
			fis = new FileInputStream("io_test/byte/노래가사.txt");
			
			int value = 0;						// 읽어온 1byte를 저장할 임시 변수
			
			// 읽어온 내용 누적용 객체
			StringBuilder sb = new StringBuilder();
			
			while(true) {							// 무한 반복
				// int fis.read()
					// 파일로부터 1byte 읽어서 반환
					// 호출 시마다 다음 내용을 읽어옴
					// 읽어올 내용이 없다면 -1 반환
				value = fis.read();
				
				if(value == -1) break;
				sb.append((char)value);	// 문자로 변환해서 누적
			}
			
			// 읽어온 값 출력
			System.out.println(sb.toString());
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			// 사용 완료된 Stream 객체 메모리 반환
			try {
				if(fis != null)	fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * 바이트 기반 파일 입력 (파일 읽어오기) 2 (한글 안깨지게)
	 */
	public void fileByteInput2() {
		FileInputStream fis = null;
		
		try {
			// 파일 입력용 바이트 기반 Stream 생성
			fis = new FileInputStream("io_test/byte/노래가사.txt");
			
			// byte[] fis.readAllBytes()
			// 연결된 파일의 내용을 모두 byte로 변환하여 읽어오기
			byte[] bytes = fis.readAllBytes();
			
			String content = new String(bytes);
			// byte[]를 String에 저장
			
			System.out.println(content);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			// 사용 완료된 Stream 객체 메모리 반환
			try {
				if(fis != null)	fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * 보조 Stream(BufferedInputStream)을 이용해서
	 * 효율적으로 파일 읽어오기
	 */
	public void bufferedFileByteInput() {
		FileInputStream fis = null;							// 기반 Stream
		BufferedInputStream bis = null;					// 보조 Stream
		
		try {
			// 파일 입력용 바이트 기반 Stream 생성
			fis = new FileInputStream("io_test/byte/노래가사.txt");
			
			// 보조 Stream 생성
			bis = new BufferedInputStream(fis);		// 기반 Stream 연결됨

			// 보조 Stream을 이용해서 파일 내용을 byte로 변환
			// 버퍼를 이용해 한번에 읽어옴
			// byte[]로 반환
			byte[] bytes = bis.readAllBytes();
			
			String content = new String(bytes);
			// byte[]를 String에 저장
			
			System.out.println(content);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			// 사용 완료된 Stream 객체 메모리 반환
			try {
				if(bis != null)	bis.close();
					// 보조 Stream만 close해도 연결된 기반 Stream도 close
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * 파일 복사
	 * <pre>
	 * 복사할 파일의 경로를 입력받아
	 * 같은 경로에 복사된 파일을 생성
	 * 
	 * 입력받은 경로에 파일이 존재하지 않으면
	 * -> "파일이 존재하지 않습니다" 출력
	 * 
	 * 입력받은 경로에 파일이 존재하면
	 * -> 같은 경로에 "파일명_copy.확장자" 이름으로 출력
	 * 
	 * [실행화면]
	 * 파일 경로 입력 : io_test/byte/노래가사.txt
	 * 복사 완료 : io_test/byte/노래가사_copy.txt
	 * </pre>
	 */
	public void fileCopy() {
		// 스캐너, 파일 입/출력 Stream, 보조 Stream 참조 변수 선언
		Scanner sc = null;															// 경로 입력용 스캐너
		FileInputStream fis = null;											// 입력 기반
		FileOutputStream fos = null;										// 출력 기반
		BufferedInputStream bis = null;									// 입력 보조
		BufferedOutputStream bos = null;								// 출력 보조
		
		try {
			sc = new Scanner(System.in);
			
			// 1) 파일 경로 입력받기
			System.out.print("파일 경로 입력 >> ");
			String path = sc.nextLine();
			
			// 2) 입력받은 경로의 파일과 FileInputStream 연결하기
			fis = new FileInputStream(path);
				// path에 파일이 없다면 FileNotFoundException 발생
			
			// 3) 보조 입력용 Stream 생성
			bis = new BufferedInputStream(fis);
			
			// 4) 연결된 파일을 byte[]로 읽어오기
			byte[] bytes = bis.readAllBytes();
			
			// 5) 입력받은 경로 파일명에 _copy 붙이기
			StringBuilder sb = new StringBuilder();
			sb.append(path);															// 기존 경로 추가
			
			// 뒤에서부터 검색하여 처음 찾은 "." 위치 (index) 반환
			int insertPoint = sb.lastIndexOf(".");
			
			// 찾은 "." 앞에 "_copy" 삽입
			sb.insert(insertPoint, "_copy");
			
			// 복사본의 경로
			String copyPath = sb.toString();
			
			// 6) 출력용 기반 Stream 객체 생성
			fos = new FileOutputStream(copyPath);
			
			// 7) 출력용 보조 Stream 객체 생성
			bos = new BufferedOutputStream(fos);
			
			// 8) 보조 Stream을 이용해 출력
			bos.write(bytes);															// 읽어온 파일 출력
			
			System.out.println("복사 완료 : " + copyPath);
		}catch(FileNotFoundException e) {
			System.out.println("파일이 존재하지 않습니다");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			// Stream 객체 메모리 반환
			try {
				if(sc != null) sc.close();
				if(bis != null) bis.close();
				if(bos != null) bos.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
