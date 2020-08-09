import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Auther: Lance.Lu
 * @Date: 2020/8/9 19:28
 * @Description: https://leetcode-cn.com/problems/chou-shu-lcof/
 */
public class NthUglyNumber {
    /*
        我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
        示例:

        输入: n = 10
        输出: 12
        解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
        说明:  

        1 是丑数。
        n 不超过1690。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/chou-shu-lcof
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int nthUglyNumber(int n) {
        // 小顶堆
        Queue<Long> queue = new PriorityQueue<>();
        int count = 0;
        int[] uglyNums = new int[]{2, 3, 5};
        queue.add(1L);
        while(!queue.isEmpty()) {
            long uglyNum = queue.poll();
            if (++count >= n) {
                return (int)uglyNum;
            }
            for (int num : uglyNums) {
                if (!queue.contains(num * uglyNum)) {
                    queue.add(num * uglyNum);
                }
            }
        }
        return -1;
    }
}
