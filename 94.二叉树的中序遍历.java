import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return new ArrayList<Integer>();
        }
        result.addAll(inorderTraversal(root.left));
        result.add(root.val);
        result.addAll(inorderTraversal(root.right));
        return result;
    }

    // 回溯思路
    // 先遍历左节点 -> 再遍历当前节点 -> 再遍历右节点
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stk = new ArrayDeque<>();
        while (root != null || !stk.isEmpty()) {
            // 把所有左节点都拿到
            while(root != null) {
                // 先push自己
                stk.push(root);
                root = root.left;
            }
            root = stk.pop(); // 最左的节点 且没有左节点
            // 插入 - 是中间
            result.add(root.val);
            root = root.right;
            // // 证明是边缘节点 -> 直接pop出来
            // if (root.right == null) {
            //     continue; // 所以这一步多余 - 但也要优化后才能写出来！
            // } else {
            //     // in case 有右节点 - 右节点遍历一遍其实就是小问题的分解
            //     root = root.right; 
            // }
        }
        return result;
    }

    // 单独拿出一个inorder的好处在于不用创建多个arraylist和多个arrayList的addAll
    // public void inorder(TreeNode root, List<Integer> res) {
    //     if (root == null) {
    //         return;
    //     }
    //     inorder(root.left, res);
    //     res.add(root.val);
    //     inorder(root.right, res);
    // }

    // 用回溯的方法来实现 - 模拟一个栈？


}
// @lc code=end

