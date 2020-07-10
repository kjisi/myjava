import java.util.Map;
import java.util.Map.Entry;
import java.util.Iterator;

/**
* 	��������ڵ���StudentService �ܵķ��������Գ�������	
*/
public class StudentController{
		
	private StudentService studentService = new StudentServiceImpl();

	//1�����Բ�ѯѧ�����гɼ� 
	public void findAll()throws Exception{
		Map<String, Double> scores = studentService.allScore();
	
		// ��ӡ�����е�����
		scores.entrySet().stream().forEach(System.out::println);
	}
	
	// 2�����Բ�ѯѧ�����ܳɼ� 
	public void totalScore()throws Exception{
		Map<String, Double> totalScores = studentService.totalScore();
		
		// ��ӡ�����е�����
		totalScores.entrySet().stream().forEach(System.out::println);
	}
	
	//	3�����Բ�ѯѧ���ܳɼ�����߳ɼ�
	public void maxScores()throws Exception{
		String maxScores = studentService.maxTotalScore();
		System.out.println(maxScores);
	}
	
	//4�����Բ�ѯѧ���ܳɼ���ƽ���ɼ�
	public void averageScore(boolean bool)throws Exception{
		Double averageScore= studentService.averageTotalScoreWithEnds(bool);
		System.out.println("�ֵܷ�ƽ�����ǣ�" + averageScore);
	}
	
	// 5����ѯѧ��ѧ�����гɼ�  studentService.allScore();
	
	public void classScore(String className)throws Exception{
		Map<String, Double> scores = studentService.classScore(className);
		// ��ӡ�����е�����
		scores.entrySet().stream().forEach(System.out::println);
	}
	
	//6����ѯѧ�Ƶ��ܳɼ� 
	public void classTotalScores()throws Exception{
		Map<String, Double> classTotalScores = studentService.classTotalScore();
	
		// ��ӡ�����е�����
		classTotalScores.entrySet().stream().forEach(System.out::println);
	}
	
	// 7�����Բ�ѯѧ����߳ɼ�
	public void maxClassTotalScore()throws Exception{
		String maxClassTotalScore = studentService.maxClassTotalScore();
		System.out.println(maxClassTotalScore);
	}
	
	// 8�����Բ�ѯ��ѧ���ֵܷ�ƽ����
	public void averageClassTotalScore(boolean bool)throws Exception{
		Double averageClassTotalScore = studentService.averageClassTotalScoreWithEnds(bool);
		System.out.println("��ѧ���ֵܷ�ƽ�����ǣ�" + averageClassTotalScore);
	}

	
	// 9������ ����ѧ�Ʋ�ѯ����ѧ�Ƴɼ���ߵ�ѧ��
		public void maxClassScore(String className)throws Exception{
		String maxClassScore = studentService.maxClassScore(className);
		System.out.println(maxClassScore);
	}
	
	// 10������ ��ѯѧ��ƽ���ɼ�	
	public void averageClassScoreWithEnds(String className, boolean bool)throws Exception{
		Double averageClassScore = studentService.averageClassScoreWithEnds(className,bool);
		System.out.println(className + "��ƽ�����ǣ�" + averageClassScore);
	}
	
	// 11������ ����ѧ��������ѯѧ���ɼ�
	
	public void studentScore(String studentName)throws Exception{
		Map<String, Double> studentScores = studentService.studentScore(studentName);
		
		// ��ӡ�����е�����
		studentScores.entrySet().stream().forEach(System.out::println);
	}
	
	// 12������ ��ѯѧ������߷�
	public void maxStudentScore(String studentName)throws Exception{
		String maxStudentScore = studentService.maxStudentScore(studentName);
		System.out.println(maxStudentScore);
	}
	
	// 13�� ���Բ�ѯѧ����ƽ���ɼ�
	public void averageStudentScoreWithEnds(String studentName, boolean bool)throws Exception{
		Double averageStudentScore = studentService.averageStudentScoreWithEnds(studentName, bool);
		System.out.println(studentName + "��ƽ�����ǣ�" + averageStudentScore );
	}
	
}