package com.priest.list;

import com.priest.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 详情 : 回文链表
 * <p>
 * 详细 : https://leetcode-cn.com/problems/palindrome-linked-list/
 *
 * @author liangguanglong 2019/6/6
 */
public class IsPalindrome {

    //思路 ：遍历的过程把内容放到一个数组里面存储，再判断数组是否为回文数组,空间复杂度 O(n)
    public boolean isPalindrome(ListNode head) {
        List<Integer> nums = new ArrayList<>();
        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }
        for (int i = 0; i < nums.size() / 2; i++) {
            if (nums.get(i).intValue() != nums.get(nums.size() - i - 1).intValue()) {
                return false;
            }
        }
        return true;
    }

    /**
     * O(n) 时间复杂度和 O(1) 空间复杂度
     * 其一，find mid node 使用快慢指针找到链表中点。
     * 其二，reverse 逆序后半部分。
     * 其三，check 从头、中点，开始比较是否相同。
     */
    public boolean isPalindrome2(ListNode head) {
        ListNode midNode = head;
        ListNode fastNode = head;
        while (fastNode != null) {
            midNode = midNode.next;
            if (fastNode.next == null) {
                break;
            }
            fastNode = fastNode.next.next;
        }
        ListNode revertNode = revertNode(midNode);
        while (revertNode != null) {
            if (head.val != revertNode.val) {
                return false;
            }
            head = head.next;
            revertNode = revertNode.next;
        }
        return true;
    }

    private ListNode revertNode(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = revertNode(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public static void main(String[] args) {
        ListNode n2 = new ListNode(2);
        ListNode n1 = new ListNode(1);
        n1.next = n2;
        IsPalindrome isPalindrome = new IsPalindrome();
        isPalindrome.isPalindrome2(n1);
    }
}
