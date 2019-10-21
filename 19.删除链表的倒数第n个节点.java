/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第N个节点
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // 1. 先来暴力法
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n < 0) {
            return head;
        }
        int index = 0; 
        ListNode lHead = head;
        ListNode cur = head;
        int len = 1;
        while(cur.next != null) {
            cur = cur.next;
            len++;
        }
        cur = lHead; 
        // 去掉头结点的边界情况
        if (n == len) {
            lHead = head.next;
            head.next = null;
            return lHead;
        }
        // 找到要删除节点的前一个节点
        while(index < len - n - 1) {
            cur = cur.next; 
            index++;
        }
        // cur.next 是要删除的节点
        ListNode temp = cur.next.next;
        cur.next.next = null; 
        cur.next = temp;
        return lHead;
    }

    // 2. 进阶法，一次遍历，仔细想一下是快慢指针0，n的关系
    public ListNode removeNthFromEndV2(ListNode head, int n) {
        if (head == null || n < 0) {
            return head;
        }
        ListNode lHead = head;
        ListNode slow = head;
        ListNode fast = head;
        int index = 0;
        while(fast.next != null) {
            fast = fast.next;
            if (index < n){
                index++;
            } else {
                slow = slow.next;
            }
        }
        // index == n 说明是正好计算的第n个也就是需要删除头结点
        // 否则说明头结点是要删除结点的前一个结点
        if (slow == head && index == n) {
            lHead = head.next;
            head.next = null;
        } else {
            // slow.next 是要删除的节点
            ListNode temp = slow.next.next;
            slow.next.next = null; 
            slow.next = temp;
        }
        return lHead;
    }

    // 双指针猜出来了，但是轮询时候的方法太复杂
    // 并且官方用了dummy，守护结点保证后面问题的处理都是一样的！！！！
    public ListNode removeNthFromEndV3(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        // 从1开始计数，fast向前走n+1步
        for(int i=1;i<n+1;i++) {
            fast = fast.next;
        }
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}




// @lc code=end

