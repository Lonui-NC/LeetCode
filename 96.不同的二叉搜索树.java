/*
 * @lc app=leetcode.cn id=96 lang=java
 *
 * [96] 不同的二叉搜索树
 */

// @lc code=start
class Solution {
    public int numTrees(int n) {
        // 数学方法写出递推公式就好求解了！
        // return numTrees(n - 1) * 2 + 
        // 同理这个可以看成是两个子问题的集合 -> 左右子树都是二叉搜索树
        // 所以等同于左右数字相乘，就是卡特兰数！！！！！！！！
        int[] G = new int[n+1];
        // 0和1 空节点和单个节点
        G[0] = 1;
        G[1] = 1;
        for (int i=2; i<=n; i++) {
            for (int j=1; j<=i; j++) {
                G[i] += G[j-1] * G[i-j];
            }
        }
        return G[n];
    }
}
// @lc code=end
