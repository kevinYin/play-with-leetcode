package com.priest.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 详情 : 787. K 站中转内最便宜的航班
 * <p>
 * 详细 :https://leetcode-cn.com/problems/cheapest-flights-within-k-stops/description/
 *
 * @author liangguanglong 2018/10/26
 */
public class FindCheapestPrice {

    // n 范围是 [1, 100]，城市标签从 0 到 n - 1.
    // 航班数量范围是 [0, n * (n - 1) / 2].
    // 每个航班的格式 (src, dst, price).
    // 每个航班的价格范围是 [1, 10000].
    // k 范围是 [0, n - 1].
    private int result = -1;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int beginCity = flights[0][0];
        return 0;
    }

    /**
     * 获取邻居节点
     */
    private List<Integer> getNeighbours(int[][] flights, int src) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < flights.length; i++) {
            if (flights[i][0] == src) {
                result.add(flights[i][1]);
            }
        }
        return result;
    }

}
