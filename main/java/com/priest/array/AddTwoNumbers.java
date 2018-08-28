package com.priest.array;

/**
 * 详情 : https://leetcode-cn.com/problems/add-two-numbers/description/
 * <p>
 * 详细 : 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @author liangguanglong 2018/4/25
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 1. 将2数转化为数字
        int num1 = getNum(l1);
        int num2 = getNum(l2);

        // 2.2数相加
        int result = num1 + num2;
        // 3.遍历
        String s = result + "";
        String[] arr = s.split("");

        ListNode node = null;
        for (int i = 0; i < arr.length ; i++) {
            if (node == null) {
                node = new ListNode(Integer.valueOf(arr[i]));
            } else {
                ListNode newNode = new ListNode(Integer.valueOf(arr[i]));
                newNode.next = node;
                node = newNode;
            }
        }
        return node;
    }

    private int getNum(ListNode l1) {
        int tmp = 1, num = 0;
        while (l1 != null) {
            num = num + l1.val * tmp;
            tmp = tmp * 10;
            l1 = l1.next;
        }
        return num;
    }

    public static void main(String[] args) {
        AddTwoNumbers numbers = new AddTwoNumbers();
        ListNode listNode = buildNode(new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9, 9});
        ListNode listNode2 = buildNode(new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9, 9});
        ListNode node = numbers.addTwoNumbers(listNode, listNode2);
    }

    public static ListNode buildNode(int[] arr) {
        ListNode node = new ListNode(arr[arr.length - 1]);
        for (int i = arr.length - 2; i > 0; i--) {
             ListNode newNode = new ListNode(Integer.valueOf(arr[i]));
                newNode.next = node;
                node = newNode;
        }
        return node;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
