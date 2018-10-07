package top.vabook.thirdwork;

/**
 * @author vabook@163.com
 * @version 2018年9月30日 上午10:59:19
 */
public class ConcurrentPrint {
	public static class Print implements Runnable {
		public String name;
		public Object prev;
		public Object self;

		public Print(String name, Object prev, Object self) {
			this.name = name;
			this.prev = prev;
			this.self = self;
		}

		public void run() {
			int count = 10;
			while (count > 0) {
				synchronized (prev) {
					synchronized (self) {
						System.out.println(name);
						count--;

						self.notifyAll(); // 唤醒一个处于等待该对象锁的线程,然后继续往下执行,直到退出对象锁区域再释放锁
					}
					try {
						if (count == 0) {
							break;	//最后一次打印后,让程序正常退出
						}else {
							prev.wait();
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {

		Object a = new Object();
		Object b = new Object();
		Object c = new Object();

		Print pa = new Print("A", c, a);
		Print pb = new Print("B", a, b);
		Print pc = new Print("C", b, c);

		Thread aThread = new Thread(pa);
		Thread bThread = new Thread(pb);
		Thread cThread = new Thread(pc);
		aThread.start();
		Thread.sleep(10);
		
		bThread.start();
		Thread.sleep(10);
		
		cThread.start();
		Thread.sleep(10);
		
	}
}
