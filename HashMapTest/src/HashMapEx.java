import java.util.HashMap;
import java.util.Scanner;

public class HashMapEx {
	public static void main(String[] args) {
		HashMap<String, String> dic = new HashMap<String, String>();
		
		dic.put("baby", "�ư�");
		dic.put("love", "���");
		dic.put("apple", "���");
		
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.println("ã����� �ܾ��?");
			String str = sc.nextLine();
			if (str.equals("exit")) {
				System.out.println("�����մϴ�");
				break;
			
			}
			String kor = dic.get(str);
			if (kor==null) {
				System.out.println(str+"�� ���� �ܾ��Դϴ�");
				
			}else {
				System.out.println(kor);
			}
			
		}

	}
}
