import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=9 lang=java
 *
 * [9] 回文数
 */

// @lc code=start
class Solution {
    // solution 1 - string 方式
    public boolean isPalindromeV1(int x) {
        String s = String.valueOf(x);
        for (int i=0; i <= s.length()/2 - 1; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    // solution 2 - without converting to string
    public boolean isPalindromeV2(int x) {
        // 如果为负数一定不是
        int temp = 0;
        if (x == 0) {
            return true;
        } else if (x < 0) {
            return false;
        } else {
            // 考虑比较，其实就是一个首尾相比，考虑使用一个队列和一个栈来做
            Stack<Integer> stack = new Stack<>();
            Queue<Integer> queue = new LinkedList<>();
            while (x != 0) {
                temp = x%10;
                stack.push(temp);
                queue.add(temp);
                x = x/10;
            }
            int length = queue.size();
            for (int i=0; i < length/2; i++) {
                if (stack.pop() != queue.poll()) {
                    return false;
                }
            }
            return true;
        }
    }

    // solution 3 - 对数字的一半进行翻转
    // 通过对应的oldNumber 和 newNumber的大小判断临界条件
    // 对于中间的奇数情况，选择最后舍去
    public boolean isPalindromeV3(int x) {
        // 去除负数和末尾为0的条件
        if (x < 0 || (x % 10 == 0 && x != 0 )) {
            return false;
        }
        int reversedNumber = 0;
        while (reversedNumber < x) {
            reversedNumber = reversedNumber * 10 + x % 10;
            x = x / 10;
        }

        return x == reversedNumber || x == reversedNumber/10;
    }

}
// @lc code=end

