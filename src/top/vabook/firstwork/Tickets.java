package top.vabook.firstwork;

/**
 * @author vabook@163.com
 * @version 2018年9月29日 下午9:50:31
 */
public class Tickets extends Thread {
	public String name;
	public static int tickets = 100;

	public Tickets(String name) {
		this.name = name;
	}

	public void run() {

		while (tickets > 0) {
			synchronized (Tickets.class) {
				System.out.println(name + "取走了一张票" + " 取走的票号是 ->" + tickets);
				tickets--;
			}
			try {
				sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Tickets A = new Tickets("A");
		Tickets B = new Tickets("B");
		Tickets C = new Tickets("C");
		Tickets D = new Tickets("D");

		A.start();
		B.start();
		C.start();
		D.start();
	}
}
