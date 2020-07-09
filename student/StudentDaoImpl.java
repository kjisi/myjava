import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.LinkedHashMap;


public class StudentDaoImpl implements StudentDao{
	
	private DBUtil dbUtil = new DBUtil();
	
	/**
	*	查询所有学生的成绩信息
	*
	*/
	@Override
	public List<Student> findAll()throws Exception{
		
		// 1、定义查询的sql
		String sql = 
		"SELECT st.`student_id`,st.`student_name`,c.`class_name`,sc.`score` " +  // 查询项
		" FROM yigu_student st, yigu_class c, yigu_score sc" +  // 查询的表
		" WHERE st.`student_id` = sc.`student_id` " +  // 查询条件
		" AND c.`class_id` = sc.`class_id`" + 
		" ORDER BY st.`student_id`,c.`class_id`;";  // 排序：学生id、课程id
		
		ResultSet resultSet = dbUtil.query(sql);
		
		// 2、处理查询结果 -- 封装到List对象
		List<Student> students = new ArrayList<Student>() ;
		while(resultSet.next()){
			// 2.1、获取学生信息
			Integer student_id = resultSet.getInt("student_id");
			String student_name = resultSet.getString("student_name");
			String class_name = resultSet.getString("class_name");
			Double score = resultSet.getDouble("score");
			
			// 2.2、给student 对象赋值
			Student student = new Student();
			
			student.setStudent_id(student_id);
			student.setStudent_name(student_name);
			student.setClass_name(class_name);
			student.setScore(score);
			
			// 2.3、添加到集合 
			students.add(student);
		}
		
		// 遍历集合，查看结果
		students.forEach( (Student temp) -> {
			System.out.println(temp);
		});
		System.out.println("--------------------------------------------------------------------------------");
		
		// 关闭资源
		resultSet.close();
		dbUtil.close();
		
		return students;
	}
	
		/**
	*	查询所有学生的总成绩
	*
	*/
	public Map<String, Double> findTotalScore()throws Exception{
		// 1、定义查询的sql
		String sql = 
		"SELECT st.`student_name`, SUM(sc.`score`) score " + 
		" FROM yigu_student st, yigu_score sc " + 
		" WHERE st.`student_id` = sc.`student_id` " + 
		" GROUP BY st.`student_name` " + 
		" ORDER BY st.`student_id` ";	
		
		System.out.println(sql);
		
		ResultSet resultSet = dbUtil.query(sql);
		
		// 2、处理查询结果
		Map<String, Double> totalScores = new LinkedHashMap<String, Double>();
		String student_name = "";
		Double score = 0.0;
		
		while(resultSet.next()){
			
			student_name = resultSet.getString("student_name");
			score = resultSet.getDouble("score");
			
			totalScores.put(student_name,score);
		}
		
		return totalScores;
	}
	
}