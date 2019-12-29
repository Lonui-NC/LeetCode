import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {
    // 其实原因是C63 没有完全覆盖所有情况
    public List<List<Integer>> threeSumV1(int[] nums) {
        List<Integer> item; 
        // by default would be set
        Set<List<Integer>> items = new HashSet<>();
        if (nums == null || nums.length <= 2) {
            // return items.toArray();
        }
        // 基本思路对，问题在于如何去重 
        // 如果使用Java的话，那么先进行排序
        int[] unique = nums;
        Arrays.sort(unique);
        // 用一个set来做暂存的数据，保证不会有重复数据加入
        int i, j, k, base;
        for (i=0;i<unique.length-1;i++) {
            base = unique[i] + unique[i+1];
            for (j=i+2;j<unique.length;j++) {
                if (base + unique[j] == 0) {
                    // 顺序
                    item = constructItem(unique[i], unique[i+1], unique[j]);
                    items.add(item);
                }
            }
            // C(3,6)遍历其余的部分，从倒数第二个遍历其他 - 顺序
            for (k=i-2;k>=0;k--) {
                if (base + unique[k] == 0) {
                    item = constructItem(unique[k], unique[i], unique[i+1]);
                    items.add(item);
                }
            }
        }
        // return new ArrayList(items);
    }

    public List<Integer> constructItem(int a, int b, int c) {
        List<Integer> item = new LinkedList<>();
        item.add(a);
        item.add(b);
        item.add(c);
        return item;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        // 所以最关键的一步还是需要数组排序
        // Arrays.sort()
        // Arrays.asList("a", "b", "c")
        // 分析出了原理，解析了关键步骤，就OK了
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        if (nums == null || nums.length < 3) {
            return ans;
        }
        Arrays.sort(nums); // 排序， 关键一步
        for(int i=0;i<len;i++) {
            // 因为是从小到大去找，所以如果最小的已经大于0，那么就可以直接break了
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i-1]) continue; // 去重
            // 双指针法，从头尾进行遍历
            int L = i + 1;
            int R = len - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while (L<R && nums[L] == nums[L+1]) L++; //去重L
                    while (L<R && nums[R] == nums[R-1]) R--; //去重R
                    L++;
                    R--;
                } else if (sum > 0) {
                    R--;
                } else if (sum < 0) {
                    L++;
                }
            }
        }   
        return ans;
    }

}
// @lc code=end

