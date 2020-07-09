import java.util.Map;
import java.util.Map.Entry;
import java.util.Iterator;

public class StudentController{
	
	public static void main(String[] args)throws Exception{
		
		StudentService studentService = new StudentServiceImpl();
		
		Map<String, Double> scores = studentService.queryStudentScore();
		
		// ����map ����ɼ�
		// 1��Ԥ������ʱ����
		Map.Entry<String, Double> entry;
		String nameAndClass = "";
		Double score = 0.0;
		
		Iterator<Entry<String,Double>> iter = scores.entrySet().iterator();
		while(iter.hasNext()){
			
			entry = iter.next();
			nameAndClass = entry.getKey();
			score = entry.getValue();
			
			System.out.println(nameAndClass +"�ķ����ǣ�"+ score);
		}

	}
	
}