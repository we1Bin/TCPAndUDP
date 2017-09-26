package com.weibin.ip;

/**
 * 欧几里得算法
 * Created by wei.bin on 2017/8/21.
 */
public class Test {
    /**
     * 计算最小公约数
     * @param p
     * @param q
     * @return
     */
    public static int gcd(int p, int q){
        if (q == 0){
            return p;
        }else {
            int r = p % q;
            return gcd(q, r);
        }
    }

    public static void main(String[] args) {
        System.out.println(gcd(4, 2));
    }
}
