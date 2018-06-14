package org.gntp;

import java.io.*;
import java.util.*;
import java.sql.*;
import java.sql.Date;
import javax.naming.*;
import org.gntp.Member2;
import org.gntp.db.DBConnection;


public class LoadData {

	/*	int [] errorCode = {0,0,0,0,0,0};
	String [] errorMessage= {
			"File Not Found Error!",
			"IO Error",
			"JDBC Error",
			"SQL Error",
			"JNDI Error",
			"DATA insert Error"
	};

	 */

	private String filename;

	public void readFile(String filename) {

		String line;

		File inFile = new File(filename);

		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(inFile));
			//*line =br.readLine();

			while ((line = br.readLine()) != null) {
				processToken(line);
			}
		} catch (FileNotFoundException e) {
			//errorCode[0]=1;
			e.printStackTrace();
		} catch (IOException e) {
			//errorCode[1]=1;
			e.printStackTrace();
		}finally {
			if(br != null) {
				try {
					br.close(); 
				} catch (IOException e) {}
			}
		}
	}

	
	public void processToken(String str) {

		/*StringTokenizer st = new StringTokenizer(str, ",");  // ","로 구분    

      while (st.hasMoreTokens()) {
         System.out.println(st.nextToken());
      }
      addMember();
		 */


		Member2 member = new Member2();

		StringTokenizer st = new StringTokenizer(str, ",");

		member.setId(st.nextToken());
		member.setPw(st.nextToken());

		addMember(member);

		/*String id = st.nextToken();
      String pw = st.nextToken();
      String name = st.nextToken();

      addMember(id, pw, name);*/
	}

	
	
	
	public void addMember(Member2 member) {
		Connection         con   = null;
		PreparedStatement  pstmt = null;

		boolean result = false; 


		try {         
			con = DBConnection.getConnection();
			String sql = "INSERT INTO member (id, pw) VALUES (?,?)";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());

			int count = pstmt.executeUpdate();

			if(count>0) {
				//errorCode[5]=0;
				result = true;
				System.out.println("입력성공");
			} else {
				//errorCode[5]=1;
				result = false;
			}

		} catch(ClassNotFoundException e) { 
			//errorCode[2]=1;
			System.out.println("driver error");   
		} catch (SQLException e) { 
			//errorCode[3]=1;
			System.out.println("sql error"); 
		} catch (NamingException e) {
			//errorCode[4]=1;
			System.out.println("jndi error");
		} finally {
			try {
				if(pstmt != null)
					pstmt.close();
				if(con != null)
					con.close();
			} catch(Exception e) {}   
		}
		return;
	}
}