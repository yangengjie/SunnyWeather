package com.example.sunnyweather;

/**
 * Created by ygj on 2020/12/4.
 */
class TestClass {

    public int fib(int n) {
        if (n <= 1) return n;
        int first = 0;
        int second = 1;
        int sum;
        for (int i = 0; i < n - 1; i++) {
            sum = (first + second);
            first = second;
            second = sum;
        }
        return second;
    }
}
