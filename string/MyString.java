

/**
	�����Ҳ���String���һ���࣬��������String ��ĳ��÷���

*/

public class MyString{
	public static void main(String[] args){
		
		String str1 = "�����ַ���english1324875";
		
		// 1����ȡ���ַ��� ����������ȡ
		String str2 = str1.substring(5,12);
		String str3 = str1.substring(0,5);
		
		System.out.println(str2);
		System.out.println(str3);
		
		// 2��ƴ���ַ���
		String chAndEn = str2 + str3;
		
		System.out.println(chAndEn);
		
		// 3��ʹ�ö�����ָ����Ѷ���ַ�������һ��
		String all = String.join("/","����֮��","�����޵��ǿ�","�ǿ�֮��","���޾�������" );
		String all2 = String.join("/",str1,str2,str3,all,"��Ҷ��˼");
		
		System.out.println(all);
		System.out.println(all2);
		
		// ����ַ�������һ��֮����ôȡ������ 
		// 4�������ַ��ָ��ַ���
		String[] stringList = all.split("/");
		for(int i = 0; i < stringList.length; i++)
		{
			System.out.println(stringList[i]);
		}
		
		System.out.println("------���Ƿָ���------");
		
		String[] list = all2.split("/");
		for(int i = 0; i < list.length; i ++){
			System.out.println(list[i]);
		}
		
		System.out.println("--------�Ƚ��ַ���--------");
		// 5������ַ����Ƿ����
		String string1 = "Ҫ���β�����Ҷ���Ȼ�λỵ";
		String string2 = "Ҫ���β�����Ҷ���Ȼ�λỵ";
		
		boolean equals = "Ҫ���β�����Ҷ���Ȼ�λỵ".equals(string1);
		boolean equals2 = string1.equals(string2);

		System.out.println("" + equals + equals2);
		
		boolean equals3 = "Ҫ���β�����Ҷ���Ȼ�λỵ" == string1;
		System.out.println(equals3);
		System.out.println(string1 == string2);
		
		String string4 = string1.substring(0,9) + "��Ȼ�λỵ";
		
		System.out.println("---------------------");
		
		System.out.println(string4.equals(string1));
		System.out.println(string4 == string1);
	}

}