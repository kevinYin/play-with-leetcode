package com.priest.list;

import com.priest.common.ListNode;

import java.util.HashSet;

/**
 * 详情 : 链表成环
 * <p>
 * 详细 : https://leetcode-cn.com/problems/linked-list-cycle/
 *
 * 思路 : 采用双指针，一个快一个慢
 *
 *
 * @author liangguanglong 2019/6/5
 */
public class HasCycle {

    /**
     * Hash表方式
     */
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }

    /**
     * 双指针，
     * 通过使用具有 不同速度 的快、慢两个指针遍历链表，
     * 空间复杂度可以被降低至 O(1)。慢指针每次移动一步，而快指针每次移动两步。
     *
     * 现在考虑一个环形链表，把慢指针和快指针想象成两个在环形赛道上跑步的运动员（分别称之为慢跑者与快跑者）。
     * 而快跑者最终一定会追上慢跑者。这是为什么呢？考虑下面这种情况（记作情况 A）
     * - 假如快跑者只落后慢跑者一步，在下一次迭代中，它们就会分别跑了一步或两步并相遇。
     */
     public boolean hasCycle2(ListNode head) {
         if (head == null || head.next == null) {
             return false;
         }
         ListNode slow = head;
         ListNode fast = head.next;
         while (slow != fast) {
             if (fast == null || fast.next == null) {
                 return false;
             }
             slow = slow.next;
             fast = fast.next.next;
         }
         return true;
    }
}
