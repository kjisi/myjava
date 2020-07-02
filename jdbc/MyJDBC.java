package com.myjava;

import java.sql.*;

/**
 �����Ҵ�������������mysql���ݿ⣬ʵ�ֲ�ѯ����
 */
public class MyJDBC{

	// �������ݿ���������
	public final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	// �����������ݿ��·��
	public final String JDBC_URL = "mysql:jdbc://localhost:3306/yugushujv";

	// �������ݿ���û���������
	public final String JDBC_USERNAME = "root";
	public final String JDBC_PASSWORD = "root";

	// ����һ�����ݿ����Ӷ���
	Connection connection = null;
	// ����һ��ִ��sql �Ķ��� statement
	Statement statement = null;
	//


	/**
	 �����ȡ���Ӷ���ķ���
	 @return ����һ�����Ӷ���
	 */
	private Connection getConnection() throws ClassNotFoundException,SQLException{
		// 1��ע������
		Class.forName(JDBC_DRIVER);

		// 2����ȡ���ݿ����Ӷ���
		Connection connection = DriverManager.getConnection(JDBC_URL,JDBC_USERNAME,JDBC_PASSWORD);

		return connection;
	}

	/**
	 ����һ������ִ������sql�ķ��� auto
	 @sql String��Ҫִ�е�sql���
	 @return boolean: ����ִ�в����Ƿ�ɹ�
	 */
	public boolean auto(String sql) throws Exception{
		// 1��ʹ�ñ���ķ�������ȡһ��connection����
		connection = getConnection();

		// 2��ʹ��connection�����ȡִ��sql�Ķ���statement
		statement = connection.createStatement();

		// 3��ִ��sql ���
		boolean success = statement.execute(sql);

		// 4��ִ����ϣ�������Դ
		statement.close();
		connection.close();

		return success;
	}

	/**
	 ����һ��������ɾ�ĵķ��� update
	 @sql String: Ҫִ�е�sql���
	 @return int: ���ر��β���Ӱ������� ��rows > 0 ,˵�����β���ִ�гɹ���
	 */
	public int update(String sql) throws Exception{
		// 1��ʹ�ñ���ķ�������ȡһ��connection����
		connection = getConnection();

		// 2��ʹ��connection�����ȡִ��sql�Ķ���statement
		statement = connection.createStatement();

		// 3��ִ��sql
		int rows = statement.executeUpdate(sql);

		// 4��ִ����ϣ�������Դ
		statement.close();
		connection.close();

		return rows;
	}

	/**
	 ����һ�����ڲ�ѯ�ķ���query
	 @sql String: Ҫִ�е�sql���
	 @resultSet ResultSet: ���صĲ�ѯ���
	 */
	public ResultSet query(String sql) throws Exception{
		// 1��ʹ�ñ���ķ�������ȡһ��connection����
		connection = getConnection();

		// 2��ʹ��connection�����ȡִ��sql�Ķ���statement
		statement = connection.createStatement();

		// 3��ִ��sql
		ResultSet resultSet = statement.executeQuery(sql);

		// 4��ִ����ϣ�������Դ
		resultSet.close();
		statement.close();
		connection.close();

		return resultSet;
	}





}