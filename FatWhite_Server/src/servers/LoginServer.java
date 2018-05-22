package servers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbutil.MySqlConn;

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
        response.setCharacterEncoding("UTF-8");  
          
        PrintWriter out = response.getWriter();  
          
        String result = "";
        String right_pw = "";
        boolean flag = false;
          
        String user_ID = request.getParameter("user_ID");  
        String user_pw = request.getParameter("user_pw");  
        
        String sql = "SELECT User_pw FROM Login WHERE User_ID = '"+user_ID+"';";//SQL语句
        
        try {
			Connection conn = MySqlConn.getConnect();
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			resultSet.next();
			right_pw = resultSet.getString(1);
			flag = right_pw.equals(user_pw);
			
			resultSet.close();
			statement.close();
			conn.close();
        }catch (Exception e) {
        	System.out.println(e);
			// TODO: handle exception
		}
 			
        if (flag) {  
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
