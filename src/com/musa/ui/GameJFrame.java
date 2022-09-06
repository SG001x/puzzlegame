package com.musa.ui;

import com.sun.jdi.PathSearchingVirtualMachine;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

//创建二维数组
//目的：用于管理数据
//加载图片的时候，会根据二维数组中的数据进行加载

public class GameJFrame extends JFrame implements KeyListener, ActionListener {
    // 规定：GameJFrame代表游戏主界面
    int[][] data = new int[4][4];

    //x，y记录空白方块在二维数组中的位置
    int x = 0;
    int y = 0;

    //定义一个变量，记录当前展示图片的路径
    String path = "puzzlegame\\image\\animal\\animal3\\";

    //定义一个二维数组，存储正确的数据
    int[][] win = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 0}
    };


    //定义变量用来统计步数
    int step = 0;

    //创建选项下面的条目对象
    JMenuItem replayItem = new JMenuItem("重新游戏");
    JMenuItem reLoginItem = new JMenuItem("重新登录");
    JMenuItem closeItem = new JMenuItem("关闭游戏");

    JMenuItem accountItem = new JMenuItem("制作人微信");
    JMenuItem supportItem = new JMenuItem("打赏");


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


    //初始化数据（打乱）
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

        //解法二：
        //遍历二维数组，给里面的每一个数据赋值

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (tempArr[i * 4 + j] == 0) {
                    x = i;
                    y = j;
                }

                data[i][j] = tempArr[i * 4 + j];


            }
        }
    }

    //初始化图片
    // 添加图片的时候，就需要按照二维数组中管理的数据添加图片
    private void initImage() {


        //清空已有图像
        this.getContentPane().removeAll();

        if (victory()) {
            //显示胜利图标
            JLabel winJLabel = new JLabel(new ImageIcon("C:\\Users\\SG001x\\IdeaProjects\\puzzlegame\\image\\win.png"));
            winJLabel.setBounds(203, 283, 197, 73);
            this.getContentPane().add(winJLabel);
        }

        JLabel stepCount = new JLabel("步数：" + step);
        stepCount.setBounds(80, 100, 120, 20);
        this.getContentPane().add(stepCount);


        //路径分为两种：
        // 绝对路径：一定是从盘符开始的
        // 相对路径：相对当前项目而言的
        // 实际开发时推荐写相对路径，因为相对路径在整个项目文件迁移至别的盘符、主机上时不会出错。

        //细节：
        // 先加载的图片在上方，后加图片在下。

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                //获取当前要加载的图片序号
                int num = data[i][j];
                //创建一个图片ImageIcon的对象
                ImageIcon icon = new ImageIcon(path + num + ".jpg");
                //创建一个JLable的对象（管理容器）
                JLabel jLabel = new JLabel(icon);
                //指定图片位置
                jLabel.setBounds(105 * j + 83, 105 * i + 134, 105, 105);
                //给图片添加边框
                //0 (== BevelBorder.RAISED):表示让图片凸起来
                //1 (== BevelBorder.LOWERED):表示让图片凹下去。
                jLabel.setBorder(new BevelBorder(BevelBorder.LOWERED));

                //getContentPane获取隐藏容器，再把管理容器添加到界面中
                //this.add(jLabel);
                this.getContentPane().add(jLabel);

            }
        }

        //添加背景图片
        JLabel gameGoard = new JLabel(new ImageIcon("puzzlegame\\image\\background.png"));
        gameGoard.setBounds(40, 40, 508, 560);
        //把背景图片添加到界面当中
        this.getContentPane().add(gameGoard);

        JLabel background = new JLabel(new ImageIcon("puzzlegame\\image\\木材质背景.jpg"));
        background.setBounds(0, 0, 603, 680);
        //把背景图片添加到界面当中
        this.getContentPane().add(background);

        //刷新背景图片
        this.getContentPane().repaint();
    }


    private void initJMenuBar() {
        //创建整个的菜单对象
        JMenuBar jMenuBar = new JMenuBar();


        //创建菜单上两个选项的对象（功能、关于我们）
        JMenu functionJMenu = new JMenu("功能");
        JMenu aboutJMenu = new JMenu("关于我们");


        //将每一个选项下面的条目添加到选项中
        functionJMenu.add(replayItem);
        functionJMenu.add(reLoginItem);
        functionJMenu.add(closeItem);

        aboutJMenu.add(accountItem);
        aboutJMenu.add(supportItem);


        //给条目绑定事件
        replayItem.addActionListener(this);
        reLoginItem.addActionListener(this);
        closeItem.addActionListener(this);
        accountItem.addActionListener(this);
        supportItem.addActionListener(this);


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

        //给整个界面添加键盘监听事件
        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    //按下不松时会调用这个方法
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == 65) {
            //把界面中的图片删除
            this.getContentPane().removeAll();
            //加载第一张完整的图片
            JLabel all = new JLabel(new ImageIcon(path + "all.jpg"));
            all.setBounds(83, 134, 420, 420);
            this.getContentPane().add(all);


            //加载背景图片
            JLabel gameGoard = new JLabel(new ImageIcon("puzzlegame\\image\\background.png"));
            gameGoard.setBounds(40, 40, 508, 560);
            //把背景图片添加到界面当中
            this.getContentPane().add(gameGoard);

            JLabel background = new JLabel(new ImageIcon("puzzlegame\\image\\木材质背景.jpg"));
            background.setBounds(0, 0, 603, 680);
            //把背景图片添加到界面当中
            this.getContentPane().add(background);


            //刷新背景图片
            this.getContentPane().repaint();
        }
    }

    //松开按键时会调用这个方法
    @Override
    public void keyReleased(KeyEvent e) {
        //判断游戏是否胜利，胜利则方法结束，限制移动
        if (victory()) {
            return;
        }

        //对上下左右进行判断
        //左：37   上：38   右：39   下：40。
        int code = e.getKeyCode();
        //逻辑：
        // 通过方位键将空白方块反方向的方块往空白方向移动，方位键的方向即移动方向。
        if (code == 37) {
            if (y == 3) {
                //空白方块抵达右边界
                return;
            }
            //向左移动
            data[x][y] = data[x][y + 1];
            data[x][y + 1] = 0;
            y++;
            step++;
            initImage();
        } else if (code == 38) {
            if (x == 3) {
                //空白方块抵达下边界
                return;
            }
            //向上移动
            data[x][y] = data[x + 1][y];
            data[x + 1][y] = 0;
            x++;
            step++;
            //调用方法按照最新的数字加载图片
            initImage();
        } else if (code == 39) {
            if (y == 0) {
                //空白方块抵达左边界
                return;
            }
            //向右移动
            data[x][y] = data[x][y - 1];
            data[x][y - 1] = 0;
            y--;
            step++;
            initImage();
        } else if (code == 40) {
            if (x == 0) {
                //空白方块抵达上边界
                return;
            }
            //向下移动
            data[x][y] = data[x - 1][y];
            data[x - 1][y] = 0;
            x--;
            step++;
            initImage();
        } else if (code == 65) {
            initImage();
        } else if (code == 87) {
            data = new int[][]{
                    {1, 2, 3, 4},
                    {5, 6, 7, 8},
                    {9, 10, 11, 12},
                    {13, 14, 15, 0},
            };
            initImage();
        }
    }

    //判断data数组中的数据是否跟win数组是否相同
    // 如果全部相同返回true，否则返回false。
    public boolean victory() {
        for (int i = 0; i < data.length; i++) {
            // i:以此表示二维数组
            // data[i]:依次表示每一个一维数组
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] != win[i][j]) {
                    //只要有一个数据不一样，返回false
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //获取当前被点击的条目对象
        Object obj = e.getSource();
        //判断
        if (obj == replayItem) {
            System.out.println("重新游戏");
            //计步器清零
            step = 0;
            //再次打乱二维数组中的数据
            initData();
            //重新加载图片
            initImage();
        } else if (obj == reLoginItem) {
            System.out.println("重新登录");
            //关闭当前游戏界面
            this.setVisible(false);
            //打开登录界面
            new LoginJFrame();
        } else if (obj == closeItem) {
            System.out.println("关闭游戏");
            //直接关闭虚拟机即可
            System.exit(0);
        } else if (obj == accountItem) {
            System.out.println("制作人微信");
            //创建一个弹框对象
            JDialog jDialog = new JDialog();
            //创建一个管理图片的容器对象JLabel
            JLabel jLabel = new JLabel(new ImageIcon("puzzlegame\\image\\制作人微信.jpg"));
            //设置位置和宽高
            jLabel.setBounds(0,0,500,500);
            //把图片添加到弹框中
            jDialog.getContentPane().add(jLabel);
            //给弹框设置大小
            jDialog.setSize(500,500);
            //让弹窗置顶
            jDialog.setAlwaysOnTop(true);
            //让弹窗居中
            jDialog.setLocationRelativeTo(null);
            //弹窗关闭则无法操作下面的界面
            jDialog.setModal(true);
            //让弹窗显示出来
            jDialog.setVisible(true);

        } else if (obj == supportItem) {
            //创建一个弹框对象
            JDialog jDialog = new JDialog();
            //创建一个管理图片的容器对象JLabel
            JLabel jLabel = new JLabel(new ImageIcon("puzzlegame\\image\\打赏.jpg"));
            //设置位置和宽高
            jLabel.setBounds(0,0,447,696);
            //把图片添加到弹框中
            jDialog.getContentPane().add(jLabel);
            //给弹框设置大小
            jDialog.setSize(447,696);
            //让弹窗置顶
            jDialog.setAlwaysOnTop(true);
            //让弹窗居中
            jDialog.setLocationRelativeTo(null);
            //弹窗关闭则无法操作下面的界面
            jDialog.setModal(true);
            //让弹窗显示出来
            jDialog.setVisible(true);
        }
    }
}
