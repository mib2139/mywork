package com;

import java.util.Iterator;
import java.util.Vector;

public class InteratorEx {

	public static void main(String[] args) {
		Vector<Integer> v  = new Vector<Integer>();

		v.add(5);
		v.add(4);
		v.add(-1);
		v.add(2, 100);

		//Iterator 로 정수 모든 정수 출력하기
		Iterator<Integer> it = v.iterator();
		
		while (it.hasNext()) {
			int n = it.next();
			System.out.println(n);
			
			int sum = 0;
			it = v.iterator();
			while (it.hasNext()) {
				n = it.next();
				sum += n;
				
			}
			System.out.println("백터에 있는 정수의 합 : " +sum);
		}
	}
}
