import java.util.Stack;

/**
 * @Auther: Lance.Lu
 * @Date: 2020/8/31 21:35
 * @Description: https://leetcode-cn.com/problems/minimum-path-sum/
 */
public class MinPathSum {

    public static void main(String[] args) {
        int[][] grid = {
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };
        System.out.println(minPathSum(grid));
    }

    public static int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 从第二步开始累加之前的
                if (i == 0 && j == 0) continue;
                // i，j 有一个为空时， 只能从一个方向来。
                if (i == 0) grid[i][j] = grid[i][j - 1] + grid[i][j];
                else if (j == 0) grid[i][j] = grid[i - 1][j] + grid[i][j];
                else grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
            }
        }
        return grid[m - 1][n - 1];
    }

    public static int minPathSum1(int[][] grid) {
        int min = 0;
        if (grid == null) return min;
        int width = grid[0].length - 1;
        int height = grid.length - 1;
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MAX_VALUE);
        dfs(0, 0, width, height, min, stack, grid);
        return stack.pop();
    }

    private static void dfs(int m, int n, int width, int height, int min, Stack<Integer> stack, int[][] grid) {
        min += grid[n][m];
        if (m == width && n == height) {
            if (stack.peek() > min) {
                stack.pop();
                stack.push(min);
            }
            return;
        }
        if (m < width) {
            dfs(m + 1, n, width, height, min, stack, grid);
        }
        if (n < height) {
            dfs(m, n + 1, width, height, min, stack, grid);
        }
    }
}
