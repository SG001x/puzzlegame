package com.musa.ui;

import javax.swing.*;

public class LoginJFrame extends JFrame {
    //规定：LoginJFrame表示登录界面
    public LoginJFrame(){
        //创建登陆界面的时候，同时为界面设置信息
        this.setSize(488,430);

        //设置界面的标题
        this.setTitle("拼图单机版 v1.0");
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.setVisible(true);
    }
}
