import java.util.Map;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.Collections;
import java.util.Iterator;


public class StudentServiceImpl implements StudentService{
	
	private StudentDao studentDao = new StudentDaoImpl();
	private Mean mean = new MeanImpl();
	
	/**
	*	1����ѯ����ѧ���ĳɼ�
	*
	*/
	@Override
	public Map<String, Double> allScore()throws Exception{
		
		// 1������ studentDao ��ѯ����ѧ���ĳɼ�
		List<Student> students = studentDao.findAll();
		
		// 2��ȡ������ѧ���ɼ�
		Map<String, Double> scores = new LinkedHashMap<String, Double>();
		Student student = new Student();
		
		for(int i = 0; i < students.size(); i++){
			
			student = students.get(i);
			
			String nameAndClass = student.getStudent_name() + "," + student.getClass_name();
			scores.put(nameAndClass, student.getScore());
		}
		return scores;
	}
	
	/**
	*	2����ѯѧ�����ܳɼ�
	*
	*/
	@Override
	public Map<String, Double> totalScore()throws Exception{
		Map<String, Double> totalScores = studentDao.findTotalScore();
		return totalScores;
	}
	
	/**
	*	3����ѯѧ�����ܳɼ��е���߷�
	*
	*/
	@Override
	public String maxTotalScore()throws Exception{
		Map<String, Double> totalScores = studentDao.findTotalScore();
		
		// ȡ��entry ���бȽ�
		Map.Entry<String, Double> entry;
		String name = ""; // ���ڴ����߷�ѧ��������
		Double score = 0.0; // ���ڴ����߷�ѧ���ķ���
		
		Iterator<Entry<String, Double>> iter = totalScores.entrySet().iterator();
		while(iter.hasNext()){
			entry = iter.next();
			System.out.println(entry);

			// ���ֵ�Ƚ�
			if(score < entry.getValue() ){
			name = entry.getKey();
			score = entry.getValue();
			}
		}
		return  "�ܷ���ߵ�ѧ���ǣ�" + name + "�� �����ܷ��ǣ�" + score;
	}
	
	/**
	*	4����ѯ�ֵܷ�ƽ����
	*/
	@Override
	public Double averageTotalScoreWithEnds(boolean bool)throws Exception{
		Map<String, Double> totalScores = studentDao.findTotalScore();
		
		// ȡ��entry ����ܳɼ������飬����Mean ��ƽ��ֵ
		List<Double> scores = new ArrayList<Double>(); // ���ڴ�ųɼ�
		Map.Entry<String, Double> entry;
		Iterator<Entry<String, Double>> iter = totalScores.entrySet().iterator();
		while(iter.hasNext()){
			entry = iter.next();
			scores.add( entry.getValue());
		}
		
		Double[] scoresArray = new Double[scores.size()];
		scores.toArray(scoresArray);
		
		Double result =  mean.queryMeanWithEnds(scoresArray,bool);
		return result ;
	}
	
	/**
	*	5����ѯ��ѧ�Ƶ��ܷ�
	*/
	@Override
	public Map<String, Double> classTotalScore()throws Exception{
		Map<String, Double> classTotalScores =  studentDao.findClassTotalScore();
		
		return classTotalScores;
		
	}
	
	/**
	*	6����ѯ��ѧ�Ƶ���߷�
	*/
	@Override
	public String maxClassTotalScore()throws Exception{
		
		Map<String, Double> classTotalScores = studentDao.findClassTotalScore();
		
		// ȡ��entry ���бȽ�
		Map.Entry<String, Double> entry;
		String class_name = ""; // ���ڴ����߷�ѧ��������
		Double score = 0.0; // ���ڴ����߷�ѧ���ķ���
		
		Iterator<Entry<String, Double>> iter = classTotalScores.entrySet().iterator();
		while(iter.hasNext()){
			entry = iter.next();
			System.out.println(entry);

			// ���ֵ�Ƚ�
			if(score < entry.getValue() ){
			class_name = entry.getKey();
			score = entry.getValue();
			}
		}
		return  "�ܷ���ߵ�ѧ���ǣ�" + class_name + "�� �����ܷ��ǣ�" + score;
	}
	
	/**
	*	7����ѯ��ѧ���ֵܷ�ƽ����
	*/
	@Override
	public Double averageClassTotalScoreWithEnds(boolean bool)throws Exception{
		
		Map<String, Double> classTotalScores = studentDao.findClassTotalScore();
		
		// ȡ��entry ����ܳɼ������飬����Mean ��ƽ��ֵ
		List<Double> scores = new ArrayList<Double>(); // ���ڴ�ųɼ�
		Map.Entry<String, Double> entry;
		Iterator<Entry<String, Double>> iter = classTotalScores.entrySet().iterator();
		while(iter.hasNext()){
			entry = iter.next();
			scores.add( entry.getValue());
		}
		
		Double[] scoresArray = new Double[scores.size()];
		scores.toArray(scoresArray);
		
		Double averageClassTotalScore =  mean.queryMeanWithEnds(scoresArray,bool);
		return averageClassTotalScore ;

	}
	
