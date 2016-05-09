package com.sm.xblock;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Random;

/**
 * Created by smplayer on 2016/5/3.
 */
public class KeyGenerator {

    public void generateRandomNumber() {
        Random r = new Random();
        try {
            FileOutputStream out = new FileOutputStream("keys.txt");
            PrintStream p = new PrintStream(out);
            for (int i = 0; i < 10000; i++) {
                int n = r.nextInt(999999999);
                p.println(n);
            }
            p.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void getFixLenthString(int strLength) {

        Random rm = new Random();


        for (int i = 0; i < 200; i++) {

            // 获得随机数
            double pross1 = (1 + rm.nextDouble()) * Math.pow(10, strLength);
            // 将获得的获得随机数转化为字符串
            String fixLenthString1 = String.valueOf(pross1);

            // 获得随机数
            double pross2 = (1 + rm.nextDouble()) * Math.pow(10, strLength);
            // 将获得的获得随机数转化为字符串
            String fixLenthString2 = String.valueOf(pross2);

            String s = fixLenthString1.substring(2, strLength + 1) + "A" + fixLenthString2.substring(2, strLength + 1);

        }

        // 返回固定的长度的随机数
    }

    private void toSN(String chars, FileOutputStream fos, Random random){

    }

    public static void main(String[] args) {
        KeyGenerator.getFixLenthString(7);
        char c=112;
        int a = 'A';
        System.out.println(c);
        System.out.println(a);
        System.out.println(Integer.toHexString(16*10 + 11));
        System.out.println(new String(Integer.toHexString(new Integer(0xAA01))).toUpperCase());
    }

}
