// import java.util.*;
import java.util.Arrays;

public class MeanImpl implements Mean{
	
	/**
	* �������ƽ��ֵ
	* @return ����ƽ��ֵ
	*/
	@Override
	public Double queryMeanWithEnds(Double[] scores, boolean bool){
		Double[] removeScores = scores;
		
		// 1��ȥ����߷�����ͷ�
		if(! bool){
		removeScores = removeBothEnds(scores);
		}

		// 2�����
		Double sum = 0.0;
		for(int i = 0; i < removeScores.length; i++){
			sum += removeScores[i];
		}
		System.out.println("�ܳɼ���" + sum);
		
		// 3������ƽ��ֵ
		return sum/removeScores.length;
	}
	
}