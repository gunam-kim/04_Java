package section04.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class CharService {
	/* [문자 기반 Stream]
		: 2byte 문자(char) 단위로 입/출력하는 Stream
		: 문자만 작성된 파일(txt, bin 등), 채팅, JSON, 웹 요청/응답
		문자 기반 Stream 최상위 인터페이스 : Reader(입력), Writer(출력)
	*/
	
	/** 문자 기반 Stream을 이용한 파일 출력 */
	public void fileOutput1() {
		FileWriter fw = null;
		
		try {
			String content = """
나는 내가 빛나는 별인 줄 알았어요
한 번도 의심한 적 없었죠
몰랐어요 난 내가 벌레라는 것을
그래도 괜찮아 난 눈부시니까
하늘에서 떨어진 별인 줄 알았어요
소원을 들어주는 작은 별
몰랐어요 난 내가 개똥벌레라는 것을
그래도 괜찮아 나는 빛날 테니까
나는 내가 빛나는 별인 줄 알았어요
한 번도 의심한 적 없었죠
몰랐어요 난 내가 벌레라는 것을
그래도 괜찮아 난 눈부시니까
한참 동안 찾았던 내 손톱
하늘로 올라가 초승달 돼 버렸지
주워 담을 수도 없게 너무 멀리 갔죠
누가 저기 걸어놨어 누가 저기 걸어놨어
우주에서 무주로 날아온
밤하늘의 별들이 반딧불이 돼 버렸지
내가 널 만난 것처럼 마치 약속한 것처럼
나는 다시 태어났지 나는 다시 태어났지
나는 내가 빛나는 별인 줄 알았어요
한 번도 의심한 적 없었죠
몰랐어요 난 내가 벌레라는 것을
그래도 괜찮아 난 눈부시니까
하늘에서 떨어진 별인 줄 알았어요
소원을 들어주는 작은 별
몰랐어요 난 내가 개똥벌레란 것을
그래도 괜찮아 나는 빛날 테니까
""";
			
			// 폴더가 없을 경우 생성
			String path = "io_test/char";
			File folder = new File(path);
			if(!folder.exists()) folder.mkdirs();
			
			// 문자 기반 파일 출력 Stream 객체 생성
			fw = new FileWriter(folder + "/" + "반딧불.txt");
			
			// 문자 기반 Stream을 이용해 출력하기
			fw.write(content);				// String, char[] 출력을 위한 기능이 제공
			
			fw.flush();								// Stream에 남은 데이터를 밀어냄. close() 시 자동 수행됨
			
			System.out.println("!!! 출력 완료 !!!");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(fw != null) fw.close();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	
	/** 문자 기반 Stream + 보조 Stream을 이용한 파일 출력 */
	public void fileOutput2() {
		FileWriter fw = null;
		BufferedWriter bw = null;					// 버퍼를 이용한 보조 Stream
		
		try {
			String content = """
나는 내가 빛나는 별인 줄 알았어요
한 번도 의심한 적 없었죠
몰랐어요 난 내가 벌레라는 것을
그래도 괜찮아 난 눈부시니까
하늘에서 떨어진 별인 줄 알았어요
소원을 들어주는 작은 별
몰랐어요 난 내가 개똥벌레라는 것을
그래도 괜찮아 나는 빛날 테니까
나는 내가 빛나는 별인 줄 알았어요
한 번도 의심한 적 없었죠
몰랐어요 난 내가 벌레라는 것을
그래도 괜찮아 난 눈부시니까
한참 동안 찾았던 내 손톱
하늘로 올라가 초승달 돼 버렸지
주워 담을 수도 없게 너무 멀리 갔죠
누가 저기 걸어놨어 누가 저기 걸어놨어
우주에서 무주로 날아온
밤하늘의 별들이 반딧불이 돼 버렸지
내가 널 만난 것처럼 마치 약속한 것처럼
나는 다시 태어났지 나는 다시 태어났지
나는 내가 빛나는 별인 줄 알았어요
한 번도 의심한 적 없었죠
몰랐어요 난 내가 벌레라는 것을
그래도 괜찮아 난 눈부시니까
하늘에서 떨어진 별인 줄 알았어요
소원을 들어주는 작은 별
몰랐어요 난 내가 개똥벌레란 것을
그래도 괜찮아 나는 빛날 테니까
""";
			
			// 폴더가 없을 경우 생성
			String path = "io_test/char";
			File folder = new File(path);
			if(!folder.exists()) folder.mkdirs();
			
			// 문자 기반 파일 출력 Stream 객체 생성
			fw = new FileWriter(folder + "/" + "반딧불_buffer.txt");
			
			// 보조 Stream 객체 생성
			bw = new BufferedWriter(fw);
			
			// 문자 기반 Stream을 이용해 출력하기
			bw.write(content);
			
			bw.flush();
			
			System.out.println("!!! 출력 완료 !!!");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(bw != null) bw.close();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	/** 문자 기반 입력 Stream + 보조 Stream 이용해 파일 읽어오기 */
	public void fileInput() {
		/* [try - with - resource]
			: Java 7 버전에서 추가된 기능
			: finally에서 작성하던 close 처리 구문을 자동으로 수행하도록 만드는 구문
		*/
		String path = "io_test/char/반딧불.txt";
		try(BufferedReader br = new BufferedReader(new FileReader(path))) {
			// 보조 Stream을 이용해서 파일 내용 읽어오기
			StringBuilder sb = new StringBuilder();					// 읽어온 내용 누적
			String temp = null;															// 임시 변수
			while(true) {																		// 무한 반복
				temp = br.readLine();													// 한 줄씩 읽어오기
				if(temp == null) break;												// 읽어온 내용이 없으면 반복 종료
				sb.append(temp);															// 읽어온 내용 누적 (엔터 미포함)
				sb.append("\n");															// 엔터 추가
			}
			System.out.println("!!! 읽어오기 성공 !!!");
			System.out.println("-----------------------------------------------------------");
			System.out.println(sb.toString());
		}
		catch(Exception e) {
			e.printStackTrace();
		} // finally에서 close하던 구문 생략 가능
	}
	
	
	// 키보드 입력 -> 바이트(2진수) 코드 입력 -> 문자 변화
	// Scanner가 편리하지만 느림
	/** Scanner 대신 Stream을 이용한 문자열 입력 받기 */
	public void keyboardInput() {
		// System.in : 기본 장치(키보드)와 연결된 InputStream 반환
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			// InputStreamReader : 바이트 Stream -> 문자 Stream 변환
			System.out.print("문자열 입력 1 : ");
			String input1 = br.readLine();												// 입력된 한 줄 읽어오기
			System.out.print("문자열 입력 2 : ");
			String input2 = br.readLine();												// 입력된 한 줄 읽어오기
			
			System.out.println("input1 : " + input1);
			System.out.println("input2 : " + input2);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}