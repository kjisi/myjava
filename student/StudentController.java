import java.util.Map;
import java.util.Map.Entry;
import java.util.Iterator;

/**
* 	这个类用于调用StudentService 总的方法，测试程序运行	
*/
public class StudentController{
		
	private StudentService studentService = new StudentServiceImpl();

	//1、测试查询学生所有成绩 
	public void findAll()throws Exception{
		Map<String, Double> scores = studentService.allScore();
	
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
	/*
	 studentService.allScore();			
	*/
	
	
	// 2、测试查询学生的总成绩 
	public void totalScore()throws Exception{
		Map<String, Double> totalScores = studentService.totalScore();
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
	

	
	
	//	3、测试查询学生总成绩的最高成绩
	public void maxScores()throws Exception{
		String maxScores = studentService.maxTotalScore();
		System.out.println(maxScores);
	}
	
	//4、测试查询学生总成绩的平均成绩
	public void averageScore(boolean bool)throws Exception{
		Double averageScore= studentService.averageTotalScoreWithEnds(bool);
		System.out.println("总分的平均分是：" + averageScore);
	}
	
	// 5、查询学科学生所有成绩  studentService.allScore();
	
	public void classScore(String className)throws Exception{
		Map<String, Double> scores = studentService.classScore(className);
	
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
	
	//6、查询学科的总成绩 
	public void classTotalScores()throws Exception{
		Map<String, Double> classTotalScores = studentService.classTotalScore();
		Map.Entry<String, Double> entry ;
		String class_name = "";
		Double score = 0.0;
		
		Iterator<Entry<String, Double>> iter = classTotalScores.entrySet().iterator();
		while(iter.hasNext()){
			
			entry = iter.next();
			class_name = entry.getKey();
			score = entry.getValue();
			
			System.out.println(class_name +" 的总成绩是："+ score);
		}
	}
	
	// 7、测试查询学科最高成绩
	public void maxClassTotalScore()throws Exception{
		String maxClassTotalScore = studentService.maxClassTotalScore();
		System.out.println(maxClassTotalScore);
	}
	
	// 8、测试查询各学科总分的平均分
	public void averageClassTotalScore(boolean bool)throws Exception{
		Double averageClassTotalScore = studentService.averageClassTotalScoreWithEnds(bool);
		System.out.println("各学科总分的平均分是：" + averageClassTotalScore);
	}

	
	// 9、测试 按照学科查询，本学科成绩最高的学生
		public void maxClassScore(String className)throws Exception{
		String maxClassScore = studentService.maxClassScore(className);
		System.out.println(maxClassScore);
	}
	
	// 10、测试 查询学科平均成绩	
	public void averageClassScoreWithEnds(String className, boolean bool)throws Exception{
		Double averageClassScore = studentService.averageClassScoreWithEnds(className,bool);
		System.out.println(className + "的平均分是：" + averageClassScore);
	}
	
	// 11、测试 按照学生姓名查询学生成绩
	
	public void studentScore(String studentName)throws Exception{
		Map<String, Double> studentScores = studentService.studentScore(studentName);
		
		Map.Entry<String, Double> entry ;
		String nameAndClass = "";
		Double score = 0.0;
		
		Iterator<Entry<String, Double>> iter = studentScores.entrySet().iterator();
		while(iter.hasNext()){
			entry = iter.next();
			
			nameAndClass = entry.getKey();
			score = entry.getValue();
			
			System.out.println(nameAndClass + "成绩是：" + score);	
		}
	}
	
	// 12、测试 查询学生的最高分
	public void maxStudentScore(String studentName)throws Exception{
		String maxStudentScore = studentService.maxStudentScore(studentName);
		System.out.println(maxStudentScore);
	}
	
	// 13、 测试查询学生的平均成绩
	public void averageStudentScoreWithEnds(String studentName, boolean bool)throws Exception{
		Double averageStudentScore = studentService.averageStudentScoreWithEnds(studentName, bool);
		System.out.println(studentName + "的平均分是：" + averageStudentScore );
	}
	
}