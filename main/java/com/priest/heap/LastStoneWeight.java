package com.priest.heap;

import java.util.PriorityQueue;

/**
 * 详情 :1046. 最后一块石头的重量
 * <p>
 * 详细 : https://leetcode-cn.com/problems/last-stone-weight/
 *
 * @author liangguanglong 2019/7/28
 */
public class LastStoneWeight {

    /**
     * 思路：大顶堆，每次取最大2个
     */
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int stone : stones) {
            priorityQueue.offer(stone);
        }
        while (priorityQueue.size() > 1) {
            Integer x = priorityQueue.poll();
            Integer y = priorityQueue.poll();
            int result = Math.abs(x - y);
            if (result != 0) {
                priorityQueue.offer(result);
            }
        }
        if (priorityQueue.size() == 0) {
            return 0;
        }
        return priorityQueue.peek();
    }
}
