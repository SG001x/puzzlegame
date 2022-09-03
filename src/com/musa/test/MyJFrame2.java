package com.musa.test;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class MyJFrame2 extends JFrame implements MouseListener {
    //创建一个按钮对象
    JButton jButton1 = new JButton("点我呀");
    public MyJFrame2() {
        //设置窗体宽高
        this.setSize(603, 680);
        this.setTitle("拼图单机版 v1.0");
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //取消默认居中放置，取消之后才能按照xy轴的形式添加组件
        this.setLayout(null);


        // 设置位置和宽高
        jButton1.setBounds(0, 0, 100, 50);
        // 给按钮绑定鼠标事件
        jButton1.addMouseListener(this);


        //把按钮添加到整个页面中
        this.getContentPane().add(jButton1);


        //让整个界面显示出来
        this.setVisible(true);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("单击");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("按下不松");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("松开");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("划入");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("划出");
    }
}
