import java.util.HashMap;
import java.util.Scanner;

public class HashMapEx {
	public static void main(String[] args) {
		HashMap<String, String> dic = new HashMap<String, String>();
		
		dic.put("baby", "아가");
		dic.put("love", "사랑");
		dic.put("apple", "사과");
		
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.println("찾고싶은 단어는?");
			String str = sc.nextLine();
			if (str.equals("exit")) {
				System.out.println("종료합니당");
				break;
			
			}
			String kor = dic.get(str);
			if (kor==null) {
				System.out.println(str+"은 없는 단어입니다");
				
			}else {
				System.out.println(kor);
			}
			
		}

	}
}
