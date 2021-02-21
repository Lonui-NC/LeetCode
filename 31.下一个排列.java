import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=31 lang=java
 *
 * [31] 下一个排列
 */

// @lc code=start
class Solution {
    // 首先从后向前查找第一个顺序对 (i,i+1)(i,i+1)，满足 a[i] < a[i+1]a[i]<a[i+1]。这样「较小数」即为 a[i]a[i]。此时 [i+1,n)[i+1,n) 必然是下降序列。
    // 如果找到了顺序对，那么在区间 [i+1,n)[i+1,n) 中从后向前查找第一个元素 jj 满足 a[i] < a[j]a[i]<a[j]。这样「较大数」即为 a[j]a[j]。
    // 交换 a[i]a[i] 与 a[j]a[j]，此时可以证明区间 [i+1,n)[i+1,n) 必为降序。我们可以直接使用双指针反转区间 [i+1,n)[i+1,n) 使其变为升序，而无需对该区间进行排序。
    // 思路和我想的差不多，只是需要找到第一个顺序对满足两者都小的关系！
    // 然后最后可以直接翻转升序，不用再调用排序
    // 同时我们要让这个「较小数」尽量靠右，而「较大数」尽可能小。

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        // 找到第一个顺序对
        while (i >= 0 && nums[i] >= nums[i+1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i+1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    // 两边扫描写错了！
    public void nextPermutation1(int[] nums) {
        // 是在前一个的基础上做调整
        // 类似是局部有序 - 双指针法 - 字典序反向 
        // 两个for循环指针！
        int temp;
        int i,j;
        for (i=nums.length - 1; i > 0; i--) {
            for (j=i-1; j >= 0; j--) {
                // 找到比最后的大一点的数字
                // 前面位数大，后面位数小
                if (nums[i] > nums[j]) {
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    // 保险起见交换了前面的位数需要把后面再变成有序 - 最小的！
                    Arrays.sort(nums, j + 1, nums.length);
                    return;
                }
            }
        }
        //如果没找到 - rearrange order
        Arrays.sort(nums);
        return;
    }
}
// @lc code=end

