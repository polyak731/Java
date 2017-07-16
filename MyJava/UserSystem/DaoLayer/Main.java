package DaoLayer;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws SQLException {
		UserDao udao = new UserDaoJdbc();
		
		for(User user: udao.selectAll()){
			System.out.println(user);
		}
	}
}
