package top.vabook.fourthwork;
/**
 * @author vabook@163.com
 * @version 2018年9月19日 下午5:07:28
 */
import java.awt.Color;  
import java.awt.Graphics;  
import java.awt.Panel;  

import javax.swing.JFrame;  

public class Ball {  

    public static void main(String[] args) {  
        JFrame win=new JFrame();//新建窗口  
        win.setTitle("小球碰撞!");
        win.setLocation(250,100);//设置窗口位置  
        win.setSize(800,600);//设置窗口大小  
        win.setVisible(true);//显示窗口  
        win.setDefaultCloseOperation(3);//设置关闭退出  
        MyPanel my=new MyPanel();  
        win.add(my);  
        Thread t=new Thread(my);  
        t.start();  
    }  

}  

class MyPanel extends Panel implements Runnable{  
        int x=0,y=0;  
        int flyx=1,flyy=1;  
    public void paint(Graphics g) {  
        g.setColor(Color.blue);  
        g.fillOval(x, y, 70, 70);  
        if (flyx==1) {  
            x++;  
        }  
        if(flyx ==2) {  
            x--;  
        }  
        if(flyy==1) {  
            y++;  
        }  
        if(flyy==2) {  
            y--;  
        }  
        if(x>730) {  
            flyx=2;  
        }  
        if(x<0) {  
            flyx=1;  
        }  
        if(y<0) {  
            flyy=1;  
        }  
        if(y>530) {  
            flyy=2;  
        }  
    }  
    public void run() {  
        while(true){  
            repaint();  
            try {  
                Thread.sleep(10);  
            }  
            catch(Exception e) {  

            }  
        }  
    }  
}  