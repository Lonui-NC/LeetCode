/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 确定头结点
        ListNode res = new ListNode(0);
        ListNode cur = res;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                cur = cur.next; 
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = cur.next; 
                l2 = l2.next;
            }
        }

        // l1有剩余节点
        while (l1 != null) {
            cur.next = l1;
            cur = cur.next; 
            l1 = l1.next;
        }

        // l2有剩余节点
        while (l2 != null) {
            cur.next = l2;
            cur = cur.next; 
            l2 = l2.next;
        }

        return res.next;
    }
}
// @lc code=end

