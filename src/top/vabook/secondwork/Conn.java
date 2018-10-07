package top.vabook.secondwork;
/**
 * @author vabook@163.com
 * @version 2018年9月30日 下午2:48:35
 */

import java.sql.Connection;
import java.sql.DriverManager;

public class Conn {
	public Conn() {}
	public static Connection getConn() throws Exception {
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/mydb";
	String usernameString = "root";
	String passwordString = "root";
	
	Class.forName(driver);
	Connection conn = DriverManager.getConnection(url,usernameString,passwordString);
	return conn;
	}
}
