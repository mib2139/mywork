package org.gntp.db;

import java.util.HashMap;
import java.util.Scanner;

public class loginhash {
	public static void main(String[] args) {
		HashMap<String, String> h = new HashMap<String, String>();
		Scanner sc = new Scanner(System.in);
		
		h.put("user", "1234");
		h.put("user2", "1234");
		
		System.out.println("id:");
		String id = sc.next();
		System.out.println("pw:");
		String pw = sc.next();
		
		String db_id = id;
		String db_pw = h.get(db_id);
		
		
		if(db_pw.equals(pw)) {
			System.out.println("사용자입니다");
		}else {
			System.out.println("사용자가 아닙니다");
		}
	}

}
