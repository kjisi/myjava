import java.util.List;
import java.util.Map;

public interface StudentDao{
	
	/**
	*	1����ѯ����ѧ���ĳɼ���Ϣ
	*
	*/
	public List<Student> findAll()throws Exception;
	
	/**
	*	2����ѯ����ѧ�����ܳɼ�
	*
	*/
	public Map<String, Double> findTotalScore()throws Exception;
	
	/**
	*	3����ѯ����ѧ�Ƶ��ܳɼ�
	*
	*/
	public Map<String, Double> findClassTotalScore()throws Exception;
	
	/**
	*	4������ѧ������ѯ�ɼ�
	*
	*/
	public List<Student> findByClassName(String className)throws Exception;
	
	/**
	* 	5������ѧ��������ѯ�ɼ�
	*/
	public List<Student> findByStudentName(String studentName) throws Exception;
}