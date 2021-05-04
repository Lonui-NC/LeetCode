import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=101 lang=java
 *
 * [101] 对称二叉树
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
    // 思路对，但not efficent
    // public boolean isSymmetric(TreeNode root) {
    //     // 基础法 - 二叉树翻转 + 比较
    //     if (root == null) {
    //         return true;
    //     }

    //     if (root.left == null && root.right == null) {
    //         return true;
    //     } else if (root.left == null || root.right == null) {
    //         return false;
    //     } else if (root.left.val == root.right.val) {
    //         // 看下面的节点是不是对称的
    //         TreeNode reversedLeft = reverse(root.left);
    //     } 
    //     return false;
    // }

    // public TreeNode reverse(TreeNode root) {
    //     if (root == null) {
    //         return null;
    //     }

    //     TreeNode left = reverse(root.left);
    //     TreeNode right = reverse(root.right);
    //     root.left = right;
    //     root.right = left;
    //     return root;
    // }

    // public boolean isSameTree(TreeNode one, TreeNode two) {
    //     if (one == null && two == null) {
    //         return true;
    //     } else if (one == null || two == null) {
    //         return false;
    //     }

    //     if (one.val != two.val) {
    //         return false;
    //     } else {
    //         return isSameTree(one.left, two.left) && isSameTree(one.right, two.right);
    //     }
    // }

    // 还是有意义和意思的题目！
    public boolean isSymmetric(TreeNode root) {
        // 问题转化 - 将是否为镜像树转化为：两个树在什么情况下互为镜像？
        // 每层遍历比较实现！
        if (root == null) {
            return true;
        } else {
            return checkSymmetric(root.left, root.right);
        }
    }

    public boolean checkSymmetricV1(TreeNode one, TreeNode two) {
        if (one == null && two == null) {
            return true;
        } else if (one == null || two == null) {
            return false;
        } else {
            return one.val == two.val && checkSymmetric(one.left, two.right) && checkSymmetric(one.right, two.left);
        }
    }

    // 递归的方法判断 -> 其实就是模拟实现了一个栈
    // 两个栈同时插入pop

    public boolean checkSymmetric(TreeNode one, TreeNode two) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(one);
        queue.offer(two);

        while(!queue.isEmpty()) {
            one = queue.poll();
            two = queue.poll();

            if (one == null && two == null) {
                continue;
            }

            if ((one == null || two == null) || (one.val != two.val)){
                return false;
            }

            queue.offer(one.left);
            queue.offer(two.right);

            queue.offer(one.right);
            queue.offer(two.left);
        }
        return true;
    }
}
// @lc code=end

