package top.vabook.firstwork;

import java.util.concurrent.CountDownLatch;

/**
 * @author vabook@163.com
 * @version 2018年9月29日 下午9:50:54 和取票类似,只是多了一些线程间的调度
 */

public class PrintNumber extends Thread {
	public static int number = 100;
	public static int count = 0;
	public String name ;
	public PrintNumber(String name) {
		this.name = name ;
	}
	public void run() {
		synchronized (PrintNumber.class) {
			while(number > 0) {
				System.out.println(name + "打印了 -> " + number);
				number --;
				count ++;
				if (count > 2) {	//打印三次就换其他线程打印
					try {
						count = 0;	//标志必须重置为0
						PrintNumber.class.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}else {
					PrintNumber.class.notifyAll();	//唤醒其他线程
				}
			}
		}
	}
	public static void main(String[] args) throws InterruptedException {
		PrintNumber A = new PrintNumber("A");
		PrintNumber B = new PrintNumber("B");
		PrintNumber C = new PrintNumber("C");
		A.start();
		B.start();
		C.start();
		A.join();	//后台守护进程,能固定打印顺序
		B.join();
		C.join();
	}
}