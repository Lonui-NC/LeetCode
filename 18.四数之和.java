import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=18 lang=java
 *
 * [18] 四数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            // 如果最小的数已经比target大，直接skip
            if (nums[i] * 4 > target) break;
            // 去重
            if (i > 0 && (nums[i] == nums[i-1])) continue; 
            int remain = target - nums[i];
            for (int j=i+1; j<len; j++) {
                // 这一步不对，因为后面两次相加的还有可能为负，所以不一定加起来就比remain大！！！
                // 所以用类比的方式取3或4倍来算 => 边界问题？？？
                if (nums[j] * 3 > remain) break;
                // 三数之和会多做一步check，但是这里不需要类似的，因为第一个例子不算，应该i + 1
                // scope language
                if (j > i + 1 && (nums[j] == nums[j-1])) continue; 
                // 仿照三数之和
                int L = j + 1;
                int R = len - 1; 
                while (L < R) {
                    int sum = nums[j] + nums[L] + nums[R];
                    if (sum == remain) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[L], nums[R]));
                        // 用相对的L和R来实现比较
                        while (L < R && nums[L] == nums[L+1]) L++; //去重
                        while (L < R && nums[R] == nums[R-1]) R--; //去重
                        L++;
                        R--;
                    } else if (sum > remain) {
                        R--;
                    } else if (sum < remain) {
                        L++;
                    }
                }
            }
        }
        return result;
    }
}
// @lc code=end

