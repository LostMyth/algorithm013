import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Lance.Lu
 * @Date: 2020/9/15 22:23
 * @Description: https://leetcode-cn.com/problems/generate-parentheses/
 */
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        dfs(0, 0, n, "", list);
        return list;
    }

    private void dfs(int left, int right, int n, String s, List<String> list) {
        if (left == n && right == n) {
            list.add(s);
            return;
        }
        if (left < n) {
            dfs(left + 1, right, n, s + "(", list);
        }
        if (right < left) {
            dfs(left, right + 1, n, s + ")", list);
        }
    }

    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        generateParenthesis.generateParenthesis(3).forEach(System.out::println);
    }
}
