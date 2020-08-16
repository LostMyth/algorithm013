import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Auther: Lance.Lu
 * @Date: 2020/8/17 01:07
 * @Description:
 */
public class Combine {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (n <= 0 || k <= 0 || n < k) {
            return result;
        }
        findCombinations(n, k, 1, new Stack<>(), result);
        return result;
    }

    private void findCombinations(int n, int k, int index, Stack<Integer> p, List<List<Integer>> result) {
        if (p.size() == k) {
            result.add(new ArrayList<>(p));
            return;
        }
        for (int i = index; i <= n - (k - p.size()) + 1; i++) {
            p.push(i);
            findCombinations(n, k, i + 1, p, result);
            p.pop();
        }
    }
}
