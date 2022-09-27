package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.MemberService;
import member.service.MemberServiceImpl;

@WebServlet("/user")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String url = new String();
	private MemberService service;
	public MemberController() {
		service = MemberServiceImpl.getMemberService();
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String action = request.getParameter("action");
		System.out.println("action === " + action);
		
		url = "index.jsp";
		try {
			if (action != null) {
				if (action.equals("registmemberform")) {
					url = "user/register.jsp";
				} else if (action.equals("")) {
					url = registMember(request, response);
				} else if (action.equals("")) {
					
				} else if (action.equals("")) {
					
				} else if (action.equals("")) {
					
				} else if (action.equals("")) {
					
				} else if (action.equals("")) {
					
				} else if (action.equals("")) {
					
				} else if (action.equals("")) {
					
				} else if (action.equals("")) {
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (url.startsWith("redirect")) {
			url = url.substring(url.indexOf(":")+1);
			response.sendRedirect(url);
		} else {
			request.getRequestDispatcher(url).forward(request, response);
		}
	}

	private String registMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		String userName = request.getParameter("userName");
		String userEmail = request.getParameter("userEmail");
		String userPhoneNum = request.getParameter("userPhoneNum");
		
		service.insertMember(userId, userPw, userName, userEmail, userPhoneNum);
		String url = "redirect:index.jsp";
		return url;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

}
