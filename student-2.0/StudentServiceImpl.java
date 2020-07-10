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
	*	1、查询所有学生的成绩
	*
	*/
	@Override
	public Map<String, Double> allScore()throws Exception{
		
		// 1、调用 studentDao 查询所有学生的成绩
		List<Student> students = studentDao.findAll();
		
		// 2、取出所有学生成绩
		Map<String, Double> scores = new LinkedHashMap<String, Double>();
		// Student student = new Student();
		
		// 3、使用Stream流遍历List
		students.stream().forEach( streamStudent -> scores.put(streamStudent.getStudent_name() + "," + streamStudent.getClass_name(),streamStudent.getScore()));
		
		return scores;
	}
	
	/**
	*	2、查询学生的总成绩
	*
	*/
	@Override
	public Map<String, Double> totalScore()throws Exception{
		Map<String, Double> totalScores = studentDao.findTotalScore();
		return totalScores;
	}
	
	/**
	*	3、查询学生的总成绩中的最高分
	*
	*/
	@Override
	public String maxTotalScore()throws Exception{
		Map<String, Double> totalScores = studentDao.findTotalScore();
		
		// Stream流获取总分最高分的值
		Double max = totalScores.values().stream()
		.max(Comparator.naturalOrder()).get();
		
		// 使用stream流获取最高成绩学生 的信息
		List<String> names = totalScores.entrySet().stream()
		.filter(entry -> entry.getValue() == max)
		.map(Map.Entry::getKey)
		.collect(Collectors.toList()) ;

		return  "总分最高的学生是：" + names.get(0) + "， 他的总分是：" + max;
	}
	
	/**
	*	4、查询总分的平均分
	*/
	@Override
	public Double averageTotalScoreWithEnds(boolean bool)throws Exception{
		Map<String, Double> totalScores = studentDao.findTotalScore();
		
		// Stream流获取总分的数组
		Double[] scores = totalScores.values().stream().toArray(Double[]::new);
		
		Double result =  mean.queryMeanWithEnds(scores,bool);
		return result ;
	}
	
	/**
	*	5、查询各学科的总分
	*/
	@Override
	public Map<String, Double> classTotalScore()throws Exception{
		Map<String, Double> classTotalScores =  studentDao.findClassTotalScore();
		
		return classTotalScores;
		
	}
	
	/**
	*	6、查询各学科的最高分
	*/
	@Override
	public String maxClassTotalScore()throws Exception{
		
		Map<String, Double> classTotalScores = studentDao.findClassTotalScore();
		
		// Stream流，查询总分最大值
		Double maxScore = classTotalScores.values().stream()
		.max(Comparator.naturalOrder()).get();
		
		// Stream流，获取总分最高学科名的集合
		List<String> names = classTotalScores.entrySet().stream()
		.filter(entry -> entry.getValue() == maxScore)
		.map(Map.Entry::getKey)
		.collect(Collectors.toList());

		return  "总分最高的学科是：" + names.get(0) + "，他的总分是：" + maxScore;
	}
	
	/**
	*	7、查询各学科总分的平均分
	*/
	@Override
	public Double averageClassTotalScoreWithEnds(boolean bool)throws Exception{
		
		Map<String, Double> classTotalScores = studentDao.findClassTotalScore();
		
		Double[] scoresArray = classTotalScores.values().stream().toArray(Double[]::new);
		
		Double averageClassTotalScore =  mean.queryMeanWithEnds(scoresArray,bool);
		return averageClassTotalScore ;
	}
	
	/**
	*	8、根据课程名查询成绩
	*/
	@Override
	public Map<String, Double> classScore(String className)throws Exception{
		// 1、调用 studentDao 查询所有学生的成绩
		List<Student> students = studentDao.findByClassName(className);
		
		// Stream流，取学生信息，存放到map中
		Map<String, Double> scores = new LinkedHashMap<String, Double>();
		students.stream().forEach(student -> {
			scores.put(student.getStudent_name() + "," + student.getClass_name(), student.getScore()); 
		});
		
		return scores;
	}
	
	/**
	*	9、查询单科最高分
	*/
	@Override
	public String maxClassScore(String className) throws Exception{
		
		List<Student> students = studentDao.findByClassName(className);
		
		// Stream 取student 对象，分数的最大值
		Double maxScore = students.stream().map(student -> student.getScore()).max(Comparator.naturalOrder()).get();
		// Stream流，取最大分数对应的student 的集合
		List<Student> maxStudent = students.stream().filter(student -> student.getScore() == maxScore).collect(Collectors.toList());
	
		return className + "成绩最好的学生是：" + maxStudent.get(0).getStudent_name() + "， 他的分数是：" + maxScore;	
		
		
	}
	
	/**
	*	10、查询单科平均分
	*/
	@Override
	public Double averageClassScoreWithEnds(String className, boolean bool) throws Exception{
		List<Student> students = studentDao.findByClassName(className);
		
		// Stream流取 某个属性的数组
		Double[] scores = students.stream().map(student -> student.getScore()).toArray(Double[]::new);
		
		return mean.queryMeanWithEnds(scores,bool);
	}
	
	/**
	*	11、查询指定学生的成绩
	*/
	@Override
	public Map<String, Double> studentScore(String studentName) throws Exception{
		List<Student> students = studentDao.findByStudentName(studentName);
		
		// Stream流，取学生信息，存放到map中
		Map<String, Double> scores = new LinkedHashMap<String, Double>();
		students.stream().forEach(student -> {
			scores.put(student.getStudent_name() + "," + student.getClass_name(), student.getScore()); 
		});
		
		return scores;
	}
	
	/**
	*	12、查询指定学生的成绩最好的科目
	*/
	@Override
	public String maxStudentScore(String studentName) throws Exception{
		List<Student> students = studentDao.findByStudentName(studentName);
		
		// Stream流获取学生的最高分
		Double maxScore = students.stream().map(student -> student.getScore()).max(Comparator.naturalOrder()).get();
		List<Student> maxStudent = students.stream().filter(student -> student.getScore() == maxScore).collect(Collectors.toList());
		
		return studentName + "成绩最好科目是：" + maxStudent.get(0).getClass_name() + "， 他的分数是：" + maxScore;	
	}	
	
	/**
	*	13、查询单个学生的平均成绩
	*/
	public Double averageStudentScoreWithEnds(String studentName, boolean bool) throws Exception{
		List<Student> students = studentDao. findByStudentName(studentName);

		// Stream流获取某个属性的数组 
		Double[] scores = students.stream().map(student -> student.getScore()).toArray(Double[]::new);
		
		return mean.queryMeanWithEnds(scores,bool);
	}	
	
	
}