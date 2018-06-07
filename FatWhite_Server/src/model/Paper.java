package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Paper {
	private int id;
	private String type;//这个是正常的type，表示cet4和其它xx的那个
	private String name;
	private String datetime;
	private Question question_0 = new Question();
	private Question question_1 = new Question();
	private Question question_2 = new Question();
	private Question question_3 = new Question();
	
	public void setid(int id) { this.id = id;}
	public int getid() {return id;}
	
	public void settype(String type) {this.type = type;}
	public String gettype () {return type;}
	
	public void setname(String name) {this.name = name;}
	public String getname () {return name;}
	
	public void setdatetime() {
		Date now = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");

		datetime = dateFormat.format( now ); 
		System.out.println(datetime); 
	}
	public String getdatatime() {return datetime;}
	
	public void setquestion_0(Question question) {
		this.question_0.setid(question.getid());
		this.question_0.settype(question.gettype());
		this.question_0.setquestion(question.getquestion());
		this.question_0.setanswer(question.getanswer());
	}
	public Question getquestion_0() {return question_0;}
	
	public void setquestion_1(Question question) {
		this.question_1.setid(question.getid());
		this.question_1.settype(question.gettype());
		this.question_1.setquestion(question.getquestion());
		this.question_1.setanswer(question.getanswer());
	}
	public Question getquestion_1() {return question_1;}
	
	public void setquestion_2(Question question) {
		this.question_2.setid(question.getid());
		this.question_2.settype(question.gettype());
		this.question_2.setquestion(question.getquestion());
		this.question_2.setanswer(question.getanswer());
	}
	public Question getquestion_2() {return question_2;}
	
	public void setquestion_3(Question question) {
		this.question_3.setid(question.getid());
		this.question_3.settype(question.gettype());
		this.question_3.setquestion(question.getquestion());
		this.question_3.setanswer(question.getanswer());
	}
	public Question getquestion_3() {return question_3;}
}
