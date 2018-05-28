package dbutil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class MakePaper {
	private String papername;
	
	public MakePaper(String str) {
		this.papername = str;
	}
	
	public String doit(String type) {
		StringBuilder paper = new StringBuilder();
		StringBuilder answer = new StringBuilder();
		
		try {
			Connection conn = MySqlConn.getConnect();
			Statement statement = conn.createStatement();
			
			if(papername.equals("roll")) {
				String sql = "SELECT * FROM questions_"+type+" WHERE type = 1 ORDER BY RAND() LIMIT 1;";
				ResultSet resultSet = statement.executeQuery(sql);
				
				resultSet.next();
				paper.append(resultSet.getString(3)).append("#");
				answer.append(resultSet.getString(4)+ "#");
				
				sql = "SELECT * FROM questions_"+type+" WHERE type = 2 ORDER BY RAND() LIMIT 1;";
				resultSet = statement.executeQuery(sql);
				
				resultSet.next();
				paper.append(resultSet.getString(3)).append("#");
				answer.append(resultSet.getString(4)+ "#");
				
				sql = "SELECT * FROM questions_"+type+" WHERE type = 3 ORDER BY RAND() LIMIT 1;";
				resultSet = statement.executeQuery(sql);
				
				resultSet.next();
				paper.append(resultSet.getString(3)).append("#");
				answer.append(resultSet.getString(4)+ "#");
				
				sql = "SELECT * FROM questions_"+type+" WHERE type = 4 ORDER BY RAND() LIMIT 1;";
				resultSet = statement.executeQuery(sql);
				
				resultSet.next();
				paper.append(resultSet.getString(3)).append("#");
				answer.append(resultSet.getString(4));
			}else {
				String sql = "SELECT * FROM papers WHERE name = '"+papername+"';";
				ResultSet resultSet = statement.executeQuery(sql);
				
				resultSet.next();
				String[] ids = {resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),resultSet.getString(7)};
				
				sql = "SELECT * FROM questions_"+type+" WHERE id = '"+ids[0]+"';";
				resultSet = statement.executeQuery(sql);
				resultSet.next();
				paper.append(resultSet.getString(3)).append("#");
				answer.append(resultSet.getString(4)+ "#");
				
				sql = "SELECT * FROM questions_"+type+" WHERE id = '"+ids[1]+"';";
				resultSet = statement.executeQuery(sql);
				resultSet.next();
				paper.append(resultSet.getString(3)).append("#");
				answer.append(resultSet.getString(4)+ "#");
				
				sql = "SELECT * FROM questions_"+type+" WHERE id = '"+ids[2]+"';";
				resultSet = statement.executeQuery(sql);
				resultSet.next();
				paper.append(resultSet.getString(3)).append("#");
				answer.append(resultSet.getString(4)+ "#");
				
				sql = "SELECT * FROM questions_"+type+" WHERE id = '"+ids[3]+"';";
				resultSet = statement.executeQuery(sql);
				resultSet.next();
				paper.append(resultSet.getString(3)).append("#");
				answer.append(resultSet.getString(4));
				
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
