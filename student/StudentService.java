import java.util.Map;

public interface StudentService{
	
	/**
	*	��ѯ����ѧ���ĳɼ�
	*/
	public Map<String, Double> queryAllScore()throws Exception;
	
	/**
	*	2����ѯѧ�����ܳɼ�
	*
	*/
	public Map<String, Double> queryTotalScore()throws Exception;
	
}