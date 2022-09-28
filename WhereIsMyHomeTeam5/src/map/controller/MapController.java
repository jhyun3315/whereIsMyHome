package map.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.net.httpserver.HttpServer;

import map.Service.MapService;
import map.Service.MapServiceImpl;

/**
 * Servlet implementation class MapController
 */
@WebServlet("/map")
public class MapController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MapService mapservice;
	
	public void init() {
		mapservice = MapServiceImpl.getMapService();
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action"); 
		String url = "index.jsp";
		System.out.println("act === "+ action);
		
		try {
			if (action != null) {
				if (action.equals("mapform")) {
					url = mapform(request, response);
				}else if(action.equals("mvlmap")) {
					url = "/aptform.jsp";
				}
			}else {
				url = "index.jsp";
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			request.setAttribute("comment", "똑바로해라");
			url = "error/error.jsp";
		}
		if(url.startsWith("redirect")) {
			url = url.substring(url.indexOf(":")+1);
			response.sendRedirect(url);
		}else {
			request.getRequestDispatcher(url).forward(request, response);
		}
	}   
    
    private String mapform(HttpServletRequest request, HttpServletResponse response) {
    	//세션으로 로그인 되어있으면 local에 저장하기
    	HttpSession session = request.getSession();
    	System.out.println(session);
    	
    	if(session == null) {
    		request.setAttribute("msg", "로그인 이후 사용 가능합니다.");  
    		return "index.jsp";
    	}else {
    		
    		HashMap<String,HashMap<String,ArrayList<String>>> sidogugunmap = mapservice.sidogugunmap(); 
    		return "/map/mapform.jsp";
    	}
    	    	 
	}

	private String listmap(HttpServletRequest request, HttpServletResponse response) {
		 
		return null;
	}

	public MapController() {
        super();
    }
    
    
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		process(request, response); 
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
