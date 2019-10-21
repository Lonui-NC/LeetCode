/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] 整数反转
 */

// @lc code=start
class Solution {
    public int reverse(int x) {
        int bitNum = 0;
        int result = 0;
        while(x != 0) {
            bitNum = x % 10;
            x = x / 10;
            // 之所以不能用((result * 10 + x % 10) <= Integer.MAX_VALUE)
            // 是因为在这个状态下已经溢出了
            // 所以需要只取前面的result < Integer.MAX_VALUE/10 
            // 如果 result == Integer.MAX_VALUE / 10, 就check最后一位是不是超过最大值
            // -2147483648——2147483647 
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE && bitNum > 7)) {
                return 0;
            }
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE && bitNum < -8)) {
                return 0;
            }
            result = result * 10 + bitNum; 
        }
        return result;
    }
}
// @lc code=end

