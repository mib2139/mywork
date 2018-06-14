package org.gntp;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import java.io.File;
import java.util.Enumeration;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

public class MyFile {
	
	private String name;
	private String subject;

	private String fileName1; // �ߺ�ó���� �̸�
	private String originalName1; // �ߺ� ó���� ���� ���� �̸�
	
	

	public void upload(String path, HttpServletRequest request, int size) {

		String uploadPath = path;

		//String uploadPath ="C:/Users/user42/eclipse-workspace/Login2/WebContent/data";
		//�� �������� �������� �ٲ�� ��.

		int maxSize = 1024 * 1024 * size; // �ѹ��� �ø� �� �ִ� ���� �뷮 : 10M�� ����


		long fileSize = 0; // ���� ������
		String fileType = ""; // ���� Ÿ��

		MultipartRequest multi = null;

		try{
			// request,����������,�뷮,���ڵ�Ÿ��,�ߺ����ϸ� ���� �⺻ ��å
			multi = new MultipartRequest(request,uploadPath,maxSize,"utf-8",new DefaultFileRenamePolicy());

			// form���� input name="name" �� �༮ value�� ������
			name = multi.getParameter("name");
			// name="subject" �� �༮ value�� ������
			subject = multi.getParameter("subject");

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
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getFileName1() {
		return fileName1;
	}

	public void setFileName1(String fileName1) {
		this.fileName1 = fileName1;
	}

	public String getOriginalName1() {
		return originalName1;
	}

	public void setOriginalName1(String originalName1) {
		this.originalName1 = originalName1;
	}
}
