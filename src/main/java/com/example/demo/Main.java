package com.example.demo;

public class Main {
    //给定一个二叉树的根 root 和两个整数 val 和 depth ，在给定的深度 depth 处添加一个值为 val 的节点行。
    //
    //注意，根节点 root 位于深度 1 。
    //
    //加法规则如下:
    //
    //给定整数 depth，对于深度为 depth - 1 的每个非空树节点 cur ，创建两个值为 val 的树节点作为 cur 的左子树根和右子树根。
    //cur 原来的左子树应该是新的左子树根的左子树。
    //cur 原来的右子树应该是新的右子树根的右子树。
    //如果 depth == 1 意味着 depth - 1 根本没有深度，那么创建一个树节点，值 val 作为整个原始树的新根，而原始树就是新根的左子树。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode.cn/problems/add-one-row-to-tree
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static int depth = 1;
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        addOneRow(root, 1, 2);
        System.out.println(root.val);
        System.out.println(root.left.val);
        System.out.println(root.right.val);
        System.out.println(root.left.left.val);
        System.out.println(root.left.right.val);
        System.out.println(root.right.left.val);
        System.out.println(root.right.right.val);
    }

    public static TreeNode addOneRow(TreeNode root, int v, int d) {
        if (root == null){
            return null;
        }
        addOneRow(root.left, v, d + 1);
        addOneRow(root.right, v, d + 1);
        if (d == depth-1) {
            TreeNode left = new TreeNode(v);
            left.left = root.left;
            root.left = left;
            TreeNode right = new TreeNode(v);
            right.right = root.right;
            root.right = right;
        }
        return root;
    }
}
