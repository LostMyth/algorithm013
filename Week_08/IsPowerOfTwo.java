/**
 * @Auther: Lance.Lu
 * @Date: 2020/10/9 23:21
 * @Description: https://leetcode-cn.com/problems/power-of-two/
 */
public class IsPowerOfTwo {
    public static void main(String[] args) {
        IsPowerOfTwo isPowerOfTwo = new IsPowerOfTwo();
        System.out.println(isPowerOfTwo.isPowerOfTwo(8));
        System.out.println(isPowerOfTwo.isPowerOfTwo(9));
    }

    // 2的幂次的二进制一定是1或者1后面跟上若干个0， 所以将最低位的1打掉如果为0，那么就是2的幂次。 打掉最低位1的方法： x & (x - 1)
    public boolean isPowerOfTwo(int n) {
        if (n == 0) return false;
        long x = (long) n;
        return (x & (x - 1)) == 0;
    }

    // x & -x 保留二进制最低位的1， 2的幂次的二进制一定是1或者1后面跟上若干个0， 如果结果为x， 则表示是2的幂次
    public boolean isPowerOfTwo1(int n) {
        if (n == 0) return false;
        long x = (long) n;
        return (x & (-x)) == x;
    }
}
