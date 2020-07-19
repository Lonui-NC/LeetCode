/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start
class Solution {
    // 动态规划法 - n+1数组空间
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    // 斐波那契数列
    public int climbStairsV2(int n) {
        if (n < 1) {
            return 0;
        }
        int prev = 0;
        int cur = 1; 
        int temp;
        for (int i=0; i < n; i++) {
            temp = cur;
            cur = cur + prev;
            prev = temp;
        }
        return cur;
    }
}
// @lc code=end

