import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;


public class StudentDaoImpl implements StudentDao{
	
	private DBUtil dbUtil = new DBUtil();
	
	/**
	*	��ѯ����ѧ���ĳɼ���Ϣ
	*
	*/
	@Override
	public List<Student> findAll()throws Exception{
		
		// 1�������ѯ��sql
		String sql = 
		"SELECT st.`student_id`,st.`student_name`,c.`class_name`,sc.`score` " +  // ��ѯ��
		" FROM yigu_student st, yigu_class c, yigu_score sc" +  // ��ѯ�ı�
		" WHERE st.`student_id` = sc.`student_id` " +  // ��ѯ����
		" AND c.`class_id` = sc.`class_id`" + 
		" ORDER BY st.`student_id`,c.`class_id`;";  // ����ѧ��id���γ�id
		
		ResultSet resultSet = dbUtil.query(sql);
		
		// 2�������ѯ��� -- ��װ��List����
		List<Student> students = new ArrayList<Student>() ;
		while(resultSet.next()){
			// 2.1����ȡѧ����Ϣ
			Integer student_id = resultSet.getInt("student_id");
			String student_name = resultSet.getString("student_name");
			String class_name = resultSet.getString("class_name");
			Double score = resultSet.getDouble("score");
			
			// 2.2����student ����ֵ
			Student student = new Student();
			
			student.setStudent_id(student_id);
			student.setStudent_name(student_name);
			student.setClass_name(class_name);
			student.setScore(score);
			
			// 2.3����ӵ����� 
			students.add(student);
		}
		
		// �������ϣ��鿴���
		students.forEach( (Student temp) -> {
			System.out.println(temp);
		});
		System.out.println("--------------------------------------------------------------------------------");
		
		// �ر���Դ
		resultSet.close();
		dbUtil.close();
		
		return students;
	}
	
}