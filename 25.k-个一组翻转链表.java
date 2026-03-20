/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;

        int len = 0;
        while (cur != null) {
            ++len;
            cur = cur.next;
        }

        while(len >= k) {
            cur = prev.next;
            ListNode nxt = cur.next;
            for (int i = 1; i < k; ++i) {
                cur.next = nxt.next;
                nxt.next = prev.next;
                prev.next = nxt;
                nxt = cur.next;
            }
            prev = cur;
            len -= k;
        }

        return dummy.next;
    }
}
// @lc code=end

