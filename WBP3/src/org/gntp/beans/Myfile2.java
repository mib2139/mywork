package org.gntp.beans;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import java.io.BufferedReader;
import java.io.File;
import java.util.Enumeration;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;


public class Myfile2 {

	private String fileName1; // 중복처리된 이름
	private String originalName1; // 중복 처리전 실제 원본 이름

	public boolean upload(String path, HttpServletRequest request) {

		String uploadPath = path;
		String cmd;
		//String uploadPath="C:/Users/user42/eclipse-workspace/Login2/WebContent/data";
		//역 슬러쉬를 슬러쉬로 바꿔야 함.

		int maxSize = 1024 * 1024 * 10; // 한번에 올릴 수 있는 파일 용량 : 10M로 제한

		long fileSize = 0; // 파일 사이즈
		String fileType = ""; // 파일 타입

		MultipartRequest multi = null;
		BufferedReader br = null;

		boolean result = false;

		InventoryBean inven = new InventoryBean(); 
		ManagementBean mb = new ManagementBean();
		Member member = new Member();
		LoginBean lb = new LoginBean();

		try{

			// request,파일저장경로,용량,인코딩타입,중복파일명에 대한 기본 정책
			multi = new MultipartRequest(request,uploadPath,maxSize,"utf-8",new DefaultFileRenamePolicy());

			String model = multi.getParameter("model");
			String id = multi.getParameter("id");
			fileName1 = multi.getParameter("fileName1");

			// 전송한 전체 파일이름들을 가져옴
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
				// form 태그에서 <input type="file" name="여기에 지정한 이름" />을 가져온다.
				String file1 = (String)files.nextElement(); // 파일 input에 지정한 이름을 가져옴
				// 그에 해당하는 실재 파일 이름을 가져옴
				originalName1 = multi.getOriginalFileName(file1);
				// 파일명이 중복될 경우 중복 정책에 의해 뒤에 1,2,3 처럼 붙어 unique하게 파일명을 생성하는데
				// 이때 생성된 이름을 filesystemName이라 하여 그 이름 정보를 가져온다.(중복에 대한 처리)
				fileName1 = multi.getFilesystemName(file1);
				// 파일 타입 정보를 가져옴
				fileType = multi.getContentType(file1);
				// input file name에 해당하는 실재 파일을 가져옴
				// 그 파일 객체의 크기를 알아냄

				File upfile1 = new File(uploadPath+"/"+fileName1); //--'/'를빼고 작업했다 .그래서 경로가 제대로 나오지 않음

				File upfile2 = new File(uploadPath+"/"+model+".jpg");

				if(upfile1.renameTo(upfile2)){
					result = true;
				}else{
					System.out.print("이름변경실패");
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
