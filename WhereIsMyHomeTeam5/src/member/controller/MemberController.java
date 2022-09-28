package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.dto.Member;
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
		
		try {
			if (action != null) {
				if (action.equals("registmemberform")) {
					url = "user/register.jsp";
				} else if (action.equals("registmember")) {
					url = registMember(request, response);
				} else if (action.equals("loginform")) {
					url = "user/login.jsp";
				} else if (action.equals("login")) {
					url = login(request, response);
				} else if (action.equals("userinfo")) {
					url = listMember(request, response);
				} else if (action.equals("modifyform")) {
					url = "user/userModify.jsp";
				} else if (action.equals("modifymember")) {
					url = updateMember(request, response);
				} else if (action.equals("deletemember")) {
					url = deleteMember(request, response);
				} else if (action.equals("logout")) {
					url = logout(request, response);
				}
			} else {
				url = "index.jsp";
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			request.setAttribute("exception", e);
			request.setAttribute("comments", "그따구로 입력할거면 꺼져");
			url = "error/error.jsp";
		}
		
		if (url.startsWith("redirect")) {
			url = url.substring(url.indexOf(":")+1);
			response.sendRedirect(url);
		} else {
			request.getRequestDispatcher(url).forward(request, response);
		}
	}

	private String logout(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().invalidate();
		
		String url = "redirect:index.jsp";
		return url;
	}

	private String deleteMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userId = (String) request.getSession().getAttribute("userinfo");
		service.deleteMember(userId);
		request.getSession().invalidate();
		
		String url = "redirect:index.jsp";
		return url;
	}

	private String updateMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		String userName = request.getParameter("userName");
		String userEmail = request.getParameter("userEmail");
		String userPhoneNum = request.getParameter("userPhoneNum");
		service.updateMember(userId, userPw, userName, userEmail, userPhoneNum);
		
		String url = "redirect:user?action=userinfo";
		return url;
	}

	private String listMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userId = (String) request.getSession().getAttribute("userinfo");
		Member m = service.selectMember(userId);
		request.setAttribute("mem", m);
		
		String url = "user/userInfo.jsp";
		return url;
	}

	private String login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		boolean result = service.login(userId, userPw);
		if (result) {
			request.getSession().setAttribute("userinfo", userId); 
			url = "index.jsp";
		} else {
			url = "redirect:user?action=loginform";
		}
		return url;
	}

	private String registMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		String userName = request.getParameter("userName");
		String userEmail = request.getParameter("userEmail");
		String userPhoneNum = request.getParameter("userPhoneNum");
		
		service.insertMember(userId, userPw, userName, userEmail, userPhoneNum);
		String url = "redirect:user?action=loginform";
		return url;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

}
