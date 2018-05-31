package dbutil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.google.gson.Gson;

import model.Paper;
import model.Question;

public class MakePaper {
	private String papername;
	
	public MakePaper(String str) {
		this.papername = str;
	}
	
	public String doit(String type) {
		StringBuilder paper = new StringBuilder();
		
		try {
			Connection conn = MySqlConn.getConnect();
			Statement statement = conn.createStatement();
			
			if(papername.equals("roll")) {

				Paper newpaper = new Paper();
				Question temp_question = new Question();
				newpaper.setid(0);
				newpaper.settype(type);
				newpaper.setname("Ëæ»úÊÔ¾í");
				newpaper.setdatetime();
				
				//Ìî³äÄÚÈÝ----
				String sql = "SELECT * FROM questions_"+type+" WHERE type = 1 ORDER BY RAND() LIMIT 1;";
				ResultSet resultSet = statement.executeQuery(sql);
				resultSet.next();
				temp_question.setid(resultSet.getInt(1));
				temp_question.settype(resultSet.getInt(2));
				temp_question.setquestion(resultSet.getString(3));
				temp_question.setanswer(resultSet.getString(4));
				newpaper.setquestion_0(temp_question);
				
				sql = "SELECT * FROM questions_"+type+" WHERE type = 2 ORDER BY RAND() LIMIT 1;";
				resultSet = statement.executeQuery(sql);
				resultSet.next();
				temp_question.setid(resultSet.getInt(1));
				temp_question.settype(resultSet.getInt(2));
				temp_question.setquestion(resultSet.getString(3));
				temp_question.setanswer(resultSet.getString(4));
				newpaper.setquestion_1(temp_question);
				
				sql = "SELECT * FROM questions_"+type+" WHERE type = 3 ORDER BY RAND() LIMIT 1;";
				resultSet = statement.executeQuery(sql);
				resultSet.next();
				temp_question.setid(resultSet.getInt(1));
				temp_question.settype(resultSet.getInt(2));
				temp_question.setquestion(resultSet.getString(3));
				temp_question.setanswer(resultSet.getString(4));
				newpaper.setquestion_2(temp_question);
				
				sql = "SELECT * FROM questions_"+type+" WHERE type = 4 ORDER BY RAND() LIMIT 1;";
				resultSet = statement.executeQuery(sql);
				resultSet.next();
				temp_question.setid(resultSet.getInt(1));
				temp_question.settype(resultSet.getInt(2));
				temp_question.setquestion(resultSet.getString(3));
				temp_question.setanswer(resultSet.getString(4));
				newpaper.setquestion_3(temp_question);
				resultSet.close();
				//Ìî³äÄÚÈÝ----
				
				Gson gson = new Gson();
				String jsonpaper = gson.toJson(newpaper);
				
				paper.append(jsonpaper);
				System.out.println(jsonpaper);

			}else {
				String sql = "SELECT * FROM papers WHERE name = '"+papername+"';";
				ResultSet resultSet = statement.executeQuery(sql);
				resultSet.next();
				String[] ids = {resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),resultSet.getString(7)};
				
				Paper newpaper = new Paper();
				Question temp_question = new Question();
				newpaper.setid(resultSet.getInt(1));
				newpaper.settype(type);
				newpaper.setname(papername);
				newpaper.setdatetime();
				
				sql = "SELECT * FROM questions_"+type+" WHERE id = '"+ids[0]+"';";
				resultSet = statement.executeQuery(sql);
				resultSet.next();
				temp_question.setid(resultSet.getInt(1));
				temp_question.settype(resultSet.getInt(2));
				temp_question.setquestion(resultSet.getString(3));
				temp_question.setanswer(resultSet.getString(4));
				newpaper.setquestion_0(temp_question);
				
				sql = "SELECT * FROM questions_"+type+" WHERE id = '"+ids[1]+"';";
				resultSet = statement.executeQuery(sql);
				resultSet.next();
				temp_question.setid(resultSet.getInt(1));
				temp_question.settype(resultSet.getInt(2));
				temp_question.setquestion(resultSet.getString(3));
				temp_question.setanswer(resultSet.getString(4));
				newpaper.setquestion_1(temp_question);
				
				sql = "SELECT * FROM questions_"+type+" WHERE id = '"+ids[2]+"';";
				resultSet = statement.executeQuery(sql);
				resultSet.next();
				temp_question.setid(resultSet.getInt(1));
				temp_question.settype(resultSet.getInt(2));
				temp_question.setquestion(resultSet.getString(3));
				temp_question.setanswer(resultSet.getString(4));
				newpaper.setquestion_2(temp_question);
				
				sql = "SELECT * FROM questions_"+type+" WHERE id = '"+ids[3]+"';";
				resultSet = statement.executeQuery(sql);
				resultSet.next();
				temp_question.setid(resultSet.getInt(1));
				temp_question.settype(resultSet.getInt(2));
				temp_question.setquestion(resultSet.getString(3));
				temp_question.setanswer(resultSet.getString(4));
				newpaper.setquestion_3(temp_question);
				resultSet.close();
				
				Gson gson = new Gson();
				String jsonpaper = gson.toJson(newpaper);
				
				paper.append(jsonpaper);
				System.out.println(jsonpaper);
			}
			
		statement.close();
		conn.close();
		
	}catch(Exception e) {
		System.out.println(e);
	}
	return paper.toString();
	}
}
