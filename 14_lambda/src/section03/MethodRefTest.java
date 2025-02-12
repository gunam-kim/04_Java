package section03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class MethodRefTest {
	public static void main(String[] args) {
		/* 메서드 참조
			: 이미 존재하는 메서드를 람다식으로 표현할 때 사용하는 축약된 표시
			-> 새로운 람다식을 작성하는 것이 아니라
				 이미 구현된 같은 기능의 메서드를 참조
		*/
		
		String str = "Hello World";
		
		/* 1) 람다식 작성 */
		Function<String, Integer> strLength = s -> s.length();
		System.out.printf("%s의 길이 : %d\n", str, strLength.apply(str));
		
		/* 2) 메서드 참조 */
		Function<String, Integer> strLength2 = String::length;
			// String을 매개변수로 전달하면 String.length() 메서드를 참조해서 실행 후 Integer 값을 반환
		System.out.printf("%s의 길이 : %d\n", str, strLength2.apply(str));
		
		System.out.println("-----------------------------------------------------------------------");
		
		List<String> nameList = new ArrayList<String>();
		nameList.add("짱구");
		nameList.add("유리");
		nameList.add("훈이");
		nameList.add("맹구");
		nameList.add("철수");
		nameList.forEach( name -> System.out.println(name) );
			// 모든 요소를 반복하며 출력
		
		nameList.forEach(System.out::println);		// 메서드 참조
			// nameList에서 하나씩 꺼낸 값을 System.out.println()에 전달하여 실행
			// 이미 완성되어있는 메서드 (모양을) 참조
		
		System.out.println("-----------------------------------------------------------------------");
		
		// 절대값 반환 람다식 작성
		Function<Integer, Integer> abs1
			= num -> {
				if(num < 0) return num * -1;
				return num;
			};
			
		// 절대값 반환 메서드 참조
		Function<Integer, Integer> abs2
			= Math::abs;
			// 이미 같은 메서드가 존재하면 또 작성하지 말고 참조 => 메서드 참조
		
		System.out.println(abs1.apply(-100));
		System.out.println(abs2.apply(-100));
	}
}
