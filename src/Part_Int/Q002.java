package Part_Int;

import java.util.Scanner;

/**
 * @Date: 2021/9/15
 * @Author: Tiaoteek
 * @Brief:
 *面试题 2：二进制加法
 * 输入两个表示二进制的字符串，请计算它们的和，并以二进制字符串的形式输出。
 * 例如输入的二进制字符串分别是"11"和"10"，则输出"101"。
 */
public class Q002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入两个表示二进制的字符串");
        System.out.println("输入第一个二进制的字符串：");
        String a = sc.nextLine();
        System.out.println("输入第二个二进制的字符串：");
        String b = sc.nextLine();

        String res = addBinary(a,b);
        System.out.println("结果是："+res);
    }

    public static String addBinary(String a, String b) {
        //StringBuilder类型更适合字符串的拼接
        StringBuilder result = new StringBuilder();
        //取得最后一位的索引
        int i = a.length() - 1;
        int j = b.length() - 1;
        //默认进位为0
        int carry = 0;
        while (i >= 0 || j >= 0) {
            //字符转换为数字，与字符0做对比
            int digitA = i >= 0 ? a.charAt(i--) - '0' : 0;
            int digitB = j >= 0 ? b.charAt(j--) - '0' : 0;
            //当前位的值等于当前位上的数与进位的相加
            int sum = digitA + digitB + carry;
            //结果与2做对比，等于则进1，小于则为0
            carry = sum >= 2 ? 1 : 0;
            //结果与2做对比，减2或不变
            sum = sum >= 2 ? sum - 2 : sum;
            //当前位的值保存下来
            result.append(sum);
        }
        //计算到最高位，如果进位上有值，则继续添加
        if (carry == 1) {
            result.append(1);
        }
        //结果是倒序，反转即可
        return result.reverse().toString();
    }
}
