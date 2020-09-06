/**
 * @Auther: Lance.Lu
 * @Date: 2020/9/6 22:00
 * @Description:
 */
public class NumDecodings {
    public static void main(String[] args) {
        String s = "226";
        int result = numDecodings(s);
        System.out.println(result);
        System.out.println(numDecodings1(s));
    }

    // 和动态规划一样， 只是使用变量替换数组， 降低空间复杂度
    private static int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;
        int pre = 1, curr = 1;//dp[-1] = dp[0] = 1
        for (int i = 1; i < s.length(); i++) {
            int tmp = curr;
            if (s.charAt(i) == '0')
                if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') curr = pre;
                else return 0;
            else if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) >= '1' && s.charAt(i) <= '6'))
                curr = curr + pre;
            pre = tmp;
        }
        return curr;
    }

    // 动态规划
    private static int numDecodings1(String s) {
        int n = s.length();
        if (n == 0 || s.charAt(0) == '0')     return 0;
        int[] dp = new int [n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; ++i) {
            if (s.charAt(i - 2) == '1' || s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6')
                dp[i] += dp[i - 2];
            if (s.charAt(i - 1) != '0')
                dp[i] += dp[i - 1];
        }
        return dp[n];
    }
}
