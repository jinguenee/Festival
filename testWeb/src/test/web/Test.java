package test.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html);charset=utf-8");
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		PrintWriter pw = response.getWriter();
		
		pw.println("<html>");
		pw.println("<head></head>");
		pw.println("<body>");
		
		pw.println("your id : " + id + "<br/>");
		pw.println("your password : " + pass + "<br/>");
		
		for (int i = 0; i < 100; i++) {
			pw.println("hello servlet");
			
		}
		throw new ServletException("test exception");
		pw.println("</body>");
		pw.println("</html>");
		pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
