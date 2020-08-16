/**
 * @Auther: Lance.Lu
 * @Date: 2020/8/13 23:07
 * @Description:
 */
public class LowestCommonAncestor {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode l1 = new TreeNode(5);
        root.left = l1;
        TreeNode l2 = new TreeNode(6);
        TreeNode l3 = new TreeNode(2);
        l1.left = l2;
        l1.right = l3;
        TreeNode l4 = new TreeNode(7);
        TreeNode l5 = new TreeNode(4);
        l3.left = l4;
        l3.right = l5;

        TreeNode r1 = new TreeNode(1);
        TreeNode r2 = new TreeNode(0);
        TreeNode r3 = new TreeNode(8);
        r1.left = r2;
        r1.right = r3;
        root.right = r1;

        LowestCommonAncestor test = new LowestCommonAncestor();
        System.out.println(test.lowestCommonAncestor(root, r2, r3).val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null) return right;
        if(right == null) return left;
        return root;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
