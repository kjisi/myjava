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
	*	1、查询所有学生的成绩
	*
	*/
	@Override
	public Map<String, Double> allScore()throws Exception{
		
		// 1、调用 studentDao 查询所有学生的成绩
		List<Student> students = studentDao.findAll();
		
		// 2、取出所有学生成绩
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
		
		// 取出entry 进行比较
		Map.Entry<String, Double> entry;
		String name = ""; // 用于存放最高分学生的姓名
		Double score = 0.0; // 用于存放最高分学生的分数
		
		Iterator<Entry<String, Double>> iter = totalScores.entrySet().iterator();
		while(iter.hasNext()){
			entry = iter.next();
			System.out.println(entry);

			// 最大值比较
			if(score < entry.getValue() ){
			name = entry.getKey();
			score = entry.getValue();
			}
		}
		return  "总分最高的学生是：" + name + "， 他的总分是：" + score;
	}
	
	/**
	*	4、查询总分的平均分
	*/
	@Override
	public Double averageTotalScoreWithEnds(boolean bool)throws Exception{
		Map<String, Double> totalScores = studentDao.findTotalScore();
		
		// 取出entry 获得总成绩的数组，调用Mean 求平均值
		List<Double> scores = new ArrayList<Double>(); // 用于存放成绩
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
		
		// 取出entry 进行比较
		Map.Entry<String, Double> entry;
		String class_name = ""; // 用于存放最高分学生的姓名
		Double score = 0.0; // 用于存放最高分学生的分数
		
		Iterator<Entry<String, Double>> iter = classTotalScores.entrySet().iterator();
		while(iter.hasNext()){
			entry = iter.next();
			System.out.println(entry);

			// 最大值比较
			if(score < entry.getValue() ){
			class_name = entry.getKey();
			score = entry.getValue();
			}
		}
		return  "总分最高的学科是：" + class_name + "， 他的总分是：" + score;
	}
	
	/**
	*	7、查询各学科总分的平均分
	*/
	@Override
	public Double averageClassTotalScoreWithEnds(boolean bool)throws Exception{
		
		Map<String, Double> classTotalScores = studentDao.findClassTotalScore();
		
		// 取出entry 获得总成绩的数组，调用Mean 求平均值
		List<Double> scores = new ArrayList<Double>(); // 用于存放成绩
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
	*	8、根据课程名查询成绩
	*/
	@Override
	public Map<String, Double> classScore(String className)throws Exception{
		// 1、调用 studentDao 查询所有学生的成绩
		List<Student> students = studentDao.findByClassName(className);
		
		// 2、取出所有学生成绩
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
	*	9、查询单科最高分
	*/
	@Override
	public String maxClassScore(String className) throws Exception{
		
		List<Student> students = studentDao.findByClassName(className);
		
		// 遍历集合查找最高分的学生
		Student maxStudent = new Student();
		maxStudent.setScore(0.0);
		Student student = new Student(); // 用于存放最高分学生的信息

		Iterator<Student> iter = students.iterator();
		while(iter.hasNext()){
			student = iter.next();
			
			// 最大值比较
			if(maxStudent.getScore() < student.getScore() ){
			maxStudent = student;
			}
		}
		return className + "成绩最好的学生是：" + maxStudent.getStudent_name() + "， 他的分数是：" + maxStudent.getScore();	
		
		
	}
	
	/**
	*	10、查询单科平均分
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
	*	11、查询指定学生的成绩
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
	*	12、查询指定学生的成绩
	*/
	@Override
	public String maxStudentScore(String studentName) throws Exception{
		List<Student> students = studentDao.findByStudentName(studentName);
		
		// 遍历集合查找最高分的学生
		Student maxStudent = new Student();
		maxStudent.setScore(0.0);
		Student student = new Student(); // 用于存放最高分学生的信息

		Iterator<Student> iter = students.iterator();
		while(iter.hasNext()){
			student = iter.next();
			
			// 最大值比较
			if(maxStudent.getScore() < student.getScore() ){
			maxStudent = student;
			}
		}
		return studentName + "成绩最好科目是：" + maxStudent.getClass_name() + "， 他的分数是：" + maxStudent.getScore();	
	}	
	
	/**
	*	13、查询单个学生的平均成绩
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