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
		
		if(! bool){
		// 1��ȥ����߷�����ͷ�
		// System.out.println("ԭʼ���鳤��" + scores.length);
		removeScores = removeBothEnds(scores);
		// System.out.println("��ȡ�����鳤��" + removeScores.length);
		}

		// 2�����
		Double sum = 0.0;
		// Stream.of(removeScores).forEach( score -> sum + score);
		for(int i = 0; i < removeScores.length; i++){
			sum += removeScores[i];
		}
		System.out.println("�ܳɼ���" + sum);
		
		// 3������ƽ��ֵ
		return sum/removeScores.length;
	}
	
}