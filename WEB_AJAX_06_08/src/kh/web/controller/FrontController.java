package kh.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import kh.web.dto.PersonDTO;
import kh.web.util.NaverAPI;
import kh.web.util.PublicAirAPI;

@WebServlet("*.do")
public class FrontController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		
		if(command.equals("/ajax01.do")) {
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			System.out.println(name+" : "+email);
		}else if(command.equals("/ajax02.do")) {
			JSONObject json = new JSONObject();
			json.put("name", "jack");
			json.put("email", "jack@naver.com");
			// 기본은 
			//클라이언트  오브젝트 보내는거니  컨텐드 헤드를 바꿔야 함 
			response.setCharacterEncoding("utf8");
			response.setContentType("application/json");
			
			response.getWriter().print(json);
			response.getWriter().flush();
			response.getWriter().close();
			//상대방 한테 데이터가 날라감 
		}else if(command.equals("/ajax03.do")) {
			List<PersonDTO> list = new ArrayList<>();
			list.add(new PersonDTO(1,"ABC","123"));
			list.add(new PersonDTO(2,"식송추","9기자"));
			list.add(new PersonDTO(3,"고8니","11티도"));
			//JSONArray jarray =new JSONArray();
			
//			for(PersonDTO tmp:list) {
//				JSONObject o =new JSONObject();
//				o.put("id", list.get(i).getId());
//				o.put("name", list.get(i).getName());
//				o.put("contact", list.get(i).getContact());
//				jarray.add(o);
//			}
			
//			for(int i=0;i<list.size();i++) {    // 자바의 어레이 리스트 구분을    제이슨 어레이 구분으로 바꿈
//				JSONObject o =new JSONObject();
//				o.put("id", list.get(i).getId());
//				o.put("name", list.get(i).getName());
//				o.put("contact", list.get(i).getContact());
//				jarray.add(o);
//			}
			
			response.setCharacterEncoding("utf8");
			response.setContentType("application/json"); // 
			
			//Gson gson = new Gson();
			new Gson().toJson(list,response.getWriter());
			
//			response.getWriter().print(jarray);  // 
//			response.getWriter().flush();
//			response.getWriter().close();
		}else if(command.equals("/ajax04.do")){
			NaverAPI napi = new NaverAPI();
			try {
				JsonArray arr = napi.getNews("야구");
				response.setCharacterEncoding("utf8");
				response.setContentType("application/json");
				
				new Gson().toJson(arr,response.getWriter());
			} catch (Exception e) {
				response.getWriter().print("야구뉴스를 가져오는데 실패했습니다");
			}
		}else if(command.equals("/ajax05.do")) {
		    PublicAirAPI papi = new PublicAirAPI();
		    try {
		    	String day = request.getParameter("date");
		    	System.out.println(day);
		    	JsonArray arr = papi.getNews(day);
		    	response.setCharacterEncoding("utf8");
				response.setContentType("application/json");
				new Gson().toJson(arr,response.getWriter());
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
