package Part_Int;

/**
 * @Date: 2021/9/15
 * @Author: Tiaoteek
 * @Brief:
 * 面试题 4：只出现一次的数字
 * 输入一个整数数组，数组中除一个数字只出现一次之外其他数字都出现三次。请找出那个唯一只出现一次的数字。
 * 例如，如果输入的数组为[0, 1, 0, 1, 0, 1, 100]，则只出现一次的数字时100。
 */

public class Q004 {
    public static void main(String[] args) {
        //输入测试数据数组
        System.out.println("输入的数组:[0, 2, 2, 2, 0, 0, 6]");
        int[] test = new int[]{0, 2, 2, 2, 0, 0, 6};
        //放入函数中进行处理
        int result = singleNumber(test);
        System.out.println("结果是："+result);

    }

    public static int singleNumber(int[] nums) {
        /*除了其中一个数，其他都是3的倍数，则一定可以被3整除
        *单独的数组成个数只有1个，除非是0，否则一定不能整除
        * 100*3+110=410，对应位置对3取余得110，得出结果
        * */
        //int类型是32位
        int[] bitSums = new int[32];
        //通过for循环将每个数对应位置相加
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                /*32位中，第i位的数加到对应的数组中
                 *num >> (31 - i)) & 1 --是用来提取第i个位置上的值
                 * 将要计算的位置右移到最后一位，与1 进行”与“操作进行提取
                 * */
                bitSums[i] += (num >> (31 - i)) & 1;
            }
        }

        int result = 0;
        for (int i = 0; i < 32; i++) {
            //通过for循环一边求对应位置的数，一边左移到相应的位置
            result = (result << 1) + bitSums[i] % 3;
        }

        return result;
    }

}
