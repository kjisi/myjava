package com.myjava;

import java.sql.ResultSet;


/**
	这是我用于测试MyJDBC类实现查询的测试类
	
*/
public class JDBCTest{
	
	public static void main(String[] args) throws Exception {
		// 1、实例化一个MyJDBC对象
		MyJDBC myJDBC = new MyJDBC();

		// 2、定义一条sql语句
		String sql = "select * from yigu_user";

		// 3、使用自定义的方法实现查询
		boolean success = myJDBC.auto(sql);

		ResultSet resultSet = myJDBC.query(sql);

		System.out.println(success);
		System.out.println("----------");
		System.out.println(resultSet);


	}
	
	
}