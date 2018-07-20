package com.javalec.upload;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class UserService {


	public boolean upload(HttpServletRequest request) {
		String uploadPath = "C:/Users/user42/Documents/카카오톡 받은 파일/Team3/WebContent/images";
		int maxSize = 1024 * 1024 * 10;

		String fileName1 = ""; // 占쌩븝옙처占쏙옙占쏙옙 占싱몌옙
		String originalName1 = ""; // 占쌩븝옙 처占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙 占싱몌옙
		long fileSize = 0; // 占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙
		String fileType = ""; // 占쏙옙占쏙옙 타占쏙옙

		MultipartRequest multi = null;


		try{
			// request,占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙,占쎈량,占쏙옙占쌘듸옙타占쏙옙,占쌩븝옙占쏙옙占싹몌옙 占쏙옙占쏙옙 占썩본 占쏙옙책
			multi = new MultipartRequest(request,uploadPath,maxSize,"utf-8",new DefaultFileRenamePolicy());
			// 占쏙옙占쏙옙占쏙옙 占쏙옙체 占쏙옙占쏙옙占싱몌옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙
			Enumeration files = multi.getFileNames();

			while(files.hasMoreElements()){
				// form 占승그울옙占쏙옙 <input type="file" name="占쏙옙占썩에 占쏙옙占쏙옙占쏙옙 占싱몌옙" />占쏙옙 占쏙옙占쏙옙占승댐옙.
				String file1 = (String)files.nextElement(); // 占쏙옙占쏙옙 input占쏙옙 占쏙옙占쏙옙占쏙옙 占싱몌옙占쏙옙 占쏙옙占쏙옙占쏙옙
				// 占쌓울옙 占쌔댐옙占싹댐옙 占쏙옙占쏙옙 占쏙옙占쏙옙 占싱몌옙占쏙옙 占쏙옙占쏙옙占쏙옙
				originalName1 = multi.getOriginalFileName(file1);
				// 占쏙옙占싹몌옙占쏙옙 占쌩븝옙占쏙옙 占쏙옙占� 占쌩븝옙 占쏙옙책占쏙옙 占쏙옙占쏙옙 占쌘울옙 1,2,3 처占쏙옙 占쌕억옙 unique占싹곤옙 占쏙옙占싹몌옙占쏙옙 占쏙옙占쏙옙占싹는듸옙
				// 占싱띰옙 占쏙옙占쏙옙占쏙옙 占싱몌옙占쏙옙 filesystemName占싱띰옙 占싹울옙 占쏙옙 占싱몌옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占승댐옙.(占쌩븝옙占쏙옙 占쏙옙占쏙옙 처占쏙옙)
				fileName1 = multi.getFilesystemName(file1);
				// 占쏙옙占쏙옙 타占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙
				fileType = multi.getContentType(file1);
				// input file name占쏙옙 占쌔댐옙占싹댐옙 占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙
				File file = multi.getFile(file1);
				// 占쏙옙 占쏙옙占쏙옙 占쏙옙체占쏙옙 크占썩를 占싯아놂옙
				fileSize = file.length();
			}



			String cate = multi.getParameter("cate");
			System.out.println(cate);

			String dbUrl = "jdbc:mysql://localhost:3307/pmsystem";
			String dbUser = "root";
			String dbPw = "user123456789";
			Connection connection = null;
			PreparedStatement statement = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection(dbUrl, dbUser, dbPw);
				String sql = "INSERT INTO gallery (cate) VALUES (?)";
				statement = connection.prepareStatement(sql);
				statement.setString(1, cate);
				statement.executeUpdate();


			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					statement.close();
				} catch (Exception e) {
				}
				try {
					connection.close();
				} catch (Exception e) {
				}
			}

		}catch(Exception e){
			e.printStackTrace();
		}
		return true;
	}

}
