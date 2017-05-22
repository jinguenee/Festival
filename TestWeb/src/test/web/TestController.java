package test.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestController
 */
@WebServlet("/TestController")
public class TestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
	String cmd = request.getParameter("cmd");
	
	if(cmd != null && cmd.equals("login")){
		
		//TODO DB 접속시 데이터를 취득했다고 거절하자
		
	MemberBean bean = new MemberBean();
	
	bean.setId("abctest");
	bean.setPass("1234");
	bean.setName("hong");
	bean.setAge("18");
		
	request.setAttribute(bean.getClass().getName(), bean);
	
	
	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/login.jsp");
	rd.forward(request, response);
	
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println(request.getParameter("id"));
		System.out.println(request.getParameter("pass"));
		
		
		doGet(request, response);
	}

}
