package dbutil;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;

import model.HistoryPaper;

public class SaveHistoryPaper {
	public static String savepaper(HttpServletRequest request) {
		String report = "failed";
		
		String openid = request.getParameter("openid");
		String historypaper;
		try { historypaper = new String(request.getParameter("historypaper").getBytes("iso-8859-1"), "utf-8");}catch (Exception e) {System.out.println(e);historypaper = "´í";}
		String myanswerjson = request.getParameter("myanswerjson");
		
		Gson gson = new Gson();
		HistoryPaper hp = gson.fromJson(historypaper, HistoryPaper.class);
		
		try {
			Connection connection = MySqlConn.getConnect();
			String sql = "INSERT INTO papers_history(openid,type,name,question_id_0,question_id_1,question_id_2,question_id_3,myanswer) VALUES(?,?,?,?,?,?,?,?);";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			
			pstmt.setString(1, openid);
			pstmt.setString(2, hp.gettype());
			pstmt.setString(3, hp.getname());
			pstmt.setInt(4, hp.getquestion_0_id());
			pstmt.setInt(5, hp.getquestion_1_id());
			pstmt.setInt(6, hp.getquestion_2_id());
			pstmt.setInt(7, hp.getquestion_3_id());
			pstmt.setString(8, myanswerjson);
			if(pstmt.executeUpdate() > 0) {
				report = "success";
			}
			
			System.out.println("\n"+openid);
			System.out.println(historypaper);
			System.out.println(myanswerjson);
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		return report;
	}

}
