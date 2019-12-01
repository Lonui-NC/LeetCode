/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] x 的平方根
 */

// @lc code=start
class Solution {
    public int mySqrtV1(int x) {
        // 采用二分查找法
        // 由于小数会被舍去，所以是找到r^2 <= x 的最后一个数
        return findSqrtV1(x, 0, x);
    }

    // 这就是为什么不建议用递归的原因 - 调用链过长会爆栈！ - 2147395599
    // 递归方式 - 但其实可以用while循环来做
    public int findSqrtV1(int x, int low, int high) {
        int mid = low + (high - low)/2;
        if (mid * mid > x) {
            return (mid - 1 >= 0) ? findSqrt(x, low, mid - 1) : low;
        } else if (mid * mid == x) {
            return mid;
        } else {
            // 这时因为mid有可能包括进去 
            if ((mid + 1 <= x) && ((mid + 1) * (mid + 1) > x)) {
                return mid;
            } else {
                return findSqrt(x, mid + 1, high);
            }
        }
    }

    // 使用循环的方式来写二分查找 - 一道小题不简单！！！
    // 如果这道题我出，我会限制只能用int来解决，不能用long！ - 看对边界条件的分析！！！
    public int mySqrt(int x) {
        int low = 0;
        int high = x;
        int mid;
        // 考虑为0的情况
        if (x == 0 || x == 1) {
            return x;
        }
        while (low <= high) {
            mid = low + (high - low)/2;
            // 考虑除0问题
            if (mid > (x/mid)) {
                if (mid - 1 >= 0) {
                    high = mid - 1;
                } else {
                    return low;
                }
            } else {
                // 需要考虑数据越界问题 - int最大值 - 2147395599
                if ((mid + 1) > (x/(mid + 1))) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }
}
// @lc code=end

