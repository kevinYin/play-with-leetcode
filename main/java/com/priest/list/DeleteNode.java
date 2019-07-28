package com.priest.list;

import com.priest.common.ListNode;

/**
 * 详情 : 删除链表中的节点
 * <p>
 * 详细 : https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 *
 * @author liangguanglong 2019/5/21
 */
public class DeleteNode {

     public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next =node.next.next;
    }
}
