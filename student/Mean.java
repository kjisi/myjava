import java.util.Arrays;

public interface Mean{
	/**
	* 求数组的平均值
	* @return 返回 平均值
	*/
	Double queryMeanWithEnds(Double[] scores, boolean bool);
	
	/**
	* 默认方法：去掉最高分和最低分
	*/
	default Double[] removeBothEnds(Double[] scores){
		System.out.println("排序前的数组：" + Arrays.toString(scores));
		
		// 1、排序
		Arrays.sort(scores); 

		System.out.println("排序后的数组：" + Arrays.toString(scores));
		
		// 2、去掉最高分和最低分
		Double[] result = Arrays.copyOfRange(scores,1,scores.length -1); 
		
		return result;
	}
}