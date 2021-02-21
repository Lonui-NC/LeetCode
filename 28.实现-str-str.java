/*
 * @lc app=leetcode.cn id=28 lang=java
 *
 * [28] 实现 strStr()
 */

// @lc code=start
class Solution {
    // str2 => check -> 暴力法会超时！

    // 1. 用了substring的判断
    // for (int start = 0; start < n - L + 1; ++start) {
    //     if (haystack.substring(start, start + L).equals(needle)) {
    //       return start;
    //     }
    //   }
    //   return -1;
    // }
  
    // 2. 用滑动窗口 -》 还是指针加上下限更好实现
  
    public int strStr(String haystack, String needle) {
        // 两种方法，暴力扫描 + 滑动窗口
        int nH = haystack.length();
        int nN = needle.length();
        if (nN == 0) {
            return 0;
        }

        // 滑动窗口下标 - N - L + 1
        for (int i=0; i < nH - nN + 1; i++) {
            for (int j=0; j < nN; j++) {
                if (haystack.charAt(i+j) != needle.charAt(j)) {
                    break;
                }
                // all is matched 
                if (j == nN - 1) {
                    return i;
                }

            }
        }
        return -1;
    }
}
// @lc code=end

