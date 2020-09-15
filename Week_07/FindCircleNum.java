/**
 * @Auther: Lance.Lu
 * @Date: 2020/9/15 22:46
 * @Description: https://leetcode-cn.com/problems/friend-circles/
 */
public class FindCircleNum {
    public int findCircleNum(int[][] M) {
        // 因为二维数组具有对称性,m[i][j] = m[j][i],所以可以用一维数据记录访问状态。
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfs(M, i, visited);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] m, int i, int[] visited) {
        for (int j = 0; j < m.length; j++) {
            if (m[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(m, j, visited);
            }
        }
    }

    public static void main(String[] args) {
        FindCircleNum findCircleNum = new FindCircleNum();
        int[][] m = new int[][]{
                {1, 1, 0},
                {1, 1, 0},
                {0, 1, 1}
        };
        System.out.println(findCircleNum.findCircleNum(m));
    }
}
