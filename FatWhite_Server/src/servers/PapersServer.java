package servers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbutil.MakePaper;
import dbutil.MySqlConn;

/**
 * Servlet implementation class PapersServer
 */
@WebServlet("/PapersServer")
public class PapersServer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PapersServer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8"); // 设置响应报文的编码格式
		String paper = request.getParameter("paper");
		String type = request.getParameter("type");
		if(paper.equals("15242005956")) {
			StringBuilder paper_names = new StringBuilder();
			try {
				String sql = "SELECT name FROM papers WHERE type = '"+type+"';";
				Connection conn = MySqlConn.getConnect();
				Statement statement = conn.createStatement();
				ResultSet resultSet = statement.executeQuery(sql);
				
				while(resultSet.next()) {
					paper_names.append(resultSet.getString(1) + "#");
				}
				paper_names.deleteCharAt(paper_names.length() - 1);
				
				resultSet.close();
				statement.close();
				conn.close();
			}catch (Exception e) {
				System.out.println(e);
				// TODO: handle exception
			}
			response.getWriter().append(paper_names);
			System.out.println("处理请求1");
		}else {
			MakePaper makePaper = new MakePaper(paper);
			
			response.getWriter().append(makePaper.doit(type));
			System.out.println("处理请求2");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
