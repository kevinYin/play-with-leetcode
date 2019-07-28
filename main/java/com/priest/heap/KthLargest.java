package com.priest.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 详情 : 703. 数据流中的第K大元素
 * <p>
 * 详细 : https://leetcode-cn.com/problems/kth-largest-element-in-a-stream/
 *
 * @author liangguanglong 2019/7/28
 */
public class KthLargest {

    private PriorityQueue<Integer> priorityQueue;

    private int index;

    public KthLargest(int k, int[] nums) {
        priorityQueue = new PriorityQueue<Integer>(k, Comparator.comparingInt(o -> o));
        this.index = k;
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (priorityQueue.size() < index) {
            priorityQueue.offer(val);
        } else if (priorityQueue.peek() < val) {
            priorityQueue.poll();
            priorityQueue.offer(val);
        }

        return priorityQueue.peek();
    }
}
