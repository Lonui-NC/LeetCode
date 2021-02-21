/*
 * @lc app=leetcode.cn id=27 lang=java
 *
 * [27] 移除元素
 */

// @lc code=start
class Solution {
    public int removeElement(int[] nums, int val) {
        // 暴力法 - 比较修改 - 双指针
        int L = 0; 
        int R = nums.length - 1;
        int length = 0;
        while (L <= R) {
            if (nums[L] == val) {
                nums[L] = nums[R];
                R--;
            } else {
                L++;
                length++;
            }
        }
        return length;
    }
}
// @lc code=end

