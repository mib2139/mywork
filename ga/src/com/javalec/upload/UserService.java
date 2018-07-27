package com.javalec.upload;

import java.io.File;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class UserService {
	
	
	
	public boolean upload(HttpServletRequest request) {
		String uploadPath = "C:/JavaProgramming/source/ga2/WebContent/images";
		int maxSize = 1024 * 1024 * 10;
		
		String fileName1 = ""; // �ߺ�ó���� �̸�
	    String originalName1 = ""; // �ߺ� ó���� ���� ���� �̸�
	    long fileSize = 0; // ���� ������
	    String fileType = ""; // ���� Ÿ��
	    
	    MultipartRequest multi = null;
	     
	    try{
			// request,����������,�뷮,���ڵ�Ÿ��,�ߺ����ϸ� ���� �⺻ ��å
	        multi = new MultipartRequest(request,uploadPath,maxSize,"utf-8",new DefaultFileRenamePolicy());
	        // ������ ��ü �����̸����� ������
	        Enumeration files = multi.getFileNames();
	         
	        while(files.hasMoreElements()){
	            // form �±׿��� <input type="file" name="���⿡ ������ �̸�" />�� �����´�.
	            String file1 = (String)files.nextElement(); // ���� input�� ������ �̸��� ������
	            // �׿� �ش��ϴ� ���� ���� �̸��� ������
	            originalName1 = multi.getOriginalFileName(file1);
	            // ���ϸ��� �ߺ��� ��� �ߺ� ��å�� ���� �ڿ� 1,2,3 ó�� �پ� unique�ϰ� ���ϸ��� �����ϴµ�
	            // �̶� ������ �̸��� filesystemName�̶� �Ͽ� �� �̸� ������ �����´�.(�ߺ��� ���� ó��)
	            fileName1 = multi.getFilesystemName(file1);
	            // ���� Ÿ�� ������ ������
	            fileType = multi.getContentType(file1);
	            // input file name�� �ش��ϴ� ���� ������ ������
	            File file = multi.getFile(file1);
	            // �� ���� ��ü�� ũ�⸦ �˾Ƴ�
	            fileSize = file.length();
	        }
	    }catch(Exception e){
	        e.printStackTrace();
	    }
		return true;
	}
	
	

}
