/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
class Solution {
    public int maxAreaV1(int[] height) {
        // 基础做法 - 二次遍历数组 - n^2复杂度
        if (height == null) {
            return 0;
        }
        int max = 0;
        int temp = 0;
        int minHeight = 0;
        for (int i=0;i<height.length-1;i++){
            for (int j=i+1;j<height.length;j++){
                // 计算当前水桶的容量
                minHeight = Math.min(height[i], height[j]);
                temp = (j - i) * minHeight;
                if (temp > max) {
                    max = temp;
                }
            }
        }
        return max;
    }

    // 进阶做法 - 双指针法 - O(n)
    // 基础思路是需要找到两条尽可能长的边，并且两条边之间的距离尽可能远
    public int maxAreaV2(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l<r) {
            maxarea = Math.max(maxarea, Math.min(height[r], height[i]) * (r - l));
            // 只移动短的那条边，保证永远去寻找更大的面积 - 因为移动长边不会使面积增加
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxarea;
    }

}
// @lc code=end

