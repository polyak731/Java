package DaoLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJdbc implements UserDao{

	private static String username = "root";
	private static String password = "root";
	private static String URL = "jdbc:mysql://localhost:3306/FACTORY";
	
	static{
		JdbcUtils.initDriver("com.mysql.jdbc.Driver");
	}
	
	@Override
	public List<User> selectAll() throws SQLException {
		
		List<User> result = new ArrayList<>();
		Connection connection = getConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		try{
			connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			connection.setAutoCommit(false);
			
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT id,name,password,email,age FROM Users");
			while(resultSet.next()){
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String password = resultSet.getString("password");
				String email = resultSet.getString("email");
				int age = resultSet.getInt("age");
				
				User user = new User(id);
				user.setAge(age);
				user.setEmail(email);
				user.setName(name);
				user.setPassword(password);
				
				result.add(user);
			}
			connection.commit();
			return result;
		}catch(SQLException ex){
			JdbcUtils.rollbackQuietly(connection);
			throw ex;
		}finally{
			JdbcUtils.closeQuietly(resultSet);
			JdbcUtils.closeQuietly(statement);
			JdbcUtils.closeQuietly(connection);
		}
		
	}
	
	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, username, password);
	}

	@Override
	public int insert(User user) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = getConnection();
		PreparedStatement ps = null;
		connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
		connection.setAutoCommit(false);
		try{
			ps = connection.prepareStatement("INSERT INTO Users(id,name,email,password,age) values(?,?,?,?,?)");
			ps.setInt(1, user.getId());
			ps.setString(2, user.getName());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPassword());
			ps.setInt(5, user.getAge());
			int result = ps.executeUpdate();
			connection.commit();
			return result;
		}catch(SQLException ex){
			JdbcUtils.rollbackQuietly(connection);
			throw ex;
		}finally{
			JdbcUtils.closeQuietly(ps);
			JdbcUtils.closeQuietly(connection);
		}
	}

	@Override
	public int deleteById(int id) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = getConnection();
		PreparedStatement ps = null;
		connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
		connection.setAutoCommit(false);
		try{
			ps = connection.prepareStatement("DELETE FROM Users where id=?");
			ps.setInt(1, id);
			int result = ps.executeUpdate();
			connection.commit();
			return result;
		}catch(SQLException ex){
			JdbcUtils.rollbackQuietly(connection);
			throw ex;
		}finally{
			JdbcUtils.closeQuietly(ps);
			JdbcUtils.closeQuietly(connection);
		}
	}

}
