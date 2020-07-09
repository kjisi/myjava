import java.util.List;
import java.util.Map;

public interface StudentDao{
	
	/**
	*	查询所有学生的成绩信息
	*
	*/
	public List<Student> findAll()throws Exception;
	
	/**
	*	查询所有学生的总成绩
	*
	*/
	public Map<String, Double> findTotalScore()throws Exception;
	
	
	
}