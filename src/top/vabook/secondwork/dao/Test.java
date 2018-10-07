package top.vabook.secondwork.dao;
/**
 * @author vabook@163.com
 * @version 2018年9月30日 下午3:39:20
 */
public class Test {
	public static void main(String[] args) throws Exception {
	
		User tom = new User("tom","12345678",100);
		Curd curdTom = new Curd(tom);
		curdTom.insert();
	}
}
