import java.util.List;

public interface StudentDao{
	
	/**
	*	查询所有学生的成绩信息
	*
	*/
	public List<Student> findAll()throws Exception;
	
	
	
}