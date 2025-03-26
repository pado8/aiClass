package ch08;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class getservlet
 */
@WebServlet("/getServlet")
public class GetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/*
	 * protected void doGet(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { // TODO Auto-generated
	 * method stub
	 * response.getWriter().append("Served at: ").append(request.getContextPath());
	 * }
	 */
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		String msg = request.getParameter("msg");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter(); 
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Get Servlet</h1>");
		out.println("<h2>msg : "+msg + "</h2>");
		out.println("</body>");
		out.println("</html>");
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String msg = request.getParameter("msg");
		request.setCharacterEncoding("UTF-8");
		/* response.setContentType("text/html; charset=UTF-8"); */
		PrintWriter out = response.getWriter(); 
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>post Servlet</h1>");
		out.println("<h2>msg : "+msg + "</h2>");
		out.println("</body>");
		out.println("</html>");
	}

}
