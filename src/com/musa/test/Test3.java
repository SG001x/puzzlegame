package com.musa.test;

import javax.swing.*;

public class Test3 {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        //设置窗体宽高
        jFrame.setSize(603,680);
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


        jFrame.setVisible(true);
    }
}
