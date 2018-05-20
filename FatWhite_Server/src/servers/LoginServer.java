package servers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServer
 */
@WebServlet("/LoginServer")
public class LoginServer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		//设置客户端的解码方式为utf-8  
        response.setContentType("text/html;charset=utf-8");  
        //  
        response.setCharacterEncoding("UTF-8");  
          
        PrintWriter out = response.getWriter();  
          
        String result = "";  
          
        String user_ID = request.getParameter("user_ID");  
        String user_pw = request.getParameter("user_pw");  
          
        //System.out.println("name="+name);  
        //System.out.println("password="+pwd);  
        if (user_ID.equals("admin")&&user_pw.equals("123")) {  
            result = "success";  
        }  
        else{  
            result = "fail";  
        }  
        out.write(result);  
        out.flush();  
        out.close();  
        System.out.println(result);
	}

}
