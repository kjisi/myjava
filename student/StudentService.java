import java.util.Map;

public interface StudentService{
	
	/**
	*	查询所有学生的成绩
	*/
	public Map<String, Double> queryStudentScore()throws Exception;
	
}