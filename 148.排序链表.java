/*
 * @lc app=leetcode.cn id=148 lang=java
 *
 * [148] 排序链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return head;
        }
        int len = 0;
        ListNode node = head;
        while (node != null) {
            ++len;
            node = node.next;
        }

        ListNode dummy = new ListNode(0, head);
        for (int sublen = 1; sublen < len; sublen <<= 1) {
            ListNode prev = dummy;
            ListNode curr = dummy.next;
            // 进行链表分割并合并排序
            while (curr != null) {
                ListNode head1 = curr;
                for (int i = 1; i < sublen && curr.next != null; ++i) {
                    // 移动到第一个链表的末端
                    curr = curr.next;
                }
                // 获取第二个链表
                ListNode head2 = curr.next;
                // 截断第一个链表
                curr.next = null;
                // 移动到第二个链表
                curr = head2;
                for (int i = 1; i < sublen && curr != null && curr.next != null; ++i) {
                    // 移动到第二个链表的末端
                    curr = curr.next;
                }
                ListNode next = null;
                if (curr != null) {
                    // 获取第二个链表的下一个节点
                    next = curr.next;
                    // 截断第二个链表
                    curr.next = null;
                }
                // 将截断的两个链表进行合并
                ListNode merged = mergeList(head1, head2);
                // 拼接合并后的链表
                prev.next = merged;
                while (prev.next != null) {
                    // 移动到合并后的链表末端
                    prev = prev.next;
                }
                // 移动到合并后的链表的下一个节点
                curr = next;
            }
        }
        return dummy.next;
    }

    ListNode mergeList(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        ListNode temp1 = head1;
        ListNode temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val < temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }

        if (temp1 != null) {
            temp.next = temp1;
        } else if (temp2 != null) {
            temp.next = temp2;
        }

        return dummy.next;
    }
}
// @lc code=end
