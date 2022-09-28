package map.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpCookie;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
					url = "/mapform.jsp";
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
    
    private String mapform(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {  
    	Cookie[] cookies = request.getCookies();
    	boolean flag = false; 
    	
    	for(Cookie c : cookies) { 
    		if(c.getName() == "selData") {
    			flag = true;
    			break;
    		}
    	}
    	
    	if(!flag) { 
    		HashMap<String,HashMap<String,ArrayList<String>>> sidogugunmap = mapservice.sidogugunmap(); 
    		Cookie cookie = new Cookie("selData",URLEncoder.encode(sidogugunmap.toString(), "UTF-8"));  
    		cookie.setMaxAge(60*60*24); 
    		response.addCookie(cookie); 
    	} 
    	
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
