/**
 * @Auther: Lance.Lu
 * @Date: 2020/8/23 22:52
 * @Description: https://leetcode-cn.com/problems/sqrtx/
 */
public class MySqrt {
    public int mySqrt(int x) {
        int left = 0, right = x, res = -1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if ((long)mid * mid <= x) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}
