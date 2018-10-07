package top.vabook.secondwork;

import java.util.Scanner;

/**
 * @author vabook@163.com
 * @version 2018广10朿6旿 下午3:17:27
 */
public class App {
	public static void main(String[] args) throws Exception {

		System.out.println("请插入银行卡(或输入用户名)  : ");
		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();
		System.out.println("输入密码验证   : ");
		String password = scanner.nextLine();

		User user = new User(name);
		Curd curd = new Curd(user);

		int count = 5;
		/**
		 * 五次密码验证
		 */
		String rightPassword = curd.select().password;
		while (count > 0) {
			if (rightPassword.compareTo(password) == 0) {
				System.out.println("密码正确");
				break;
			} else {
				if (count > 0) {
					count--;
					System.out.println("密码错误 !!!  还剩" + count + "次机伿" + password.length() + password);
					System.out.println("请重新输入密砿 :");
					password = scanner.nextLine();
				} else {
					break;
				}
			}
		}
		/**
		 * 银行存取操作
		 */
		User user2 = new User(password);
		Curd curd2 = new Curd(user2);
		while (true) {
			System.out.println("请鿉择操作:");
			System.out.println("1.查询余额");
			System.out.println("2.取款");
			System.out.println("3.存款");
			System.out.println("4.逿凿");

			int operatorNumber = scanner.nextInt();
			switch (operatorNumber) {
			// 查询余额
			case 1:
				System.out.println(curd2.select().money);
				break;
			// 取款
			case 2:
				while (true) {
					System.out.println("请输入取款金颿 :");
					int fetchMoney = scanner.nextInt();
					int firstmoney = curd2.select().money;
					int newMoney;
					if (firstmoney > fetchMoney) {
						newMoney = firstmoney - fetchMoney;
						curd.update(newMoney);
						System.out.println("取款成功,还有余额 :" + newMoney );
						System.out.println("按下2号键逿出取欿");
						int exitNumber = scanner.nextInt();
						if (exitNumber == 2) {
							break;
						}
					} else {
						System.out.println("余额不够 ,请重新输兿 :");
						fetchMoney = scanner.nextInt();
					}
				}
				//存款
			case 3:
				System.out.println("请放入纸帿 :");
				int insertMoney = scanner.nextInt();
				int firstMoney = curd2.select().money;
				int newMoney ;
				while(true) {
					if (insertMoney > 0) {
						newMoney = firstMoney + insertMoney;
						curd2.update(newMoney);
						System.out.println("存钱成功 ,余额还有 :"  + newMoney );
						System.out.println("按下2号键逿出取欿");
						int exitNumber = scanner.nextInt();
						if (exitNumber == 2) {
							break;
						}
					}else {
						System.out.println("存钱失败,请重新尝诿");
					}
				}
			case 4:
				System.out.println("逿出成势");
				System.exit(1);
			default:
				System.exit(1);
			}
		}

	}

}