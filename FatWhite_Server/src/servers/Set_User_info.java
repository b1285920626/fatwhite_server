package servers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.Set_User_info_tool;

/**
 * Servlet implementation class Set_User_info
 */
@WebServlet("/Set_User_info")
public class Set_User_info extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Set_User_info() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");   
        response.setCharacterEncoding("UTF-8");
        
        Set_User_info_tool setUserinfotool = new Set_User_info_tool(request);
		String result = setUserinfotool.set_data();
        System.out.println(request.toString());
        
//        String result = "success";
        PrintWriter out = response.getWriter(); 
        out.write(result);  
        out.flush();  
        out.close();  
        System.out.println(result);
	}

}
