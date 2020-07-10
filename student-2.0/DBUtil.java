import java.sql.*;

public class DBUtil{
	
	// �������ݿ����Ӷ���
	private Connection connection ;
	private Statement statement;
	private ResultSet resultSet;
	
	// �������ݿ����Ӳ���
	public final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	public final String JDBC_URL = "jdbc:mysql://localhost:3306/yigushujv";
	public final String JDBC_USERNAME = "root";
	public final String JDBC_PASSWORD = "root";
	
	/**
	 ��ʼ�����ݿ����Ӷ��� Connection Statement
	*/
	private void init() throws ClassNotFoundException,SQLException{
		// 1��ע������
		Class.forName(JDBC_DRIVER);

		// 2����ȡ���ݿ����Ӷ���
		connection = DriverManager.getConnection(JDBC_URL,JDBC_USERNAME,JDBC_PASSWORD);
		statement = connection.createStatement();
	}
	
	/**
		ִ������sql�ķ��� 
		@return boolean: ����ִ�в����Ƿ�ɹ�
	*/
	public boolean auto(String sql) throws Exception{
		init(); // ��ʼ�����Ӷ���
		
		boolean success = statement.execute(sql);
		return success;
	}
	
	/**
		�޸ķ���������ִ����ɾ�����
		@return ִ�н��Ӱ���������rows > 0 ����ִ�гɹ�
	*/
	public int update(String sql) throws Exception{
		init(); // ��ʼ�����Ӷ���
		
		int rows = statement.executeUpdate(sql);
		return rows;
	}
	
	/**
		��ѯ����
		@return �����
	*/
	public ResultSet query(String sql)throws Exception{
		init(); // ��ʼ�����Ӷ���
		
		resultSet = statement.executeQuery(sql);
		return resultSet;
	}
	
	/**
		�ر���Դ�ķ���
	*/
	public void close(){
		if(resultSet != null){
			try{
				resultSet.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		if(statement != null){
			try{
				statement.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		if(connection != null){
			try{
				connection.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
}