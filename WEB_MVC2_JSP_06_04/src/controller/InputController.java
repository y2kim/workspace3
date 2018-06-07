package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import kh.web.bean.Car;

@WebServlet("/InputController")
public class InputController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		request.setCharacterEncoding("utf8");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		System.out.println(name+" : "+ email);
		
		DAO dao = new DAO();
		int result = dao.insertInfo(name, email);
		
		
		List<String> list = new ArrayList<>();
		list.add("apple");
		list.add("Oragne");
		////리스트 데이터
		
		Map<String,String> map = new HashMap<>();
		map.put("one", "Monday");
		map.put("two", "Tuesday");
		map.put("three", "Wednesday");
		
		Car myCar = new Car();
		myCar.setPrice(10000000);
		myCar.setCarName("Tico");
		myCar.setBrand("GM");
		//map
		
		
		request.setAttribute("result", result);
		request.setAttribute("list", list);  // hash map 같은거 
		request.setAttribute("map", map);
		request.setAttribute("car", myCar);
		
		request.setAttribute("name", "임꺽정");
		request.getSession().setAttribute("name", "홍길동");
		
		RequestDispatcher rd = request.getRequestDispatcher("infoView.jsp");
		rd.forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.html");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