	/**
	*	8�����ݿγ�����ѯ�ɼ�
	*/
	@Override
	public Map<String, Double> classScore(String className)throws Exception{
		// 1������ studentDao ��ѯ����ѧ���ĳɼ�
		List<Student> students = studentDao.findByClassName(className);
		
		// 2��ȡ������ѧ���ɼ�
		Map<String, Double> scores = new LinkedHashMap<String, Double>();
		Student student = new Student();
		
		for(int i = 0; i < students.size(); i++){
			
			student = students.get(i);
			
			String nameAndClass = student.getStudent_name() + "," + student.getClass_name();
			scores.put(nameAndClass, student.getScore());
		}
		return scores;
	}
	
	/**
	*	9����ѯ������߷�
	*/
	@Override
	public String maxClassScore(String className) throws Exception{
		
		List<Student> students = studentDao.findByClassName(className);
		
		// �������ϲ�����߷ֵ�ѧ��
		Student maxStudent = new Student();
		maxStudent.setScore(0.0);
		Student student = new Student(); // ���ڴ����߷�ѧ������Ϣ

		Iterator<Student> iter = students.iterator();
		while(iter.hasNext()){
			student = iter.next();
			
			// ���ֵ�Ƚ�
			if(maxStudent.getScore() < student.getScore() ){
			maxStudent = student;
			}
		}
		return className + "�ɼ���õ�ѧ���ǣ�" + maxStudent.getStudent_name() + "�� ���ķ����ǣ�" + maxStudent.getScore();	
		
		
	}
	
	/**
	*	10����ѯ����ƽ����
	*/
	@Override
	public Double averageClassScoreWithEnds(String className, boolean bool) throws Exception{
		List<Student> students = studentDao.findByClassName(className);
		
		List<Double> scores = new ArrayList<Double>();
		Iterator<Student> iter = students.iterator();
		Student student ;
		Double sum = 0.0;
		while(iter.hasNext()){
			student = iter.next();
			scores.add( student.getScore());
		}
		
		Double[] scoresArray = new Double[scores.size()];
		scores.toArray(scoresArray);
		
		return mean.queryMeanWithEnds(scoresArray,bool);

	}
	
	/**
	*	11����ѯָ��ѧ���ĳɼ�
	*/
	@Override
	public Map<String, Double> studentScore(String studentName) throws Exception{
		List<Student> students = studentDao.findByStudentName(studentName);
		
		Map<String, Double> scores = new LinkedHashMap<String, Double>();
		Student student = new Student();
		
		Iterator<Student> iter = students.iterator();
		while(iter.hasNext()){
			student = iter.next();
			
			scores.put(student.getStudent_name() + "," + student.getClass_name(), student.getScore());
		}
		return scores;
	}
	
	/**
	*	12����ѯָ��ѧ���ĳɼ�
	*/
	@Override
	public String maxStudentScore(String studentName) throws Exception{
		List<Student> students = studentDao.findByStudentName(studentName);
		
		// �������ϲ�����߷ֵ�ѧ��
		Student maxStudent = new Student();
		maxStudent.setScore(0.0);
		Student student = new Student(); // ���ڴ����߷�ѧ������Ϣ

		Iterator<Student> iter = students.iterator();
		while(iter.hasNext()){
			student = iter.next();
			
			// ���ֵ�Ƚ�
			if(maxStudent.getScore() < student.getScore() ){
			maxStudent = student;
			}
		}
		return studentName + "�ɼ���ÿ�Ŀ�ǣ�" + maxStudent.getClass_name() + "�� ���ķ����ǣ�" + maxStudent.getScore();	
	}	
	
	/**
	*	13����ѯ����ѧ����ƽ���ɼ�
	*/
	public Double averageStudentScoreWithEnds(String studentName, boolean bool) throws Exception{
		List<Student> students = studentDao. findByStudentName(studentName);
		
		List<Double> scores = new ArrayList<Double>();
		Student student ;
		
		Iterator<Student> iter = students.iterator();
		while(iter.hasNext()){
			student = iter.next();
			
			scores.add(student.getScore());
		}
		
		Double[] scoresArray = new Double[scores.size()];
		scores.toArray(scoresArray);
		
		return mean.queryMeanWithEnds(scoresArray,bool);
	}	
	
	
}