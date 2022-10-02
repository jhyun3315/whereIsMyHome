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

import map.Service.InterestService;
import map.Service.InterestServiceImpl;
import map.Service.MapService;
import map.Service.MapServiceImpl;
import map.dto.DealDto;
import map.dto.HomeDto;
import map.dto.InterestDto;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder; 

 
@WebServlet("/map")
public class MapController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MapService mapservice;
	private InterestService interestService;
	
	public void init() {
		mapservice = MapServiceImpl.getMapService();
		interestService = InterestServiceImpl.getInterestService();
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
				}else if(action.equals("mvinterest")) { 
					url = getinstlist(request,response); 
				}else if(action.equals("mvinterest")) { 
					url = "/map/interestList.jsp"; 
				}else if(action.equals("registinst")) { 
					registinst(request,response);
					return;
				}else if(action.equals("rminst")) { 
					removeinst(request,response);
					return;
				}
			}else {
				url = "index.jsp";
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			request.setAttribute("exception", e);
			request.setAttribute("comments", "잘못된 접근");
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
     
	
    private void removeinst(HttpServletRequest request, HttpServletResponse response) throws Exception { 
    	String userId = (String) request.getSession().getAttribute("userinfo");  
    	String idx = request.getParameter("idx"); 
    	int result = interestService.deleteInterest(userId, idx);
    	Gson gson = new GsonBuilder().setPrettyPrinting().create();
    	String jsonStirng = gson.toJson(result); 
    	 
    	PrintWriter out = response.getWriter(); 
		out.print(jsonStirng);
		out.flush();
	}
    	  

	private String getinstlist(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	String userId = (String) request.getSession().getAttribute("userinfo"); 
    	List<InterestDto> list =  interestService.selectInterest(userId); 
    	request.setAttribute("instlist", list);
    	
		return "/map/interestList.jsp";
	}

	private void registinst(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	String userId = (String) request.getSession().getAttribute("userinfo"); 
    	
    	String sidoName = request.getParameter("sidoName");
    	String gugunName = request.getParameter("gugunName");
    	String dongName = request.getParameter("dongName"); 
    	String dongCode = request.getParameter("dongCode"); 
    	
    	int result = interestService.insertInterest(userId, sidoName, gugunName, dongName, dongCode);
    	Gson gson = new GsonBuilder().setPrettyPrinting().create();
    	String jsonStirng = gson.toJson(result); 
    	 
    	PrintWriter out = response.getWriter(); 
		out.print(jsonStirng);
		out.flush();
	}
 

	private void deallist(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	String aptCode = request.getParameter("aptCode"); 
    	String aptName = request.getParameter("aptName"); 
    	
    	response.setContentType("application/json;charset=utf-8");

    	ArrayList<HomeDto> lst = mapservice.getdeallist(aptCode, aptName);
 
    	Gson gson = new GsonBuilder().setPrettyPrinting().create();
    	String jsonStirng = gson.toJson(lst); 
 
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
    	Gson gson = new GsonBuilder().setPrettyPrinting().create();
    	String jsonStirng = gson.toJson(lst); 
 
		
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
