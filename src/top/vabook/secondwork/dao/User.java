package top.vabook.secondwork.dao;
/**
 * @author vabook@163.com
 * @version 2018年9月30日 下午2:43:20
 */
public class User {
	public String name;
	public String password;
	public int money = 500;
	public User() {
		
	}
	public User(String name,String password) {
		this.name = name ;
		this.password = password;
	}
	public User(String name,String password,int money) {
		this.name = name ;
		this.password = password;
		this.money = money;
	}
	public User(String name2) {
		this.name = name2;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
}
