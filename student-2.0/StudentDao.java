import java.util.List;
import java.util.Map;

public interface StudentDao{
	
	/**
	*	1、查询所有学生的成绩信息
	*
	*/
	public List<Student> findAll()throws Exception;
	
	/**
	*	2、查询所有学生的总成绩
	*
	*/
	public Map<String, Double> findTotalScore()throws Exception;
	
	/**
	*	3、查询所有学科的总成绩
	*
	*/
	public Map<String, Double> findClassTotalScore()throws Exception;
	
	/**
	*	4、按照学科名查询成绩
	*
	*/
	public List<Student> findByClassName(String className)throws Exception;
	
	/**
	* 	5、按照学生姓名查询成绩
	*/
	public List<Student> findByStudentName(String studentName) throws Exception;
}