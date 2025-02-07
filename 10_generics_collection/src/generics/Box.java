package generics;

/* Generics
		: 지정된 데이터 타입 하나로 일반화
		
	[사용 이유]
	1) 타입 안정성 보장
			: 컴파일 단계에서 강력한 타입 검증
	2) 타입 체크, 형 변환 코드 생략 가능
	3) 코드 재사용성 증가

	[주요 파라미터 타입 관례]
	T : Type
	E : Element
	K : Key
	V : Value
	N : Number
 */
public class Box<T> {
	private T value;										// 객체 생성 시점에 작성된 자료형으로 지정
	public void setValue(T value) {
		this.value = value;
	}
	public T getValue() {
		return value;
	}
}
