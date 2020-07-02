package com.myjava;

import java.sql.*;

/**
 这是我创建，用来连接mysql数据库，实现查询的类
 */
public class MyJDBC{

	// 定义数据库驱动名称
	public final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	// 定义连接数据库的路径
	public final String JDBC_URL = "mysql:jdbc://localhost:3306/yugushujv";

	// 定义数据库的用户名和密码
	public final String JDBC_USERNAME = "root";
	public final String JDBC_PASSWORD = "root";

	// 声明一个数据库连接对象
	Connection connection = null;
	// 声明一个执行sql 的对象 statement
	Statement statement = null;
	//


	/**
	 定义获取连接对象的方法
	 @return 返回一个连接对象
	 */
	private Connection getConnection() throws ClassNotFoundException,SQLException{
		// 1、注册驱动
		Class.forName(JDBC_DRIVER);

		// 2、获取数据库连接对象
		Connection connection = DriverManager.getConnection(JDBC_URL,JDBC_USERNAME,JDBC_PASSWORD);

		return connection;
	}

	/**
	 定义一个可以执行任意sql的方法 auto
	 @sql String：要执行的sql语句
	 @return boolean: 返回执行操作是否成功
	 */
	public boolean auto(String sql) throws Exception{
		// 1、使用本类的方法，获取一个connection方法
		connection = getConnection();

		// 2、使用connection对象获取执行sql的对象，statement
		statement = connection.createStatement();

		// 3、执行sql 语句
		boolean success = statement.execute(sql);

		// 4、执行完毕，返回资源
		statement.close();
		connection.close();

		return success;
	}

	/**
	 定义一个用于增删改的方法 update
	 @sql String: 要执行的sql语句
	 @return int: 返回本次操作影响的行数 ，rows > 0 ,说明本次操作执行成功。
	 */
	public int update(String sql) throws Exception{
		// 1、使用本类的方法，获取一个connection方法
		connection = getConnection();

		// 2、使用connection对象获取执行sql的对象，statement
		statement = connection.createStatement();

		// 3、执行sql
		int rows = statement.executeUpdate(sql);

		// 4、执行完毕，返回资源
		statement.close();
		connection.close();

		return rows;
	}

	/**
	 定义一个用于查询的方法query
	 @sql String: 要执行的sql语句
	 @resultSet ResultSet: 返回的查询结果
	 */
	public ResultSet query(String sql) throws Exception{
		// 1、使用本类的方法，获取一个connection方法
		connection = getConnection();

		// 2、使用connection对象获取执行sql的对象，statement
		statement = connection.createStatement();

		// 3、执行sql
		ResultSet resultSet = statement.executeQuery(sql);

		// 4、执行完毕，返回资源
		resultSet.close();
		statement.close();
		connection.close();

		return resultSet;
	}





}