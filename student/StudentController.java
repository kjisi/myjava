import java.util.Map;
import java.util.Map.Entry;
import java.util.Iterator;

public class StudentController{
	
	public static void main(String[] args)throws Exception{
		
		StudentService studentService = new StudentServiceImpl();
		
		/*
		1、测试查询学生所有成绩  studentService.queryAllScore();
		
			// 1、
			Map<String, Double> scores = studentService.queryAllScore();
		
			// 遍历map 输出成绩
			// 1、预定义临时变量
			Map.Entry<String, Double> entry;
			String nameAndClass = "";
			Double score = 0.0;
		
			Iterator<Entry<String,Double>> iter = scores.entrySet().iterator();
			while(iter.hasNext()){
			
			entry = iter.next();
			nameAndClass = entry.getKey();
			score = entry.getValue();
			
			System.out.println(nameAndClass +"的分数是："+ score);
			}
		*/
		
		/*
		2、测试查询学生的总成绩 
		*/
		Map<String, Double> totalScores = studentService.queryTotalScore();
		Map.Entry<String, Double> entry ;
		String student_name = "";
		Double score = 0.0;
		
		Iterator<Entry<String, Double>> iter = totalScores.entrySet().iterator();
		while(iter.hasNext()){
			
			entry = iter.next();
			student_name = entry.getKey();
			score = entry.getValue();
			
			System.out.println(student_name +" 的总成绩是："+ score);
			
		}
		

	}
	
}