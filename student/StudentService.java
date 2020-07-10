import java.util.Map;

public interface StudentService{
	
	/**
	*	查询所有学生的成绩
	*/
	public Map<String, Double> allScore()throws Exception;
	
	/**
	*	2、查询学生的总成绩
	*
	*/
	public Map<String, Double> totalScore()throws Exception;
	
	
	/**
	*	3、查询学生的总成绩中的最高分
	*
	*/
	public String maxTotalScore()throws Exception;
	
	/**
	*	4、查询总分的平均分
	*/
	public Double averageTotalScoreWithEnds(boolean bool)throws Exception;
	
	/**
	*	5、查询各学科的总分
	*/
	public Map<String, Double> classTotalScore()throws Exception;
	
	/**
	*	6、查询各学科的最高分
	*/
	public String maxClassTotalScore()throws Exception;
	
	/**
	*	7、查询各学科的平均分
	*/
	public Double averageClassTotalScoreWithEnds(boolean bool)throws Exception;
	
	/**
	*	8、根据课程名查询成绩
	*/
	public Map<String, Double> classScore(String className)throws Exception;
	
	/**
	*	9、查询单科最高分
	*/
	public String maxClassScore(String className) throws Exception;
	
	/**
	*	10、查询单科平均分
	*/
	public Double averageClassScoreWithEnds(String className, boolean bool) throws Exception;
	
	/**
	*	11、查询指定学生的成绩
	*/
	public Map<String, Double> studentScore(String studentName) throws Exception;
	
	
	/**
	*	12、查询指定学生的成绩
	*/
	public String maxStudentScore(String studentName) throws Exception;
	
	/**
	*	13、查询单个学生的平均成绩
	*/
	public Double averageStudentScoreWithEnds(String studentName, boolean bool) throws Exception;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}