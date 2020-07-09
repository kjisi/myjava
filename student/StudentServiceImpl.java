import java.util.Map;
import java.util.List;
import java.util.LinkedHashMap;

public class StudentServiceImpl implements StudentService{
	
	private StudentDao studentDao = new StudentDaoImpl();
	
	/**
	*	��ѯ����ѧ���ĳɼ�
	*
	*/
	@Override
	public Map<String, Double> queryStudentScore()throws Exception{
		
		// 1������ studentDao ��ѯ����ѧ���ĳɼ�
		List<Student> students = studentDao.findAll();
		
		// 2��ȡ������ѧ���ɼ�
		Map<String, Double> scores = new LinkedHashMap<String, Double>();
		Student student = new Student();
		
		for(int i = 0; i < students.size(); i++){
			
			student = students.get(i);
			
			String nameAndClass = student.getStudent_name() + "," + student.getClass_name();
			scores.put(nameAndClass, student.getScore());
		}
		return scores;
	}
	
	
}