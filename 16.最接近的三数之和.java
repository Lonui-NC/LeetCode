import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 */

// @lc code=start
class Solution {
    public int threeSumClosestV1(int[] nums, int target) {
        // 这题可以仿照上面的解题法来做，双指针法
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int len = nums.length;
        int ans = Integer.MAX_VALUE;
        int result = 0;
        for (int i=0;i<len;i++) {
            // if (i>0 && nums[i] == nums[i-1]) continue;
            // // 判断截止条件
            // // 1 - 如果当前num值大于已知ans + target, 那么后面都会一定大
            // if (ans < nums[i] - target) {
            //     break;
            // }
            int L = i + 1;
            int R = len - 1;
            // 做一次判断和截断 - 分大于情况和小于情况，分别计算才会有效
            // 计算smt最小值
            // 之所以不能按下面的来做，还是因为必须要整体考虑加减的情况，而不能直接实现
            while (L<R) {
                int sum = nums[i] + nums[L] + nums[R];
                int smt = sum - target; 
                if (smt < 0) {
                    break;
                }
                if (smt < ans) {
                    ans = smt;
                    result = sum;
                }
                R--;
            }
            // 计算smt最小值，可以保留上面R的临界值，因为是恰好的临界值刚好为负值
            while (L<R) {
                int sum = nums[i] + nums[L] + nums[R];
                int tms = target - sum;
                if (tms < 0) {
                    break;
                }
                if (tms < ans) {
                    ans = tms;
                    result = sum;
                }
                L++;
            }
            if (ans == 0) {
                break;
            }
        }
        return result;
    }


    public int threeSumClosest(int[] nums, int target) { 
        // 这题可以仿照上面的解题法来做，双指针法
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int len = nums.length;
        int ans = Integer.MAX_VALUE;
        int result = 0;
        for (int i=0;i<len;i++) {
            int L = i + 1;
            int R = len - 1;
            while (L<R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (Math.abs(sum - target) < Math.abs(ans)) {
                    ans = Math.abs(sum - target);
                    result = sum;
                }
                // 直接双指针拼凑值就可以，其实类似我的，但是没有动态的转化
                if (sum > target) {
                    R--;
                } else if (sum < target) {
                    L++;
                } else { // sum == target 
                    return sum;
                }
            }
        }
        return result;
    }
}
// @lc code=end

