package com.musa.test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test3 {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        //设置窗体宽高
        jFrame.setSize(603, 680);
        //设置界面的标题
        jFrame.setTitle("事件演示");
        //设置界面置顶
        jFrame.setAlwaysOnTop(true);
        //设置界面居中
        jFrame.setLocationRelativeTo(null);
        //设置关闭模式
        jFrame.setDefaultCloseOperation(3);
        //取消默认居中放置，取消之后才能按照xy轴的形式添加组件
        jFrame.setLayout(null);


        //创建一个按钮对象
        JButton jButton = new JButton("点我呀");
        // 设置位置和宽高
        jButton.setBounds(0, 0, 100, 50);
        // 给按钮添加动作监听
        // jtb：组件对象，表示你要给哪个组件添加事件
        // addActionListener：表示我要给组件添加哪个事件监听（动作监听:鼠标左键点击/空格）
        // 参数：表示事件被触发之后要执行的代码。
        //jButton.addActionListener(new MyActionListener());
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("戳爆！");
            }
        });
        //把按钮添加到界面中
        jFrame.getContentPane().add(jButton);


        jFrame.setVisible(true);
    }
}
