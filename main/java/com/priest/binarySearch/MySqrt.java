package com.priest.binarySearch;

/**
 * 详情 : x 的平方根
 * <p>
 * 详细 : https://leetcode-cn.com/problems/sqrtx/
 *
 * @author liangguanglong 2019/6/22
 */
public class MySqrt {

    public int mySqrt(int x) {
        if (x == 1) {
            return 1;
        }
        int begin = 0, end = x;
        while (begin < end) {
            int mid = (begin + end) / 2;
            if (mid * mid == x) {
                return mid;
            }
            if (x / mid < mid) {
                end = mid - 1;
                if (end == 0) return mid;
                if (x / end > end) return end;
            } else {
                begin = mid + 1;
                if (x / begin < begin) return mid;
            }
        }
        return begin;
    }

    /**
     * 用牛顿迭代法,首先随便猜一个近似值 xx，
     * 然后不断令 xx 等于 xx 和 a/xa/x 的平均数，迭代个六七次后 xx 的值就已经相当精确了
     **/
    public int mySqrt2(int x) {
        if (x == 1) {
            return 1;
        }
        double result = x;
        while (x / result < result) {
            // 为了避免 7 这种会跑超时情况，每次判断下是否 x 是否在result的平方 跟 result的整数部分平方之间，是则返回整数部分
            if (x / (result - 1) > (result - 1)) {
                if ((int) result * (int) result < x) {
                    return (int) result;
                }
            }
            result = (result + x / result) / 2;
        }
        return (int) result;
    }

    public int mySqrt3(int x) {
        long t = x;
        t = 0x5f3759df - (t >> 1);
        while (!(t * t <= x && (t + 1) * (t + 1) > x))
            t = (x / t + t) / 2;
        return (int) t;
    }

    public static void main(String[] args) {
        MySqrt sqrt = new MySqrt();
        int i = sqrt.mySqrt3(7);
        System.out.println(i);
    }
}
