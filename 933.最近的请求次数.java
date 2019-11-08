import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=933 lang=java
 *
 * [933] 最近的请求次数
 */

// @lc code=start
class RecentCounter {
    Queue<Integer> q;

    public RecentCounter() {
        // queue 本来是一种数组或链表的实现
        q = new LinkedList();
    }
    
    public int ping(int t) {
        q.add(t);
        while(q.peek() < t - 3000) {
            // 只返回近3000ms，再之前的没有用就可以丢掉了
            q.poll();
        }
        return q.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
// @lc code=end

