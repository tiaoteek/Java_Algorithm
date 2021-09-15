package Part_Int;

import java.util.Scanner;

/**
 * @Date: 2021/9/15
 * @Author: Tiaoteek
 * @Brief:
 * 面试题 1：整数除法
 * 输入两个int型整数，求它们除法的商，要求不得使用乘号'*'、除号'/'以及求余符号'%'。
 * 当发生溢出时返回最大的整数值。假设除数不为0。例如，输入15和2，输出15/2的结果，即7。
 */
public class Q001 {
    /**
     * dividend :被除数
     * divisor:除数
     * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("被除数：");
        int a = sc.nextInt();
        System.out.println("除数：");
        int b = sc.nextInt();;
        long startTime = System.currentTimeMillis();
//        long startTime = System.nanoTime();
        int c = divide(a,b);
        long endTime = System.currentTimeMillis();
//        long endTime = System.nanoTime();
        System.out.println("结果："+ c);
        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");

    }
    public static int divide(int dividend, int divisor) {
        //防止溢出，负数比正数多1
//        if (dividend == 0x80000000 && divisor == -1){
        if (dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        //假设有两个负值
        int negative = 2;
        //如果被除数为正，将被除数转为负数（负数转正数可能出现问题，故全使用负数进行计算）
        if (dividend > 0) {
            negative--;
            dividend = -dividend;
        }
        //同上
        if (divisor > 0) {
            negative--;
            divisor = -divisor;
        }
        //调用计算函数得到结果
        int result = divideCore(dividend, divisor);
        //判断正负值
        return negative == 1 ? -result : result;
    }

    private static int divideCore(int dividend, int divisor) {
        /**
         * 使用的指数倍数的方式进行计算的，有效降低时间复杂度
         * 15 = 2^3+2^2+2^1+1
         * */
        int result = 0;
        //因为两数都是负数，被除数小于除数（若是正数则大于）
        while (dividend <= divisor) {
            //这里将除数和部分商的值先保存
            int value = divisor;
            int quotient = 1;
            //防止溢出，保证value的2倍不超过最小值：0xc0000000 *2 = 0x00000000
            while (value >= 0xc0000000 && dividend <= value + value) {
                //差和除数都以指数的方式递增
                quotient += quotient;
                value += value;
            }
            //保存部分商，并减去对应的值
            result += quotient;
            dividend -= value;
        }
        return result;
    }
}
