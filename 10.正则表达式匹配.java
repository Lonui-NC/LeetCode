/*
 * @lc app=leetcode.cn id=10 lang=java
 *
 * [10] 正则表达式匹配
 */

// @lc code=start
class Solution {
    // 太过复杂 - 看答案！
    public boolean isMatchV1(String s, String p) {
        // it's a hard one 
        char[] parent = s.toCharArray();
        char[] sub = p.toCharArray();
        int subIndex = 0;
        char lastLetter = ' ';
        boolean sameLetter = false;
        // 先考虑基本情况，再考虑边界情况
        for (int i=0;(i < parent.length) && (subIndex < sub.length);i++) {
            if (sub[subIndex] == '.') {
                lastLetter = '.';
                subIndex += 1;
                sameLetter = false;
            } else if (sub[subIndex] == '*') {
                if (parent[i] == lastLetter || lastLetter == '.') {
                    subIndex += 1;
                    sameLetter = true;
                } else {
                    return false;
                }
            } else if (sub[subIndex] == parent[i]) {
                lastLetter = sub[subIndex];
                subIndex += 1;
                sameLetter = false;
            } else if (sameLetter && (lastLetter == parent[i]) ) {
                // 在是‘*’的匹配时，我们因为已经设置过了index的顺序，所以直接continue
                continue;
            } else {
                return false;
            }
        }

        // 边界情况 1 - parent已经遍历完，但是sub没有遍历完
        if (subIndex < sub.length) {
            // 只有以下几种可能
            // 1 - sub[subIndex] == '*'前面的字符重复一次
            if ((lastLetter == '.') && (subIndex = sub.lenth - 1) && (sub[subIndex] == '*')) {
                return true;
            }
            // 2 - 后面的情况为sub[subIndex + 1] = '*' - 包含了当前为.或其他字符的情况
        }
        // 边界情况 2 - parent没有遍历完，但是sub已经遍历完
        return true;
    }

    // 用回溯法 - 官方解法 - 其实主要问题在于*,先考虑没有*的情况
    // 如果模式串中有星号，它会出现在第二个位置，即 \text{pattern[1]}pattern[1] 。
    // 这种情况下，我们可以直接忽略模式串中这一部分，或者删除匹配串的第一个字符，前提是它能够匹配模式串当前位置字符，即 \text{pattern[0]}pattern[0] 。
    // 如果两种操作中有任何一种使得剩下的字符串能匹配，那么初始时，匹配串和模式串就可以被匹配。
    // 问题分解 - 相对复杂
    // 之所以会复杂度比较高是因为存在重复计算的情况
    public boolean isMatchV2(String text, String pattern) {
        // 空值情况判断
        if (pattern.isEmpty()) {
            return text.isEmpty();
        }
        boolean first_match = (!text.isEmpty() && (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));
        // 考虑直接删掉这个字符组合或者在first_match已经匹配的情况下比较后面的match(删掉parent当前匹配的字符)
        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            return (isMatch(text, pattern.substring(2)) || (first_match && isMatch(text.substring(1), pattern)));
        } else {
            return first_match && isMatch(text.substring(1), pattern.substring(1));
        }
    }

    // 动态规划法 - 将中间结果保存下来用于提高效率
    enum Result {
        TRUE, FALSE
    }

    Result[][] memo;

    public boolean isMatch(String text, String pattern) {
        memo = new Result[text.length() + 1][pattern.length() + 1];
        return dp(0, 0, text, pattern);
    }

    public boolean dp(int i, int j, String text, String pattern) {
        // 通过
        if (memo[i][j] != null) {
            return memo[i][j] == Result.TRUE;
        }
        boolean ans;
        // 必须两个同时为空
        if (j == pattern.length()) {
            ans = i == text.length();
        } else {
            boolean first_match = (i < text.length() && (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.'));
            if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*') {
                ans = (dp(i, j+2, text, pattern) || first_match && dp(i+1, j, text, pattern));
            } else {
                ans = first_match && dp(i+1, j+1, text, pattern);
            }
        }
        memo[i][j] = ans ? Result.TRUE : Result.FALSE;
        return ans;
    }
}
// @lc code=end

