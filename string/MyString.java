

/**
	这是我测试String类的一个类，用来测试String 类的常用方法

*/

public class MyString{
	public static void main(String[] args){
		
		String str1 = "中文字符串english1324875";
		
		// 1、提取子字符串 按照索引截取
		String str2 = str1.substring(5,12);
		String str3 = str1.substring(0,5);
		
		System.out.println(str2);
		System.out.println(str3);
		
		// 2、拼接字符串
		String chAndEn = str2 + str3;
		
		System.out.println(chAndEn);
		
		// 3、使用定界符分隔，把多个字符串放在一起
		String all = String.join("/","长城之上","是无限的星空","星空之上","是无尽的彷徨" );
		String all2 = String.join("/",str1,str2,str3,all,"红叶相思");
		
		System.out.println(all);
		System.out.println(all2);
		
		// 多个字符串放在一起之后怎么取出来？ 
		// 4、按照字符分割字符串
		String[] stringList = all.split("/");
		for(int i = 0; i < stringList.length; i++)
		{
			System.out.println(stringList[i]);
		}
		
		System.out.println("------这是分隔符------");
		
		String[] list = all2.split("/");
		for(int i = 0; i < list.length; i ++){
			System.out.println(list[i]);
		}
		
		System.out.println("--------比较字符串--------");
		// 5、检测字符串是否相等
		String string1 = "要把梦藏在树叶里，不然梦会坏";
		String string2 = "要把梦藏在树叶里，不然梦会坏";
		
		boolean equals = "要把梦藏在树叶里，不然梦会坏".equals(string1);
		boolean equals2 = string1.equals(string2);

		System.out.println("" + equals + equals2);
		
		boolean equals3 = "要把梦藏在树叶里，不然梦会坏" == string1;
		System.out.println(equals3);
		System.out.println(string1 == string2);
		
		String string4 = string1.substring(0,9) + "不然梦会坏";
		
		System.out.println("---------------------");
		
		System.out.println(string4.equals(string1));
		System.out.println(string4 == string1);
	}

}