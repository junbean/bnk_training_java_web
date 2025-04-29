package ex06.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;

/*

@MultipartConfig
	멀티파트, 폼 데이터 형식의 요청을 처리할 수 있도록 설정하는 애노테이션
	주로 파일 업로드에 사용됨

기본 개념
	멀티파트 요청이란 HTML 폼 태그에 enctype="multipart/form-data"가 설정되어 있을 때 서버로 전송되는 요청 형식
	이 형식은 일반 텍스트 데이터와 바이너리 파일 데이터를 함께 전송할 수 있게 해준다

증요한 점
	1. 파일 업로드는 항상 POST메서드를 사용해야 한다
	2. 파일을 서버로 전송하는 방식은 무조건 enctype="multipart/form-data" 이걸 지정해야한다
		- 이걸 안쓰면 파일 내용이 아니라 이름만 전송된다
	3. 무조건 @MultipartConfig 애노테이션이 필요하다
		- 이거 안하면 request.getPart() 메서드가 작동하지 않고 예외가 발생함
	4. 파일을 받을때는 request.getPart()로 받아야 한다

*/
@MultipartConfig(
			fileSizeThreshold = 1024 * 1024 * 1,	// 1MB 이하면 디스크에 저장
			maxFileSize = 1024 * 1024 * 10,			// 최대 10MB 파일 업로드 허용
			maxRequestSize = 1024 * 1024 * 15		// 요청 전체 크기 15MB 제한
			// location = ""                          // 임시 저장 위치 (기본값: 서버의 임시 디렉토리)
		)
@WebServlet("/uploadProc")
public class UploadProcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. upload 폴더 지정
		// 파일이 저장될 웹 애플리케이션의 실제 경로를 가져온다
		// 현재 서블릿에서 /images/ 폴더에 파일을 저장한다
		String uploadPath = request.getServletContext().getRealPath("/images/");
		System.out.println("uploadPath : " + uploadPath);
		
		// 2. 일반 파라미터 처리
		// 폼에 전송된 DESC(설명) 파라미터 값을 가져온다
		String desc = request.getParameter("desc");
		System.out.println("desc : " + desc);
		
		// 3. 파일처리
		// IMGFILE 이라는 이름의 파일 파트를 가져온다
		// 파일의 크기를 확인한다 - 파일 유무 확인
		Part part = request.getPart("imgfile");
		long size = part.getSize();
		
		// 4. 파일 유무에 따른 조건부 처리
		if(size > 0) {
			// 업로드된 파일을 지정된 경로에 원래 파일 이름으로 저장 - images/파일이름
			part.write(uploadPath + part.getSubmittedFileName());
			// 임시 저장된 파일을 삭제, 
			// 근데 알아서 서블릿에서 지우기 때문에 이렇게 안해줘도 됨, 
			// 이건 그냥 수동으로 지우는거
			part.delete();
			// 파일 이름을 request 속성에 저장 -> success.jsp 화면 이동
			request.setAttribute("filename", part.getSubmittedFileName());
			request.getRequestDispatcher("success.jsp").forward(request, response);
		} else {
			// 실패시 fail.jsp 화면 이동
			response.sendRedirect("fail.jsp");
		}	
	}

}
/*

파일 업로드 과정

0. @MultipartConfig 설정
1. 사용자가 웹 폼에서 파일을 선택하고 제출
2. 서버는 해당 파일을 우선 "임시 보관함"에 보관한다
3. part.write 실행 - 파일을 실제로 보관하고 싶은 폴더로 이동
4. 파일을 원하는 위치에 복사한 후, 더이상 필요없는 임시 보관함의 파일을 삭제 - 비유하자면 상자 내용물 꺼내서 빈 상자 처리하는 느낌

궁금증

	part.delete() 이후에도 part.getSubmittedFileName() 함수를 사용할 수 있는가?
		Part 객체는 두가지 정보를 가지고 있음
			- 실제 파일에 대한 데이터
			- 파일에 대한 정보
		part.delete()는 실제 임시 파일만 삭제한다
		파일에 대한 정보는 여전히 Part 객체에 남아있다
 	
 	
 	part.delete()를 굳이 하는 이유
 		1. 디스크 공간 절약
 			파일 업로드 시 서버의 임시 디렉토리에 임시 파일이 생성됨
 			이 파일들을 계속 남겨두면 서버 디스크 공간이 낭비된다
 		2. 중복 파일 방지
 			같은 파일을 여러 번 업로드하면 임시 디렉토리에 여러 개의 동일한 파일이 쌓일 수 있다
 			그래서 문제가 생길수 있기에 미리 처리한다
 		3. 민감한 정보 보호
 			임시 파일에는 사용자가 업로드한 원본 데이터가 그대로 있다
 			이 파일들을 그대로 두면 보안 위험이 될 수 있다
 		4. 서버 성능 향상
 			불필요한 파일이 많아지면 서버의 파일 시스템 성능이 저하될 수 있음
 			
*/



