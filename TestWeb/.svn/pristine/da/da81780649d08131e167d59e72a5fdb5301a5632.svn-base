package test.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestWeb1
 */
@WebServlet("/TestWeb1")
public class TestWeb1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestWeb1() {
        super();
    } // end of TestWeb1

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		// 아래 두줄은 아래의 코드를 해석해서 출력할수 있도록 한다.
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		// request 로부터 정보를 가져옴
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		PrintWriter pw = response.getWriter();
		pw.println("<html>");
		pw.println("<head></head>");
		pw.println("<body>");
		
		pw.println("귀하의 아이디 : " + id + "<br/>");
		pw.println("귀하의 비밀번호 : " + pass + "<br/>");
		
		for (int i=0; i<100; i++) {
			pw.println("Hellow Servlet");
			pw.println("<br/>");
		}
		pw.println("</body>");
		pw.println("</html>");
		
		pw.close();
	} // end of doGet()

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	} // end of doPost()
} // end of class
