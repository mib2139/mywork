package org.gntp.beans;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import java.io.BufferedReader;
import java.io.File;
import java.util.Enumeration;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;


public class Myfile2 {

	private String fileName1; // �ߺ�ó���� �̸�
	private String originalName1; // �ߺ� ó���� ���� ���� �̸�

	public boolean upload(String path, HttpServletRequest request) {

		String uploadPath = path;
		String cmd;
		//String uploadPath="C:/Users/user42/eclipse-workspace/Login2/WebContent/data";
		//�� �������� �������� �ٲ�� ��.

		int maxSize = 1024 * 1024 * 10; // �ѹ��� �ø� �� �ִ� ���� �뷮 : 10M�� ����

		long fileSize = 0; // ���� ������
		String fileType = ""; // ���� Ÿ��

		MultipartRequest multi = null;
		BufferedReader br = null;

		boolean result = false;

		InventoryBean inven = new InventoryBean(); 
		ManagementBean mb = new ManagementBean();
		Member member = new Member();
		LoginBean lb = new LoginBean();

		try{

			// request,����������,�뷮,���ڵ�Ÿ��,�ߺ����ϸ� ���� �⺻ ��å
			multi = new MultipartRequest(request,uploadPath,maxSize,"utf-8",new DefaultFileRenamePolicy());

			String model = multi.getParameter("model");
			String id = multi.getParameter("id");
			fileName1 = multi.getParameter("fileName1");

			// ������ ��ü �����̸����� ������
			Enumeration files = multi.getFileNames();

			int i = 0;

			cmd = multi.getParameter("cmd");

			inven.setBnum(multi.getParameter("bnum"));
			inven.setPname(multi.getParameter("pname"));
			inven.setModel(multi.getParameter("model"));
			inven.setCompany(multi.getParameter("company"));
			inven.setCate(multi.getParameter("cate"));
			inven.setAmount(multi.getParameter("amount"));
			inven.setPrice(multi.getParameter("price"));

			member.setBnum(multi.getParameter("bnum"));
			member.setId(multi.getParameter("id"));
			member.setPw(multi.getParameter("pw"));

			if (cmd.equals("update")) {
				mb.updateInven(inven);

			}else if(cmd.equals("insert")){
				mb.addInven(inven);

			}else if(cmd.equals("updatemember")){

				model=id;
				lb.updateMember(member);

			}else if(cmd.equals("insertmember")) {
				model = id;
				lb.addMember(member);
			}


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
				// �� ���� ��ü�� ũ�⸦ �˾Ƴ�

				File upfile1 = new File(uploadPath+"/"+fileName1); //--'/'������ �۾��ߴ� .�׷��� ��ΰ� ����� ������ ����

				File upfile2 = new File(uploadPath+"/"+model+".jpg");

				if(upfile1.renameTo(upfile2)){
					result = true;
				}else{
					System.out.print("�̸��������");
				}
			}

		}catch(Exception e){
			e.printStackTrace();
		}

		return result;
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
