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
    public List<List<Integer>> threeSum(int[] nums) {
        List<Integer> item; 
        // by default would be set
        Set<List<Integer>> items = new HashSet<>();
        if (nums == null || nums.length <= 2) {
            return items.toArray();
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
        return new ArrayList(items);
    }

    public List<Integer> constructItem(int a, int b, int c) {
        List<Integer> item = new LinkedList<>();
        item.add(a);
        item.add(b);
        item.add(c);
        return item;
    }
}
// @lc code=end

