import java.util.Stack;

/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        // 考虑用一个栈来实现
        Stack<Character> stack = new Stack<>();
        if (s == null || s.length() == 0) {
            return true;
        }
        Character top;
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty()) {
                top = stack.peek();
                if (top == '(') {
                    if (c == ')') {
                        stack.pop();
                        continue;
                    }
                    if (c == ']' || c == '}') return false;
                }
                if (top == '[') {
                    if (c == ']') {
                        stack.pop();
                        continue;
                    }
                    if (c == ')' || c == '}') return false;
                }
                if (top == '{') {
                    if (c == '}') {
                        stack.pop();
                        continue;
                    }
                    if (c == ')' || c == ']') return false;
                }
            }
            stack.push(c);
        }
        return stack.isEmpty();
    }
}
// @lc code=end

