/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        // 可以看成是三个/多个链表依次读
        if (strs == null || strs.length == 0) {
            return "";
        }
        int len = strs.length;
        boolean flag = true;
        int idx = 0;
        char c = ' ';
        StringBuilder result = new StringBuilder("");
        while(flag) {
            for (int i=0;i<len;i++) {
                if (idx >= strs[i].length()) {
                    flag = false;
                    break;
                }
                if (i == 0) {
                    c = strs[i].charAt(idx);
                    continue;
                } else if (c != strs[i].charAt(idx)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result.append(c);
                idx++;
            }
        }
        return result.toString();
    }
}
// @lc code=end

