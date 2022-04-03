import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=653 lang=java
 *
 * [653] 两数之和 IV - 输入 BST
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
    public boolean findTarget1(TreeNode root, int k) {
        // 暴力法先上
        if (root == null) {
            return false;
        } 

        // 抽象成二叉搜索树找特定值，但问题在于要先有一个值，不好确定
        // 还是暴力遍历 - 基本 
        // set.add 
        // set.contains 
        Set<Integer> set = new HashSet<Integer>();
        TreeNode cur;
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            cur = stack.pop();
            if (cur == null) {
                continue;
            }
            if (set.contains(k - cur.val)) {
                return true;
            }
            set.add(cur.val);
            stack.add(cur.left);
            stack.add(cur.right);
        }
        return false;
    }


    // 深度优先搜索dfs加hash set最简单！
    // set要独立成总体的变量才能保持状态
    Set<Integer> set = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);
    }

}


// 类似层序遍历
// set 永远都存了值
class TwoSumIVBST2 {
    boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        Set<Integer> set = new HashSet<>();
        return dfs(root, k, set);
    }
    private boolean dfs(TreeNode node, int k, Set<Integer> set) {
        if (node == null) return false;
        if (set.contains(k - node.val)) return true;
        set.add(node.val);
        return dfs(node.left, k, set) || dfs(node.right, k, set);
    }
}


// test case
class TwoSumIVBSTTest {
    @Test
    void testFindTarget() {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        node3.right = node5;
        int target = 9;
        assertTrue(new TwoSumIVBST().findTarget(root, target));
        target = 28;
        assertFalse(new TwoSumIVBST().findTarget(root, target));
    }
}
// @lc code=end

