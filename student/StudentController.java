import java.util.Map;
import java.util.Map.Entry;
import java.util.Iterator;

public class StudentController{
	
	public static void main(String[] args)throws Exception{
		
		StudentService studentService = new StudentServiceImpl();
		
		Map<String, Double> scores = studentService.queryStudentScore();
		
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

	}
	
}