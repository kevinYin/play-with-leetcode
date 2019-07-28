package com.priest.list;

import com.priest.common.ListNode;

/**
 * 详情 : 链表的中间结点
 * <p>
 * 详细 : https://leetcode-cn.com/problems/middle-of-the-linked-list/
 *
 * 思路：跟链表成环的思路一致，开起2个遍历，一个一次一步，一个一次2步，到快的走完了，慢的就是中间节点
 *
 * @author liangguanglong 2019/5/22
 */
public class MiddleNode {

    public ListNode middleNode(ListNode head) {
        ListNode slowNode = head;
        ListNode fastNode = head;

        while (fastNode != null) {
            if (fastNode.next == null) {
                break;
            } else {
                fastNode = fastNode.next.next;
            }
            slowNode = slowNode.next;
        }

        return slowNode;
    }
}
