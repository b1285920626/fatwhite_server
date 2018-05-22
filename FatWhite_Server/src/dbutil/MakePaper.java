package dbutil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class MakePaper {
	private String papername;
	
	public MakePaper(String str) {
		this.papername = str;
	}
	
	public String doit() {
		StringBuilder paper = new StringBuilder();
		StringBuilder answer = new StringBuilder();
		
		try {
			Connection conn = MySqlConn.getConnect();
			Statement statement = conn.createStatement();
			
			if(papername.equals("roll")) {
				String sql = "SELECT * FROM questions_wanxing ORDER BY RAND() LIMIT 1;";
				ResultSet resultSet = statement.executeQuery(sql);
				
				resultSet.next();
				paper.append(resultSet.getString(3)).append("#").append(resultSet.getString(4)).append("#");
				answer.append(resultSet.getString(5)+ "|")
					  .append(resultSet.getString(6)+ "|")
					  .append(resultSet.getString(7)+ "|")
					  .append(resultSet.getString(8)+ "|")
					  .append(resultSet.getString(9)+ "|")
					  .append(resultSet.getString(10)+ "|")
					  .append(resultSet.getString(11)+ "|")
					  .append(resultSet.getString(12)+ "|")
					  .append(resultSet.getString(13)+ "|")
					  .append(resultSet.getString(14)+ "|");
				
				sql = "SELECT * FROM questions_quickread ORDER BY RAND() LIMIT 1;";
				resultSet = statement.executeQuery(sql);
				
				resultSet.next();
				paper.append(resultSet.getString(3)).append("#").append(resultSet.getString(4)).append("#");
				answer.append(resultSet.getString(5)+ "|")
					  .append(resultSet.getString(6)+ "|")
					  .append(resultSet.getString(7)+ "|")
					  .append(resultSet.getString(8)+ "|")
					  .append(resultSet.getString(9)+ "|")
					  .append(resultSet.getString(10)+ "|")
					  .append(resultSet.getString(11)+ "|")
					  .append(resultSet.getString(12)+ "|")
					  .append(resultSet.getString(13)+ "|")
					  .append(resultSet.getString(14)+ "|");
				
				sql = "SELECT * FROM questions_carefulread ORDER BY RAND() LIMIT 1,2;";
				resultSet = statement.executeQuery(sql);
				resultSet.next();
				paper.append(resultSet.getString(3)).append("#").append(resultSet.getString(4)).append("#");
				answer.append(resultSet.getString(5)+ "|")
					  .append(resultSet.getString(6)+ "|")
					  .append(resultSet.getString(7)+ "|")
					  .append(resultSet.getString(8)+ "|")
					  .append(resultSet.getString(9)+ "|");
				resultSet.next();
				paper.append(resultSet.getString(3)).append("#").append(resultSet.getString(4)).append("#");
				answer.append(resultSet.getString(5)+ "|")
					  .append(resultSet.getString(6)+ "|")
					  .append(resultSet.getString(7)+ "|")
					  .append(resultSet.getString(8)+ "|")
					  .append(resultSet.getString(9));
			}else {
				String sql = "SELECT "+papername+" FROM papers LIMIT 1;";
				ResultSet resultSet = statement.executeQuery(sql);
				
				resultSet.next();
				String[] ids = {resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6)};
				
				sql = "SELECT * FROM questions_wanxing WHERE id = '"+ids[0]+"';";
				resultSet = statement.executeQuery(sql);
				resultSet.next();
				paper.append(resultSet.getString(3)).append("#").append(resultSet.getString(4)).append("#");
				answer.append(resultSet.getString(5)+ "|")
					  .append(resultSet.getString(6)+ "|")
					  .append(resultSet.getString(7)+ "|")
					  .append(resultSet.getString(8)+ "|")
					  .append(resultSet.getString(9)+ "|")
					  .append(resultSet.getString(10)+ "|")
					  .append(resultSet.getString(11)+ "|")
					  .append(resultSet.getString(12)+ "|")
					  .append(resultSet.getString(13)+ "|")
					  .append(resultSet.getString(14)+ "|");
				sql = "SELECT * FROM questions_quickread WHERE id = '"+ids[1]+"';";
				resultSet = statement.executeQuery(sql);
				resultSet.next();
				paper.append(resultSet.getString(3)).append("#").append(resultSet.getString(4)).append("#");
				answer.append(resultSet.getString(5)+ "|")
					  .append(resultSet.getString(6)+ "|")
					  .append(resultSet.getString(7)+ "|")
					  .append(resultSet.getString(8)+ "|")
					  .append(resultSet.getString(9)+ "|")
					  .append(resultSet.getString(10)+ "|")
					  .append(resultSet.getString(11)+ "|")
					  .append(resultSet.getString(12)+ "|")
					  .append(resultSet.getString(13)+ "|")
					  .append(resultSet.getString(14)+ "|");
				sql = "SELECT * FROM questions_carefulread WHERE id = '"+ids[2]+"';";
				resultSet = statement.executeQuery(sql);
				resultSet.next();
				paper.append(resultSet.getString(3)).append("#").append(resultSet.getString(4)).append("#");
				answer.append(resultSet.getString(5)+ "|")
					  .append(resultSet.getString(6)+ "|")
					  .append(resultSet.getString(7)+ "|")
					  .append(resultSet.getString(8)+ "|")
					  .append(resultSet.getString(9)+ "|");
				sql = "SELECT * FROM questions_carefulread WHERE id = '"+ids[3]+"';";
				resultSet = statement.executeQuery(sql);
				resultSet.next();
				paper.append(resultSet.getString(3)).append("#").append(resultSet.getString(4)).append("#");
				answer.append(resultSet.getString(5)+ "|")
					  .append(resultSet.getString(6)+ "|")
					  .append(resultSet.getString(7)+ "|")
					  .append(resultSet.getString(8)+ "|")
					  .append(resultSet.getString(9)+ "|");
				
				resultSet.close();
			}
			
		
		paper.append(answer);
		
		statement.close();
		conn.close();
		
	}catch(Exception e) {
		System.out.println(e);
	}
	return paper.toString();
	}
}
