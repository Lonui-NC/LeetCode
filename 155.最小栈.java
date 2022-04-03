import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=155 lang=java
 *
 * [155] 最小栈
 */

// @lc code=start
class MinStack {
    // 那么，我们可以在每个元素 a 入栈时把当前栈的最小值 m 存储起来。
    // 在这之后无论何时，如果栈顶元素是 a，我们就可以直接返回存储的最小值 m
    Deque<Integer> stack;
    // 辅助空间，去掉当前top之外的另一个最小值！
    Deque<Integer> minStack;
    // 辅助栈永远存与当前对应的最小值！类似缓存的map min value!
    int min = Integer.MAX_VALUE;
    public MinStack() {
        stack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
    }
    
    public void push(int val) {
        stack.push(val);
        min = Math.min(val, min);
        minStack.push(min);
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
        // 空值判断
        if (minStack.isEmpty()) {
            min = Integer.MAX_VALUE;
        } else {
            min = minStack.peek();
        }
    }
    
    public int top() {
        return stack.peek(); 
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end

