package com.priest.list;

import com.priest.common.ListNode;

/**
 * 详情 : 删除排序链表中的重复元素
 * <p>
 * 详细 : https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 *
 * @author liangguanglong 2019/5/23
 */
public class DeleteDuplicates {

    // 需要注意 连续多个一样的时候，不要切换head 为 head.next
    public ListNode deleteDuplicates(ListNode head) {
        ListNode result = head;
        while (head != null && head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }

        return result;
    }
}
