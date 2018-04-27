package com;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListEx {
	public static void main(String[] args) {
		ArrayList<String> a = new ArrayList<String>();
		
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < 4; i++) {
			System.out.println("이름을 입력하세요");
			String s = sc.nextLine();
			a.add(s);
			
		}
		
		for (int i = 0; i < a.size(); i++) {
			System.out.println(a.get(i));
			
		}
	}
}
