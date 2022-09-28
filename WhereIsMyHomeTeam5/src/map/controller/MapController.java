package map.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    	List<String> sidonameList = mapservice.sidoNamelist();
    	
		return "/map/mapform.jsp";
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
