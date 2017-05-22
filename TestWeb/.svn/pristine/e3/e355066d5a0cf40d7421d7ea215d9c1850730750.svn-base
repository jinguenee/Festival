package test.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import test.web.model.MemberBean;

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
    } // end of TestController

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String cmd = request.getParameter("cmd");
		if (cmd != null && cmd.equals("login")) {
			// DB접속해서 데이터를 취득했다고 가정
			MemberBean bean = new MemberBean();
			bean.setId("abctest");
			bean.setPass("1234");
			bean.setName("홍길동");
			bean.setAge("18");
			
			// View에서 사용하기 위한 Bean을 담는다.
			request.setAttribute("memberBean", bean); // View(.jsp파일)에서 getAttribute()한다.
			
			// 해당 뷰로 이동한다
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/login.jsp");
			rd.forward(request, response);
		}
	} // end of doGet()

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("id"));
		System.out.println(request.getParameter("pw"));
		
//		doGet(request, response);
	} // end of doPost()
} // end of class
