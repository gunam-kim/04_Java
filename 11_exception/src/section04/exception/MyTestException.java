package section04.exception;

/* 사용자 정의 예외를 만드는 방법
	: Exception 관련 클래스를 상속받기
	
	[사용자 정의 Checked/Unchecked Exception 만들기]
	Checked)
		: CheckedException 클래스 상속받기
	Unchecked)
		: UncheckedException 클래스 상속받기
		: RuntimeException 또는 자식 클래스들
*/
public class MyTestException extends RuntimeException{				// UncheckedException
}
