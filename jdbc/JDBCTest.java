package com.myjava;

import java.sql.ResultSet;


/**
	���������ڲ���MyJDBC��ʵ�ֲ�ѯ�Ĳ�����
	
*/
public class JDBCTest{
	
	public static void main(String[] args) throws Exception {
		// 1��ʵ����һ��MyJDBC����
		MyJDBC myJDBC = new MyJDBC();

		// 2������һ��sql���
		String sql = "select * from yigu_user";

		// 3��ʹ���Զ���ķ���ʵ�ֲ�ѯ
		boolean success = myJDBC.auto(sql);

		ResultSet resultSet = myJDBC.query(sql);

		System.out.println(success);
		System.out.println("----------");
		System.out.println(resultSet);


	}
	
	
}