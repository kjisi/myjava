import java.util.List;
import java.util.Map;

public interface StudentDao{
	
	/**
	*	��ѯ����ѧ���ĳɼ���Ϣ
	*
	*/
	public List<Student> findAll()throws Exception;
	
	/**
	*	��ѯ����ѧ�����ܳɼ�
	*
	*/
	public Map<String, Double> findTotalScore()throws Exception;
	
	
	
}