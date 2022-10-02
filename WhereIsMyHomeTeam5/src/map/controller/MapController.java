package map.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
import map.dto.DealDto;
import map.dto.HomeDto;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder; 

 
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
					mapform(request, response);
					return;
				}else if(action.equals("mvlmap")) {
					url = "/map/mapform.jsp";
				}else if(action.equals("xml")) {
					
				}else if(action.equals("deallist")) {
					deallist(request, response);
					return;
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
			System.out.println(url);
			response.sendRedirect(url);
		}else {
			request.getRequestDispatcher(url).forward(request, response);
		}
	}   
     
	
    private void deallist(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	String aptCode = request.getParameter("aptCode"); 
    	String aptName = request.getParameter("aptName"); 
    	response.setContentType("application/json;charset=utf-8");

    	ArrayList<HomeDto> lst = mapservice.getdeallist(aptCode, aptName);

    	System.out.println(lst.get(0));
    	
    	Gson gson = new GsonBuilder().setPrettyPrinting().create();
    	String jsonStirng = gson.toJson(lst); 

		System.out.println("보낼값 = " + jsonStirng);  
		
		PrintWriter out = response.getWriter(); 
		out.print(jsonStirng);
		out.flush();
	}

	private void mapform(HttpServletRequest request, HttpServletResponse response) throws IOException {   
    	String dongCode = request.getParameter("dongName");
    	String year = request.getParameter("year");
    	String month = request.getParameter("month");
    	response.setContentType("application/json;charset=utf-8");
    	
    	ArrayList<DealDto> lst = mapservice.gethomelist(dongCode, year, month);
//    	System.out.println(lst.toString());
    	Gson gson = new GsonBuilder().setPrettyPrinting().create();
    	String jsonStirng = gson.toJson(lst); 

//		System.out.println("보낼값 = " + jsonStirng);  
		
		PrintWriter out = response.getWriter(); 
		out.print(jsonStirng);
		out.flush();
		     
	}
  
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		process(request, response); 
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
