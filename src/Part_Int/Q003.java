package Part_Int;

import java.util.Scanner;

/**
 * @Date: 2021/9/15
 * @Author: Tiaoteek
 * @Brief:
 * 面试题 3：前 n个数字二进制中 1的个数
 * 输入一个非负数n，请计算0到 n之间每个数字的二进制表示中1的个数，并输出一个数组。
 * 例如，输入n为4，由于0、1、2、3、4的二进制表示的1的个数分别为0、1、1、2、1，
 * 因此输出数组[0, 1, 1, 2, 1]。
 */
public class Q003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入一个正整数n:");
        int n = sc.nextInt();
        int[] res = countBits2(n);
        for(int i:res){
            System.out.print(i+"  ");
        }

    }

    public static int[] countBits1(int num) {
        //生成一个存放1数量的数组
        int[] result = new int[num + 1];
        //挨个计算数字中的1个数
        for (int i = 0; i <= num; ++i) {
            //将对应位置的数给j，这里不能直接用i，会影响循环体
            int j = i;
            while (j != 0) {
                //计算去掉最后一个1的次数
                result[i]++;
                //这种方式可以将数最后边的1去掉，即将11110 --> 11100
                j = j & (j - 1);
            }
        }
        return result;
    }

    public static int[] countBits2(int num) {
        int[] result = new int[num + 1];
        for (int i = 1; i <= num; ++i) {
            //递归的方式直接调用出结果
            result[i] = result[i & (i - 1)] + 1;
        }

        return result;
    }

    public static int[] countBits3(int num) {
        int[] result = new int[num + 1];
        for (int i = 1; i <= num; ++i) {
            result[i] = result[i >> 1] + (i & 1);
        }

        return result;
    }
}
