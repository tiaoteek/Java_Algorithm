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

    }

    public int singleNumber(int[] nums) {
        int[] bitSums = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                bitSums[i] += (num >> (31 - i)) & 1;
            }
        }

        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = (result << 1) + bitSums[i] % 3;
        }

        return result;
    }

}
