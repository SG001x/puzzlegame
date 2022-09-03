package com.musa.test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MyJFrame extends JFrame implements ActionListener {
    JButton jButton1 = new JButton("点我呀");
    JButton jButton2 = new JButton("点我呀");

    public MyJFrame() {
        this.setTitle("拼图单机版 v1.0");
        //设置窗体宽高
        this.setSize(603, 680);
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //取消默认居中放置，取消之后才能按照xy轴的形式添加组件
        this.setLayout(null);

        //创建一个按钮对象

        // 设置位置和宽高
        jButton1.setBounds(0, 0, 100, 50);
        // 给按钮添加动作监听
        jButton1.addActionListener(this);

        //创建一个按钮对象

        jButton2.setBounds(100, 0, 100, 50);
        jButton2.addActionListener(this);

        //把按钮添加到整个页面中
        this.getContentPane().add(jButton1);
        this.getContentPane().add(jButton2);


        //让整个界面显示出来
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //对当前的按钮进行判断
        //获取当前被操作的按钮对象
        Object source = e.getSource();

        if (source == jButton1) {
            jButton1.setSize(200, 200);
        } else if (source == jButton2) {
            Random r = new Random();
            jButton2.setLocation(r.nextInt(500), r.nextInt(500));
        }
    }
}
