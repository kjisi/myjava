public class Student{
	
	private Integer student_id;
	private String student_name;
	private String class_name;
	private Double score;
	
	// 无参构造
	public Student(){}
	
	// 全参构造
	public Student(Integer student_id, String student_name, String class_name, Double score){
		this.student_id = student_id;
		this.student_name = student_name;
		this.class_name = class_name;
		this.score = score;
	}
	
	public Integer getStudent_id(){
		return student_id;
	}
	
	public String getStudent_name(){
		return student_name;
	}
	
	public String getClass_name(){
		return class_name;
	}
	
	public Double getScore(){
		return score;
	}
	
	public void setStudent_id(Integer student_id){
		this.student_id = student_id;
	}
	
	public void setStudent_name(String student_name){
		this.student_name = student_name;
	}
	
	public void setClass_name(String class_name){
		this.class_name = class_name;
	}
	
	public void setScore(Double score){
		this.score = score;
	}
	
	// 重写toString 方法
	public String toString(){
		return "Student{ " + 
		"student_id: " + student_id + 
		",student_name: " + student_name + 
		", class_name: " + class_name + 
		", score: " + score + 
		"}";
	}
}