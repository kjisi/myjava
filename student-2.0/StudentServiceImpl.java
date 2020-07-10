import java.util.Map;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.Collections;
import java.util.Iterator;
import java.util.Comparator;
import java.util.stream.Collectors;


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
		// Student student = new Student();
		
		// 3��ʹ��Stream������List
		students.stream().forEach( streamStudent -> scores.put(streamStudent.getStudent_name() + "," + streamStudent.getClass_name(),streamStudent.getScore()));
		
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
		
		// Stream����ȡ�ܷ���߷ֵ�ֵ
		Double max = totalScores.values().stream()
		.max(Comparator.naturalOrder()).get();
		
		// ʹ��stream����ȡ��߳ɼ�ѧ�� ����Ϣ
		List<String> names = totalScores.entrySet().stream()
		.filter(entry -> entry.getValue() == max)
		.map(Map.Entry::getKey)
		.collect(Collectors.toList()) ;

		return  "�ܷ���ߵ�ѧ���ǣ�" + names.get(0) + "�� �����ܷ��ǣ�" + max;
	}
	
	/**
	*	4����ѯ�ֵܷ�ƽ����
	*/
	@Override
	public Double averageTotalScoreWithEnds(boolean bool)throws Exception{
		Map<String, Double> totalScores = studentDao.findTotalScore();
		
		// Stream����ȡ�ֵܷ�����
		Double[] scores = totalScores.values().stream().toArray(Double[]::new);
		
		Double result =  mean.queryMeanWithEnds(scores,bool);
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
		
		// Stream������ѯ�ܷ����ֵ
		Double maxScore = classTotalScores.values().stream()
		.max(Comparator.naturalOrder()).get();
		
		// Stream������ȡ�ܷ����ѧ�����ļ���
		List<String> names = classTotalScores.entrySet().stream()
		.filter(entry -> entry.getValue() == maxScore)
		.map(Map.Entry::getKey)
		.collect(Collectors.toList());

		return  "�ܷ���ߵ�ѧ���ǣ�" + names.get(0) + "�������ܷ��ǣ�" + maxScore;
	}
	
	/**
	*	7����ѯ��ѧ���ֵܷ�ƽ����
	*/
	@Override
	public Double averageClassTotalScoreWithEnds(boolean bool)throws Exception{
		
		Map<String, Double> classTotalScores = studentDao.findClassTotalScore();
		
		Double[] scoresArray = classTotalScores.values().stream().toArray(Double[]::new);
		
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
		
		// Stream����ȡѧ����Ϣ����ŵ�map��
		Map<String, Double> scores = new LinkedHashMap<String, Double>();
		students.stream().forEach(student -> {
			scores.put(student.getStudent_name() + "," + student.getClass_name(), student.getScore()); 
		});
		
		return scores;
	}
	
	/**
	*	9����ѯ������߷�
	*/
	@Override
	public String maxClassScore(String className) throws Exception{
		
		List<Student> students = studentDao.findByClassName(className);
		
		// Stream ȡstudent ���󣬷��������ֵ
		Double maxScore = students.stream().map(student -> student.getScore()).max(Comparator.naturalOrder()).get();
		// Stream����ȡ��������Ӧ��student �ļ���
		List<Student> maxStudent = students.stream().filter(student -> student.getScore() == maxScore).collect(Collectors.toList());
	
		return className + "�ɼ���õ�ѧ���ǣ�" + maxStudent.get(0).getStudent_name() + "�� ���ķ����ǣ�" + maxScore;	
		
		
	}
	
	/**
	*	10����ѯ����ƽ����
	*/
	@Override
	public Double averageClassScoreWithEnds(String className, boolean bool) throws Exception{
		List<Student> students = studentDao.findByClassName(className);
		
		// Stream��ȡ ĳ�����Ե�����
		Double[] scores = students.stream().map(student -> student.getScore()).toArray(Double[]::new);
		
		return mean.queryMeanWithEnds(scores,bool);
	}
	
	/**
	*	11����ѯָ��ѧ���ĳɼ�
	*/
	@Override
	public Map<String, Double> studentScore(String studentName) throws Exception{
		List<Student> students = studentDao.findByStudentName(studentName);
		
		// Stream����ȡѧ����Ϣ����ŵ�map��
		Map<String, Double> scores = new LinkedHashMap<String, Double>();
		students.stream().forEach(student -> {
			scores.put(student.getStudent_name() + "," + student.getClass_name(), student.getScore()); 
		});
		
		return scores;
	}
	
	/**
	*	12����ѯָ��ѧ���ĳɼ���õĿ�Ŀ
	*/
	@Override
	public String maxStudentScore(String studentName) throws Exception{
		List<Student> students = studentDao.findByStudentName(studentName);
		
		// Stream����ȡѧ������߷�
		Double maxScore = students.stream().map(student -> student.getScore()).max(Comparator.naturalOrder()).get();
		List<Student> maxStudent = students.stream().filter(student -> student.getScore() == maxScore).collect(Collectors.toList());
		
		return studentName + "�ɼ���ÿ�Ŀ�ǣ�" + maxStudent.get(0).getClass_name() + "�� ���ķ����ǣ�" + maxScore;	
	}	
	
	/**
	*	13����ѯ����ѧ����ƽ���ɼ�
	*/
	public Double averageStudentScoreWithEnds(String studentName, boolean bool) throws Exception{
		List<Student> students = studentDao. findByStudentName(studentName);

		// Stream����ȡĳ�����Ե����� 
		Double[] scores = students.stream().map(student -> student.getScore()).toArray(Double[]::new);
		
		return mean.queryMeanWithEnds(scores,bool);
	}	
	
	
}