package test;
import java.sql.*;

public class Example1 {

  private static Connection con = null;
  private static String username = "root";
  private static String password = "root";
  private static String URL = "jdbc:mysql://localhost:3306";

  public static void main(String[] args) throws SQLException {
	 try {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
	} catch (InstantiationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    //Загружаем драйвер
    con = DriverManager.getConnection(URL, username, password);
    //соединяемся
    if(con!=null) System.out.println("Connection Successful !\n");
    if (con==null) System.exit(0);
    Statement st = con.createStatement();
    //Statement позволяет отправлять запросы базе данных
    st.executeQuery("use information_schema");
    ResultSet rs = st.executeQuery("show tables");
    //ResultSet получает результирующую таблицу
    int x = rs.getMetaData().getColumnCount();
    //Resultset.getMetaData() получаем информацию
    //результирующей таблице
    while(rs.next()){
      for(int i=1; i<=x;i++){
        System.out.print(rs.getString(i) + "\t");
      }
      System.out.println();
    }
    System.out.println();
    if(rs!=null)rs.close();
    if(st!=null)st.close();
    if(con!=null)con.close();
  }
}