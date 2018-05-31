package dbutil;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;

public class SaveUserWord {
	public static String doit(HttpServletRequest request) {
        
        String opedidString = request.getParameter("openid");
        String wordString = request.getParameter("wordlist");
        System.out.println(opedidString);
        System.out.println(wordString);
        Connection conn = MySqlConn.getConnect();
        
        try {
			String sql = "UPDATE word_user SET word_jsonlist = ? WHERE User_openid = ?;";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, wordString);
			pstmt.setString(2, opedidString);
			if(pstmt.executeUpdate() > 0) {
				pstmt.close();
			
				System.out.println("更新成功。。。");
				return "success";
			}else {
				sql = "INSERT INTO word_user(User_openid,word_jsonlist) VALUES(?, ?);";
        		pstmt = conn.prepareStatement(sql);
        		pstmt.setString(1, opedidString);
        		pstmt.setString(2, wordString);
        		pstmt.executeUpdate();
				pstmt.close();
			
				System.out.println("插入成功。。。");
				return "success";
			}
        }catch(Exception e) {
        	System.out.println(e);
        	System.out.println("插入失败。。。");
        	return "failed";
        }
        
	}
}
