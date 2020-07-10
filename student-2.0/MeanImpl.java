// import java.util.*;
import java.util.Arrays;

public class MeanImpl implements Mean{
	
	/**
	* 求数组的平均值
	* @return 返回平均值
	*/
	@Override
	public Double queryMeanWithEnds(Double[] scores, boolean bool){
		Double[] removeScores = scores;
		
		// 1、去掉最高分与最低分
		if(! bool){
		removeScores = removeBothEnds(scores);
		}

		// 2、求和
		Double sum = 0.0;
		for(int i = 0; i < removeScores.length; i++){
			sum += removeScores[i];
		}
		System.out.println("总成绩：" + sum);
		
		// 3、返回平均值
		return sum/removeScores.length;
	}
	
}