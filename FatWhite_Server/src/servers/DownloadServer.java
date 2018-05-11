package servers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbutil.SelectWords;

/**
 * Servlet implementation class DownloadServer
 */
@WebServlet("/DownloadServer")
public class DownloadServer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadServer() {
        super();
        System.out.println("�ȴ����ӡ�������");
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8"); // ������Ӧ���ĵı����ʽ
		String tablename = request.getParameter("tablename");
		
		SelectWords selectWords = new SelectWords(tablename);
		selectWords.doSelect();
			
		response.getWriter().append(selectWords.setResponse());
		System.out.println("������ϡ���");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
