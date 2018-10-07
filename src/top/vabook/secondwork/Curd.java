package top.vabook.secondwork;
/**
 * @author vabook@163.com
 * @version 2018年9月30日 下午2:54:32
 * 数据库访问层
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import top.vabook.secondwork.User;

public class Curd {
	public static Connection connection;
	public User user;

	public Curd(User user) {
		this.user = user;
	}

	// 加同步锁
	public void insert() throws Exception {
		//锁住当前操作对象
		synchronized (user) {
			connection = Conn.getConn();
			String sql = "insert into user_login(username,password,money) values( ?,?,?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getPassword());
			ps.setInt(3, user.getMoney());
			ps.executeUpdate();

			System.out.println("插入成功");
			ps.close();
			connection.close();
		}
	}

	public  void update(int money) throws Exception {
		synchronized (user) {
		connection = Conn.getConn();
		String sql = "update user_login set money = '" + money + "' where username = ' " + user.getName() + "'";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.executeUpdate();
		System.out.println("更新成功 -> " + user.getMoney());
		ps.close();
		connection.close();
		}
	}

	public User select() throws Exception {
		connection = Conn.getConn();
		String sql = "select * from user_login where username = '" + user.name + "'";
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			user.password = rs.getString(2);
			user.money = rs.getInt(3);
		}
		ps.close();
		connection.close();
		return user;
	}
}
