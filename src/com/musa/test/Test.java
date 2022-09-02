package com.musa.test;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        //需求：
        //把一个一维数组中的数据：0~15 打乱顺序
        //然后再按照4个一组的方式添加到二维数组当中

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
        int[][] data = new int[4][4];
        //解法一：
        // 遍历一维数组tempArr得到每一个元素，把每一个元素一次添加到二维数组当中
        for (int i = 0; i < tempArr.length; i++) {
//            int row = 0;
//            data[row][i % 4] = tempArr[i];
//            System.out.println(data[row][i % 4] + " ");
//            if ((i + 1) % 4 == 0) {
//                row++;
//            }
            data[i / 4][i % 4] = tempArr[i];
        }
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println("");
        }
    }

}

