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
				if (action.equals("insertmember")) {
					url = insertMember(request, response);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private String insertMember(HttpServletRequest request, HttpServletResponse response) {
		return null;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

}
