import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=32 lang=java
 *
 * [32] 最长有效括号
 */

// @lc code=start
class Solution {
    public int longestValidParentheses1(String s) {
        if (s == null || s == "") {
            return 0;
        }
        int max = 0; 
        int result = 0;
        Deque<Character> stack = new LinkedList<>();
        for (int i=0;i < s.length(); i++) {
            stack.push(s.charAt(i));
        }
        char cur, pre;
        pre = 0;
        while (!stack.isEmpty()) {
            cur = stack.pop();
            // 多加一步条件判断
            // 有效括号包含多种可能！
            // 学会找条件 - 明天看其余几种方法！
            // 需要动态匹配 pop才可以，而且是边pop，边push
            // 如果栈为空，说明当前的右括号为没有被匹配的右括号，我们将其下标放入栈中来更新我们之前提到的「最后一个没有被匹配的右括号的下标」
            if (pre == ')' && cur == '(') {
                result += 2;
                pre = cur;
                continue;
            } else {
                if (max <= result) {
                    max = result;
                }
                result = 0;
            }
            pre = cur;
        }
        return max * 2;
    }

    public int longestValidParentheses(String s) {
        int maxans = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }
}
// @lc code=end

