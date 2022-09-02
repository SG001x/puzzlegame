package com.musa.ui;

import javax.swing.*;
import java.util.Random;

//创建二维数组
//目的：用于管理数据
//加载图片的时候，会根据二维数组中的数据进行加载


public class GameJFrame extends JFrame {
    // 规定：GameJFrame代表游戏主界面
    int[][] data = new int[4][4];

    public GameJFrame() {
        //初始化界面
        initJFrame();

        //初始化菜单
        initJMenuBar();

        //初始化数据
        initData();

        //初始化图片
        initImage();


        //gameJframe.show(); //show方法已过时，用setVisible代替
        //界面窗体默认隐藏，需要setVisible函数使其显现，一般写在最后
        this.setVisible(true);
    }

    private void initData() {
        int[] tempArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        for (int i = 0; i < tempArr.length; i++) {
            Random r = new Random();
            int index = r.nextInt(tempArr.length);
            //遍历每一个数据，和随即索引上的数据进行交换
            int temp = tempArr[i];
            tempArr[i] = tempArr[index];
            tempArr[index] = temp;

        }
        for (int i = 0; i < tempArr.length; i++) {
            System.out.print(tempArr[i] + " ");
        }
        System.out.println("");

        //解法二：
        //遍历二维数组，给里面的每一个数据赋值

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                data[i][j] = tempArr[i * 4 + j];
            }
        }
    }

    //初始化图片
    // 添加图片的十号，就需要按照二维数组中管理的数据添加图片
    private void initImage() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                //获取当前要加载的图片序号
                int num = data[i][j];
                //创建一个图片ImageIcon的对象
                ImageIcon icon = new ImageIcon("C:\\Users\\SG001x\\IdeaProjects\\puzzlegame\\image\\animal\\animal3\\" + num + ".jpg");
                //创建一个JLable的对象（管理容器）
                JLabel jLabel = new JLabel(icon);
                //指定图片位置
                jLabel.setBounds(105 * j, 105 * i, 105, 105);
                //getContentPane获取隐藏容器，再把管理容器添加到界面中
                //this.add(jLabel);
                this.getContentPane().add(jLabel);

            }
        }

    }


    private void initJMenuBar() {
        //创建整个的菜单对象
        JMenuBar jMenuBar = new JMenuBar();


        //创建菜单上两个选项的对象（功能、关于我们）
        JMenu functionJMenu = new JMenu("功能");
        JMenu aboutJMenu = new JMenu("关于我们");

        //创建选项下面的条目对象
        JMenuItem replayItem = new JMenuItem("重新游戏");
        JMenuItem reLoginItem = new JMenuItem("重新登录");
        JMenuItem closeItem = new JMenuItem("关闭游戏");

        JMenuItem accountItem = new JMenuItem("制作人微信");
        JMenuItem supportItem = new JMenuItem("打赏");

        //将每一个选项下面的条目添加到选项中
        functionJMenu.add(replayItem);
        functionJMenu.add(reLoginItem);
        functionJMenu.add(closeItem);

        aboutJMenu.add(accountItem);
        aboutJMenu.add(supportItem);

        //将菜单里的两个选项添加到菜单中
        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutJMenu);

        //给整个界面设置菜单
        this.setJMenuBar(jMenuBar);
    }

    private void initJFrame() {
        //设置窗体宽高
        this.setSize(603, 680);
        //设置界面的标题
        this.setTitle("拼图单机版 v1.0");
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //取消默认居中放置，取消之后才能按照xy轴的形式添加组件
        this.setLayout(null);
    }
}
