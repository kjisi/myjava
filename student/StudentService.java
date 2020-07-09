import java.util.Map;

public interface StudentService{
	
	/**
	*	查询所有学生的成绩
	*/
	public Map<String, Double> queryAllScore()throws Exception;
	
	/**
	*	2、查询学生的总成绩
	*
	*/
	public Map<String, Double> queryTotalScore()throws Exception;
	
}