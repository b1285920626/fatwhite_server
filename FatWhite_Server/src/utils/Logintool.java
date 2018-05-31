package utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import dbutil.MySqlConn;

public class Logintool {
	private String openid;

	public Logintool(String openid) {
		this.openid = openid;
	}

	public String makeresponse() {
		StringBuilder str = new StringBuilder();
		String sql0 = "SELECT user_type FROM user_info WHERE user_openid = '" + openid + "';";
		String sql1 = "SELECT name FROM user_types;";
		try {
			Connection conn = MySqlConn.getConnect();
			Statement statement = conn.createStatement();
			
			ResultSet resultSet = statement.executeQuery(sql0);
			if(resultSet.next()) {
				str.append(resultSet.getString(1));
			}else {
				resultSet = statement.executeQuery(sql1);
				while(resultSet.next()) {
					str.append(resultSet.getString(1) + "|");
				}
				str.deleteCharAt(str.length() - 1);
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return str.toString();
	}
	
}
