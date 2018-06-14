package org.gntp;

public class ErrorCheck {
	public static void main(String[] args) {
		
		
		
		int [] errorCode = {0,1,0,0,0,0};
		String [] errorMessage= {"File Not Found Error!",
				"IO Error",
				"JDBC Error",
				"SQL Error",
				"JNDI Error",
				"DATA insert Error"
				
		};
		
		errorCode[5]=1;
		
		for (int i = 0; i < 6; i++) {
			if(errorCode[i]==1) {
			System.out.println(errorMessage[i]);}
		}
		
	/*	if (errorCode[0]==1) {
			System.out.println("File not found Error");
		}
		if (errorCode[1]==0) {
			System.out.println("IO Error");
		}
		if (errorCode[2]==1) {
			System.out.println("jdbc Error");
		}
		if (errorCode[3]==1) {
			System.out.println("sql Error");
		}
		if (errorCode[4]==1) {
			System.out.println("jndi Error");
		}
		if (errorCode[5]==1) {
			System.out.println("data insert Error");
		}*/

	}
}
