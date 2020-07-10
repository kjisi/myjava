import java.util.Map;

public interface StudentService{
	
	/**
	*	��ѯ����ѧ���ĳɼ�
	*/
	public Map<String, Double> allScore()throws Exception;
	
	/**
	*	2����ѯѧ�����ܳɼ�
	*
	*/
	public Map<String, Double> totalScore()throws Exception;
	
	
	/**
	*	3����ѯѧ�����ܳɼ��е���߷�
	*
	*/
	public String maxTotalScore()throws Exception;
	
	/**
	*	4����ѯ�ֵܷ�ƽ����
	*/
	public Double averageTotalScoreWithEnds(boolean bool)throws Exception;
	
	/**
	*	5����ѯ��ѧ�Ƶ��ܷ�
	*/
	public Map<String, Double> classTotalScore()throws Exception;
	
	/**
	*	6����ѯ��ѧ�Ƶ���߷�
	*/
	public String maxClassTotalScore()throws Exception;
	
	/**
	*	7����ѯ��ѧ�Ƶ�ƽ����
	*/
	public Double averageClassTotalScoreWithEnds(boolean bool)throws Exception;
	
	/**
	*	8�����ݿγ�����ѯ�ɼ�
	*/
	public Map<String, Double> classScore(String className)throws Exception;
	
	/**
	*	9����ѯ������߷�
	*/
	public String maxClassScore(String className) throws Exception;
	
	/**
	*	10����ѯ����ƽ����
	*/
	public Double averageClassScoreWithEnds(String className, boolean bool) throws Exception;
	
	/**
	*	11����ѯָ��ѧ���ĳɼ�
	*/
	public Map<String, Double> studentScore(String studentName) throws Exception;
	
	
	/**
	*	12����ѯָ��ѧ���ĳɼ�
	*/
	public String maxStudentScore(String studentName) throws Exception;
	
	/**
	*	13����ѯ����ѧ����ƽ���ɼ�
	*/
	public Double averageStudentScoreWithEnds(String studentName, boolean bool) throws Exception;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}