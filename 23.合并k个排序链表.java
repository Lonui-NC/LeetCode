/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并K个排序链表
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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeKListsIndex(lists, 0, lists.length - 1);
    }

    public ListNode mergeKListsIndex(ListNode[] lists, int begin, int end) {
        if (begin == end) {
            return lists[begin];
        }
        int mid = begin + (end - begin)/2;
        ListNode left = mergeKListsIndex(lists, begin, mid);
        ListNode right = mergeKListsIndex(lists, mid + 1, end);
        return mergeTwoLists(left, right);
    }

    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null) {
            return b;
        }

        if (b == null) {
            return a;
        }

        if (a.val < b.val) {
            a.next = mergeTwoLists(a.next, b);
            return a;
        } else {
            b.next = mergeTwoLists(a, b.next);
            return b;
        }

    }
}
// @lc code=end

