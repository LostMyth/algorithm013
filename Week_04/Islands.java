/**
 * @Auther: Lance.Lu
 * @Date: 2020/8/18 22:23
 * @Description:
 */
public class Islands {
    public int numIslands(char[][] grid) {
        if (grid == null) {
            return 0;
        }
        int height = grid.length;
        if (height == 0) return 0;
        int width = grid[0].length;
        int res = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                char c = grid[i][j];
                if (c == '1') {
                    ++res;
                    dfs(i, j, width, height, grid);
                }
            }
        }
        return res;
    }

    //  解题思路， 如果当前点是陆地，则将将此陆地移走，再判断上下左右的点是否也为陆地，如果为陆地也移走。
    private void dfs(int i, int j, int width, int height, char[][] grid) {
        if (i < 0 || j < 0 || i >= height || j >= width || grid[i][j] == '0') {
            return;
        }
        // 将岛屿移走
        grid[i][j] = '0';
        // 上下左右四个点
        dfs(i - 1, j, width, height, grid);
        dfs(i + 1, j, width, height, grid);
        dfs(i, j - 1, width, height, grid);
        dfs(i, j + 1, width, height, grid);
    }

    public static void main(String[] args) {
        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        Islands islands = new Islands();
        System.out.println(String.format("共有%d个岛屿", islands.numIslands(grid)));
    }
}
