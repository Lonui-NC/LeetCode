/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除排序数组中的重复项
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        // 其实很简单，判断加元素移动
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 双指针法
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            if (nums[i] == nums[j]) {
                j++;
            } else {
                nums[i+1] = nums[j];
                i++;
                // 去掉这个也一样，虽然没有那么优雅
                // j++;
            }
        }
        return i+1;
    }
}
// @lc code=end

