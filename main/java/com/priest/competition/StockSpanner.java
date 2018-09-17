package com.priest.competition;

import java.util.ArrayList;
import java.util.List;

/**
 * 详情 :
 * <p>
 * 详细 :
 *
 * @author liangguanglong 2018/9/9
 */
public class StockSpanner {

    private List<Integer> element = new ArrayList<Integer>();
    private List<Integer> num = new ArrayList<Integer>();

    public StockSpanner() {
    }

    public int next(int price) {
        element.add(price);
        if (element.size() == 1) {
            num.add(1);
            return 1;
        } else {
            int lowerNum = 1;
            for (int i = element.size() - 2; i >= 0; ) {
                if (element.get(i) <= price) {
                    // 直接相加小弟的数量
                    lowerNum = lowerNum + num.get(i);
                    if (i == 0) {
                        break;
                    }
                    i = i - num.get(i - 1) - 1;
                } else {
                    break;
                }
            }
            num.add(lowerNum);
            return lowerNum;
        }
    }

    public static void main(String[] args) {
        StockSpanner spanner = new StockSpanner();
        int[] arr = {31,41,48,59,79};
        for (int i = 0; i < arr.length; i++) {
            System.out.print(spanner.next(arr[i]) + " , ");
        }
    }
}
