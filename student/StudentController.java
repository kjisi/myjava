import java.util.Map;
import java.util.Map.Entry;
import java.util.Iterator;

public class StudentController{
	
	public static void main(String[] args)throws Exception{
		
		StudentService studentService = new StudentServiceImpl();
		
		/*
		1�����Բ�ѯѧ�����гɼ�  studentService.queryAllScore();
		
			// 1��
			Map<String, Double> scores = studentService.queryAllScore();
		
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
		*/
		
		/*
		2�����Բ�ѯѧ�����ܳɼ� 
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
			
			System.out.println(student_name +" ���ܳɼ��ǣ�"+ score);
			
		}
		

	}
	
}