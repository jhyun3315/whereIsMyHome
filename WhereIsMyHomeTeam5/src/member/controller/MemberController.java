package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/user")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String url = new String();
	
	

	@Override
	public void init() throws ServletException {
		
	}

	private void process(HttpServletRequest request, HttpServletResponse response) {
		String action = request.getParameter("action");
		System.out.println("action ===" + action);
		
		try {
			if (action != null) {
				if (action.equals("registmember")) {
					url = registMember(request, response);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String registMember(HttpServletRequest request, HttpServletResponse response) {
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		String userName = request.getParameter("userName");
		String userEmail = request.getParameter("userEmail");
		String userPhoneNum = request.getParameter("userPhoneNum");
		return null;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

}
