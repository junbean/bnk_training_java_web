package ex07.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import ex07.dao.AccountDAO;
import ex07.service.AccountService;

@WebServlet("/transfer")
public class TransferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AccountDAO accountDAO = new AccountDAO();
    private AccountService service = new AccountService();
	
    public TransferServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config) throws ServletException {
		
	}
	
	// https://chatgpt.com/c/68119427-12c4-800a-88d3-78b401d1b39d
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fromAccountId = request.getParameter("fromAccount");
		String toAccountId = request.getParameter("toAccount");
		String amountStr = request.getParameter("amount");
		
		try {
			double amount = Double.parseDouble(amountStr);
			
			service.transfer(fromAccountId, toAccountId, amount);
			
			request.setAttribute("message", "이체 성공 : " + fromAccountId + "에서 " + 
					toAccountId + "로 " + amount + "원 이체되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch(NumberFormatException e) {
			request.setAttribute("errorMessage", "유효하지 않은 금액입니다.");	
		}
		
		
		/*
		DAO의 transfer 메서드를 통한 코드
		try {
			double amount = Double.parseDouble(amountStr);
			
			// 트랜잭션 실행
			accountDAO.transfer(fromAccountId, toAccountId, amount);
			
			request.setAttribute("message", "이체 성공 : " + fromAccountId + "에서 " + 
									toAccountId + "로 " + amount + "원 이체되었습니다.");
		} catch(SQLException e) {
			request.setAttribute("errorMessage", "이체 실패 : " + e.getMessage());
		} catch(NumberFormatException e) {
			request.setAttribute("errorMessage", "유효하지 않은 금액입니다.");	
		}
		*/
		request.getRequestDispatcher("transfer_result.jsp").forward(request, response);
	}

	
	/*
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	*/	
}
