import java.sql.*;

public class DBUtil{
	
	// 定义数据库连接对象
	private Connection connection ;
	private Statement statement;
	private ResultSet resultSet;
	
	// 定义数据库连接参数
	public final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	public final String JDBC_URL = "jdbc:mysql://localhost:3306/yigushujv";
	public final String JDBC_USERNAME = "root";
	public final String JDBC_PASSWORD = "root";
	
	/**
	 初始化数据库连接对象 Connection Statement
	*/
	private void init() throws ClassNotFoundException,SQLException{
		// 1、注册驱动
		Class.forName(JDBC_DRIVER);

		// 2、获取数据库连接对象
		connection = DriverManager.getConnection(JDBC_URL,JDBC_USERNAME,JDBC_PASSWORD);
		statement = connection.createStatement();
	}
	
	/**
		执行任意sql的方法 
		@return boolean: 返回执行操作是否成功
	*/
	public boolean auto(String sql) throws Exception{
		init(); // 初始化连接对象
		
		boolean success = statement.execute(sql);
		return success;
	}
	
	/**
		修改方法，用于执行增删改语句
		@return 执行结果影响的行数，rows > 0 ，则执行成功
	*/
	public int update(String sql) throws Exception{
		init(); // 初始化连接对象
		
		int rows = statement.executeUpdate(sql);
		return rows;
	}
	
	/**
		查询方法
		@return 结果集
	*/
	public ResultSet query(String sql)throws Exception{
		init(); // 初始化连接对象
		
		resultSet = statement.executeQuery(sql);
		return resultSet;
	}
	
	/**
		关闭资源的方法
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