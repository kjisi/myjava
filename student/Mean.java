import java.util.Arrays;

public interface Mean{
	/**
	* �������ƽ��ֵ
	* @return ���� ƽ��ֵ
	*/
	Double queryMeanWithEnds(Double[] scores, boolean bool);
	
	/**
	* Ĭ�Ϸ�����ȥ����߷ֺ���ͷ�
	*/
	default Double[] removeBothEnds(Double[] scores){
		System.out.println("����ǰ�����飺" + Arrays.toString(scores));
		
		// 1������
		Arrays.sort(scores); 

		System.out.println("���������飺" + Arrays.toString(scores));
		
		// 2��ȥ����߷ֺ���ͷ�
		Double[] result = Arrays.copyOfRange(scores,1,scores.length -1); 
		
		return result;
	}
}