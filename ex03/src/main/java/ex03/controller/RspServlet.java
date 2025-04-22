package ex03.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet("/rsp")
public class RspServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 사용자가 낸 것
		String user_str = request.getParameter("rsp");
		int user = Integer.parseInt(user_str);
		String userStr = "가위";
		
		// 컴퓨터가 낸 것
		Random rd = new Random();
		int computer = rd.nextInt(3) + 1;
		String computerStr = "가위";
		
		// 결과
		// 이김 	: 1
		// 짐 	: -1
		// 비김 	: 0
		int result = 0;
		
		// 연산
		// 가위 	:	1
		// 바위 	:	2
		// 보 	:	3
		if(user == 1 && computer == 3) {
			result = 1;
		} else if(user == 3 && computer == 1) {
			result = -1;
		} else if(user > computer) {
			result = 1;	
		} else if(user == computer) {
			result = 0;		
		} else {
			result = -1;
		}
		
		// 사용자가 낸거
		if(user == 1) {
			userStr = "가위";
		} else if(user == 2) {
			userStr = "바위";	
		} else {
			userStr = "보";	
		}
		
		// 컴퓨터가 낸거
		if(computer == 1) {
			computerStr = "가위";
		} else if(computer == 2) {
			computerStr = "바위";	
		} else {
			computerStr = "보";	
		}
		System.out.println(user);
		System.out.println(computer);
		System.out.println(result);
		
		request.setAttribute("user", userStr);
		request.setAttribute("computer", computerStr);
		request.setAttribute("result", result);
		
		request.getRequestDispatcher("rspResult.jsp").forward(request, response);
	}

}
