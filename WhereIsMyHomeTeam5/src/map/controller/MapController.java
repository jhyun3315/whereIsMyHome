package map.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MapController
 */
@WebServlet("/map")
public class MapController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action"); 
//		try {
//			if (action != null) {
//				if (action.equals("listmap")) {
//					url = listmap(request, response);
//				}else if(action.equals("insertmemberform")){
//					url = "member/insertForm.jsp";
//				}else if(action.equals("login")) {
//					url = login(request,response);
//				}
//			}else {
//				url = "index.jsp";
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			request.setAttribute("msg", e.getMessage());
//			request.setAttribute("comment", "똑바로해라");
//			url = "error/error.jsp";
//		}
//		if(url.startsWith("redirect")) {
//			url = url.substring(url.indexOf(":")+1);
//			response.sendRedirect(url);
//		}else {
//			request.getRequestDispatcher(url).forward(request, response);
//		}
	}   
    
    public MapController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
