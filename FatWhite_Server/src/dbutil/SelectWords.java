package dbutil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.Word;

public class SelectWords {
	private ArrayList<Word> wordList = new ArrayList<Word>();
	private String tablename = null;
	Connection conn	= null;

	public SelectWords(String str) {
		this.tablename = str;
	}
	
	public void doSelect(){
		System.out.println("读取数据。。。。");
		String sql = "SELECT * FROM "+tablename+";";//SQL语句
		
		try {
			conn = MySqlConn.getConnect();
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()) {
				Word word = new Word();
				String tempstr = resultSet.getString(1);
				word.set_word(tempstr);
				System.out.println(tempstr);
				tempstr = resultSet.getString(2);
				word.set_soundmark(tempstr);
				tempstr = resultSet.getString(3);
				word.set_translation(tempstr);
				tempstr = resultSet.getString(4);
				word.set_sentence(tempstr);
				int tempint = resultSet.getInt(5);
				word.set_importance(tempint);
				
				wordList.add(word);
			}
			
			resultSet.close();
			statement.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println(e);
		}
		
		System.out.println("读取完成。。。");
	}
	
	public String setResponse() {
		System.out.println("准备传输数据。。。");
		StringBuilder response = new StringBuilder();
		int flag = wordList.size();
		int i = 0;
		
		for (i = 0; i < flag; i++) {
			String temp = wordList.get(i).get_word() + "|" +
					      wordList.get(i).get_soundmark() + "|" +
					      wordList.get(i).get_translation() + "|" +
					      wordList.get(i).get_sentence() + "|" +
					      Integer.toString(wordList.get(i).get_importance()) + "#";
//			System.out.println(temp);
			response.append(temp);
		}
		
		return response.toString();
	}
}
