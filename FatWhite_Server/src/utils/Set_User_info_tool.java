package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.http.HttpServletRequest;

import dbutil.MySqlConn;

public class Set_User_info_tool {
	String openid;
	String name;
	String type;
	
	public Set_User_info_tool(HttpServletRequest request) {
		//½âÎö
		openid = request.getParameter("user_openid");
		name = request.getParameter("user_name");
		type = request.getParameter("user_type");
		System.out.println(openid+"Ø­"+name+"Ø­"+type);
	}

	public String set_data() {
		//´æ´¢
		try {
			Connection conn = MySqlConn.getConnect();
			String sql = "INSERT INTO user_info(user_openid,user_name,user_type)"+" VALUES(?, ?, ?);";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, openid);
			pstmt.setString(2, name);
			pstmt.setString(3, type);
			pstmt.execute();
			
			pstmt.close();
			conn.close();
			
			return "success";
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		//	return "fail";
			return "success";
		}
		
	}
}
